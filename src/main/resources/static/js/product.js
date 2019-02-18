
/**
 * 全选和取消
 * @param  allBoxId 全选框的id
 * @param  多选框的name
 */
function checkOrCancelAll(allBoxId,boxName){
        var isAllSelect=document.getElementById(allBoxId).checked;
        console.log(isAllSelect)
        var allCheck=document.getElementsByName(productBoxName);
        if(isAllSelect){
            for(var i=0;i<allCheck.length;i++){
                allCheck[i].checked=true;
            }
        }else{
            for(var i=0;i<allCheck.length;i++){
                allCheck[i].checked=false;
            }
        }
}

/**
 * 获取选择框的id
 * @param  多选框的name
 * @return  id字符串以,号分割
 */
function getCheckBoxId(boxName) {
    var allCheck=document.getElementsByName(boxName);
    var checkBoxIds=new Array();
    for (var i=0;i<allCheck.length;i++){
        if (allCheck[i].checked){
            checkBoxIds.push(allCheck[i].id);
        }
    }
    var idStr=checkBoxIds.join(',');
    return idStr;
}


function checkFileExt(filename) {
    var flag = false; //状态
    var arr = [ "jpg", "png", "gif" ];
    //取出上传文件的扩展名
    var index = filename.lastIndexOf(".");
    var ext = filename.substr(index + 1);
    //循环比较
    for (var i = 0; i < arr.length; i++) {
        if (ext == arr[i]) {
            flag = true; //一旦找到合适的，立即退出循环
            break;
        }
    }
    //条件判断
    if (flag) {
        document.write("文件名合法");
    } else {
        document.write("文件名不合法");
    }
}


/**
 * 添加图片
 * @param   上传图片组件的id
 * @param   controller 的url
 * @param   可选属性 id/name
 */
function toAddImgs(imgs,url,isId) {
    var form = $('#uploadForm')[0];

    var formData = new FormData(form);

    if (isId){
        var fileNames = document.getElementById(imgs).value;
    } else {
        var fileNames = document.getElementsByName(imgs).value;
    }


    if (fileNames.length == 0) {
        alert("请选择文件");
        return;
    }

    $.ajax({
        url : url,
        type : 'POST',
        cache : false,
        data : formData,
        //这个参数是jquery特有的，不进行序列化，因为我们不是json格式的字符串，而是要传文件
        dataType : "json",
        processData : false,
        //注意这里一定要设置contentType:false，不然会默认为传的是字符串，这样文件就传不过去了
        contentType : false,
        success : function(data) {
            alert("sucess");
            for(var i in data){
                alert(data[i])
                var path=data[i];
            }
        },
        error : function(XMLHttpRequest, textStatus, errorThrown) {
            alert(XMLHttpRequest.textStatus);
            alert(XMLHttpRequest.readyState);
            alert(XMLHttpRequest.status);
        }
    });
}
