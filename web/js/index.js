var stop=true,start = 1; 
$(document).ready(function(){
  var userId = document.cookie.split(';')[0]
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
             '</a></div><div class=""><a class="article_title">'+data.articles[x].title+'</a></div>'+
              '<div class=""><p class="abstract">'+data.articles[x].content+'</p></div>'+
              '<div class="bottom"><a class="date">'+data.articles[x].createdate+'</a><a class="views">'+data.articles[x].views+'</a></div>'+
          '</div>'+
        '</li>')
        }
        stop=true;
        start +=20; 
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
                         '</a></div><div class=""><a class="article_title">'+data.articles[x].title+'</a></div>'+
                          '<div class=""><p class="abstract">'+data.articles[x].content+'</p></div>'+
                          '<div class="bottom"><a class="date">'+data.articles[x].createdate+'</a><a class="views">'+data.articles[x].views+'</a></div>'+
                      '</div>'+
                    '</li>')
                    }
                    stop=true;
                    start +=20; 
                   }   
               })
        } 
    } 
});
function setCookie(cvalue, exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays*24*60*60*1000));
    var expires = "expires="+d.toUTCString();
    document.cookie = cvalue + "; " + expires;
}

//清除cookie  
function clearCookie() {  
    setCookie("", -1);  
} 

