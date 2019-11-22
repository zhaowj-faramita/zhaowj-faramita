package com.briup.zhaowenjie.service;

import java.util.List;

import com.briup.zhaowenjie.book.bean.Category;
import com.briup.zhaowenjie.exception.ServiceException;

public interface ICategoryService {
	
	List<Category> getCategory(int parentId) throws ServiceException;
	
	
}
