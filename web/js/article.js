var userId = getCookie('username')
var name_check = /^1[34578]\d{9}$/.test(userId);
if(name_check){
$('.userName').text(userId)
}
var id = location.search.split('=')[1]
$.ajax({
    url:"http://192.168.155.4:8080/getArticleById",        
    data:{'id':id},
    // error:function(XMLHttpRequest, textStatus, errorThrown){
    //   alert('提交失败'+XMLHttpRequest.status+textStatus)
    // },
    success:function(data){
         if(data.code == '1'){
             $('.info_wrap .article-title').text(data.article.title)
             $('.info_wrap .author').text(data.article.username)
             $('.info_wrap .date').text(data.article.createdate)
             $('.info_wrap .views').text(data.article.views)
             $('.article_wrap').html(data.article.content)
         }
       }
    
})
//获取cookie
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