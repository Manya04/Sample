<%-- 
    Document   : request
    Created on : 08-Apr-2021, 1:39:48 pm
    Author     : manyaagarwal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <title>Show Payment Page</title>
   </head>
   <body>
      <center>
         <h1>Please do not refresh this page...</h1>
      </center>
      <form method="get" action="https://securegw-stage.paytm.in/theia/api/v1/showPaymentPage?mid=${mid}&orderId=${orderId}" name="paytm">
         <table border="1">
            <tbody>
               <input type="hidden" name="mid" value="${mid}">
               <input type="hidden" name="orderId" value="${orderId}">
               <input type="hidden" name="txnToken" value="${token}">
               <input type="hidden" name="callbackUrl" value="http://localhost:8080/TemplateCopy/responseForm">
            </tbody>
         </table>
         <script type="text/javascript"> document.paytm.submit(); </script>
      </form>
   </body>
</html>
