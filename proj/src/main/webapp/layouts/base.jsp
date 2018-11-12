<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ include file="library.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0,user-scalable=no">
    <title>JTools</title>
    
    <c:url var="urlStr" value="/layouts/plugin/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="${urlStr }">
    <c:url var="urlStr" value="/layouts/plugin/sweetalert2/sweetalert2.css" />
    <link rel="stylesheet" href="${urlStr }">
    
    <c:url var="urlStr" value="/layouts/plugin/jQuery/jquery-3.3.1.min.js" />
    <script src="${urlStr }"></script>
    <c:url var="urlStr" value="/layouts/plugin/popper/umd/popper.min.js" />
    <script src="${urlStr }"></script>
    <c:url var="urlStr" value="/layouts/plugin/bootstrap/js/bootstrap.min.js" />
    <script src="${urlStr }"></script>
    
    <c:url var="urlStr" value="/layouts/plugin/sweetalert2/sweetalert2.js" />
    <script src="${urlStr }"></script>
    
    <c:url var="urlStr" value="/layouts/css/main.css" />
    <link rel="stylesheet" href="${urlStr }">
    
    <c:url var="urlStr" value="/layouts/js/common.js" />
    <script src="${urlStr }"></script>
    <c:url var="urlStr" value="/layouts/js/main.js" />
    <script src="${urlStr }"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <span class="navbar-brand">JTool</span>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li id="navFunctionList" class="nav-item">
            	<c:url var="urlStr" value="/FunctionMenu" />
                <a class="nav-link" href="${urlStr }">功能列表</a>
            </li>
            <li id="navDataMaintain" class="nav-item">
            	<c:url var="urlStr" value="/DataMaintain" />
                <a class="nav-link" href="${urlStr }">资料维护</a>
            </li>
        </ul>
    </div>
</nav>
<tiles:insertAttribute name="content" />

</body>
</html>