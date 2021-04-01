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

    <h1>DETAIL</h1>

    <table border="1">
        <tr>
            <th>작성자</th>
            <td>${dto.writer }</td>
        </tr>
        <tr>
            <th>제목</th>
            <td>${dto.title }</td>
        </tr>
        <tr>
            <th>작성자</th>
            <td><textarea rows="10" cols="60" readonly="readonly">${dto.content }</textarea></td>
        </tr>
        <tr>
            <td colspan="3">
                <input type="button" value="답변" onclick="location.href='answer.do?command=answerForm&boardno=${dto.boardno }'">
                <input type="button" value="수정" onclick="location.href='answer.do?command=updateForm&boardno=${dto.boardno }'">
                <input type="button" value="삭제" onclick="location.href='answer.do?command=delete&boardno=${dto.boardno }'">
                <input type="button" value="메인으로" onclick="location.href='answer.do?command=list'">
            </td>
        </tr>
    </table>
</body>
</html>
