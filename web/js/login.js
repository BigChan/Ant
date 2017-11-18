var sign = location.search.split('=')[1]
function check_login(){
    var name=$("#user_name").val();
    var pass=$("#password").val();
    if(/^1[34578]\d{9}$/.test(name)&& /^.{6,10}$/.test(pass)){ 
        $.ajax({
            url:"http://192.168.155.4:8080/login",        
            data:{"username":name,"password":pass},
            error:function(XMLHttpRequest, textStatus, errorThrown){
              alert('登录失败'+XMLHttpRequest.status+textStatus)
            },
            success:function(data){
               alert(data.message);
               if(data.code == '1'){
                $("#user_name").val("");
                $("#password").val("");       
                document.cookie = name;
                 window.location.assign("index.html")
               }
            }
        })
       return
    } 
    else{
        $("#login_form").removeClass('shake_effect');  
        setTimeout(function()
        {
         $("#login_form").addClass('shake_effect')
        },1);
        alert('账号或密码不正确')  
    }
   }
   function check_register(){
     var name = $("#r_user_name").val();
     var pass = $("#r_password").val();
     var repass = $("#cr_password").val();
     var email = $("#r_email").val();
     var name_check = /^1[34578]\d{9}$/.test(name);
     var pass_check = /^.{6,10}$/.test(pass);
     var email_check = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/.test(email);
     if(name_check && email_check &&pass_check &&(pass === repass) )
      {
        $.ajax({
        url:"http://192.168.155.4:8080/register",
        data:{"username":name,"password":pass,"email":email},
        error:function(XMLHttpRequest, textStatus, errorThrown){
          alert('注册失败'+XMLHttpRequest.status+textStatus)
        },
        success:function(data){
          alert(data.message)
          if(data.code == '1'){
            $("#r_user_name").val("");
            $("#r_password").val("");
            $("#cr_password").val("");
             $("#r_email").val("");
            $('form').animate({
             height: 'toggle',
             opacity: 'toggle'
         }, 'slow');
         document.title = document.title =='码蚁——登录'?'码蚁——注册':'码蚁——登录';
          }
        }
       })
      
      }
      else
      {
       $("#login_form").removeClass('shake_effect');  
       setTimeout(function()
       {
        $("#login_form").addClass('shake_effect')
       },1);  
       
      }
   } 

//  注册
   $("#create").click(function(){
    check_register();
    return false;
  })

//   登录
  $("#login").click(function(){
    check_login();
    return false;
  })                 

//   登录注册切换
if(sign == 0){
  $('form').animate({
    height: 'toggle',
    opacity: 'toggle'
}, 'slow');
document.title = document.title =='码蚁——登录'?'码蚁——注册':'码蚁——登录';
}
  $('.message a').click(function () {
    $('form').animate({
        height: 'toggle',
        opacity: 'toggle'
    }, 'slow');   
    document.title = document.title =='码蚁——登录'?'码蚁——注册':'码蚁——登录';
});