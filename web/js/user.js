
// $(document).ready(function(){
//     $.ajax({
//         url:"192.168.191.1:8080/",
//         data:{"name":name,"pass":pass},
//         success:function(data){}
//     })
// })

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