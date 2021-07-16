package com.pch.manage.param;

import lombok.Data;

import java.awt.*;

/**
 * @author pch 651158394@qq.com
 * @version 2021/7/11 下午2:42
 */
@Data
public class QrInfo {

    private int width = 168;
    private int height = 168;
    private int left = -1;
    private int top = -1;
    private int color = Integer.parseInt("000000", 16);

    private String nameFontColor = "ff2222";
    private String nameFontName = "微软雅黑";
    private int nameFontStyle = Font.BOLD;
    private int nameFontSize = 32;
    private int nameLeft = 40;
    private int nameTop = 100;

    private String describeFontColor = "ff2222";
    private String describeFontName = "仿宋";
    private int describeFontStyle = Font.PLAIN;
    private int describeFontSize = 28;
    private int describeLeft = 40;
    private int describeTop = 150;

    private byte[] backgroundImgBytes = new byte[0];
    private String imgExtension = "jpg";
}
