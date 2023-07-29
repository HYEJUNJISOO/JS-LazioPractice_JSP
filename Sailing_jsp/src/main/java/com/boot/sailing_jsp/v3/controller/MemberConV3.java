package com.boot.sailing_jsp.v3.controller;


import com.boot.sailing_jsp.v3.service.MemberSvcV3;
import com.boot.sailing_jsp.v3.vo.Cust_info2;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/v3")
@Log4j2
public class MemberConV3 {

    @Autowired
    MemberSvcV3 memberSvcV3;

    @RequestMapping("/member")
    public String doMember(Model model){

        //Data 만들기 List , Map
        List<Cust_info2> list= memberSvcV3.doList();

        // Data 송부
        model.addAttribute("list",list);
        model.addAttribute("hello","=========== JSP ============");


        return "/v3/member/member";
    }



    /* 조회하기 */

    @PostMapping("/member_search")
    public String doSearch(@RequestParam("start_date") String strStartDate,
                           @RequestParam("end_date") String strEndDate,
                           @RequestParam("name") String strName,
                           Model model
    ){
        log.info("strStartDate: "+strStartDate);

        List<Cust_info2> list = memberSvcV3.doSearch(strStartDate,strEndDate,strName);

        model.addAttribute("list",list);
        model.addAttribute("hello","=========== JSP Search ============");


        return "/v3/member/member";
    }
}
