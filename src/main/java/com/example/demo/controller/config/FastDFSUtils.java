/**
 * 
 */
package com.example.demo.controller.config;

import java.io.IOException;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient1;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author zhangtl
 * @Time 2020年3月24日
 */
public class FastDFSUtils {
	private static StorageClient1 client1;
	
	static {
		try {
			ClientGlobal.initByProperties("fastdfs-client.properties");
		} catch (IOException | MyException e) {
			e.printStackTrace();
		}
	}
	
	public static String upload(MultipartFile file) {
		String oldName=file.getOriginalFilename();
		try {
			return client1.upload_file1(file.getBytes(), oldName.substring(oldName.lastIndexOf(".")+1), null);
		} catch (IOException | MyException e) {
			e.printStackTrace();
		}
		return null;
	}
}
