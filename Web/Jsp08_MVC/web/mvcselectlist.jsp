<%@ page import="com.mvc.dto.MVCDto" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>SELECT ONE</h1>
    <jsp:useBean id="dto" class="com.mvc.dto.MVCDto" scope="request"></jsp:useBean>

    <table border="1">
        <tr>
            <th>작성자</th>
            <td><jsp:getProperty name="dto" property="writer"/></td>
        </tr>
        <tr>
            <th>제목</th>
            <td><jsp:getProperty name="dto" property="title"/></td>

        </tr>
        <tr>
            <th>내용</th>
            <td><textarea rows="10" cols="60" readonly="readonly"><jsp:getProperty name="dto" property="content"/></textarea></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="button" value="수정" onclick="location.href='mvc.do?command=updateform&seq='<jsp:getProperty name="dto" property="seq"/>">
                <input type="button" value="삭제" onclick="location.href='mvc.do?command=delete&seq=<jsp:getProperty name="dto" property="seq"/>'">
                <input type="button" value="목록" onclick="location.href='mvc.do?command=list'">
            </td>
        </tr>
    </table>

</body>
</html>