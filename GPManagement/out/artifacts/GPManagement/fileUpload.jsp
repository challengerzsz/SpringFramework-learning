<%--
  Created by IntelliJ IDEA.
  User: 66490
  Date: 2018/5/21
  Time: 17:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>文件上传下载</title>
</head>
<body>
<form action="file/upload.do" method="post" enctype="multipart/form-data">
    选择文件:<input type="file" name="file" width="120px">
    <input type="submit" value="上传">
</form>
<hr>
<%--<form action="http://localhost:8080/uploadDemo/rest/file/down" method="get">--%>
    <%--<input type="submit" value="下载">--%>
<%--</form>--%>
</body>
</html>
