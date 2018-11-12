<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../../layouts/library.jsp"%> 
<div id="container" style="margin: 20px 50px">
	<ul class="nav flex-column">
        <li class="nav-item">
        	<c:url var="urlStr" value="/Tools/UpdateWxCardNo" />
            <a class="nav-link" href="${urlStr }">更新微信卡面号</a>
        </li>
    </ul>
</div>
<script type="text/javascript">
	topMenuNone();
	topMenuBlock("navFunctionList");
</script>