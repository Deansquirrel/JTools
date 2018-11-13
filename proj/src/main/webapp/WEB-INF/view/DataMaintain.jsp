<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../../layouts/library.jsp"%> 
<div id="container" style="margin: 20px 50px">
    <ul class="nav nav-tabs">
        <li class="nav-item">
            <a id="navList" class="nav-link active" href="javascript:navList()">List</a>
        </li>
        <li class="nav-item">
            <a id="navAdd" class="nav-link" href="javascript:navAdd()">Add</a>
        </li>
    </ul>
    <div id="divList" class="d-none divide50">
        <div class="table-responsive">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th scope="col">类型</th>
                    <th scope="col">名称</th>
                    <th scope="col">显示名称</th>
                    <th scope="col">描述</th>
                    <th scope="col">操作</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>Mark</td>
                    <td>Mark</td>
                    <td>Mark</td>
                    <td>Otto</td>
                    <td>@mdo</td>
                </tr>
                <tr>
                    <td>Mark</td>
                    <td>Mark</td>
                    <td>Mark</td>
                    <td>Otto</td>
                    <td>@mdo</td>
                </tr>
                <tr>
                    <td>Mark</td>
                    <td>Mark</td>
                    <td>Mark</td>
                    <td>Otto</td>
                    <td>@mdo</td>
                </tr>
                </tbody>
            </table>
        </div>
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
                        </div>
                    </div>
                </div>
            </div>
        </form>
        <form id="frm-customerAddCode" class="margin50 d-none">
            <div class="form-group row">
                <label for="customerAddCode" class="col-sm-2 col-form-label">编码</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="customerAddCode" name="customerAddCode" placeholder="编码">
                </div>
            </div>
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

        <form id="frm-ecs" class="margin50 d-none">
            <div class="form-group row">
                <span>123123</span>
            </div>
        </form>
    </div>
</div>
<c:url var="urlStr" value="/layouts/js/datamaintain.js" />
<script src="${urlStr }"></script>
<c:url var="urlStr" value="/Resource/Customer/Add" />
<script type="text/javascript">
	
	$("#submit-customer").click(function(){
	    console.log("submit customer");
	    frmCustomerAddSubmit("${urlStr }");
	});
	
	topMenuNone();
	topMenuBlock("navDataMaintain");
	navList();
</script>