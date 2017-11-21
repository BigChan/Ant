var userId = getCookie('username')
var name_check = /^1[34578]\d{9}$/.test(userId);
if(name_check){
$('.userName').text(userId)
}
var key = location.search.split('=')[1]
key = decodeURI(key)
$.ajax({
    url:"http://192.168.0.1:8080/searchArticles",        
    data:{'key':key},
    success:function(data){
      $('.search_key span').eq(1).text(data.count)      
        for(x in data.articles){
            var abstract=data.articles[x].content.replace(/<\/?.+?>/g,"");
            var newabstract=abstract.replace(/ /g,"");
          $('.list-wrap').append(
        '<li class="list-box">' +
          '<div class="content">'+
             '<div class=""><a class="article_title" href="article.html?id='+data.articles[x].id+ '"  target="_blank">'+data.articles[x].title+'</a></div>'+
              '<div class=""><p class="abstract">'+newabstract+'</p></div>'+
              '<div class="bottom"><a class="author">'+data.articles[x].username+'</a><a class="date">'+data.articles[x].createdate+'</a><a class="views">'+data.articles[x].views+'</a></div>'+
          '</div>'+
        '</li>')
        }
       }   
   })
   $('.search_key span').eq(0).text(key)
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