package com.qf.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.RequestWrapper;

import org.apache.commons.beanutils.BeanUtils;

import com.qf.domain.GoodsInfoDomain;
import com.qf.entity.Address;
import com.qf.entity.Goods;
import com.qf.entity.GoodsInfo;
import com.qf.entity.OrderDetail;
import com.qf.entity.OrderInfo;
import com.qf.entity.ShopCar;
import com.qf.entity.User;
import com.qf.service.IAddressService;
import com.qf.service.IGoodsInfoService;
import com.qf.service.IGoodsService;
import com.qf.service.IOrderInfoService;
import com.qf.service.impl.AddressServiceImpl;
import com.qf.service.impl.GoodsInfoServiceImpl;
import com.qf.service.impl.GoodsServiceImpl;
import com.qf.service.impl.OrderInfoServiceImpl;

/**
 * Servlet implementation class ShopServlet
 */
public class ShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IGoodsInfoService goodsInfoService = new GoodsInfoServiceImpl();
	private IGoodsService goodsService = new GoodsServiceImpl();
	private IAddressService addressService = new AddressServiceImpl();
	private IOrderInfoService orderInfoService = new OrderInfoServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShopServlet() {
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
		if ("all".equals(action)) {

			// 1.查询商品类别
			List<Goods> goodsList = goodsService.getGoodsList();

			// 2.商品信息
			List<GoodsInfo> goodsInfoList = goodsInfoService.getGoodsInfoList();

			request.setAttribute("gtList", goodsList);
			request.setAttribute("giList", goodsInfoList);

			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else if ("getGoodsInfoById".equals(action)) {
			Integer id = Integer.parseInt(request.getParameter("id"));

			GoodsInfo goodsInfo = goodsInfoService.getById(id);

			request.setAttribute("goodsInfo", goodsInfo);

			request.getRequestDispatcher("introduction.jsp").forward(request, response);
		} else if ("addShopCar".equals(action)) {

			Integer id = Integer.parseInt(request.getParameter("id"));
			Integer count = Integer.parseInt(request.getParameter("count"));

			// 1.根据id查询对象
			GoodsInfo goodsInfo = goodsInfoService.getById(id);

			// 2.创建domain对象
			GoodsInfoDomain goodsInfoDomain = new GoodsInfoDomain();
			// 3.把goodsInfo中的属性拷贝到gooInfoDomain中
			try {
				BeanUtils.copyProperties(goodsInfoDomain, goodsInfo);
				goodsInfoDomain.setCount(count);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}

			// 4.创建购物车对象

			ShopCar shopCar = ShopCar.getShopCarIns(request.getSession());
			shopCar.add(goodsInfoDomain);

		} else if ("deleteShopCarGoodsInfo".equals(action)) {

			// 获取要删除商品的id
			Integer id = Integer.parseInt(request.getParameter("id"));

			// 2.获取购物车对象
			ShopCar shopCar = ShopCar.getShopCarIns(request.getSession());

			// 3.删除商品
			shopCar.delete(id);

			response.sendRedirect("shopcat.jsp");
		} else if ("toPay".equals(action)) {

			// 1.先获取登录用户
			User user = (User) request.getSession().getAttribute("user");

			// 2.判断用是否登录
			if (user == null) {
				// response.sendRedirect("login.jsp");
				// return ;
				user = new User();
				user.setId(3);
				user.setUsername("admin");
			}

			// 3.根据用户id查询用户地址
			List<Address> addresseList = addressService.getAddressByUserId(user.getId());

			request.setAttribute("addressList", addresseList);

			// 4.跳转到支付页面
			request.getRequestDispatcher("pay.jsp").forward(request, response);

		} else if ("pay".equals(action)) {

			User user = (User) request.getSession().getAttribute("user");

			// 2.判断用是否登录
			if (user == null) {
				// response.sendRedirect("login.jsp");
				// return ;
				user = new User();
				user.setId(3);
				user.setUsername("admin");
			}
			
			ShopCar shopCar = ShopCar.getShopCarIns(request.getSession());
			

			// 1.获取收货信息和支付，物流信息
			String username = request.getParameter("shouhuoren");
			String phone = request.getParameter("phone");
			String express = request.getParameter("express");
			String address = request.getParameter("address");
			String bank = request.getParameter("bank");

			// 2.把数据封装成对象
			OrderInfo orderInfo = new OrderInfo();
			orderInfo.setO_orderdate(new Date());
			orderInfo.setO_paycount(shopCar.getCount()); // 总金额
			orderInfo.setO_paytype(bank);
			orderInfo.setO_sendtype(express);
			orderInfo.setO_shaddress(address);
			orderInfo.setO_shperson(username);
			orderInfo.setUserid(user.getId());
			orderInfo.setO_shphone(phone);
			
			// 3.添加订单(主键回填)
			int orderId = orderInfoService.addOrderInfo(orderInfo);
			
			// 4.添加订单详情
			List<GoodsInfoDomain> goodsInfoDomains = shopCar.getList();
			for (GoodsInfoDomain goodsInfoDomain : goodsInfoDomains) {
				OrderDetail orderDetail = new OrderDetail();
				orderDetail.setGoods_date(new Date());
				orderDetail.setGoods_description(goodsInfoDomain.getGoods_descrip());
				// 小计(商品的数量*商品优惠价)
				orderDetail.setGoods_total_price(goodsInfoDomain.getCount()*goodsInfoDomain.getGoods_price_off());
				orderDetail.setGoodsid(goodsInfoDomain.getId());
				orderDetail.setGoodsname(goodsInfoDomain.getGoods_name());
				orderDetail.setGoodsnum(goodsInfoDomain.getCount());
				orderDetail.setGoodsprice(goodsInfoDomain.getGoods_price());
				orderDetail.setGoodspic(goodsInfoDomain.getGoods_pic());
				orderDetail.setO_orderid(orderId); // 订单id
				
				// orderDetailService.add(orderDetail);
			}
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
