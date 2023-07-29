<%@ page import="com.boot.sailing_jsp.v3.vo.Cust_info2" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String hello=(String)request.getAttribute("hello");
  List<Cust_info2> list=(List<Cust_info2>) request.getAttribute("list");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <title>Member List</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <link rel="stylesheet" type="text/css" href="/css/comm.css">
  <link rel="stylesheet" type="text/css" href="/css/coffee.css">

</head>
<body>

<!-- 헤더 위치(jsp include로 공통헤더 설정) -->
<%@include file="/WEB-INF/views/v3/comm/header.jsp"%>


<div id="main" style="font-size:large; text-align: center; ">

  <div id="search" style="height: 150px;padding: 15px; font-size: small; width: 90%; margin-left: auto;  margin-right: auto;">
    <h3>[ Member Info <span style="font-size:30px;">&#128699;</span> ] <%=hello%></h3>

    <form name="fm_member" autocomplete="on" action="/v3/member_search" method="post">
      <fieldset>
        <legend> [검색조건] </legend>
        <label>등록기간</label><input type="date" id="start_date" name="start_date" min="2020-01-01" max="2023-12-31">
        - <input type="date" id="end_date" name="end_date" min="2020-01-01" max="2023-12-31">
        &nbsp;&nbsp;
        <label>고객명</label> <input type="text" id="name" name="name">


        &nbsp;&nbsp;<input type="submit" value="조회" style="width: 80px;height: 30px;font-weight: bold; font-size: medium">

      </fieldset>

    </form>


  </div>


  <table class="table">
    <thead>
    <tr class="tr_td">
      <th>Chk</th>
      <th>고객ID</th>
      <th>고객명</th>
      <th>이메일</th>
      <th>권한</th>
      <th>등록일</th>
    </tr>
    </thead>


    <tbody id="t_body">
    <% for(Cust_info2 custInfo2 : list){ %>
    <tr class="tr_td">
      <td><input type="checkbox" name="chkMemberNo" value="<%=custInfo2.getNo()%>"></td>
      <th><%=custInfo2.getCust_id()%></th>
      <td><%=custInfo2.getName()%></td>
      <td><%=custInfo2.getEmail()%></td>
      <td><%=custInfo2.getRole()%></td>
      <td><%=custInfo2.getReg_day()%></td>
    </tr>
    <% } %>
    </tbody>
  </table>
</div>

<!-- 푸터 위치(jsp include로 공통푸터 설정) -->
<%@include file="/WEB-INF/views/v3/comm/footer.jsp"%>

<script>
  /* 현재 시간 날짜에 적용시키기 */
  const now = new Date();	// 현재 날짜 및 시간
  const time7 = new Date(now.setDate(now.getDate() - 100));	// 기간 설정
  document.getElementById("start_date").value= time7.toISOString().slice(0,10);
  document.getElementById("end_date").value= new Date().toISOString().slice(0,10);
</script>

</body>
</html>


