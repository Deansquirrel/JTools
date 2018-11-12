function showLoading(){
    swal({
        text:"处理中 ，请稍后",
        allowEscapeKey:false,
        allowOutsideClick:false,
        showConfirmButton:true,
        showCancelButton:false,
        showLoaderOnConfirm:true
    });
    swal.enableLoading();
}