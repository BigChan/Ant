

 var userId = getCookie('username')
 $.ajax({
    url:"http://192.168.0.1:8080/getUserInfo",
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

function save_setting(){
    var penName = $('#penName').val();
    var email = $('#mail').val();
    var sex = $('input[name="sex"]:checked').prop('value');
    var introduction = $('#description').text();
    var website = $('#site').val();
    $.ajax({
        url:"http://192.168.0.1:8080/getUserInfo",
        data:{"penName":penName,'email':email,'sex':sex,'introduction':introduction,'website':website},
        dataType:'json',
        // error:function(XMLHttpRequest, textStatus, errorThrown){
        //     alert(XMLHttpRequest.status+textStatus+XMLHttpRequest.readyState)
        //   },
        success:function(data){
            if(data.code == '1'){
               alert(data.message)     
            } 
        }
    })        
}

$.ajax({
    url:"http://192.168.0.1:8080/getMyArticles",
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
                   '<div class=""><a class="article_title" href="article.html?id='+data.articles[x].id+'"  target="_blank">'+data.articles[x].title+'</a></div>'+
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
$('.search_input').on('keypress',function(event){
    if(event.keyCode == '13'){
        search()
    }     
})
$('.search').on('click',function(){
    search()
})

function search(){
    var search_key = $('.search_input').val()
    if(search_key != ''){
        window.open('search_result.html?key='+search_key)        
    }
}
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