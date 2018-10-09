package com.qf.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.qf.entity.User;

@Controller
public class UserController {

	@RequestMapping(value="/uploadFile")
	public String uploadFile(@RequestParam("myFile")MultipartFile file,HttpServletRequest request) {
		
		// 获取文件上传路径
		String uplaodPath = request.getServletContext().getRealPath("upload");
		
		String fileName = file.getOriginalFilename();
		System.out.println(file.getName());// 表单中文件上传组件的name
		System.out.println(fileName); // 真实的文件名称
		System.out.println(file.getContentType()); // 文件类型
		
		if(!fileName.toLowerCase().endsWith("png")){
			request.setAttribute("msg", "上传失败，文件类型不合法");
			return "ok";
		}
		
		FileOutputStream ops  = null;
		FileInputStream ips = null;
		try {
			ops  = new FileOutputStream(uplaodPath+File.separator+file.getOriginalFilename());
			ips = (FileInputStream) file.getInputStream();
			// IO流拷贝
			IOUtils.copy(file.getInputStream(), ops);
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			IOUtils.closeQuietly(ops);
			IOUtils.closeQuietly(ips);
		}
		return "ok";
	}
}
