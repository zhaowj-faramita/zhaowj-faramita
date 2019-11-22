package com.briup.zhaowenjie.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.zhaowenjie.book.bean.Customer;
import com.briup.zhaowenjie.exception.ServiceException;
import com.briup.zhaowenjie.service.impl.CustomerServiceImpl;

@WebServlet("/LoginFrom")
public class LoginFrom extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginFrom() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
		try {
			String username = request.getParameter("name");
			System.out.println(username);
			Customer customer = customerServiceImpl.login(username, request.getParameter("password"));
			request.getSession().setAttribute("customer",customer);
			response.sendRedirect("/jd1914_EStore/");
			return;
		} catch (ServiceException e) {
			request.setAttribute("message_login", e.getMessage());
			request.getRequestDispatcher("login").forward(request, response);
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
