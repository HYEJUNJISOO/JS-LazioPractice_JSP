<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <title>Lazio Store_Home</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- content="width=device-width 장치에따른 화면너비를 따르도록 페이지 너비지정 , initial-scale=1 : 페이지 처음로드할때 초기 확대/축소 수준설정 -->
  <link rel="stylesheet" type="text/css" href="/css/comm.css">
  <!-- link태그는 외부의 문서를 연결시키는 태그 -->

</head>
<body>

<!-- 헤더 위치(jsp include로 공통헤더 설정) -->
<%@include file="/WEB-INF/views/v3/comm/header.jsp"%>

<div id="main" style="font-size:large; alignment: center; padding:10px 50px">
  <table>
    <tr>
      <td style="width:450px">
        <p>안녕하세요 Lazio Store Korea 입니다<p>
        다양한 라치오관련 유니폼 및 굿즈를 판매중입니다<p>
        감사합니다.
      </p>
        <p>
        <hr>
        <!-- hr : 구분선 그음 -->
        <ul style="list-style-type:square;">
          <li>Develop Tool : InteliJ</li>
          <li>Java Version : 1.8</li>
          <li>View : jsp </li>
          <li>DBMS : Maria DB</li>
          <li>Mapper : MyBatis</li>
        </ul>
        </p>
      </td>
      <td style="width:auto">
        <img src="/img/laziologo.png" style="width:500px">
      </td>
    </tr>
  </table>
</div>

<!-- 푸터 위치(jsp include로 공통푸터 설정) -->
<%@include file="/WEB-INF/views/v3/comm/footer.jsp"%>

</body>
</html>



