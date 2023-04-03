package com.bjqg.web.utils.file;

import org.apache.commons.lang3.StringUtils;

import java.io.File;

/**
 * @author: lbj
 * @date: 2022/12/7 11:30
 */
public class FileTypeUtils {

    /**
     * @return : {@link String}
     * @param: file
     * @author : lbj
     * @description: <获取文件类型>
     * @date : 2022/12/7 11:34
     */
    public static String getFileType(File file) {
        if (null == file) {
            return StringUtils.EMPTY;
        }
        return getFileType(file.getName());
    }

    /**
     * @return : {@link String}
     * @param: fileName
     * @author : lbj
     * @description: <获取文件类型>
     * @date : 2022/12/7 11:35
     */
    public static String getFileType(String fileName) {
        int separatorIndex = fileName.lastIndexOf(".");
        if (separatorIndex < 0) {
            return "";
        }
        return fileName.substring(separatorIndex + 1).toLowerCase();
    }

    public static String getFileExtendName(byte[] photoByte) {
        String strFileExtendName = "JPG";
        if ((photoByte[0] == 71) && (photoByte[1] == 73) && (photoByte[2] == 70) && (photoByte[3] == 56)
                && ((photoByte[4] == 55) || (photoByte[4] == 57)) && (photoByte[5] == 97)) {
            strFileExtendName = "GIF";
        } else if ((photoByte[6] == 74) && (photoByte[7] == 70) && (photoByte[8] == 73) && (photoByte[9] == 70)) {
            strFileExtendName = "JPG";
        } else if ((photoByte[0] == 66) && (photoByte[1] == 77)) {
            strFileExtendName = "BMP";
        } else if ((photoByte[1] == 80) && (photoByte[2] == 78) && (photoByte[3] == 71)) {
            strFileExtendName = "PNG";
        }
        return strFileExtendName;
    }
}
