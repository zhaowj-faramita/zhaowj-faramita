package com.briup.zhaowenjie.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.zhaowenjie.book.bean.Category;
import com.briup.zhaowenjie.exception.ServiceException;
import com.briup.zhaowenjie.service.impl.CategoryServiceImpl;

@WebServlet("/getCategory")
public class GetCategoryAtHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetCategoryAtHomeServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CategoryServiceImpl categoryServiceImpl = new CategoryServiceImpl();
		 ServletContext context = request.getSession().getServletContext();
		String parentId = request.getParameter("category_parentId");
		try {
			List<Category> list = categoryServiceImpl.getCategory(Integer.parseInt(parentId));
			context.setAttribute("category", list);
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		} catch (NumberFormatException e) {
			request.setAttribute("message_getCategory", "NumberFormatException");
			e.printStackTrace();
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch (ServiceException e) {
			request.setAttribute("message_getCategory", e.getMessage());
			e.printStackTrace();
			request.getRequestDispatcher("/index").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
