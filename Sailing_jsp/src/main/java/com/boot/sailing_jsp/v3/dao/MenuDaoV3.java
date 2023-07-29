package com.boot.sailing_jsp.v3.dao;

import com.boot.sailing_jsp.v3.vo.Product_menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MenuDaoV3 {

    List<Product_menu> doList();

    int doInsert(Product_menu productMenu);

    int doDelete(String strNo);

    //One row 조회
    Map<String, Object> doListOne(String strNo);

    // Update
    int doUpdate(Product_menu productMenu);

    // Search
    List<Product_menu> doSearch(String strStartDate, String strEndDate, String strProduct, String strKind);

    // 가격수정
    int doUpdatePrice(String strNo, String strPrice);

    // 가격수정 로그입력
    int doInsertLog(String strNo, String strPrice);

    // 가격수정 로그입력(원쿼리)
    int doInsertLogOne(List<String> chkList, String strPrice);

    //가격수정(원쿼리)
    int doUpdatePriceOne(List<String> chkList, String strPrice);

    int doBootLog(String name);
}
