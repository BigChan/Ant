
     var userId = getCookie('username')
        var name_check = /^1[34578]\d{9}$/.test(userId);
    if(name_check){
        $('.userName').text(userId)
    }
    CKEDITOR.replace('my-editor')

  function submit(){
    var editor_data = CKEDITOR.instances.content.getData(); 
    var article_title =  $('#article_title').val()
if(editor_data==null||editor_data==""||article_title==''){  
    alert("文章题目或内容不能为空");  
}else{               
    // document.myform.submit()
    $.ajax({
    url:"http://192.168.155.4:8080/saveArticle",        
    data:{'content':editor_data,'title':article_title,'username':userId},
    error:function(XMLHttpRequest, textStatus, errorThrown){
      alert('提交失败'+XMLHttpRequest.status+textStatus)
    },
    success:function(data){
         if(data.code == '1'){
            alert(data.message)
         }
       }
    
})
}  
}
function getCookie(cname) {
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for(var i=0; i<ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0)==' ') c = c.substring(1);
        if (c.indexOf(name) != -1) return c.substring(name.length, c.length);
    }
    return "";
}