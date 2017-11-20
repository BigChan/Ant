var stop=true,start = 1; 
$(document).ready(function(){
  var userId = getCookie('username')
  var name_check = /^1[34578]\d{9}$/.test(userId);
  if(name_check){
      $('#LognReg').hide();
      $('.userMsg').show();
      $('.userMsg .userName').text(userId)
  }
  $.ajax({
    url:"http://192.168.155.4:8080/recommendArticles",        
    data:{'start':start},
    success:function(data){
        for(x in data.articles){
          $('.list-wrap').append(
        '<li class="list-box">' +
          '<div class="content">'+
             '<div><a class="author">'+data.articles[x].username+
             '</a></div><div class=""><a class="article_title" href="article.html?id='+data.articles[x].id+ '"  target="_blank">'+data.articles[x].title+'</a></div>'+
              '<div class=""><p class="abstract">'+data.articles[x].content+'</p></div>'+
              '<div class="bottom"><a class="date">'+data.articles[x].createdate+'</a><a class="views">'+data.articles[x].views+'</a></div>'+
          '</div>'+
        '</li>')
        }
        stop=true;
        start +=10; 
       }   
   })
  
})

$(window).scroll(function(){ 
    totalheight = parseFloat($(window).height()) + parseFloat($(window).scrollTop()); 
    if($(document).height()-50 <= totalheight){ 
        if(stop==true){ 
            stop=false; 
            $.ajax({
                url:"http://192.168.155.4:8080/recommendArticles",        
                data:{'start':start},
                success:function(data){
                    for(x in data.articles){
                      $('.list-wrap').append(
                    '<li class="list-box">' +
                      '<div class="content">'+
                         '<div><a class="author">'+data.articles[x].username+
                         '</a></div><div class=""><a class="article_title" href="article.html?id='+data.articles[x].id+ '" target="_blank">'+data.articles[x].title+'</a></div>'+
                          '<div class=""><p class="abstract">'+data.articles[x].content+'</p></div>'+
                          '<div class="bottom"><a class="date">'+data.articles[x].createdate+'</a><a class="views">'+data.articles[x].views+'</a></div>'+
                      '</div>'+
                    '</li>')
                    }
                    stop=true;
                    start +=10; 
                   }   
               })
        } 
    } 
});
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

  function setCookie(cname, cvalue, exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays*24*60*60*1000));
    var expires = "expires="+d.toUTCString();
    document.cookie = cname + "=" + cvalue + "; " + expires;
  }