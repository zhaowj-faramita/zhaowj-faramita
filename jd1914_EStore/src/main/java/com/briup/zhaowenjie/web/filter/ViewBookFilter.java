package com.briup.zhaowenjie.web.filter;

import java.io.IOException;
import java.util.TreeSet;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.briup.zhaowenjie.book.bean.Book;

@WebFilter("/viewBook")
public class ViewBookFilter implements Filter {

	public ViewBookFilter() {
		// TODO Auto-generated constructor stub
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
		Object object = httpServletRequest.getSession().getServletContext().getAttribute("AllBook");
		if(object==null) {
			httpServletRequest.getRequestDispatcher("/getAllBook").forward(request, response);
		} else {
			TreeSet<Book> allBook = (TreeSet<Book>)object;
			for (Book book2 : allBook) {
				if(book2.getId().toString().equals(request.getParameter("id"))) {
					httpServletRequest.getSession().setAttribute("book", book2);
					chain.doFilter(request, response);
					return;
				}
			}
			request.setAttribute("message_viewBook", "未找到该书籍");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
