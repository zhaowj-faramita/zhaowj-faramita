package com.briup.zhaowenjie.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.briup.zhaowenjie.book.bean.OrderLine;
import com.briup.zhaowenjie.exception.ServiceException;
import com.briup.zhaowenjie.service.IShopCarService;

public class ShopCarServiceImpl implements IShopCarService {

	List<OrderLine> list = null;

	@SuppressWarnings("unchecked")
	public ShopCarServiceImpl(Object object) throws ServiceException {
		if(object instanceof ArrayList<?>) {
			ArrayList<OrderLine> list = (ArrayList<OrderLine>)object;
			this.list=list;
		} else {
			throw new ServiceException("");
		}
	}

	private ShopCarServiceImpl() {

	}

	@Override
	public List<OrderLine> UpdataShopCarNum(String num) throws ServiceException{
		int newNum = Integer.parseInt(num);
		return null;
	}


	@Override
	public Double getMaxPrice() throws ServiceException {
		Double maxPrice = 0d;
		for (OrderLine orderLine : list) {
			maxPrice +=orderLine.getNum()*orderLine.getBook().getPrice();
		}
		return maxPrice;
	}

	@Override
	public List<OrderLine> removeShopCar(Object orderLine) throws ServiceException {
		return null;
	}

}
