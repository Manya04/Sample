/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admis.controller;

import co.admis.model.Login;

import co.admis.service.BeansTrialService;
import co.admis.service.CommonMethodsService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.paytm.pg.merchant.PaytmChecksum;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.http.converter.json.Jackson2ObjectMapperBuilder.json;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Adeep My IT Solution Private Limited
 */
@Controller
public class Index {
    
    @Autowired
    CommonMethodsService commonMethodsService;
    
    @Autowired
    BeansTrialService beansTrialService;
    
    @RequestMapping(value = {"/index"}, method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("index");
    }
    
    
    
    @RequestMapping(value = {"/requestForm"}, method = RequestMethod.GET)
    public ModelAndView requestForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            
            ModelAndView mav = new ModelAndView("requestForm");
            JSONObject paytmParams = new JSONObject();
            String orderId = "ORDERID_9876524326";
            JSONObject body = new JSONObject();
            body.put("requestType", "Payment");
            body.put("mid", "wRXHIs53733826046276");
            body.put("websiteName", "WEBSTAGING");
            body.put("orderId", orderId);
            body.put("callbackUrl", "http://localhost:8080/TemplateCopy/responseForm");
            
            JSONObject txnAmount = new JSONObject();
            txnAmount.put("value", "1.00");
            txnAmount.put("currency", "INR");
            
            JSONObject userInfo = new JSONObject();
            userInfo.put("custId", "CUST_001");
            body.put("txnAmount", txnAmount);
            body.put("userInfo", userInfo);
            
            /*
            * Generate checksum by parameters we have in body
            * You can get Checksum JAR from https://developer.paytm.com/docs/checksum/
            * Find your Merchant Key in your Paytm Dashboard at https://dashboard.paytm.com/next/apikeys
            */
            

            String checksum = PaytmChecksum.generateSignature(body.toString(), "HoYUpL1N2_fiRrRn");
            System.out.println("check");
            JSONObject head = new JSONObject();
            head.put("signature", checksum);
            
            paytmParams.put("body", body);
            paytmParams.put("head", head);
            
            String post_data = paytmParams.toString();
            
            /* for Staging */
            URL url = new URL("https://securegw-stage.paytm.in/theia/api/v1/initiateTransaction?mid=wRXHIs53733826046276&orderId="+orderId);
            
            /* for Production */
            // URL url = new URL("https://securegw.paytm.in/theia/api/v1/initiateTransaction?mid=YOUR_MID_HERE&orderId=ORDERID_98765");
            
            try {
                
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("POST");
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setDoOutput(true);
                
                DataOutputStream requestWriter = new DataOutputStream(connection.getOutputStream());
                requestWriter.writeBytes(post_data);
                requestWriter.close();
                String responseData = "";
                InputStream is = connection.getInputStream();
                BufferedReader responseReader = new BufferedReader(new InputStreamReader(is));
                if ((responseData = responseReader.readLine()) != null) {
                    System.out.append("Response: " + responseData);
                    
                }
                
                ObjectMapper mapper = new ObjectMapper();
                JsonNode actualObj = mapper.readTree(responseData); 
                System.out.println("hello");
                String token = actualObj.get("body").get("txnToken").asText();
                System.out.println("Token is"+token);
                mav.addObject("token",token);
                mav.addObject("orderId",orderId);
                mav.addObject("mid","wRXHIs53733826046276");
                responseReader.close();
                return mav;
            } catch (Exception exception) {
                exception.printStackTrace();
                System.out.println("exception is"+exception);
                return null;
            }
        } catch (Exception ex) {
            Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("exception hai");
            return null;
        }
       
    }
    
    @RequestMapping(value = {"/responseForm"}, method = RequestMethod.POST)
    public ModelAndView responseForm(HttpServletRequest request, HttpServletResponse response) {
        try{
            ModelAndView mav = new ModelAndView("responseForm");
            String currency = request.getParameter("CURRENCY");
            System.out.println(currency);
            mav.addObject("CURRENCY",currency);
            String gatewayName = request.getParameter("GATEWAYNAME");
            mav.addObject("GATEWAYNAME","Kotak");
            String respMsg = request.getParameter("RESPMSG");
            mav.addObject("RESPMSG",respMsg);
            String bankName = request.getParameter("BANKNAME");
            mav.addObject("BANKNAME",bankName);
            String paymentMode = request.getParameter("PAYMENTMODE");
            mav.addObject("PAYMENTMODE",paymentMode);
            String mid = request.getParameter("MID");
            mav.addObject("MID",mid);
            String respCode = request.getParameter("RESPCODE");
            mav.addObject("RESPCODE",respCode);
            String txnId = request.getParameter("TXNID");
            mav.addObject("TXNID",txnId);
            String txnAmount = request.getParameter("TXNAMOUNT");
            mav.addObject("TXNAMOUNT",txnAmount);
            String orderId = request.getParameter("ORDERID");
            mav.addObject("ORDERID",orderId);
            String status = request.getParameter("STATUS");
            mav.addObject("STATUS",status);
            String banktxnId = request.getParameter("BANKTXNID");
            mav.addObject("BANKTXNID",banktxnId);
            String txnDate = request.getParameter("TXNDATE");
            mav.addObject("TXNDATE",txnDate);
            String checksumash = request.getParameter("CHECKSUMHASH");
            mav.addObject("CHECKSUMHASH",checksumash);
            return mav;
        }catch (Exception ex) {
            Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
           return null;
        }
    }
    
    
        
        
    @RequestMapping(value = {"/registration_form"}, method = RequestMethod.GET)
    public ModelAndView rform(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("hey");
        return new ModelAndView("registration_form");
    }
    
    @RequestMapping(value = {"/form"} , method = RequestMethod.GET)
    public ModelAndView form(HttpServletRequest request, HttpServletResponse response){
        ModelAndView mav =  new ModelAndView("form");
        /*Cookie ck[] = request.getCookies();
        for(Cookie c: ck){
            if(c.getName().equalsIgnoreCase("username")){
                if(c.getValue().equalsIgnoreCase("admin")){
                    return new ModelAndView("success");
                }
            }
        }*/
        return mav;
    }
    
    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public @ResponseBody 
        String login(HttpServletRequest request, HttpServletResponse response, Login login) {
            HttpSession session = request.getSession();
            System.out.println(login);
            Login l = beansTrialService.user(login);
            if(l!=null){
               session.setAttribute("username",login.getUsername()); 
               return "success";
            }else{
                return "Please enter correct login id and password";
            }
    }
    /*@RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("login") Login login) {
        Login l = beansTrialService.user(login);
        if(l==null){
            return new ModelAndView("failure");
        }else{
            return new ModelAndView("success");  
        }
    }*/

    @RequestMapping(value = {"/success"} , method = RequestMethod.POST)
    public ModelAndView success(HttpServletRequest request, HttpServletResponse response){
        System.out.println("Parameters");
        System.out.println(request.getParameter("ORDERID"));
        return new ModelAndView("success");
    }
}
