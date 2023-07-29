<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko"  xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Coffee Menu</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" type="text/css" href="/css/comm.css">
    <link rel="stylesheet" type="text/css" href="/css/coffee.css">

</head>
<body>

<!-- 헤더 위치(jsp include로 공통헤더 설정) -->
<%@include file="/WEB-INF/views/v3/comm/header.jsp"%>


<div id="main" style="font-size:large; text-align: center; ">

    <div id="search" style="height: 300px;padding: 15px; font-size: small; width: 90%; margin-left: auto;  margin-right: auto;">
        <h3>[ Product menu 수정 <span style="font-size:30px;">&#129413;</span> ] </h3>

        <form name="fm_menu_ins" autocomplete="on" action="/v3/menu_up" method="post">
            <fieldset>

                <legend> [상품 메뉴 수정] </legend>
                <label>메뉴명</label> <input type="text" id="name" name="product" th:value="${map.get('product')}"></p>
                <label>종 류 </label><select name="kind">
                                    <option value="유니폼" th:selected="${map.get('kind')} == '유니폼'">유니폼</option>
                                    <option value="축구용품" th:selected="${map.get('kind')} == '축구용품'">축구용품</option>
                                    <option value="굿즈" th:selected="${map.get('kind')} == '굿즈'">굿즈</option>
                                    </select>
                                        </p>
                &nbsp;&nbsp;
                <label>가 격 </label><input type="number" name="price" th:value="${map.get('price')}"></p>
                <input type="hidden" name="no" th:value="${map.get('no')}">

                <input type="submit" value="상품 수정" style="width: 100px;height: 30px;font-weight: bold; font-size: medium">
            </fieldset>
        </form>


    </div>

</div>

<!-- 푸터 위치(jsp include로 공통푸터 설정) -->
<%@include file="/WEB-INF/views/v3/comm/footer.jsp"%>

</body>
</html>


