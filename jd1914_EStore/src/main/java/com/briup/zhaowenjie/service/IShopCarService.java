package com.briup.zhaowenjie.service;

import java.util.List;

import com.briup.zhaowenjie.book.bean.OrderLine;
import com.briup.zhaowenjie.exception.ServiceException;

public interface IShopCarService {
	
	List<OrderLine> UpdataShopCarNum(String num) throws ServiceException;
	
	List<OrderLine> removeShopCar(Object orderLine) throws ServiceException;
	
	Double getMaxPrice()throws ServiceException;
}
