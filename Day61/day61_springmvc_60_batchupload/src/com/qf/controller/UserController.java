package com.qf.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.qf.entity.User;

@Controller
public class UserController {

	@RequestMapping(value = "/uploadFile")
	public String uploadFile(@RequestParam("myFile") MultipartFile[] file, HttpServletRequest request) {

		// 获取文件上传路径
		String uplaodPath = request.getServletContext().getRealPath("upload");

		for (MultipartFile multipartFile : file) {
			String fileName = multipartFile.getOriginalFilename();
			if (fileName.toLowerCase().endsWith("png") || fileName.toLowerCase().endsWith("txt")) {
				FileOutputStream ops = null;
				InputStream ips = null;
				try {
					ops = new FileOutputStream(uplaodPath + File.separator + fileName);
					ips = multipartFile.getInputStream();
					// IO流拷贝
					IOUtils.copy(multipartFile.getInputStream(), ops);
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					IOUtils.closeQuietly(ops);
					IOUtils.closeQuietly(ips);
				}
			} else {
				request.setAttribute("msg", "上传失败，文件类型不合法");
				return "ok";
			}

		}
		return "ok";
	}
}
