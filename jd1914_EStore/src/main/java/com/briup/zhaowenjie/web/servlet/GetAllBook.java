package com.briup.zhaowenjie.web.servlet;

import java.io.IOException;
import java.util.List;
import java.util.TreeSet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.zhaowenjie.book.bean.Book;
import com.briup.zhaowenjie.exception.ServiceException;
import com.briup.zhaowenjie.service.impl.BookServiceImpl;

@WebServlet("/getAllBook")
public class GetAllBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetAllBook() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BookServiceImpl bookServiceImpl = new BookServiceImpl();
		try {
			List<Book> allBook = bookServiceImpl.getAllBook();
			 ServletContext context = request.getSession().getServletContext();

			TreeSet<Book> treeBook = new TreeSet<>((s1, s2) -> {
				if (s1.getPubdate().before(s2.getPubdate())) {
					return 1;
				} else {
					return -1;
				}
			});
			treeBook.addAll(allBook);
			treeBook.forEach(System.out::println);
			context.setAttribute("AllBook", treeBook);
			request.getRequestDispatcher("/index").forward(request, response);
			return;
		} catch (ServiceException e) {
			request.setAttribute("message_getBook", e.getMessage());
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
