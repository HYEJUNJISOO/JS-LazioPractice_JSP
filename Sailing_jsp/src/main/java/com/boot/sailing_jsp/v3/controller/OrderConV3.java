package com.boot.sailing_jsp.v3.controller;


import com.boot.sailing_jsp.v3.service.OrderSvcV3;
import com.boot.sailing_jsp.v3.vo.Order_list2;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Log4j2
@RequestMapping("/v3")
public class OrderConV3 {

    @Autowired
    OrderSvcV3 orderSvcV3;

    @RequestMapping("/order")
    public String doOrder(Model model){

        //Data 만들기 List , Map
        List<Order_list2> list= orderSvcV3.doList();

        // Data 송부
        model.addAttribute("list",list);
        model.addAttribute("hello","=========== JSP ============");



        return "/v3/order/order";
    }

    //조회하기
    @PostMapping("/order_search")
    public String doSearch(@RequestParam("start_date") String strStartDate,
                           @RequestParam("end_date") String strEndDate,
                           @RequestParam(value="product" , defaultValue="ALL") String strProduct,
                           @RequestParam("name") String strName,
                           Model model
    ){
        log.info("strStartDate: "+strStartDate);

        List<Order_list2> list = orderSvcV3.doSearch(strStartDate,strEndDate,strProduct,strName);

        model.addAttribute("list",list);

        return "/v3/order/order";
    }

}
