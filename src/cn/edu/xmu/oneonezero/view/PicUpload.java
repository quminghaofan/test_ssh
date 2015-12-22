package cn.edu.xmu.oneonezero.view;

import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class PicUpload {
    /**
     * 
     * 功能描述   保存图片
     * 
     * @param newFileName
     *            上传照片文件名
     * @param filedata
     *           文件数据
     */
    private static String picDir="C:\\Program Files\\apache-tomcat-7.0.65\\webapps\\test_ssh";
    public static String saveFile(MultipartFile filedata) {
        // 保存相对路径到数据库 图片写入服务器
        if (filedata != null && !filedata.isEmpty()) {
            // 获取图片的文件名
            String fileName = filedata.getOriginalFilename();
            String saveFilePath = picDir;
            /* 构建文件目录 */
            File fileDir = new File(saveFilePath);
            if (!fileDir.exists()) {
                fileDir.mkdirs();
            }
     
            try {
                FileOutputStream out = new FileOutputStream(saveFilePath + "\\"
                        + fileName);
                // 写入文件
                out.write(filedata.getBytes());
                out.flush();
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }  
            return saveFilePath + "\\"+ fileName;
        }
        return "";
    }
    /**
     * 
     * 功能描述：删除图片
     */
    public static void deleteFile(String picName) {
        File fileDir = new File(picDir+"\\"+picName);
        if (fileDir.exists()) {
            //把修改之前的图片删除 以免太多没用的图片占据空间
            fileDir.delete();
        }
 
    }
}
