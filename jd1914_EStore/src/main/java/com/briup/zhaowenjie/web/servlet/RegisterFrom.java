package com.briup.zhaowenjie.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.zhaowenjie.book.bean.Customer;
import com.briup.zhaowenjie.exception.ServiceException;
import com.briup.zhaowenjie.service.ICustomerService;
import com.briup.zhaowenjie.service.impl.CustomerServiceImpl;

@WebServlet("/RegisterFrom")
public class RegisterFrom extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterFrom() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String zipCode = request.getParameter("zipCode");
		String telephone = request.getParameter("telephone");
		String email = request.getParameter("email");
		if (name.equals("")) {
			request.setAttribute("message_register_name", "姓名不能为空");
			request.getRequestDispatcher("WEB-INF/jsp/register.jsp").forward(request, response);
			return;
		}
		if (password.equals("")) {
			request.setAttribute("message_register_password", "密码不能为空");
			request.getRequestDispatcher("WEB-INF/jsp/register.jsp").forward(request, response);
			return;
		}
		if (zipCode.equals("")) {
			request.setAttribute("message_register_zipCode", "邮编不能为空");
			request.getRequestDispatcher("WEB-INF/jsp/register.jsp").forward(request, response);
			return;
		}
		if (telephone.equals("")) {
			request.setAttribute("message_register_telephone", "号码不能为空");
			request.getRequestDispatcher("WEB-INF/jsp/register.jsp").forward(request, response);
			return;
		}
		if (email.equals("")) {
			request.setAttribute("message_register_email", "邮箱不能为空");
			request.getRequestDispatcher("WEB-INF/jsp/register.jsp").forward(request, response);
			return;
		} else {
			Customer customer = new Customer(name, password, zipCode, telephone, email);
			ICustomerService customerService = new CustomerServiceImpl();
			try {
				customerService.Register(customer);
				request.setAttribute("message", "注册成功");
				request.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(request, response);
				return;
			} catch (ServiceException e) {
				request.setAttribute("message_register_name", e.getMessage());
				request.getRequestDispatcher("WEB-INF/jsp/register.jsp").forward(request, response);
				e.printStackTrace();
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
