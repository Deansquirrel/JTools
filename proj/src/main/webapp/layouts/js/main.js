function topMenuNone(){
    const navList = new Array("navFunctionList","navDataMaintain");

    for(let index in navList){
        $("#" + navList[index]).removeClass("active");
    }
}

function topMenuBlock(id){
    $("#" + id).addClass("active");
}