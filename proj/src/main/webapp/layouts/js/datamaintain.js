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
            $("#customerAddCode").focus();
            break;
        case "ecs":
            $("#btnGroupAddType").text("ECS");
            divFormNone();
            divFormBlock("frm-ecs");
            break;
         default:
             console.log("error");
    }
}


function divFormNone(){
    const frmList = new Array("frm-customerAdd","frm-ecs");

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

function frmCustomerAddSubmit(frmurl){
	$.ajax({
        url:frmurl,
        type:"POST",
        cache:false,
        data:$("#frm-customerAdd").serialize(),
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
                        text:"添加成功",
                        type:"success",
                        confirmButtonText: '确定',
                        showCancelButton: false,
                        allowEscapeKey:false,
                        allowOutsideClick:false
                    }).then(function(){
                    	resetFrm_CustomerAdd();
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


function frmCustomerDelSubmit(frmurl, id){

	$("#customerDelId").val(id);
	$.ajax({
        url:frmurl,
        type:"POST",
        cache:false,
        data:$("#frm-customerDel").serialize(),
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
    $("#customerAddCode").focus();
}

$(".form_datetime").datetimepicker({format: 'yyyy-mm-dd'});

$("#reset-customer").click(function(){
    resetFrm_CustomerAdd();
});