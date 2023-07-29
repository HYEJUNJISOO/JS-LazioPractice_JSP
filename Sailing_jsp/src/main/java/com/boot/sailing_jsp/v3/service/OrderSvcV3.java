package com.boot.sailing_jsp.v3.service;


import com.boot.sailing_jsp.v3.dao.OrderDaoV3;
import com.boot.sailing_jsp.v3.vo.Order_list2;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class OrderSvcV3 {

    @Autowired
    OrderDaoV3 orderDaoV3;

    public List<Order_list2> doList() {

        List<Order_list2> list= orderDaoV3.doList();

        return list;
    }

    //조회하기
    public List<Order_list2> doSearch(String strStartDate, String strEndDate, String strProduct, String strName) {

        List<Order_list2> list = orderDaoV3.doSearch(strStartDate,strEndDate,strProduct,strName);

        return list;

    }
}
