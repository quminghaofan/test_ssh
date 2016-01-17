package cn.edu.xmu.oneonezero.view;

import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
/**
 * 图片上传
 * @author DELL
 *
 */
public class PicUpload {
	/**
	 * 
	 * 保存图片
	 * 
	 * @param saveFilePath
	 *            图片保存路径
	 * @param filedata
	 *            文件数据
	 * @return String
	 */
	public static String saveFile(MultipartFile filedata, String saveFilePath) {
		// 保存相对路径到数据库 图片写入服务器
		if (filedata != null && !filedata.isEmpty()) {
//			System.out.println("测试测试");
			// 获取图片的文件名
			String fileName = filedata.getOriginalFilename();
			// 获取图片的扩展名
			String extensionName = fileName
					.substring(fileName.lastIndexOf(".") + 1);
			// 新的图片文件名 = 获取时间戳+"."图片扩展名
			String newFileName = String.valueOf(System.currentTimeMillis())
					+ "." + extensionName;
			// String saveFilePath = picDir;
			/* 构建文件目录 */
			File fileDir = new File(saveFilePath);
			if (!fileDir.exists()) {
				fileDir.mkdirs();
			}

			try {
				FileOutputStream out = new FileOutputStream(saveFilePath + "/"
						+ newFileName);
				// 写入文件
				out.write(filedata.getBytes());
				out.flush();
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "../attached/"+newFileName;
		}
		return "../images/nopic.jpg";
	}
	
	/**
	 * 删除图片
	 * @param picName 图片名称
	 * @param picUrl 图片路径
	 */
	public static void deleteFile(String picName, String picUrl) {
			File fileDir = new File(picUrl + picName);
			if (fileDir.exists()) {
				// 把修改之前的图片删除 以免太多没用的图片占据空间
				fileDir.delete();
			}

	}
}
