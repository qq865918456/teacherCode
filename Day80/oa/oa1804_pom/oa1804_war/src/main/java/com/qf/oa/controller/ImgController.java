package com.qf.oa.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.UUID;

@Controller
@RequestMapping("/img")
public class ImgController {


    @Value("${uploadPath}")
    private String uploadPath;

    /**
     * 图片上传
     *
     * 1、上传到哪里
     *  1）直接上传到tomcat
     *  2）随意指定一个文件路径
     *  3）上传到分布式文件系统中
     * 2、上传的文件名叫什么
     *  1）沿用原来的文件名
     *      -重名
     *      -中文乱码
     *  2）uuid
     *      -没有后缀 （截取后缀拼在文件名的后面）
     *
     *  后缀的作用：仅仅只是提示操作系统这是一个什么类型的文件
     *
     *  百度云
     *      秒传 - a.jpg   a.jpg
     *
     *  哈希表的思路
     *
     *  文件1 -> 签名 -> abcdefg
     *  文件2 -> 签名 -> abcdefg
     *
     * @return
     */
    @RequestMapping("/upload")
    @ResponseBody
    public String imgUploader(MultipartFile file){
        InputStream in = null;
        OutputStream out = null;
        try {
            //文件的上传流
            in = file.getInputStream();

            String path = uploadPath + "/" + UUID.randomUUID().toString();

            //本地的输出流
            out = new FileOutputStream(path);

            //上传
            IOUtils.copy(in, out);

            //响应上传的文件路径
            return "{\"fileuploader\":\"" + path + "\"}";
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(in != null){
                try {
                    in.close();
                } catch (IOException e) {
                }
            }

            if(out != null){
                try {
                    out.close();
                } catch (IOException e) {
                }
            }
        }

        return null;
    }


    /**
     * 图片的回显
     */
    @RequestMapping("/getImg")
    public void getImg(String path, HttpServletResponse response){

        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(path);
            out = response.getOutputStream();

            IOUtils.copy(in, out);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
