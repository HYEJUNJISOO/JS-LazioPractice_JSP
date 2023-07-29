package com.boot.sailing_jsp.v3.service;


import com.boot.sailing_jsp.comm.Bootlog;
import com.boot.sailing_jsp.comm.MyExceptionRuntime;
import com.boot.sailing_jsp.v3.dao.MenuDaoV3;
import com.boot.sailing_jsp.v3.vo.Product_menu;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Log4j2
public class MenuSvcV3 {

    @Autowired
    MenuDaoV3 menuDao;

    @Autowired
    Bootlog bootlog;

    @Autowired
    PlatformTransactionManager transactionManager;

    @Autowired
    TransactionDefinition definition;

    @Autowired
    TransactionTemplate transactionTemplate;

    //Dao에 연동시켜서 뷰로 데이터 전송
    public List<Product_menu> doList(){

        //Data 만들기 List , Map
        List<Product_menu> list=menuDao.doList();

        log.info(list);

        return list;
    }

    //List,Map 이용하여 수동으로 데이터 뷰로 전송
    public List<Map<String,Object>> doListOld(){

        //Data 만들기 List , Map
        List<Map<String,Object>> list=new ArrayList<>();

        Map<String,Object> map=new HashMap<>();

        map.put("No","1");
        map.put("name","Lazio Home Kit(2023-2024)");
        map.put("kind","유니폼");
        map.put("price","150,000");
        map.put("reg_day","2022.07.17");
        map.put("mod_day","2023.07.17");
        list.add(map);

        Map<String,Object> map2=new HashMap<>();

        map2.put("No","2");
        map2.put("name","Lazio Away Kit(2023-2024)");
        map2.put("kind","유니폼");
        map2.put("price","145,000");
        map2.put("reg_day","2022.09.30");
        map2.put("mod_day","2023.07.17");
        list.add(map2);

        Map<String,Object> map3=new HashMap<>();

        map3.put("No","3");
        map3.put("name","Luis Alberto Soccer Shoes");
        map3.put("kind","축구용품");
        map3.put("price","317,000");
        map3.put("reg_day","2023.02.14");
        map3.put("mod_day","2023.07.17");
        list.add(map3);

        log.info(list);

        return list;

    }

    public int doInsert(Product_menu productMenu) {

        int i = menuDao.doInsert(productMenu);

        return i;
    }

    public int doDelete(String strNo) {

        int i=menuDao.doDelete(strNo);

        return i;
    }

    //One row 조회
    public Map<String, Object> doListOne(String strNo) {

        Map<String,Object> map = menuDao.doListOne(strNo);

        return map;
    }

    // Update
    public int doUpdate(Product_menu productMenu) {

        int i = menuDao.doUpdate(productMenu);

        return i;
    }

    // 조회하기
    public List<Product_menu> doSearch(String strStartDate, String strEndDate, String strProduct, String strKind) {

        List<Product_menu> list = menuDao.doSearch(strStartDate,strEndDate,strProduct,strKind);

        return list;
    }

    //가격 수정하기
    public int doUpdatePrice(String strNo, String strPrice) {
        int int2=menuDao.doUpdatePrice(strNo,strPrice);
        return int2;
    }

    //가격 로그입력
    public int doInsertLog(String strNo, String strPrice) {
        int int1=menuDao.doInsertLog(strNo,strPrice);
        return int1;
    }

    //가격 로그입력(원쿼리)
    public int doInsertLogOne(List<String> chkList, String strPrice) {
        int int1=menuDao.doInsertLogOne(chkList, strPrice);
        return int1;
    }

    //가격 수정하기(원쿼리)
    public int doUpdatePriceOne(List<String> chkList, String strPrice) {
        int int2=menuDao.doUpdatePriceOne(chkList,strPrice);
        return int2;
    }

    /*
    //@Transactional(rollbackFor = Exception.class)
    //가격 수정 및 로그입력(원커리 / TransactionManager 사용해봄)
    public int doUpdateInsert(List<String> chkList, String strPrice) throws RuntimeException {

        int int1=0;
        try {
            TransactionStatus status = transactionManager.getTransaction(definition);
            int int2 = menuDao.doUpdatePriceOne(chkList, strPrice);
                transactionManager.rollback(status);

            TransactionStatus status2 = transactionManager.getTransaction(definition);
            int1 = menuDao.doInsertLogOne(chkList, strPrice); // -> autocommit으로 commit됨
                transactionManager.rollback(status2); // -> 해당 commit 은 실행불가 오류발생함 -> transactionManager 각각 한개씩 선언해줘야 실행가능

        }catch (Exception e){
            throw new MyExceptionRuntime(e.getMessage(), getClass().getName());
        }finally {
            log.info("==================== Finally ====================");

            TransactionStatus status3 = transactionManager.getTransaction(definition);
            bootlog.doBootLog(getClass().getName());
            transactionManager.rollback(status3);
        }

        return int1;
*/
    //가격 수정 및 로그입력(원커리 / transactionTemplate 사용해봄)
    //transactionTemplate는 오류없이 잘 돌아가면 자동 Commit 됨
    public int doUpdateInsert(List<String> chkList, String strPrice) throws RuntimeException {

        int rI=0;
        try {

            log.info("================ return ==============================");
            rI = transactionTemplate.execute(status -> {
                        int int2 = menuDao.doUpdatePriceOne(chkList, strPrice);
                        //status.setRollbackOnly();//한 세션을 강제로 롤백시키기
                        return int2;
                    });

            log.info("================ No return ==============================");
            transactionTemplate.execute(new TransactionCallbackWithoutResult() {
                @Override
                protected void doInTransactionWithoutResult(TransactionStatus status) {
                    int int1 = menuDao.doInsertLogOne(chkList,strPrice);
                    //status.setRollbackOnly();
                }
            });


        }catch (Exception e){
            throw new MyExceptionRuntime(e.getMessage(), getClass().getName());
        }finally {
            log.info("==================== Finally ====================");
            TransactionStatus status3 = transactionManager.getTransaction(definition);
            bootlog.doBootLog(getClass().getName());
            transactionManager.commit(status3);
        }

        return rI;



        // Checked Exception
//        File file = new File("not_existing_file.txt");
//        FileInputStream stream
//                = new FileInputStream(file);

        //Unchecked Exception, -> ArithmeticException
//            int numerator = 1;
//            int denominator = 0;
//            int result = numerator / denominator;
    }


}