package com.iotplatform.BasicTest.test;

import com.iotplatform.client.dto.SSLConfig;
import com.iotplatform.client.testapi.BasicTest;
import com.iotplatform.utils.AuthUtil;
import com.iotplatform.utils.PropertyUtil;

public class Test {
	public static void main(String[] args) {
		/**---------------------test basic function of the APIs------------------------*/
		//BasicTest will help to test the basic API and find out if there's a problem or not.
		System.out.println("============test with inner certificates only============");
		
		PropertyUtil.init("./src/main/resources/application.properties");
		
		BasicTest.beginBasicTest(PropertyUtil.getProperty("platformIp"), PropertyUtil.getProperty("platformPort"), 
				PropertyUtil.getProperty("appId"), AuthUtil.getAesPropertyValue("secret"), null);
		
		
		//use ca.jks and outgoing.CertwithKey.pkcs12 as commercial certificates, and see what happened ~ ~
		System.out.println("\n===========test with both inner certificates and outer certificates=============");
		
		SSLConfig sslconfig = new SSLConfig();
		sslconfig.setTrustCAPath("./src/main/resources/ca.jks");
		sslconfig.setTrustCAPwd("Huawei@123");
		sslconfig.setSelfCertPath("./src/main/resources/outgoing.CertwithKey.pkcs12");
		sslconfig.setSelfCertPwd("IoM@1234");
		
		BasicTest.beginBasicTest(PropertyUtil.getProperty("platformIp"), PropertyUtil.getProperty("platformPort"), 
				PropertyUtil.getProperty("appId"), AuthUtil.getAesPropertyValue("secret"), sslconfig);
	}
	
}
