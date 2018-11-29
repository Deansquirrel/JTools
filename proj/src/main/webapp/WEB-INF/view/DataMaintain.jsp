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
        <c:url var="urlStrRdsDetail" value="/Resource/Rds/" />
        <c:url var="urlStrRdsDel" value="/Resource/Rds/Del/" />
        <c:url var="urlStrCommonDbDetail" value="/Resource/CommonDb/" />
        <c:url var="urlStrCommonDbDel" value="/Resource/CommonDb/Del/" />
        <c:url var="urlStrRdsDbDetail" value="/Resource/RdsDb/" />
        <c:url var="urlStrRdsDbDel" value="/Resource/RdsDb/Del/" />
        <c:url var="urlStrRedisDetail" value="/Resource/Redis/" />
        <c:url var="urlStrRedisDel" value="/Resource/Redis/Del/" />
        <c:url var="urlStrExceptionLessDetail" value="/Resource/ExceptionLess/" />
        <c:url var="urlStrExceptionLessDel" value="/Resource/ExceptionLess/Del/" />
        <c:url var="urlStrMongoDBDetail" value="/Resource/MongoDB/" />
        <c:url var="urlStrMongoDBDel" value="/Resource/MongoDB/Del/" />
        <c:url var="urlStrRabbitMQDetail" value="/Resource/RabbitMQ/" />
        <c:url var="urlStrRabbitMQDel" value="/Resource/RabbitMQ/Del/" />
        <c:url var="urlStrTpProxyDetail" value="/Resource/TpProxy/" />
        <c:url var="urlStrTpProxyDel" value="/Resource/TpProxy/Del/" />
 
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
                 			<c:when test="${rlist.type == 'RDS' }">
                 				<div class="col">
	                          		<a href="${urlStrRdsDetail }${rlist.id }" target="_blank"><span>详细信息</span></a>
	                      		</div>
	                      		<div class="col">
	                          		<a href="javascript:frmDelSubmit('${urlStrRdsDel }' ,'${rlist.id }')"><span>删除</span></a>
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
                 			<c:when test="${rlist.type == 'RdsDb' }">
                 				<div class="col">
	                          		<a href="${urlStrRdsDbDetail }${rlist.id }" target="_blank"><span>详细信息</span></a>
	                      		</div>
	                      		<div class="col">
	                          		<a href="javascript:frmDelSubmit('${urlStrRdsDbDel }' ,'${rlist.id }')"><span>删除</span></a>
	                      		</div>
                 			</c:when>
                 			<c:when test="${rlist.type == 'Redis' }">
                 				<div class="col">
	                          		<a href="${urlStrRedisDetail }${rlist.id }" target="_blank"><span>详细信息</span></a>
	                      		</div>
	                      		<div class="col">
	                          		<a href="javascript:frmDelSubmit('${urlStrRedisDel }' ,'${rlist.id }')"><span>删除</span></a>
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
                 			<c:when test="${rlist.type == 'MongoDB' }">
                 				<div class="col">
	                          		<a href="${urlStrMongoDBDetail }${rlist.id }" target="_blank"><span>详细信息</span></a>
	                      		</div>
	                      		<div class="col">
	                          		<a href="javascript:frmDelSubmit('${urlStrMongoDBDel }' ,'${rlist.id }')"><span>删除</span></a>
	                      		</div>
                 			</c:when>
                 			<c:when test="${rlist.type == 'RabbitMQ' }">
                 				<div class="col">
	                          		<a href="${urlStrRabbitMQDetail }${rlist.id }" target="_blank"><span>详细信息</span></a>
	                      		</div>
	                      		<div class="col">
	                          		<a href="javascript:frmDelSubmit('${urlStrRabbitMQDel }' ,'${rlist.id }')"><span>删除</span></a>
	                      		</div>
                 			</c:when>
                 			<c:when test="${rlist.type == 'TpProxy' }">
                 				<div class="col">
	                          		<a href="${urlStrTpProxyDetail }${rlist.id }" target="_blank"><span>详细信息</span></a>
	                      		</div>
	                      		<div class="col">
	                          		<a href="javascript:frmDelSubmit('${urlStrTpProxyDel }' ,'${rlist.id }')"><span>删除</span></a>
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
                            <a class="dropdown-item" href="javascript:addTypeChanged('rds')">RDS</a>
                            <a class="dropdown-item" href="javascript:addTypeChanged('commondb')">数据库（普通）</a>
                            <a class="dropdown-item" href="javascript:addTypeChanged('rdsdb')">数据库（RDS）</a>
                            <a class="dropdown-item" href="javascript:addTypeChanged('redis')">Redis</a>
                            <a class="dropdown-item" href="javascript:addTypeChanged('mongodb')">MongoDB</a>
                            <a class="dropdown-item" href="javascript:addTypeChanged('rabbitmq')">RabbitMQ</a>
                            <a class="dropdown-item" href="javascript:addTypeChanged('exceptionless')">ExceptionLess</a>
                            <a class="dropdown-item" href="javascript:addTypeChanged('tpproxy')">TpProxy</a>
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
        <form id="frm-rdsAdd" class="margin50 d-none">
            <div class="form-group row">
                <label for="rdsAddName" class="col-sm-2 col-form-label">名称</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="rdsAddName"  name ="rdsAddName" placeholder="名称">
                </div>
            </div>
            <div class="form-group row">
                <label for="rdsAddDescription" class="col-sm-2 col-form-label">描述</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="rdsAddDescription" name="rdsAddDescription" placeholder="描述">
                </div>
            </div>
            <div class="form-group row">
                <label for="rdsAddInstanceID" class="col-sm-2 col-form-label">实例ID</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="rdsAddInstanceID" name="rdsAddInstanceID" placeholder="实例ID">
                </div>
            </div>
            <div class="form-group row">
                <label for="rdsAddArea" class="col-sm-2 col-form-label">所在区</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="rdsAddArea" name="rdsAddArea" placeholder="所在区">
                </div>
            </div>
            <div class="form-group row">
                <label for="rdsAddDbType" class="col-sm-2 col-form-label">系统类型</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="rdsAddDbType" name="rdsAddDbType" placeholder="系统类型，如SQL Server 2008 R2">
                </div>
            </div>
            <div class="form-group row">
                <label for="rdsAddInternetIp" class="col-sm-2 col-form-label">外网IP</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="rdsAddInternetIp" name="rdsAddInternetIp" placeholder="外网IP">
                </div>
            </div>
            <div class="form-group row">
                <label for="rdsAddInternetPort" class="col-sm-2 col-form-label">外网端口</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="rdsAddInternetPort" name="rdsAddInternetPort" placeholder="外网端口，默认3433">
                </div>
            </div>
			<div class="form-group row">
                <label for="rdsAddIntranetIp" class="col-sm-2 col-form-label">内网IP</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="rdsAddIntranetIp" name="rdsAddIntranetIp" placeholder="内网IP">
                </div>
            </div>
            <div class="form-group row">
                <label for="rdsAddIntranetPort" class="col-sm-2 col-form-label">内网端口</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="rdsAddIntranetPort" name="rdsAddIntranetPort" placeholder="内网端口，默认3433">
                </div>
            </div>
            <div class="form-group row">
                <label for="rdsAddExpirationDate" class="col-sm-2 col-form-label">过期日期</label>
                <div class="col-sm-10 input-group">
                    <input type="text" class="form-control form_datetime" id="rdsAddExpirationDate"  name="rdsAddExpirationDate" placeholder="过期日期，格式如 2050-12-31">
                </div>
            </div>
            <div class="form-group row">
                <div class="col">
                    <button id="reset-rds" type="button" class="btn btn-primary btn-block">Reset</button>
                </div>
                <div class="col">
                    <button id="submit-rds" type="button" class="btn btn-primary btn-block">Submit</button>
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
        <form id="frm-rdsDbAdd" class="margin50 d-none">
            <div class="form-group row">
                <label for="rdsDbAddName" class="col-sm-2 col-form-label">名称</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="rdsDbAddName"  name ="rdsDbAddName" placeholder="名称">
                </div>
            </div>
            <div class="form-group row">
                <label for="rdsDbAddDescription" class="col-sm-2 col-form-label">描述</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="rdsDbAddDescription" name="rdsDbAddDescription" placeholder="描述">
                </div>
            </div>
            <div class="form-group row">
                <label for="rdsDbAddDbName" class="col-sm-2 col-form-label">数据库名称</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="rdsDbAddDbName" name="rdsDbAddDbName" placeholder="数据库名称">
                </div>
            </div>
            <div class="form-group row">
                <label for="rdsDbAddDbUser" class="col-sm-2 col-form-label">数据库登录名</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="rdsDbAddDbUser" name="rdsDbAddDbUser" placeholder="数据库登录名">
                </div>
            </div>
            <div class="form-group row">
                <label for="rdsDbAddDbPwd" class="col-sm-2 col-form-label">数据库登录密码</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="rdsDbAddDbPwd" name="rdsDbAddDbPwd" placeholder="数据库登录密码">
                </div>
            </div>
             <div class="form-group row">
                <label class="col-sm-2 col-form-label">所在RDS</label>
                <div class="col-sm-10">
                    <div class="btn-group" role="group">
                        <button id="btnGroupRdsDbAddDbRds"  type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            请选择
                        </button>
                        <div class="dropdown-menu">
	                        <c:forEach items="${rdsList }" var="rds">
						        <a class="dropdown-item" href="javascript:chooseRds_RdsDbAdd('${rds.key }','${rds.value }')">${rds.value }</a>
						   </c:forEach>
                        </div>
                        <input id="rdsDbAddDbRds" type="hidden" name="rdsDbAddDbRds" value="" />
                    </div>
                </div>
             </div>
            <div class="form-group row">
                <div class="col">
                    <button id="reset-rdsdb" type="button" class="btn btn-primary btn-block">Reset</button>
                </div>
                <div class="col">
                    <button id="submit-rdsdb" type="button" class="btn btn-primary btn-block">Submit</button>
                </div>
            </div>
        </form>
        <form id="frm-redisAdd" class="margin50 d-none">
            <div class="form-group row">
                <label for="redisAddName" class="col-sm-2 col-form-label">名称</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="redisAddName"  name ="redisAddName" placeholder="名称">
                </div>
            </div>
            <div class="form-group row">
                <label for="redisAddDescription" class="col-sm-2 col-form-label">描述</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="redisAddDescription" name="redisAddDescription" placeholder="描述">
                </div>
            </div>
            <div class="form-group row">
                <label for="redisAddInstanceID" class="col-sm-2 col-form-label">实例ID</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="redisAddInstanceID" name="redisAddInstanceID" placeholder="实例ID">
                </div>
            </div>
            <div class="form-group row">
                <label for="redisAddArea" class="col-sm-2 col-form-label">所在区</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="redisAddArea" name="redisAddArea" placeholder="所在区">
                </div>
            </div>
            <div class="form-group row">
                <label for="redisAddHost" class="col-sm-2 col-form-label">连接地址</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="redisAddHost" name="redisAddHost" placeholder="连接地址">
                </div>
            </div>
            <div class="form-group row">
                <label for="redisAddPort" class="col-sm-2 col-form-label">连接端口</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="redisAddPort" name="redisAddPort" placeholder="连接端口">
                </div>
            </div>
            <div class="form-group row">
                <label for="redisAddPwd" class="col-sm-2 col-form-label">密码</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="redisAddPwd" name="redisAddPwd" placeholder="密码">
                </div>
            </div>
            <div class="form-group row">
                <div class="col">
                    <button id="reset-redis" type="button" class="btn btn-primary btn-block">Reset</button>
                </div>
                <div class="col">
                    <button id="submit-redis" type="button" class="btn btn-primary btn-block">Submit</button>
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
    	<form id="frm-mongodb" class="margin50 d-none">
            <div class="form-group row">
                <label for="mongodbAddName" class="col-sm-2 col-form-label">名称</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="mongodbAddName"  name ="mongodbAddName" placeholder="名称">
                </div>
            </div>
            <div class="form-group row">
                <label for="mongodbAddDescription" class="col-sm-2 col-form-label">描述</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="mongodbAddDescription" name="mongodbAddDescription" placeholder="描述">
                </div>
            </div>
            <div class="form-group row">
                <label for="mongodbAddInternetIp" class="col-sm-2 col-form-label">外网IP</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="mongodbAddInternetIp" name="mongodbAddInternetIp" placeholder="外网IP">
                </div>
            </div>
			<div class="form-group row">
                <label for="mongodbAddIntranetIp" class="col-sm-2 col-form-label">内网IP</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="mongodbAddIntranetIp" name="mongodbAddIntranetIp" placeholder="内网IP">
                </div>
            </div>
            <div class="form-group row">
                <label for="mongodbAddPort" class="col-sm-2 col-form-label">端口</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="mongodbAddPort" name="mongodbAddPort" placeholder="端口，默认27017">
                </div>
            </div>
            <div class="form-group row">
                <label for="mongodbAddLoginName" class="col-sm-2 col-form-label">登录名</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="mongodbAddLoginName" name="mongodbAddLoginName" placeholder="登录名">
                </div>
            </div>
            <div class="form-group row">
                <label for="mongodbAddLoginPwd" class="col-sm-2 col-form-label">登录密码</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="mongodbAddLoginPwd" name="mongodbAddLoginPwd" placeholder="登录密码">
                </div>
            </div>
            <div class="form-group row">
                <div class="col">
                    <button id="reset-mongodb" type="button" class="btn btn-primary btn-block">Reset</button>
                </div>
                <div class="col">
                    <button id="submit-mongodb" type="button" class="btn btn-primary btn-block">Submit</button>
                </div>
            </div>
        </form>
    	<form id="frm-rabbitmq" class="margin50 d-none">
            <div class="form-group row">
                <label for="mongodbAddName" class="col-sm-2 col-form-label">名称</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="rabbitmqAddName"  name ="rabbitmqAddName" placeholder="名称">
                </div>
            </div>
            <div class="form-group row">
                <label for="rabbitmqAddDescription" class="col-sm-2 col-form-label">描述</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="rabbitmqAddDescription" name="rabbitmqAddDescription" placeholder="描述">
                </div>
            </div>
            <div class="form-group row">
                <label for="rabbitmqAddInternetIp" class="col-sm-2 col-form-label">外网IP</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="rabbitmqAddInternetIp" name="rabbitmqAddInternetIp" placeholder="外网IP">
                </div>
            </div>
			<div class="form-group row">
                <label for="rabbitmqAddIntranetIp" class="col-sm-2 col-form-label">内网IP</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="rabbitmqAddIntranetIp" name="rabbitmqAddIntranetIp" placeholder="内网IP">
                </div>
            </div>
            <div class="form-group row">
                <label for="rabbitmqAddPort" class="col-sm-2 col-form-label">端口</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="rabbitmqAddPort" name="rabbitmqAddPort" placeholder="端口，默认5672">
                </div>
            </div>
            <div class="form-group row">
                <label for="rabbitmqAddLoginName" class="col-sm-2 col-form-label">登录名</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="rabbitmqAddLoginName" name="rabbitmqAddLoginName" placeholder="登录名">
                </div>
            </div>
            <div class="form-group row">
                <label for="rabbitmqAddLoginPwd" class="col-sm-2 col-form-label">登录密码</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="rabbitmqAddLoginPwd" name="rabbitmqAddLoginPwd" placeholder="登录密码">
                </div>
            </div>
            <div class="form-group row">
                <div class="col">
                    <button id="reset-rabbitmq" type="button" class="btn btn-primary btn-block">Reset</button>
                </div>
                <div class="col">
                    <button id="submit-rabbitmq" type="button" class="btn btn-primary btn-block">Submit</button>
                </div>
            </div>
        </form>
    	<form id="frm-tpproxy" class="margin50 d-none">
            <div class="form-group row">
                <label for="mongodbAddName" class="col-sm-2 col-form-label">名称</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="tpproxyAddName"  name ="tpproxyAddName" placeholder="名称">
                </div>
            </div>
            <div class="form-group row">
                <label for="tpproxyAddDescription" class="col-sm-2 col-form-label">描述</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="tpproxyAddDescription" name="tpproxyAddDescription" placeholder="描述">
                </div>
            </div>
            <div class="form-group row">
                <label for="tpproxyAddUrl" class="col-sm-2 col-form-label">URL</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="tpproxyAddUrl" name="tpproxyAddUrl" placeholder="URL">
                </div>
            </div>
            <div class="form-group row">
                <label for="tpproxyAddPort" class="col-sm-2 col-form-label">Port</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="tpproxyAddPort" name="tpproxyAddPort" placeholder="Port">
                </div>
            </div>
            <div class="form-group row">
                <label for="tpproxyAddCrmDataCenterDb" class="col-sm-2 col-form-label">CrmDataCenterDb</label>
                <div class="col-sm-10">
                    <div class="btn-group" role="group">
                        <button id="btnGroupAddType" onclick="$('.dropdown-toggle').dropdown()" type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            请选择
                        </button>
                        <div id="addTypeMenu" class="dropdown-menu" >
                        	<c:forEach var="db"  items="${dbList }">
                        		<a class="dropdown-item" href="javascript:addTypeChanged('${db.key }')">${db.value }</a>
                        	</c:forEach>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-group row">
                <label for="tpproxyAddCrmDataCenterDb" class="col-sm-2 col-form-label">TpO2OProxyConfigDb</label>
                <div class="col-sm-10">
                    <div class="btn-group" role="group">
                        <button id="btnGroupAddType" onclick="$('.dropdown-toggle').dropdown()" type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            请选择
                        </button>
                        <div id="addTypeMenu" class="dropdown-menu" >
                        	<c:forEach var="db"  items="${dbList }">
                        		<a class="dropdown-item" href="javascript:addTypeChanged('${db.key }')">${db.value }</a>
                        	</c:forEach>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-group row">
                <div class="col">
                    <button id="reset-tpproxy" type="button" class="btn btn-primary btn-block">Reset</button>
                </div>
                <div class="col">
                    <button id="submit-tpproxy" type="button" class="btn btn-primary btn-block">Submit</button>
                </div>
            </div>
        </form>
    </div>
