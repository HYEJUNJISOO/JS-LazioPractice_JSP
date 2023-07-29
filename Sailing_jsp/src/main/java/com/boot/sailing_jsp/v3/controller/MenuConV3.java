package com.boot.sailing_jsp.v3.controller;


import com.boot.sailing_jsp.v3.service.MenuSvcV3;
import com.boot.sailing_jsp.v3.vo.Product_menu;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/v3")
@Log4j2
public class MenuConV3 {

    @Autowired
    MenuSvcV3 menuSvc;

    @RequestMapping("/menu")
    public String doMenu(Model model){

        //Data 만들기 List , Map
        List<Product_menu> list= menuSvc.doList();

        // Data 송부
        model.addAttribute("list",list);


        return "/v3/menu/menu";
    }

    //등록버튼 누를시 등록화면 띄우기
    @GetMapping("/menu_ins")
    public String doInsert(){
        return "/v3/menu/menu_ins";
    }

    //등록버튼 누를시 데이터 뷰에 송부
    @PostMapping("/menu_ins")
    public String doInsertPost(@ModelAttribute Product_menu productMenu
    ){

        int i = menuSvc.doInsert(productMenu);

        return "redirect:/v3/menu";
    }

    //삭제 기능
    @GetMapping("/menu_del")
    public String doDelete(@RequestParam("no") String strNo){

        log.info("strNo: "+strNo);

        int i=menuSvc.doDelete(strNo);

        return "redirect:/v3/menu";
    }

    @GetMapping("/menu_up")
    public String doUpdate(Model model,
                           @RequestParam("no") String strNo){

        Map<String,Object> map = menuSvc.doListOne(strNo);
        model.addAttribute("map",map);

        return "/v3/menu/menu_up";
    }

    //수정버튼 누를시 데이터 뷰에 송부
    @PostMapping("/menu_up")
    public String doUpdatePost(Product_menu productMenu
    ){

        int i = menuSvc.doUpdate(productMenu);

        return "redirect:/v3/menu";
    }

    //조회하기
    @PostMapping("/menu_search")
    public String doSearch(@RequestParam("start_date") String strStartDate,
                           @RequestParam("end_date") String strEndDate,
                           @RequestParam(value="product" , defaultValue="ALL") String strProduct,
                           @RequestParam("kind") String strKind,
                           Model model
    ){
        log.info("strStartDate: "+strStartDate);

        List<Product_menu> list = menuSvc.doSearch(strStartDate,strEndDate,strProduct,strKind);

        model.addAttribute("list",list);

        return "/v3/menu/menu";
    }

    //가격수정(다중체크)
    @PostMapping("/menu_updatePrice")
    public String doUpdatePrice(@RequestParam("chkProductNo") List<String> chkList,
                                @RequestParam("hidden_price") String strPrice,
                                Model model

    ){

        String strReturn="redirect:/v3/menu";

        try {
            if (chkList != null) {
//            for(String strNo:chkList){
//
//                int int2=menuSvc.doUpdatePrice(strNo,strPrice);
//                int int1=menuSvc.doInsertLog(strNo,strPrice);
//            }
                int int1 = menuSvc.doUpdateInsert(chkList, strPrice);
//            int int1=menuSvc.doInsertLogOne(chkList, strPrice);
//            int int2=menuSvc.doUpdatePriceOne(chkList,strPrice);
            }
        }catch (Exception e){
            log.info("Error Error Error : "+e.getMessage());

            model.addAttribute("em",e.getMessage());
            strReturn="/v3/comm/ErrorPage";
        }

        return strReturn;
    }
}
