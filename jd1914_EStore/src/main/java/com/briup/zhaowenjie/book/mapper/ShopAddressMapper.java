package com.briup.zhaowenjie.book.mapper;

import com.briup.zhaowenjie.book.bean.ShopAddress;
import com.briup.zhaowenjie.book.bean.ShopAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopAddressMapper {
    long countByExample(ShopAddressExample example);

    int deleteByExample(ShopAddressExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ShopAddress record);

    int insertSelective(ShopAddress record);

    List<ShopAddress> selectByExample(ShopAddressExample example);

    ShopAddress selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ShopAddress record, @Param("example") ShopAddressExample example);

    int updateByExample(@Param("record") ShopAddress record, @Param("example") ShopAddressExample example);

    int updateByPrimaryKeySelective(ShopAddress record);

    int updateByPrimaryKey(ShopAddress record);
}