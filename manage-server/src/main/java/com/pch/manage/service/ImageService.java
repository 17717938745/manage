package com.pch.manage.service;

import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author pch 651158394@qq.com
 * @version 2021/7/13 下午4:10
 */
@Service
@Slf4j
public class ImageService {

    public InputStream zipImage(InputStream in) {
        try {
            float outputQuality = new BigDecimal(1024 * 1024 * 3).divide(new BigDecimal(in.available()), 3, RoundingMode.UP).floatValue();
            log.info("length: {}b {}kb {}m, outputQuality: {}", in.available(), in.available() / 1024, in.available() / 1024 / 1024, outputQuality);
            if (outputQuality < 1) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Thumbnails.of(in)
                        .scale(1f)
                        .outputQuality(outputQuality)
                        .toOutputStream(byteArrayOutputStream);
                in = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            }
        } catch (IOException e) {
            log.error("", e);
        }

        return in;
    }

    public boolean isImage(InputStream inputStream) {
        if (null != inputStream) {
            try {
                return isImage(ImageIO.read(inputStream));
            } catch (Exception e) {
                log.error("", e);
            }
        }
        return false;
    }

    public boolean isImage(Image img) {
        if (img != null && img.getWidth(null) > 0 && img.getHeight(null) > 0) {
            return true;
        } else {
            return false;
        }
    }
}
