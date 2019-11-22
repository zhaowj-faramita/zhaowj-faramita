package com.briup.zhaowenjie.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter("/user/*")
public class UserFilter implements Filter {

    public UserFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest= (HttpServletRequest)request;
		HttpSession session = httpServletRequest.getSession();
		if(session.getAttribute("customer")==null) {
			request.getRequestDispatcher("/login").forward(request, response);
			return;
		} else {
			chain.doFilter(request, response);
			return;
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
