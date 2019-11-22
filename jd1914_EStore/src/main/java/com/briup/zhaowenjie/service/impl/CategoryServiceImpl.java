package com.briup.zhaowenjie.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.zhaowenjie.book.bean.Category;
import com.briup.zhaowenjie.book.mapper.CategoryMapper;
import com.briup.zhaowenjie.exception.ServiceException;
import com.briup.zhaowenjie.service.ICategoryService;
import com.briup.zhaowenjie.util.SqlSessionBuilder;

public class CategoryServiceImpl implements ICategoryService {
	SqlSession sqlSession = null;

	@Override
	public List<Category> getCategory(int parentId) throws ServiceException {
		sqlSession = SqlSessionBuilder.getSqlSession(true);
		CategoryMapper categoryMapper = sqlSession.getMapper(CategoryMapper.class);
		List<Category> list = categoryMapper.selectByParentId(parentId);
		if(list.isEmpty()) {
			throw new ServiceException("无匹配类型");
		} else {
			return list;
		}
		
	}

}
