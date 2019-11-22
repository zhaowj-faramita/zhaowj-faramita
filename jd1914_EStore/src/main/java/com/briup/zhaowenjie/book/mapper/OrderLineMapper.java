package com.briup.zhaowenjie.book.mapper;

import com.briup.zhaowenjie.book.bean.OrderLine;
import com.briup.zhaowenjie.book.bean.OrderLineExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderLineMapper {
    long countByExample(OrderLineExample example);

    int deleteByExample(OrderLineExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrderLine record);

    int insertSelective(OrderLine record);

    List<OrderLine> selectByExample(OrderLineExample example);

    OrderLine selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrderLine record, @Param("example") OrderLineExample example);

    int updateByExample(@Param("record") OrderLine record, @Param("example") OrderLineExample example);

    int updateByPrimaryKeySelective(OrderLine record);

    int updateByPrimaryKey(OrderLine record);
}