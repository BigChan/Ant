

 var userId = getCookie('username')
 $.ajax({
    url:"http://192.168.155.4:8080/getUserInfo",
    data:{"username":userId},
    dataType:'json',
    // error:function(XMLHttpRequest, textStatus, errorThrown){
    //     alert(XMLHttpRequest.status+textStatus+XMLHttpRequest.readyState)
    //   },
    success:function(data){
        if(data.code == '1'){
            $('#penName').val(data.info.penname);
            $('#mail').val(data.info.email);
            $('input[name="sex"]').eq(Number(data.info.sex)).prop('checked','checked')
            $('#description').text(data.info.introduction);
            $('#site').val(data.info.website);         
        } 
    }
})
$.ajax({
    url:"http://192.168.155.4:8080/getMyArticles",
    data:{"username":userId},
    dataType:'json',
    // error:function(XMLHttpRequest, textStatus, errorThrown){
    //     alert(XMLHttpRequest.status+textStatus+XMLHttpRequest.readyState)
    //   },
    success:function(data){
        if(data.code == '1'){
            for(x in data.articles){
                $('.article').append('<tr><td class="list-box">' +
                '<div class="content">'+
                   '</a></div><div class=""><a class="article_title" href="article.html?id='+data.articles[x].id+ '"  target="_blank">'+data.articles[x].title+'</a></div>'+
                    '<div class="bottom"><a class="date">'+data.articles[x].createdate+'</a><a class="views">'+data.articles[x].views+'</a></div>'+
                '</div>'+
              '</td></tr>')   
            }         
        } 
    }
})


$('.left_part li').click(function(){
    var index = $('.left_part li').index($(this));
    $(this).addClass('active')
    $(this).siblings().removeClass('active')
    $('.right_part table').eq(index).addClass('active')
    $('.right_part table').eq(index).siblings().removeClass('active')
})

$('#img_file').change(function(){
    loadImg();
 })
 function loadImg(){  
var file = $("#img_file")[0].files[0];
var reader = new FileReader();  
var imgFile;  
reader.onload=function(e) {  
    imgFile = e.target.result;  
    $("#image").attr('src', imgFile);  
};   
reader.readAsDataURL(file);
}  

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