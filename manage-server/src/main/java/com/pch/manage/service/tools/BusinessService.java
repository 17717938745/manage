package com.pch.manage.service.tools;

import cn.hutool.json.JSONUtil;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.pch.common.api.StorableApi;
import com.pch.manage.param.QrInfo;
import com.pch.manage.service.ImageService;
import com.pch.system.api.StorageApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Hashtable;

/**
 * @author pch 651158394@qq.com
 * @version 2021/7/11 下午4:48
 */
@Slf4j
public class BusinessService implements StorableApi {

    private static final String STORAGE_FILE_NAME = "qr_info.json";
    private StorageApi storageApi;
    private QrInfo qrInfo;
    private ImageService imageService;

    @Autowired
    public void setImageService(ImageService imageService) {
        this.imageService = imageService;
    }

    public BusinessService(StorageApi storageApi) {
        this.storageApi = storageApi;
        try {
            this.qrInfo = JSONUtil.toBean(storageApi.load(STORAGE_FILE_NAME), QrInfo.class);
        } catch (Exception e) {
            storageApi.storage(STORAGE_FILE_NAME, JSONUtil.toJsonStr(this.qrInfo = new QrInfo()));
        }
    }

    public void setQrInfo(QrInfo qrInfo) {
        this.qrInfo = qrInfo;
    }

    public QrInfo defaultConfig() {
        return qrInfo;
    }

    public byte[] mergeImage(InputStream in, String url, String name, String describe) {
        byte[] bytes = new byte[0];
        final ByteArrayInputStream backgroundImageInputStream = new ByteArrayInputStream(qrInfo.getBackgroundImgBytes());
        if (backgroundImageInputStream.available() > 0) {
            Graphics2D graphics = null;
            BitMatrix bitMatrix = null;
            try {
                final Hashtable<EncodeHintType, Object> hints = new Hashtable<>();
                hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
                hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
                hints.put(EncodeHintType.MARGIN, 1);
                BufferedImage qr = null != in ?
                        ImageIO.read(imageService.zipImage(in)) :
                        new BufferedImage(
                                (bitMatrix = new MultiFormatWriter().encode(url, BarcodeFormat.QR_CODE, qrInfo.getWidth(), qrInfo.getHeight(), hints)).getWidth(),
                                bitMatrix.getHeight(),
                                BufferedImage.TYPE_INT_RGB
                        );
                if (null != qr && qr.getWidth() > 0 && qr.getHeight() > 0) {
                    if (null != bitMatrix) {
                        for (int x = 0; x < bitMatrix.getWidth(); x++) {
                            for (int y = 0; y < bitMatrix.getHeight(); y++) {
                                qr.setRGB(x, y, bitMatrix.get(x, y) ? qrInfo.getColor() : 0xFFFFFF);
                            }
                        }
                    }
                    try (final ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
                        final BufferedImage backgroundImage = ImageIO.read(backgroundImageInputStream);
                        graphics = backgroundImage.createGraphics();
                        final Font defaultFont = graphics.getFont();
                        graphics.drawImage(
                                qr,
                                qrInfo.getLeft() >= 0 ? qrInfo.getLeft() : (backgroundImage.getWidth() - qrInfo.getWidth() - 32),
                                qrInfo.getTop() >= 0 ? qrInfo.getTop() : (backgroundImage.getHeight() - qrInfo.getHeight() - 32),
                                qrInfo.getWidth(),
                                qrInfo.getHeight(),
                                null
                        );
                        graphics.setColor(new Color(Integer.parseInt(qrInfo.getNameFontColor(), 16)));
                        graphics.setFont(new Font(qrInfo.getNameFontName(), qrInfo.getNameFontStyle(), qrInfo.getNameFontSize()));
                        graphics.drawString(name, qrInfo.getNameLeft(), qrInfo.getNameTop());
                        graphics.setColor(new Color(Integer.parseInt(qrInfo.getDescribeFontColor(), 16)));
                        graphics.setFont(new Font(qrInfo.getDescribeFontName(), qrInfo.getDescribeFontStyle(), qrInfo.getDescribeFontSize()));
                        graphics.drawString(describe, qrInfo.getDescribeLeft(), qrInfo.getDescribeTop());
                        graphics.setFont(defaultFont);
                        ImageIO.write(backgroundImage, qrInfo.getImgExtension(), bos);
                        bytes = bos.toByteArray();
                    }
                }
            } catch (Exception e) {
                log.error("", e);
            } finally {
                if (null != graphics) {
                    graphics.dispose();
                }
                if (null != bitMatrix) {
                    bitMatrix.clear();
                }
            }
        }
        return bytes;
    }

    @Override
    public void storage() {
        storageApi.storage(STORAGE_FILE_NAME, JSONUtil.toJsonStr(this.qrInfo));
    }
}
