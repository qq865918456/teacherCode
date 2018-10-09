package com.qf.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.qf.entity.User;

@Controller
public class UserController {

	@RequestMapping(value = "/downloadFile")
	public void downloadFile(HttpServletResponse response) {

		// 1.指定要下载的文件
		String path = "C:/java/workspace/demo/day61_springmvc_61_download/src/";
//		String path = "C:/java/workspace/demo/day61_springmvc_61_download/WebContent/";
		
		String fileName = "总结.txt";
//		String fileName = "ok.jsp";
		
		
		FileInputStream ips = null;
		try {
			// 2.把文件转成流
			ips = new FileInputStream(path+fileName);
			
			// 3.设置响应头
			response.setContentType("application/x-msdownload"); // 设置文件类型
			response.setHeader("Content-Disposition", "attachment;filename="+new String(fileName.getBytes("utf-8"),"ISO-8859-1"));
			
			// 3.把文件拷贝reponse里面
			IOUtils.copy(ips, response.getOutputStream()); // 下载一般都用字节流
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			IOUtils.closeQuietly(ips);
		}
	}
}
