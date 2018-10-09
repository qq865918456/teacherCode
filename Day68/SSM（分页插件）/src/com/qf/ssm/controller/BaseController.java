package com.qf.ssm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.PropertyValuesEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

import com.qf.ssm.interceptor.Page;
import com.qf.ssm.interceptor.PagePlugin;

@ControllerAdvice
public class BaseController {

	/**
	 * @InitBinder - ��ʾ��ʼ����
	 * ��ע���ǵķ���������controller�ķ���ִ�У���ʼ�������Ĳ���
	 */
	@InitBinder
	public void init(WebDataBinder webDataBinder, final HttpServletRequest request){
		webDataBinder.registerCustomEditor(Page.class, new PropertyValuesEditor() {
			@Override
			public void setValue(Object value) {
				Page page = (Page) value;
				//��̬����page��url
				String url = request.getRequestURL().toString();
				//��ô��ݹ����Ĳ���
				String params = request.getQueryString();
				if(params == null){
					url += "?1=1";
				} else {
					url += "?" + params;
				}
				
				if(url.indexOf("&page=") != -1){
					url = url.substring(0, url.indexOf("&page="));
				}
				page.setUrl(url);
				
				//��ʼ��ҳ
				PagePlugin.startPage(page);
				
				super.setValue(page);
			}
		});
	}
}
