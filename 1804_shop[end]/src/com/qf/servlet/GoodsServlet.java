package com.qf.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.qf.entity.Goods;
import com.qf.entity.Page;
import com.qf.service.IGoodsService;
import com.qf.service.impl.GoodsServiceImpl;

/**
 * Servlet implementation class GoodsServlet
 */
public class GoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IGoodsService goodsService = new GoodsServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GoodsServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if ("getGoodsPage".equals(action)) {
			Page<Goods> page = new Page<Goods>();
			String currentPageTemp = request.getParameter("currentPage");
			if (currentPageTemp != null && !"".equals(currentPageTemp)) {
				page.setCurrentPage(Integer.parseInt(currentPageTemp));
			}
			page.setUrl("GoodsServlet?action=getGoodsPage");
			goodsService.getPage(page);
			request.setAttribute("page", page);
			request.getRequestDispatcher("back/goodstype/goodstype.jsp").forward(request, response);
		}else if("getParentGoodsList".equals(action)){
			
			List<Goods> goodsList = goodsService.getParentGoodsList();
			response.getWriter().write(new Gson().toJson(goodsList)); // 把集合转出json
		}else if("getGodsById".equals(action)){
			Integer id = Integer.parseInt(request.getParameter("id"));
			Goods goods = goodsService.getById(id);
			request.setAttribute("goods", goods);
			request.getRequestDispatcher("back/goodstype/goodstypeupdate.jsp").forward(request, response);
		}else if("getGoodsListByParentId".equals(action)){
			Integer id = Integer.parseInt(request.getParameter("id"));
			List<Goods> goodsList = goodsService.getGoodsListByParentId(id);
			response.getWriter().write(new Gson().toJson(goodsList));
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
