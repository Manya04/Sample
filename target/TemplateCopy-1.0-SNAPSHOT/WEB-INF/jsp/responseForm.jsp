<%-- 
    Document   : responseForm
    Created on : 09-Apr-2021, 3:31:23 pm
    Author     : manyaagarwal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Paytm Secure Online Payment Gateway</title>
	</head>
	<body>
		<table align='center'>
			<tr>
				<td><STRONG>Transaction is being processed,</STRONG></td>
			</tr>
			<tr>
				<td><font color='blue'>Please wait ...</font></td>
			</tr>
			<tr>
				<td>(Please do not press 'Refresh' or 'Back' button</td>
			</tr>
		</table>
		<FORM NAME='TESTFORM' ACTION='http://localhost:8080/TemplateCopy/success'  METHOD='POST'>
			<input type='hidden' name='CURRENCY' value='${CURRENCY}'>
			<input type='hidden' name='GATEWAYNAME' value='${GATEWAYNAME}'>
			<input type='hidden' name='RESPMSG' value='${RESPMSG}'>
			<input type='hidden' name='BANKNAME' value='${BANKNAME}'>
			<input type='hidden' name='PAYMENTMODE' value='${PAYMENTMODE}'>
			<input type='hidden' name='MID' value='${MID}'>
			<input type='hidden' name='RESPCODE' value='${RESPCODE}'>
			<input type='hidden' name='TXNID' value='${TXNID}'>
			<input type='hidden' name='TXNAMOUNT' value='${TXNAMOUNT}'>
			<input type='hidden' name='ORDERID' value='${ORDERID}'>
			<input type='hidden' name='STATUS' value='${STATUS}'>
			<input type='hidden' name='BANKTXNID' value='${BANKTXNID}'>
			<input type='hidden' name='TXNDATE' value='${TXNDATE}'>
			<input type='hidden' name='CHECKSUMHASH' value='${CHECKSUMHASH}'>
		</FORM>
	</body>
	<script type="text/javascript">  document.forms[0].submit();</script>    
</html>
