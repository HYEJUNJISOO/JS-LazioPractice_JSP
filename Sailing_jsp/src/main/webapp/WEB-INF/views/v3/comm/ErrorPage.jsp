<!-- 타임리프 네임스페이스 적용 -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ko" xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Lazio store Menu</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" type="text/css" href="/css/comm.css">
    <link rel="stylesheet" type="text/css" href="/css/coffee.css">

</head>
<body>

<!-- 헤더 위치(타임리프로 공통헤더 설정예정) -->
<th:block th:replace="/v3/comm/header :: headerFragment"></th:block>

<div id="main" style="font-size:large; alignment:center; padding:10px 50px">
    <img src="/img/Error.jpg" style="width:800px">
    <p>
        오류 메세지 : <label th:text="${em}"></label>
    </p>

</div>
</main>

<!-- 푸터 위치(타임리프로 공통헤더 설정예정) -->
<th:block th:replace="/v3/comm/footer :: footerFragment"></th:block>


</body>
</html>