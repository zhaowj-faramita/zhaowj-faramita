package com.briup.zhaowenjie.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.zhaowenjie.book.bean.Book;
import com.briup.zhaowenjie.book.bean.BookExample;
import com.briup.zhaowenjie.book.bean.BookExample.Criteria;
import com.briup.zhaowenjie.book.mapper.BookMapper;
import com.briup.zhaowenjie.exception.ServiceException;
import com.briup.zhaowenjie.service.IBookService;
import com.briup.zhaowenjie.util.SqlSessionBuilder;



public class BookServiceImpl implements IBookService {
	SqlSession sqlSession = null;

	@Override
	public List<Book> getBookByCategoryId(int category_id) throws ServiceException {
		BookExample bookExample = new BookExample();
		Criteria criteria = bookExample.createCriteria();
		criteria.andCategoryIdEqualTo(category_id);
		sqlSession = SqlSessionBuilder.getSqlSession(true);
		BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
		List<Book> list = bookMapper.selectByExample(bookExample);
		if(list.isEmpty()) {
			throw new ServiceException("无该种书籍");
		} else {
			return list;
		}
	}

	@Override
	public List<Book> getAllBook() throws ServiceException {
		sqlSession = SqlSessionBuilder.getSqlSession(true);
		BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
		List<Book> list = bookMapper.selectAll();
		if(list.isEmpty()) {
			throw new ServiceException("无任何书籍");
		} else {
			return list;
		}
	}

	@Override
	public Book getBook(int id) throws ServiceException {
		sqlSession = SqlSessionBuilder.getSqlSession(true);
		BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
		Book book = bookMapper.selectByPrimaryKey(id);
		if(book == null) {
			throw new ServiceException("无该书籍");
		} else {
			return book;
		}
	}

}
