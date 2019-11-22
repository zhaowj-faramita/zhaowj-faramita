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

import com.briup.zhaowenjie.book.bean.Book;
import com.briup.zhaowenjie.book.bean.OrderLine;
import com.briup.zhaowenjie.exception.ServiceException;
import com.briup.zhaowenjie.service.impl.ShopCarServiceImpl;

@WebServlet("/user/addShopCar")
public class AddBookToShopCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddBookToShopCarServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int num = Integer.parseInt(request.getParameter("num"));
			HttpSession session = request.getSession();
			Book book = (Book)session.getAttribute("book");
			if(num==0||book==null) {
				request.getRequestDispatcher("/user/shopCar").forward(request, response);
				return;
			} else {
				@SuppressWarnings("unchecked")
				List<OrderLine> list = (ArrayList<OrderLine>)session.getAttribute("ShopCar");
				if(list==null) {
					list = new ArrayList<OrderLine>(0);
				} 
				OrderLine orderLine = new OrderLine();
				orderLine.setNum(num);
				orderLine.setBookId(book.getId());
				orderLine.setBook(book);
				orderLine.setCost(num*book.getPrice());
				list.add(orderLine);
				session.setAttribute("ShopCar", list);
				session.setAttribute("maxPrice", new ShopCarServiceImpl(list).getMaxPrice());
				response.sendRedirect("/jd1914_EStore/user/shopCar");
				return;
			}
		} catch (NumberFormatException e) {
			request.setAttribute("message_addShopCart", "addShopCart_NumberFormatException");
			response.sendRedirect("/jd1914_EStore/user/shopCar");
		} catch (ServiceException e) {
			request.setAttribute("message_addShopCart", e.getMessage());
			response.sendRedirect("/jd1914_EStore/user/shopCar");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