</div>
<c:url var="urlStr" value="/layouts/js/datamaintain.js" />
<script src="${urlStr }"></script>
<c:url var="urlStrCustomerAdd" value="/Resource/Customer/Add" />
<c:url var="urlStrEcsAdd" value="/Resource/Ecs/Add" />
<c:url var="urlStrRdsAdd" value="/Resource/Rds/Add" />
<c:url var="urlStrCommonDbAdd" value="/Resource/CommonDb/Add" />
<c:url var="urlStrRdsDbAdd" value="/Resource/RdsDb/Add" />
<c:url var="urlStrRedisAdd" value="/Resource/Redis/Add" />
<c:url var="urlStrExceptionLessAdd" value="/Resource/ExceptionLess/Add" />
<c:url var="urlStrMongoDBAdd" value="/Resource/MongoDB/Add" />
<c:url var="urlStrRabbitMQAdd" value="/Resource/RabbitMQ/Add" />
<c:url var="urlStrTpProxyAdd" value="/Resource/TpProxy/Add" />
<script type="text/javascript">
	
	$("#submit-customer").click(function(){
	    frmAddSubmit("${urlStrCustomerAdd }","frm-customerAdd","customer");
	});
	
	$("#submit-ecs").click(function(){
	    frmAddSubmit("${urlStrEcsAdd }","frm-ecsAdd","ecs");
	});
	
	$("#submit-rds").click(function(){
	    frmAddSubmit("${urlStrRdsAdd }","frm-rdsAdd","rds");
	});
	
	$("#submit-commondb").click(function(){
	    frmAddSubmit("${urlStrCommonDbAdd }","frm-commonDbAdd","commondb");
	});
	
	$("#submit-rdsdb").click(function(){
	    frmAddSubmit("${urlStrRdsDbAdd }","frm-rdsDbAdd","rdsdb");
	});
	
	$("#submit-redis").click(function(){
	    frmAddSubmit("${urlStrRedisAdd }","frm-redisAdd","redis");
	});
	
	$("#submit-exceptionless").click(function(){
	    frmAddSubmit("${urlStrExceptionLessAdd }","frm-exceptionless","exceptionless");
	});
	
	$("#submit-mongodb").click(function(){
	    frmAddSubmit("${urlStrMongoDBAdd }","frm-mongodb","mongodb");
	});
	
	$("#submit-rabbitmq").click(function(){
	    frmAddSubmit("${urlStrRabbitMQAdd }","frm-rabbitmq","rabbitmq");
	});
	
	$("#submit-tpproxy").click(function(){
	    frmAddSubmit("${urlStrTpProxyAdd }","frm-tpproxy","tpproxy");
	});
	
	topMenuNone();
	topMenuBlock("navDataMaintain");
	navList();
</script>