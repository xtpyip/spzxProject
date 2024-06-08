package com.pyip.spzx.model.vo.common;

import org.springframework.util.StringUtils;

/**
 * @Date: 2023/11/05/9:39
 * @Author: zgm
 * @Function:
 */
public enum ViewContentType {
    DEFAULT("default","application/octet-stream"),
    JPG("jpg", "image/jpeg"),
    TIFF("tiff", "image/tiff"),
    GIF("gif", "image/gif"),
    JFIF("jfif", "image/jpeg"),
    PNG("png", "image/png"),
    TIF("tif", "image/tiff"),
    ICO("ico", "image/x-icon"),
    JPEG("jpeg", "image/jpeg"),
    WBMP("wbmp", "image/vnd.wap.wbmp"),
    FAX("fax", "image/fax"),
    NET("net", "image/pnetvue"),
    JPE("jpe", "image/jpeg"),
    RP("rp", "image/vnd.rn-realpix");

    private String prefix;

    private String type;

    public static String getContentType(String prefix){
        if(StringUtils.isEmpty(prefix)){
            return DEFAULT.getType();
        }
        prefix = prefix.substring(prefix.lastIndexOf(".") + 1);
        for (ViewContentType value : ViewContentType.values()) {
            if(prefix.equalsIgnoreCase(value.getPrefix())){
                return value.getType();
            }
        }
        return DEFAULT.getType();
    }

    ViewContentType(String prefix, String type) {
        this.prefix = prefix;
        this.type = type;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getType() {
        return type;
    }
}

