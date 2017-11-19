
     var userId = document.cookie.split(';')[0]
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
        var newdate = JSON.parse(data)
         if(newdate.code == '1'){
            alert('提交成功')
         }
       }
    
})
}  
}