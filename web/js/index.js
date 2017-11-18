$(document).ready(function(){
  
  var userId = document.cookie.split(';')[0]
  console.log(userId)
  var name_check = /^1[34578]\d{9}$/.test(userId);
  if(name_check){
      $('#LognReg').hide();
      $('.userMsg').show();
      $('.userMsg .userName').text(userId)
  }
 
})

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