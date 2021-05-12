<%-- 
    Document   : form
    Created on : 19-Feb-2021, 4:55:03 pm
    Author     : manyaagarwal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Form</title>
    </head>
    <body>
        <h2>Login Page</h2>
            
        <form id="add-event-form" onsubmit="return validate()" action="login" method="post">
            <input id="uname" type="text" name="uname" placeholder="Username"><br>
            <input id="psw" type="password" name="password" placeholder="Password"><br>
            <button id="submit-btn" type="submit">Submit</button>
        </form>
    </body>
    <script type="text/javascript">
        function validate(){
            var username = document.getElementById("uname");
            var password = document.getElementById("psw");
            if(username.value.trim()==="")
            {
                alert("blank username not allowed");
                return false;
            }
            if(password.value.trim()==="")
            {
                alert("blank password not allowed");
                return false;
            }
            else if(password.value.trim().length<5)
            {
                alert("password length too small");
                return false;
            }
            else
                return true;
        }
    </script>
    <script
  src="https://code.jquery.com/jquery-3.6.0.js"
  integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
  crossorigin="anonymous"></script>
    <script>
    $(document).ready(function(){
       $('form').submit(function(event) 
       {  
           event.preventDefault();
          $.ajax({
            type: "POST",
            url:"/TemplateCopy/login",
            data: $('form').serialize(),
            timeout: 600000
            
             }).done(function(response){
                 if(response === "success"){
                    window.location.href = "/TemplateCopy/success";
                }else{
                    alert(response);
                }
                 console.log(response);
             });                               
           });
         });
   </script>   
</html>
    