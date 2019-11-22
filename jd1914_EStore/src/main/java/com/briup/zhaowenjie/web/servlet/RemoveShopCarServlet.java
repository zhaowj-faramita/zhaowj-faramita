package com.briup.zhaowenjie.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.zhaowenjie.book.bean.OrderLine;
import com.briup.zhaowenjie.exception.ServiceException;
import com.briup.zhaowenjie.service.impl.ShopCarServiceImpl;
@WebServlet("/RemoveShopCar")
public class RemoveShopCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RemoveShopCarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			@SuppressWarnings("unchecked")
			List<OrderLine> list = (ArrayList<OrderLine>)session.getAttribute("ShopCar");
			list.remove(Integer.parseInt(request.getParameter("id"))-1);
			session.setAttribute("maxPrice", new ShopCarServiceImpl(list).getMaxPrice());
			response.sendRedirect("/jd1914_EStore/user/shopCar");
			return;
		} catch (NumberFormatException e) {
			request.setAttribute("message_removeShopCar", "RemoveShopCar_NumberFormatException");
			response.sendRedirect("/jd1914_EStore/user/shopCar");
			return;
		} catch (ServiceException e) {
			request.setAttribute("message_removeShopCart", e.getMessage());
			response.sendRedirect("/jd1914_EStore/user/shopCar");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
