package com.iotplatform.DataCollection.test;

import com.iotplatform.client.NorthApiClient;
import com.iotplatform.client.dto.AuthOutDTO;
import com.iotplatform.client.dto.QueryBatchDevicesInfoInDTO;
import com.iotplatform.client.dto.QueryBatchDevicesInfoOutDTO;
import com.iotplatform.client.dto.QueryDeviceCapabilitiesInDTO;
import com.iotplatform.client.dto.QueryDeviceCapabilitiesOutDTO;
import com.iotplatform.client.dto.QueryDeviceDataHistoryInDTO;
import com.iotplatform.client.dto.QueryDeviceDataHistoryOutDTO;
import com.iotplatform.client.dto.QueryDeviceDesiredHistoryInDTO;
import com.iotplatform.client.dto.QueryDeviceDesiredHistoryOutDTO;
import com.iotplatform.client.dto.QuerySingleDeviceInfoOutDTO;
import com.iotplatform.client.invokeapi.Authentication;
import com.iotplatform.client.invokeapi.DataCollection;
import com.iotplatform.utils.AuthUtil;

public class DataCollectionTest
{
    public static void main(String args[]) throws Exception {
    	/**---------------------initialize northApiClient------------------------*/
    	NorthApiClient northApiClient = AuthUtil.initApiClient();
    	DataCollection dataCollection = new DataCollection(northApiClient);
        
        /**---------------------get accessToken at first------------------------*/
        Authentication authentication = new Authentication(northApiClient);        
        AuthOutDTO authOutDTO = authentication.getAuthToken();        
        String accessToken = authOutDTO.getAccessToken();
        
        /**---------------------query device info------------------------*/
        //this is a test device
        System.out.println("======query device info======");
        String deviceId = "cb15cbb6-04ce-4e2b-bf35-d6a264c74646";
        QuerySingleDeviceInfoOutDTO qsdiOutDTO = dataCollection.querySingleDeviceInfo(deviceId, null, null, accessToken);
        if (qsdiOutDTO != null) {
        	System.out.println(qsdiOutDTO.toString());
		}
        
        /**---------------------query batch device info------------------------*/
        System.out.println("\n======query batch device info======");
        QueryBatchDevicesInfoInDTO qbdiInDTO = new QueryBatchDevicesInfoInDTO();
        qbdiInDTO.setPageNo(0);
        qbdiInDTO.setPageSize(10);
        QueryBatchDevicesInfoOutDTO qbdiOutDTO = dataCollection.queryBatchDevicesInfo(qbdiInDTO, accessToken);
        if (qbdiOutDTO != null) {
        	System.out.println(qbdiOutDTO.toString());
		}
        
        /**---------------------query device data history------------------------*/
        System.out.println("\n======query device data history======");
        QueryDeviceDataHistoryInDTO qddhInDTO = new QueryDeviceDataHistoryInDTO();
        qddhInDTO.setDeviceId(deviceId);
        qddhInDTO.setGatewayId(deviceId);//for directly-connected device, the gatewayId is its own deviceId
        QueryDeviceDataHistoryOutDTO qddhOutDTO = dataCollection.queryDeviceDataHistory(qddhInDTO, accessToken);
        if (qddhOutDTO != null) {
        	System.out.println(qddhOutDTO.toString());        	
		}
        
        /**---------------------query device desired history------------------------*/
        System.out.println("\n======query device desired history======");
        QueryDeviceDesiredHistoryInDTO qddesiredhInDTO = new QueryDeviceDesiredHistoryInDTO();
        qddesiredhInDTO.setDeviceId(deviceId);
        qddesiredhInDTO.setGatewayId(deviceId);//for directly-connected device, the gatewayId is its own deviceId
        QueryDeviceDesiredHistoryOutDTO qddesiredhOutDTO = dataCollection.queryDeviceDesiredHistory(qddesiredhInDTO, accessToken);
        if (qddesiredhOutDTO != null) {
        	System.out.println(qddesiredhOutDTO.toString());        	
		}
        
        /**---------------------query device desired capabilities------------------------*/
        System.out.println("\n======query device desired capabilities======");
        QueryDeviceCapabilitiesInDTO qdcInDTO = new QueryDeviceCapabilitiesInDTO();
        qdcInDTO.setDeviceId(deviceId);
        QueryDeviceCapabilitiesOutDTO qdcOutDTO = dataCollection.queryDeviceCapabilities(qdcInDTO, accessToken); 
        if (qdcOutDTO != null) {
        	System.out.println(qdcOutDTO.toString());        	
		}
    }
    
}
