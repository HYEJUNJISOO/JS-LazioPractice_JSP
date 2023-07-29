package com.boot.sailing_jsp.v3.dao;

import com.boot.sailing_jsp.v3.vo.Order_list2;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderDaoV3 {

    List<Order_list2> doList();

    //조회하기
    List<Order_list2> doSearch(String strStartDate, String strEndDate, String strProduct, String strName);
}
