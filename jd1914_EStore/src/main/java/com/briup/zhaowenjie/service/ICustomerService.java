package com.briup.zhaowenjie.service;

import com.briup.zhaowenjie.book.bean.Customer;
import com.briup.zhaowenjie.exception.ServiceException;

public interface ICustomerService {
	
	Customer login(String username, String password) throws ServiceException;

	void Register(Customer customer) throws ServiceException;
	
}
