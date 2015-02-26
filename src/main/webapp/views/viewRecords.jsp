<%--
  Created by IntelliJ IDEA.
  User: Austin
  Date: 2/19/2015
  Time: 10:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Records</title>
</head>
<body>
    <c:if test="${not empty records}">
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Job Title</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="record" items="${records}">
                    <tr>
                        <td>${record.id}</td>
                        <td>${record.firstName}</td>
                        <td>${record.lastName}</td>
                        <td>${record.jobTitle}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </c:if>
</body>
</html>
