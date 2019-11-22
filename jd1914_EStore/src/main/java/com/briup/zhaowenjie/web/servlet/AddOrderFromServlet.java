package com.briup.zhaowenjie.web.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.zhaowenjie.book.bean.Customer;
import com.briup.zhaowenjie.book.bean.OrderForm;
import com.briup.zhaowenjie.book.bean.OrderLine;

@WebServlet("/user/addOrderForm")
public class AddOrderFromServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public AddOrderFromServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MMdd-SSS");
		Object object = session.getAttribute("OrderFroms");
		Object object2 = session.getAttribute("customer");
		List<OrderForm> orderFromlist = null;
		if(object==null) {
			orderFromlist = new ArrayList<OrderForm>(0);
			
		} else {
			@SuppressWarnings("unchecked")
			ArrayList<OrderForm> oderformlist = (ArrayList<OrderForm>)object;
			orderFromlist = oderformlist;
		} 
		OrderForm orderForm = new OrderForm();
		Customer customer = (Customer)object2;
		@SuppressWarnings("unchecked")
		List<OrderLine> list = (ArrayList<OrderLine>)session.getAttribute("ShopCar");
		if(list==null) {
			System.out.println("aaaaaaaaaaaaaaa");
			response.sendRedirect("/jd1914_EStore/user/shopCar");
		} else {
			orderForm.setOrderdate(new Date());
			orderForm.setCustomerId(customer.getId());
			orderForm.setCost((Double)session.getAttribute("maxPrice"));
			orderForm.setOrderLinelist(list);
			orderForm.setCustomer(customer);
			orderForm.setOrderFromNumber(simpleDateFormat.format(orderForm.getOrderdate()));
			orderFromlist.add(orderForm);
			session.setAttribute("OrderFroms", orderFromlist);
			for (OrderForm form : orderFromlist) {
				System.out.println(form);
			}
			response.sendRedirect("/jd1914_EStore/user/orderList");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
