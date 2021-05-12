/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 
package co.admis.model;

/**
 *
 * @author manyaagarwal
 

    
    import java.util.Map;

import org.springframework.boot.context.properties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties("paytm.payment.sandbox")
public class PaytmDetail {
	
	private String merchantId;
	
	private String merchantKey;
	
	private String channelId;
	
	private String website;
	
	private String industryTypeId;
	
	private String paytmUrl;
	
	private Map<String, String> details;
	
	public PaytmDetail() {}
	

	public PaytmDetail(String merchantId, String merchantKey, String channelId, String website,
			String industryTypeId, String paytmUrl, Map<String, String> details) {
		super();
		this.merchantId = merchantId;
		this.merchantKey = merchantKey;
		this.channelId = channelId;
		this.website = website;
		this.industryTypeId = industryTypeId;
		this.paytmUrl = paytmUrl;
		this.details = details;
	}
}
//getter and setter method

   */ 

