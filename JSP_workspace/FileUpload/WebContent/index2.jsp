<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
    <title>File Upload</title>
</head>

<body>
    <h1>File Upload Form</h1>
    <hr/>

    <fieldset>
        <legend>Upload File</legend>
        <form action="<c:url value="/uploadservlet"/>" method="post" enctype="multipart/form-data">
            <label for="filename_1">File: </label>
            <input type="text" name="test111" size="50"/><br/>
            <input id="filename_1" type="file" name="filename_1" size="50"/><br/>
            <label for="filename_2">File: </label>
            <input id="filename_2" type="file" name="filename_2" size="50"/><br/>
            <br/>
            <input type="submit" value="Upload File"/>
        </form>
    </fieldset>
</body>
</html>