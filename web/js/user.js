
$(document).ready(function(){
    $.ajax({
        url:"192.168.191.1:8080/",
        data:{"name":name,"pass":pass},
        success:function(data){}
    })
})

$('.left_part li').click(function(){
    var index = $('.left_part li').index($(this));
    $(this).addClass('active')
    $(this).siblings().removeClass('active')
    $('.right_part table').eq(index).addClass('active')
    $('.right_part table').eq(index).siblings().removeClass('active')
})