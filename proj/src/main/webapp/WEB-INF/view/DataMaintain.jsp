<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../../layouts/library.jsp"%> 
<div id="container" style="margin: 20px auto;width:95%">
    <ul class="nav nav-tabs">
        <li class="nav-item">
            <a id="navList" class="nav-link active" href="javascript:navList()">List</a>
        </li>
        <li class="nav-item">
            <a id="navAdd" class="nav-link" href="javascript:navAdd()">Add</a>
        </li>
    </ul>
    <div id="divList"  style="width:100%" class="d-none divide50">
    
    	<c:url var="urlStrCustomerDetail" value="/Resource/Customer/" />
        <c:url var="urlStrCustomerDel" value="/Resource/Customer/Del/" />
        <c:url var="urlStrEcsDetail" value="/Resource/Ecs/" />
        <c:url var="urlStrEcsDel" value="/Resource/Ecs/Del/" />
        <c:url var="urlStrCommonDbDetail" value="/Resource/CommonDb/" />
        <c:url var="urlStrCommonDbDel" value="/Resource/CommonDb/Del/" />
        <c:url var="urlStrExceptionLessDetail" value="/Resource/ExceptionLess/" />
        <c:url var="urlStrExceptionLessDel" value="/Resource/ExceptionLess/Del/" />
 
            <table class="table table-hover">
                <thead>
                <tr>
                    <th scope="col">类型</th>
                    <th scope="col">名称</th>
                    <th scope="col">描述</th>
                    <th scope="col">操作</th>
                </tr>
                </thead>
                <tbody>
                
                <c:forEach var="rlist"  items="${rlist }">
                	<tr>
	                    <td>
	                    	<div>${rlist.type }</div>
	                    </td>
	                    <td>${rlist.name }</td>
	                    <td>${rlist.description }</td>
	                    <td>
	                    	<div class="row">
	                    		<c:choose>
	                    			<c:when test="${rlist.type == 'Customer' }">
	                    				<div class="col">
		                            		<a href="${urlStrCustomerDetail }${rlist.id }" target="_blank"><span>详细信息</span></a>
		                        		</div>
		                        		<div class="col">
		                            		<a href="javascript:frmDelSubmit('${urlStrCustomerDel }' ,'${rlist.id }')"><span>删除</span></a>
		                        		</div>
	                    			</c:when>
	                    			<c:when test="${rlist.type == 'ECS' }">
	                    				<div class="col">
		                            		<a href="${urlStrEcsDetail }${rlist.id }" target="_blank"><span>详细信息</span></a>
		                        		</div>
		                        		<div class="col">
		                            		<a href="javascript:frmDelSubmit('${urlStrEcsDel }' ,'${rlist.id }')"><span>删除</span></a>
		                        		</div>
	                    			</c:when>
	                    			<c:when test="${rlist.type == 'CommonDb' }">
	                    				<div class="col">
		                            		<a href="${urlStrCommonDbDetail }${rlist.id }" target="_blank"><span>详细信息</span></a>
		                        		</div>
		                        		<div class="col">
		                            		<a href="javascript:frmDelSubmit('${urlStrCommonDbDel }' ,'${rlist.id }')"><span>删除</span></a>
		                        		</div>
	                    			</c:when>
	                    			<c:when test="${rlist.type == 'ExceptionLess' }">
	                    				<div class="col">
		                            		<a href="${urlStrExceptionLessDetail }${rlist.id }" target="_blank"><span>详细信息</span></a>
		                        		</div>
		                        		<div class="col">
		                            		<a href="javascript:frmDelSubmit('${urlStrExceptionLessDel }' ,'${rlist.id }')"><span>删除</span></a>
		                        		</div>
	                    			</c:when>
	                    		</c:choose>
                    		</div>
                    	</td>
	                </tr>	
                </c:forEach>
                </tbody>
            </table>
    </div>
    <div id="divAdd" class="d-none divide50">
        <form class="margin50">
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">类型</label>
                <div class="col-sm-10">
                    <div class="btn-group" role="group">
                        <button id="btnGroupAddType" onclick="$('.dropdown-toggle').dropdown()" type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            请选择类型
                        </button>
                        <div id="addTypeMenu" class="dropdown-menu" >
                            <a class="dropdown-item" href="javascript:addTypeChanged('customer')">客户</a>
                            <a class="dropdown-item" href="javascript:addTypeChanged('ecs')">ECS</a>
                            <a class="dropdown-item" href="javascript:addTypeChanged('commondb')">数据库（普通）</a>
                            <a class="dropdown-item" href="javascript:addTypeChanged('exceptionless')">ExceptionLess</a>
                        </div>
                    </div>
                </div>
            </div>
        </form>
        <form id="frm-customerAdd" class="margin50 d-none">
            <div class="form-group row">
                <label for="customerAddName" class="col-sm-2 col-form-label">名称</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="customerAddName"  name ="customerAddName" placeholder="名称">
                </div>
            </div>
            <div class="form-group row">
                <label for="customerAddDescription" class="col-sm-2 col-form-label">描述</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="customerAddDescription" name="customerAddDescription" placeholder="描述">
                </div>
            </div>
            <div class="form-group row">
                <label for="customerAddCode" class="col-sm-2 col-form-label">编码</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="customerAddCode" name="customerAddCode" placeholder="编码">
                </div>
            </div>
            <div class="form-group row">
                <label for="customerAddShowname" class="col-sm-2 col-form-label">显示名称</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="customerAddShowname" name="customerAddShowname" placeholder="显示名称">
                </div>
            </div>
            <div class="form-group row">
                <label for="customerAddSimplename" class="col-sm-2 col-form-label">简称</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="customerAddSimplename" name="customerAddSimplename" placeholder="简称">
                </div>
            </div>
            <div class="form-group row">
                <label for="customerAddPinyinname" class="col-sm-2 col-form-label">拼音名称</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="customerAddPinyinname" name="customerAddPinyinname" placeholder="拼音名称">
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">业务系统类型</label>
                <div class="col-sm-10">
                    <div class="btn-group" role="group">
                        <button id="btnGroupMisType" name="customerAddMistype" type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            请选择业务系统类型
                        </button>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="javascript:choseMisType('Z5')">Z5</a>
                            <a class="dropdown-item" href="javascript:choseMisType('Z9')">Z9</a>
                        </div>
                        <input id="customerAddMistype" type="hidden" name="customerAddMistype" value="" />
                    </div>
                </div>
            </div>
            <div class="form-group row">
                <label for="customerAddTongdcode" class="col-sm-2 col-form-label">通道码</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="customerAddTongdcode" name="customerAddTongdcode" placeholder="通道码">
                </div>
            </div>
            <div class="form-group row">
                <div class="col">
                    <button id="reset-customer" type="button" class="btn btn-primary btn-block">Reset</button>
                </div>
                <div class="col">
                    <button id="submit-customer" type="button" class="btn btn-primary btn-block">Submit</button>
                </div>
            </div>
        </form>
		<form id="frm-del" class="margin50 d-none">
            <input id="delId" type="hidden" name="delId"/>
        </form>
        <form id="frm-ecsAdd" class="margin50 d-none">
            <div class="form-group row">
                <label for="ecsAddName" class="col-sm-2 col-form-label">名称</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="ecsAddName"  name ="ecsAddName" placeholder="名称">
                </div>
            </div>
            <div class="form-group row">
                <label for="ecsAddDescription" class="col-sm-2 col-form-label">描述</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="ecsAddDescription" name="ecsAddDescription" placeholder="描述">
                </div>
            </div>
            <div class="form-group row">
                <label for="ecsAddInstanceID" class="col-sm-2 col-form-label">实例ID</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="ecsAddInstanceID" name="ecsAddInstanceID" placeholder="实例ID">
                </div>
            </div>
            <div class="form-group row">
                <label for="ecsAddArea" class="col-sm-2 col-form-label">所在区</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="ecsAddArea" name="ecsAddArea" placeholder="所在区">
                </div>
            </div>
            <div class="form-group row">
                <label for="ecsAddInternetIp" class="col-sm-2 col-form-label">外网IP</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="ecsAddInternetIp" name="ecsAddInternetIp" placeholder="外网IP">
                </div>
            </div>
			<div class="form-group row">
                <label for="ecsAddIntranetIp" class="col-sm-2 col-form-label">内网IP</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="ecsAddIntranetIp" name="ecsAddIntranetIp" placeholder="内网IP">
                </div>
            </div>
            <div class="form-group row">
                <label for="ecsAddOs" class="col-sm-2 col-form-label">操作系统</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="ecsAddOs" name="ecsAddOs" placeholder="操作系统">
                </div>
            </div>
            <div class="form-group row">
                <label for="ecsAddExpirationDate" class="col-sm-2 col-form-label">过期日期</label>
                <div class="col-sm-10 input-group">
                    <input type="text" class="form-control form_datetime" id="ecsAddExpirationDate"  name="ecsAddExpirationDate" placeholder="过期日期，格式如 2050-12-31">
                </div>
            </div>
            <div class="form-group row">
                <label for="ecsAddRDPPort" class="col-sm-2 col-form-label">远程桌面端口</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="ecsAddRDPPort" name="ecsAddRDPPort" placeholder="远程桌面端口，操作系统默认3389">
                </div>
            </div>
            <div class="form-group row">
                <label for="ecsAddLoginName" class="col-sm-2 col-form-label">用户名</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="ecsAddLoginName" name="ecsAddLoginName" placeholder="用户名">
                </div>
            </div>
            <div class="form-group row">
                <label for="ecsAddLoginPwd" class="col-sm-2 col-form-label">密码</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="ecsAddLoginPwd" name="ecsAddLoginPwd" placeholder="密码">
                </div>
            </div>
            <div class="form-group row">
                <div class="col">
                    <button id="reset-ecs" type="button" class="btn btn-primary btn-block">Reset</button>
                </div>
                <div class="col">
                    <button id="submit-ecs" type="button" class="btn btn-primary btn-block">Submit</button>
                </div>
            </div>
        </form>
        <form id="frm-commonDbAdd" class="margin50 d-none">
            <div class="form-group row">
                <label for="commonDbAddName" class="col-sm-2 col-form-label">名称</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="commonDbAddName"  name ="commonDbAddName" placeholder="名称">
                </div>
            </div>
            <div class="form-group row">
                <label for="commonDbAddDescription" class="col-sm-2 col-form-label">描述</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="commonDbAddDescription" name="commonDbAddDescription" placeholder="描述">
                </div>
            </div>
            <div class="form-group row">
                <label for="commonDbAddDbName" class="col-sm-2 col-form-label">数据库名称</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="commonDbAddDbName" name="commonDbAddDbName" placeholder="数据库名称">
                </div>
            </div>
            <div class="form-group row">
                <label for="commonDbAddDbUser" class="col-sm-2 col-form-label">数据库登录名</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="commonDbAddDbUser" name="commonDbAddDbUser" placeholder="数据库登录名">
                </div>
            </div>
            <div class="form-group row">
                <label for="commonDbAddDbPwd" class="col-sm-2 col-form-label">数据库登录密码</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="commonDbAddDbPwd" name="commonDbAddDbPwd" placeholder="数据库登录密码">
                </div>
            </div>
            <div class="form-group row">
                <label for="commonDbAddAddress" class="col-sm-2 col-form-label">外网地址</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="commonDbAddAddress" name="commonDbAddAddress" placeholder="外网地址">
                </div>
            </div>
            <div class="form-group row">
                <label for="commonDbAddPort" class="col-sm-2 col-form-label">端口</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="commonDbAddPort" name="commonDbAddPort" placeholder="端口">
                </div>
            </div>
            <div class="form-group row">
                <div class="col">
                    <button id="reset-commondb" type="button" class="btn btn-primary btn-block">Reset</button>
                </div>
                <div class="col">
                    <button id="submit-commondb" type="button" class="btn btn-primary btn-block">Submit</button>
                </div>
            </div>
        </form>
        <form id="frm-exceptionless" class="margin50 d-none">
            <div class="form-group row">
                <label for="exceptionlessAddName" class="col-sm-2 col-form-label">名称</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="exceptionlessAddName"  name ="exceptionlessAddName" placeholder="名称">
                </div>
            </div>
            <div class="form-group row">
                <label for="exceptionlessAddDescription" class="col-sm-2 col-form-label">描述</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="exceptionlessAddDescription" name="exceptionlessAddDescription" placeholder="描述">
                </div>
            </div>
            <div class="form-group row">
                <label for="exceptionlessAddUrl" class="col-sm-2 col-form-label">URL</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="exceptionlessAddUrl" name="exceptionlessAddUrl" placeholder="URL">
                </div>
            </div>
            <div class="form-group row">
                <label for="exceptionlessAddLoginName" class="col-sm-2 col-form-label">登录名</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="exceptionlessAddLoginName" name="exceptionlessAddLoginName" placeholder="登录名">
                </div>
            </div>
            <div class="form-group row">
                <label for="exceptionlessAddLoginPwd" class="col-sm-2 col-form-label">登录密码</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="exceptionlessAddLoginPwd" name="exceptionlessAddLoginPwd" placeholder="登录密码">
                </div>
            </div>
            <div class="form-group row">
                <div class="col">
                    <button id="reset-exceptionless" type="button" class="btn btn-primary btn-block">Reset</button>
                </div>
                <div class="col">
                    <button id="submit-exceptionless" type="button" class="btn btn-primary btn-block">Submit</button>
                </div>
            </div>
        </form>
    </div>
