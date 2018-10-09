package com.qf.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import com.qf.entity.GoodsInfo;
import com.qf.entity.Page;
import com.qf.service.IGoodsInfoService;
import com.qf.service.impl.GoodsInfoServiceImpl;

/**
 * Servlet implementation class GoodsInfoServlet
 */
public class GoodsInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IGoodsInfoService goodsInfoService = new GoodsInfoServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GoodsInfoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		if ("addGoodsInfo".equals(action)) {

			// 指定文件上传的路径
			String uploaPath = request.getServletContext().getRealPath("images");

			// 1.文件上传的工厂
			DiskFileItemFactory factory = new DiskFileItemFactory();

			// 2.上传文件的核心组件
			ServletFileUpload upload = new ServletFileUpload(factory);

			// 3.解析requset
			Map<String, Object> map = new HashMap<String, Object>();
			try {
				List<FileItem> list = upload.parseRequest(request);
				for (FileItem fileItem : list) {
					String fieldName = fileItem.getFieldName(); // 获取属性名称
					if (fileItem.isFormField()) { // 判断是否是表单类型
						String value = fileItem.getString("utf-8"); // 属性值
						map.put(fieldName, value); // 把数组放到map中
					} else {
						String name = fileItem.getName();// 图片名称
						InputStream ips = fileItem.getInputStream();
						map.put(fieldName, name); // 把文文件名称方到map中

						// 文件拷贝的操作
						// 指定文件输出路径
						FileOutputStream ops = new FileOutputStream(uploaPath + File.separator + name);
						try {
							// 流的拷贝
							IOUtils.copy(ips, ops);
						} catch (Exception e) {
							e.printStackTrace();
						} finally {
							if (ops != null) {
								ops.close();
							}
						}
					}
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
			System.out.println(map);
			GoodsInfo goodsInfo = new GoodsInfo();
			try {
				// 把map中的数据拷贝到对象中
				BeanUtils.populate(goodsInfo, map);
				System.out.println(goodsInfo);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		} else if ("getGoodsInfoList".equals(action)) {
			Page<GoodsInfo> page = new Page<GoodsInfo>();
			String currentPage = request.getParameter("currentPage");
			if (currentPage != null && !"".equals(currentPage)) {
				page.setCurrentPage(Integer.parseInt(currentPage));
			}
			goodsInfoService.getPage(page);
			page.setUrl("GoodsInfoServlet?action=getGoodsInfoList");
			request.setAttribute("page", page);
			request.getRequestDispatcher("back/goods/goodsList.jsp").forward(request, response);
		}else if("getGoodsInfoById".equals(action)){
			Integer id = Integer.parseInt(request.getParameter("id"));
			GoodsInfo goodsInfo = goodsInfoService.getById(id);
			request.setAttribute("goodsInfo", goodsInfo);
			request.getRequestDispatcher("back/goods/goodupdate.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
