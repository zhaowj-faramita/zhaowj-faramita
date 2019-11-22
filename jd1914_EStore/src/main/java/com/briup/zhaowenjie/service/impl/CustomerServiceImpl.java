package com.briup.zhaowenjie.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.zhaowenjie.book.bean.Customer;
import com.briup.zhaowenjie.book.bean.CustomerExample;
import com.briup.zhaowenjie.book.bean.CustomerExample.Criteria;
import com.briup.zhaowenjie.book.mapper.CustomerMapper;
import com.briup.zhaowenjie.exception.ServiceException;
import com.briup.zhaowenjie.service.ICustomerService;
import com.briup.zhaowenjie.util.SqlSessionBuilder;

public class CustomerServiceImpl implements ICustomerService {
	SqlSession sqlSession = null;

	@Override
	public Customer login(String username, String password) throws ServiceException {
		CustomerExample customerExample = new CustomerExample();
		Criteria criteria = customerExample.createCriteria();
		criteria.andNameEqualTo(username);
		sqlSession = SqlSessionBuilder.getSqlSession(true);
		CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
		List<Customer> list = customerMapper.selectByExample(customerExample);
		if(list.isEmpty()) {
			throw new ServiceException("用户不存在，请注册");
		} else {
			for (Customer customer : list) {
				if(customer.getPassword().equals(password)) {
					return customer;
				} 
			}
			throw new ServiceException("密码错误");
		}
		
	}

	@Override
	public void Register(Customer customer) throws ServiceException {
		CustomerExample customerExample = new CustomerExample();
		Criteria criteria = customerExample.createCriteria();
		criteria.andNameEqualTo(customer.getName());
		sqlSession = SqlSessionBuilder.getSqlSession(true);
		CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
		List<Customer> list = customerMapper.selectByExample(customerExample);
		if (list.isEmpty()) {
			customerMapper.insert(customer);
		} else {
			throw new ServiceException("用户名已存在");
		}
	}

}
