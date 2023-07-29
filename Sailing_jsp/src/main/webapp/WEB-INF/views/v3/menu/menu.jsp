<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!-- 타임리프 네임스페이스 적용 -->
<html lang="ko" xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Lazio store Menu</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" type="text/css" href="/css/comm.css">
    <link rel="stylesheet" type="text/css" href="/css/coffee.css">

</head>
<body>

<!-- 헤더 위치(jsp include로 공통헤더 설정) -->
<%@include file="/WEB-INF/views/v3/comm/header.jsp"%>

<div id="main" style="font-size: large; text-align: center;">

    <div id="search" style="height:150px; padding:15px; font-size: small; width:90%; margin-left: auto; margin-right: auto;">
        <h3>[ LazioStore Menu Management <span style="font-size:30px;">&#129413;</span> ]</h3>

        <form name="fm_menu" autocomplete="on" action="/v3/menu_search" method="post">

            <fieldset>
                <legend> [검색조건] </legend>
                <label>등록기간</label>
                <input type="date" id="start_date" name="start_date" min="2020-01-01" max="2024-12-31">
                <input type="date" id="end_date" name="end_date" min="2020-01-01" max="2024-12-31">
                &nbsp;&nbsp;
                <label>상품명</label>
                <input type="text" id="product" name="product">
                &nbsp;&nbsp;
                <label>종류</label>
                <select id="kind" name="kind">
                    <option value="ALL">전체</option>
                    <option value="유니폼">유니폼</option>
                    <option value="축구용품">축구용품</option>
                    <option value="굿즈">굿즈</option>
                </select>
                &nbsp;&nbsp;
                <input type="submit" value="조회" style="width:80px; height:30px; font-weight: bold; font-size: medium">
                &nbsp;&nbsp;
                <button style="width:80px; height:30px; font-weight: bold; font-size:medium"><a href="/v3/menu_ins">등록</a></button>
                &nbsp;&nbsp;
                <button type="button" id="IdUpdateAll" style="width:80px; height:30px; font-weight: bold; font-size: medium" onclick="onModify()">가격수정</button>

            </fieldset>

        </form>

    </div>

    <form name="formTable" id="IdFormTable" method="post" action="/v3/menu_updatePrice">
        <table class="table">
            <thread>
                <tr class="tr_td">
                    <th>Chk</th>
                    <th>상품No</th>
                    <th>상품명</th>
                    <th>종류</th>
                    <th>가격</th>
                    <th>등록일</th>
                    <th>수정일</th>
                    <th>수정</th>
                    <th>삭제</th>
                </tr>
            </thread>

            <tbody id="t_body">

            <!-- 데이터 출력 부분 -->
            <tr th:each="prod : ${list}">
                <td><input type="checkbox" name="chkProductNo" th:value="${prod.getNo()}"></td>
                <td th:text="${prod.getNo()}">상품No</td>
                <td th:text="${prod.getProduct()}">메뉴명</td>
                <td th:text="${prod.getKind()}">종류</td>
                <td th:text="${#numbers.formatInteger(prod.getPrice(),0,'COMMA')}">가격</td>
                <td th:text="${prod.getReg_day()}">등록일</td>
                <td th:text="${prod.getMod_day()}">수정일</td>
                <td><a th:href="@{/v3/menu_up(no=${prod.getNo()})}">수정</a></td>
                <td><a th:href="@{/v3/menu_del(no=${prod.getNo()})}">삭제</a></td>
            </tr>

            </tbody>
        </table>
        <!-- 변경하면 안되는 고정 price 값 히든설정  -->
        <input type="hidden" name="hidden_price">
    </form>
</div>

<!-- 푸터 위치(jsp include로 공통푸터 설정) -->
<%@include file="/WEB-INF/views/v3/comm/footer.jsp"%>

<script>
    /* 현재 시간 날짜에 적용시키기*/
    const now=new Date(); //현재 날짜 및 시간
    const time7=new Date(now.setDate(now.getDate() - 200)); //기간 설정
    document.getElementById("start_date").value=time7.toISOString().slice(0,10);
    document.getElementById("end_date").value=new Date().toISOString().slice(0,10);
</script>

<script>
    //가격수정 버튼 클릭 후 미입력시 알림창 띄우는 자바스크립트 함수
    function onModify(){
        let _price=prompt("가격을 입력하세요");
        //undefinded=가격입력창에서 취소버튼 눌렀을시 가격이 정의되지않았을때
        if(_price==undefined){
            return;
        }else if(_price==""){
            alert("가격을 입력하세요");
            onModify();
        }else if(_price !=""){
            let _frm=document.formTable;
            _frm.hidden_price.value=_price;
            _frm.submit();
        }
    }

</script>
</body>
</html>
