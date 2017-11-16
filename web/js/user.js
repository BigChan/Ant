
$('.left_part li').click(function(){
    var index = $('.left_part li').index($(this));
    console.log(index)
    $(this).addClass('active')
    $(this).siblings().removeClass('active')
    $('.right_part table').eq(index).addClass('active')
    $('.right_part table').eq(index).siblings().removeClass('active')
})