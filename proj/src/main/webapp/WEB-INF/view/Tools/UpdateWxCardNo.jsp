<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../../../layouts/library.jsp"%> 
<div id="container" style="margin: 20px 50px">
    <form id="f-add" class="form-horizontal">
    	<div class="form-group row">
            <label for="customer" class="col-sm-2 col-form-label">客户</label>
            <div class="col-sm-10">
                <select id="customer" name="customer" class="form-control">
	                <c:forEach items="${customerList }" var="customer">
					        <option value="${customer.key }">${customer.value }</option>
					   </c:forEach>
                </select>
            </div>
        </div>
        <div class="form-group row">
            <label for="tel" class="col-sm-2 col-12 col-form-label">手机号</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="tel" id="tel" placeholder="手机号">
            </div>
        </div>
        <div class="float-right">
            <button type="button" id="btnSubmit" class="btn btn-primary btn-block">Submit</button>
        </div>
        <div class="clearfix divide50"></div>
    </form>

    <div class="row">
        <label id="labResult"></label>
    </div>
</div>

<c:url var="urlStr" value="/Tools/UpdateWxCardNo" />
<script type="text/javascript">
	$("#btnSubmit").click(function(){
	    if($("#customer option:selected").val() == undefined){
	        alert("请选择客户");
	        return
	    }
	    if($("#tel").val().trim()==""){
	        alert("手机号不能为空");
	        return
	    }
	
	    $.ajax({
	        url:"${urlStr }",
	        type:"POST",
	        cache:false,
	        data:$("#f-add").serialize(),
	        beforeSend:function(){
	            $("#btnSubmit").attr("disabled",true);
	        },
	        complete:function(){
	            $("#btnSubmit").attr("disabled",false);
	        },
	        success:function (data) {
	            $("#labResult").html(data);
	
	            var json;
	            try{
	                json = JSON.parse(data);
	                if(json != null){
	                    if(json.errcode == "0"){
	                        $("#labResult").html(json.data);
	                        $("#tel").val("");
	                    }
	                    else{
	                        var errMsg = json.errmsg + "[" + json.errcode + "]"
	                        $("#labResult").html(errMsg);
	                    }
	                }
	            }catch(err){
	                console.log(data)
	                console.log(err)
	                $("#labResult").html("返回数据解析异常");
	            }
	        },
	        error:function(){
	            alert("提交数据时发生错误，请重试");
	        }
	    });
	});
</script>