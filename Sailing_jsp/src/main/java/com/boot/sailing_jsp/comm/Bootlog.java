package com.boot.sailing_jsp.comm;

import com.boot.sailing_jsp.v3.dao.MenuDaoV3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@Transactional(propagation = Propagation.REQUIRES_NEW)
public class Bootlog {

    @Autowired
    MenuDaoV3 menuDaoV3;

    public int doBootLog(String strClass){
        int int1=menuDaoV3.doBootLog(strClass);

        return int1;
    }
}
