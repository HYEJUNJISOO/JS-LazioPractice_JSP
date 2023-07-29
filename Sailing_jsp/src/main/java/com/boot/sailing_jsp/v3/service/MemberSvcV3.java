package com.boot.sailing_jsp.v3.service;


import com.boot.sailing_jsp.v3.dao.MemberDaoV3;
import com.boot.sailing_jsp.v3.vo.Cust_info2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberSvcV3 {

    @Autowired
    MemberDaoV3 memberDaoV3;


    public List<Cust_info2> doList() {

        List<Cust_info2> list= memberDaoV3.doList();

        return list;
    }

    public List<Cust_info2> doSearch(String strStartDate, String strEndDate, String strName) {

        List<Cust_info2> list=memberDaoV3.doSearch(strStartDate,strEndDate,strName);

        return list;
    }
}
