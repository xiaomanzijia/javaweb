package com.lsgx.admin.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.web.multipart.MultipartFile;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * 图片工具
 * @author Po
 *
 */
public class ImageTool {
	
    public static String dirSplit = "\\";//linux windows

	/**
	 * 是否为允许图片类型
	 * 
	 * @param fileName
	 * @return
	 */
	public static boolean isImageAllowType(String fileName) {
		String typeName = "";
		// 扩展名格式：
		if (fileName.lastIndexOf(".") >= 0) {
			typeName = fileName.substring(fileName.lastIndexOf("."));
		}
		// 定义允许上传的文件类型
		List<String> fileTypes = new ArrayList<String>();
		fileTypes.add(".jpg");
		fileTypes.add(".jpeg");
		fileTypes.add(".png");
		fileTypes.add(".bmp");
		return fileTypes.contains(typeName.toLowerCase());
	}

    /**
     * 
     * @param image
     * @param realPath 绝对路径（不包含文件名）
     * @return
     * @throws IllegalStateException
     * @throws IOException
     */
    public static String upload(MultipartFile image, String realPath)
    {
        if (image != null && StringUtil.isNotEmpty(realPath))
        {
            String imageFileName = image.getOriginalFilename();
            String typeName = "";
            // 扩展名格式：
            if (imageFileName.lastIndexOf(".") >= 0)
            {
                typeName = imageFileName.substring(imageFileName.lastIndexOf("."));
            }
            
            DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
            Calendar calendar = Calendar.getInstance();
            String newName = df.format(calendar.getTime());// 以当前时间为文件名
            String newFileName = newName + typeName;
            File pathFile = new File(realPath);
            if (!pathFile.exists())
            {
                pathFile.mkdirs();
            }
            String toPath = realPath + newFileName;
            try
            {
                image.transferTo(new File(toPath));
            }
            catch (IllegalStateException e)
            {
                e.printStackTrace();
                return null;
            }
            catch (IOException e)
            {
                e.printStackTrace();
                return null;
            }
            return newFileName;
        }
        else
        {
            return null;
        }
    }
	/**
	 * 长高等比例2倍缩小图片
	 * @param targetDirectory
	 *            图片所在的文件夹路径
	 * @param imagePath
	 *            图片路径
	 * @param ext
	 *            缩略图扩展名后缀
	 * @param imageName
	 *            图片名
	 * @param w
	 *            目标宽
	 * @param h
	 *            目标高
	 * @param per
	 *            压缩 默认0.5
	 */
	public static void GenerateSmallImage(String orginFile,String targetDirectory, String ext,
			String imageName, int w, int h, float per) {
		BufferedImage src;
		int ratio=1;
		try {
			String imagePath = orginFile;
			File imageFile = new File(imagePath);
			src = javax.imageio.ImageIO.read(imageFile); // 构造Image对象
			String img_midname = targetDirectory+ System.getProperty("file.separator") + imageName.substring(0, imageName.indexOf("."))	+ imageName.substring(imageName.indexOf("."));
			int width = src.getWidth();  
            int height = src.getHeight();  
            // 缩小边长 
            BufferedImage tag = new BufferedImage(width / ratio, height / ratio, BufferedImage.TYPE_INT_RGB);  
            // 绘制 缩小  后的图片 
            tag.getGraphics().drawImage(src, 0, 0, width / ratio, height / ratio, null);  
            FileOutputStream newimage = new FileOutputStream(img_midname); // 输出到文件流
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(newimage);  
            JPEGEncodeParam jep = JPEGCodec.getDefaultJPEGEncodeParam(tag);
		    //压缩质量 
			jep.setQuality(per, true);
            encoder.encode(tag,jep);  
			// encoder.encode(tag); //近JPEG编码
			newimage.close();
		} catch (IOException ex) {
			Logger.getLogger(ImageTool.class.getName()).log(Level.SEVERE, null,
					ex);
		}
	}
    
    /**
     * 删除图片文件
     * 
     * @param path
     */
    public static boolean deletePicture(String path)
    {
        try
        {
            File file = new File(path);
            if (file.exists())
            {
                file.delete();
                return true;
            }
            return false;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

}