</div>
<c:url var="urlStr" value="/layouts/js/datamaintain.js" />
<script src="${urlStr }"></script>
<c:url var="urlStrCustomerAdd" value="/Resource/Customer/Add" />
<c:url var="urlStrEcsAdd" value="/Resource/Ecs/Add" />
<c:url var="urlStrCommonDbAdd" value="/Resource/CommonDb/Add" />
<c:url var="urlStrExceptionLessAdd" value="/Resource/ExceptionLess/Add" />
<script type="text/javascript">
	
	$("#submit-customer").click(function(){
	    frmAddSubmit("${urlStrCustomerAdd }","frm-customerAdd","customer");
	});
	
	$("#submit-ecs").click(function(){
	    console.log("submit ecs");
	    frmAddSubmit("${urlStrEcsAdd }","frm-ecsAdd","ecs");
	});
	
	$("#submit-commondb").click(function(){
	    console.log("submit ecs");
	    frmAddSubmit("${urlStrCommonDbAdd }","frm-commonDbAdd","commondb");
	});
	
	$("#submit-exceptionless").click(function(){
	    console.log("submit ecs");
	    frmAddSubmit("${urlStrExceptionLessAdd }","frm-exceptionless","exceptionless");
	});
	
	topMenuNone();
	topMenuBlock("navDataMaintain");
	navList();
</script>