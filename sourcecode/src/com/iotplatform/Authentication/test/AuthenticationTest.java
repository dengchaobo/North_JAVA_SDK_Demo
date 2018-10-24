package com.iotplatform.Authentication.test;

import com.iotplatform.client.NorthApiClient;
import com.iotplatform.client.dto.AuthOutDTO;
import com.iotplatform.client.dto.AuthRefreshInDTO;
import com.iotplatform.client.dto.AuthRefreshOutDTO;
import com.iotplatform.client.invokeapi.Authentication;
import com.iotplatform.utils.AuthUtil;
import com.iotplatform.utils.PropertyUtil;

public class AuthenticationTest
{
    public static void main(String args[]) throws Exception
    {    	
    	/**---------------------initialize northApiClient------------------------*/
        NorthApiClient northApiClient = AuthUtil.initApiClient();
        northApiClient.getVersion();
        
        /**----------------------get access token-------------------------------*/
        System.out.println("======get access token======");
        Authentication authentication = new Authentication(northApiClient);
        
        // get access token
        AuthOutDTO authOutDTO = authentication.getAuthToken();        
        System.out.println(authOutDTO.toString());
        
        /**----------------------refresh token--------------------------------*/
        System.out.println("\n======refresh token======");
        AuthRefreshInDTO authRefreshInDTO = new AuthRefreshInDTO();
        
        authRefreshInDTO.setAppId(PropertyUtil.getProperty("appId"));
        authRefreshInDTO.setSecret(northApiClient.getClientInfo().getSecret());
        
        //get refreshToken from the output parameter (i.e. authOutDTO) of Authentication
        String refreshToken = authOutDTO.getRefreshToken();
        authRefreshInDTO.setRefreshToken(refreshToken);
        
        AuthRefreshOutDTO authRefreshOutDTO = authentication.refreshAuthToken(authRefreshInDTO);
        
        System.out.println(authRefreshOutDTO.toString());
    }
}
