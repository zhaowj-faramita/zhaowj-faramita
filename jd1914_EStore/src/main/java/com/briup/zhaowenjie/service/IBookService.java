package com.briup.zhaowenjie.service;

import java.util.List;

import com.briup.zhaowenjie.book.bean.Book;
import com.briup.zhaowenjie.book.bean.Category;
import com.briup.zhaowenjie.exception.ServiceException;

public interface IBookService {

	List<Book> getBookByCategoryId(int category_id) throws ServiceException;

	List<Book> getAllBook() throws ServiceException;
	
	Book getBook(int id) throws ServiceException;
}
