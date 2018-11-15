function divActionNone(){
    const navList = new Array("divList","divAdd");

    for(let index in navList){
        $("#" + navList[index]).removeClass("d-block");
        $("#" + navList[index]).addClass("d-none");
    }
}

function divActionBlock(id){
    $("#" + id).removeClass("d-none");
    $("#" + id).addClass("d-block");
}

function divActionMenuNone(){
    const navList = new Array("navList","navAdd");

    for(let index in navList){
        $("#" + navList[index]).removeClass("active");
    }
}

function navList(){
    divActionNone();
    divActionBlock("divList");
    divActionMenuNone();
    $("#navList").addClass("active");
}

function navAdd(){
    divActionNone();
    divActionBlock("divAdd");
    divActionMenuNone();
    $("#navAdd").addClass("active");
}

function addTypeChanged(id){
    switch(id){
        case "customer":
            $("#btnGroupAddType").text("客户");
            divFormNone();
            divFormBlock("frm-customerAdd");
            $("#customerAddName").focus();
            break;
        case "ecs":
            $("#btnGroupAddType").text("ECS");
            divFormNone();
            divFormBlock("frm-ecsAdd");
            $("#ecsAddName").focus();
            break;
         default:
             console.log("error");
    }
}


function divFormNone(){
    const frmList = new Array("frm-customerAdd","frm-ecsAdd");

    for(let index in frmList){
        $("#" + frmList[index]).removeClass("d-block");
        $("#" + frmList[index]).addClass("d-none");
    }
}

function divFormBlock(id){
    $("#" + id).removeClass("d-none");
    $("#" + id).addClass("d-block");
}

function choseMisType(id){
    $('#btnGroupMisType').text(id);
    $('#btnGroupMisType').val(id);
    $('#customerAddMistype').val(id);
}



function frmAddSubmit(frmurl,frmname,type){
	$.ajax({
        url:frmurl,
        type:"POST",
        cache:false,
        data:$("#"+frmname).serialize(),
        beforeSend:function(){
            showLoading();
        },
        complete:function(){
            // closeLoading();
        },
        success:function(data){
            var d = JSON.parse(data);
            console.log(data)
            if(d != null){
                if(d.errcode == "0"){
                    swal({
                        text:"添加成功",
                        type:"success",
                        confirmButtonText: '确定',
                        showCancelButton: false,
                        allowEscapeKey:false,
                        allowOutsideClick:false
                    }).then(function(){
                    	switch(type){
	                    	case "customer":
	                    		resetFrm_CustomerAdd();
	                    		break;
	                    	case "ecs":
	                    		resetFrm_EcsAdd();
	                    		break;
                    	}
                    }).catch(swal.noop);
                }
                else{
                    swal({
                        text:d.errmsg==""?("未知错误【" + d.errcode + "】"):d.errmsg,
                        type:"error",
                        confirmButtonText: '确定',
                        showCancelButton: false,
                        allowEscapeKey:false,
                        allowOutsideClick:false
                    }).catch(swal.noop);
                }
            }
            else{
                swal({
                    text:"返回数据解析失败，请通过列表查询执行结果",
                    type:"error",
                    confirmButtonText: '确定',
                    showCancelButton: false,
                    allowEscapeKey:false,
                    allowOutsideClick:false
                }).catch(swal.noop);
            }
        },
        error:function(){
            swal({
                text:"提交遇到错误，请通过列表查询执行结果",
                type:"warning",
                confirmButtonText: '确定',
                showCancelButton: false,
                allowEscapeKey:false,
                allowOutsideClick:false
            }).catch(swal.noop);
        }
    });
}


function frmDelSubmit(frmurl, id){

	$("#delId").val(id);
	$.ajax({
        url:frmurl,
        type:"POST",
        cache:false,
        data:$("#frm-del").serialize(),
        beforeSend:function(){
            showLoading();
        },
        complete:function(){
            // closeLoading();
        },
        success:function(data){
            var d = JSON.parse(data);
            if(d != null){
                if(d.errcode == "0"){
                    swal({
                        text:"删除成功",
                        type:"success",
                        confirmButtonText: '确定',
                        showCancelButton: false,
                        allowEscapeKey:false,
                        allowOutsideClick:false
                    }).then(function(){
                        location.reload();
                    }).catch(swal.noop);
                }
                else{
                    swal({
                        text:d.errmsg==""?("未知" + d.errcode):d.errmsg,
                        type:"error",
                        confirmButtonText: '确定',
                        showCancelButton: false,
                        allowEscapeKey:false,
                        allowOutsideClick:false
                    }).catch(swal.noop);
                }
            }
            else{
                swal({
                    text:"返回数据解析失败，请通过列表查询执行结果",
                    type:"error",
                    confirmButtonText: '确定',
                    showCancelButton: false,
                    allowEscapeKey:false,
                    allowOutsideClick:false
                }).catch(swal.noop);
            }
        },
        error:function(){
            swal({
                text:"提交遇到错误，请通过列表查询执行结果",
                type:"warning",
                confirmButtonText: '确定',
                showCancelButton: false,
                allowEscapeKey:false,
                allowOutsideClick:false
            }).catch(swal.noop);
        }
    });
} 

function resetFrm_CustomerAdd(){
	$("#customerAddCode").val("");
    $("#customerAddName").val("");
    $("#customerAddDescription").val("");
    $("#customerAddShowname").val("");
    $("#customerAddSimplename").val("");
    $("#customerAddPinyinname").val("");
    choseMisType('请选择业务系统类型');
    $("#customerAddMistype").val("");
    $("#customerAddTongdcode").val("");
    $("#customerAddName").focus();
}

function resetFrm_EcsAdd(){
	$("#ecsAddName").val("");
    $("#ecsAddDescription").val("");
    $("#ecsAddInstanceID").val("");
    $("#ecsAddArea").val("");
    $("#ecsAddInternetIp").val("");
    $("#ecsAddIntranetIp").val("");
    $("#ecsAddOs").val("");
    $("#ecsAddExpirationDate").val("");
    $("#ecsAddRDPPort").val("");
    $("#ecsAddLoginName").val("");
    $("#ecsAddLoginPwd").val("");
    $("#ecsAddName").focus();
}

$("#reset-customer").click(function(){
    resetFrm_CustomerAdd();
});

$("#reset-ecs").click(function(){
	resetFrm_EcsAdd();
});