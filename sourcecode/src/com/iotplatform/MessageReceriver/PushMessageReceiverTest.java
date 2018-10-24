package com.iotplatform.MessageReceriver;

import org.springframework.boot.SpringApplication;

import com.iotplatform.client.dto.NotifyBindDeviceDTO;
import com.iotplatform.client.dto.NotifyCommandRspDTO;
import com.iotplatform.client.dto.NotifyDeviceAddedDTO;
import com.iotplatform.client.dto.NotifyDeviceDataChangedDTO;
import com.iotplatform.client.dto.NotifyDeviceDatasChangedDTO;
import com.iotplatform.client.dto.NotifyDeviceDeletedDTO;
import com.iotplatform.client.dto.NotifyDeviceDesiredStatusChangedDTO;
import com.iotplatform.client.dto.NotifyDeviceEventDTO;
import com.iotplatform.client.dto.NotifyDeviceInfoChangedDTO;
import com.iotplatform.client.dto.NotifyDeviceModelAddedDTO;
import com.iotplatform.client.dto.NotifyDeviceModelDeletedDTO;
import com.iotplatform.client.dto.NotifyFwUpgradeResultDTO;
import com.iotplatform.client.dto.NotifyFwUpgradeStateChangedDTO;
import com.iotplatform.client.dto.NotifyMessageConfirmDTO;
import com.iotplatform.client.dto.NotifyNBCommandStatusChangedDTO;
import com.iotplatform.client.dto.NotifyRuleEventDTO;
import com.iotplatform.client.dto.NotifyServiceInfoChangedDTO;
import com.iotplatform.client.dto.NotifySwUpgradeResultDTO;
import com.iotplatform.client.dto.NotifySwUpgradeStateChangedDTO;
import com.iotplatform.client.invokeapi.PushMessageReceiver;

public class PushMessageReceiverTest extends PushMessageReceiver{
	
	public static void main(String[] args) throws Exception {
		//api-client-demo uses SpringApplication to run this class
		SpringApplication.run(PushMessageReceiverTest.class);
	}
	
//	@Override
//	public void handleBody(String body) {
//		System.out.println("handleBody ==> " + body);
//	}
	
	//override the callback functions if needed, otherwise, you can delete them.
	@Override
	public void handleDeviceAdded(NotifyDeviceAddedDTO body) {
		System.out.println("deviceAdded ==> " + body);
		//TODO deal with deviceAdded notification
	}

	@Override
	public void handleBindDevice(NotifyBindDeviceDTO body) {
		System.out.println("bindDevice ==> " + body);
		//TODO deal with BindDevice notification
	}

	@Override
	public void handleDeviceInfoChanged(NotifyDeviceInfoChangedDTO body) {
		System.out.println("deviceInfoChanged ==> " + body);
		//TODO deal with DeviceInfoChanged notification
	}

	@Override
	public void handleDeviceDataChanged(NotifyDeviceDataChangedDTO body) {
		System.out.println("deviceDataChanged ==> " + body);		
	}

	@Override
	public void handleDeviceDatasChanged(NotifyDeviceDatasChangedDTO body) {
		System.out.println("deviceDatasChanged ==> " + body);
	}

	@Override
	public void handleServiceInfoChanged(NotifyServiceInfoChangedDTO body) {
		System.out.println("serviceInfoChanged ==> " + body);
	}

	@Override
	public void handleDeviceDeleted(NotifyDeviceDeletedDTO body) {
		System.out.println("deviceDeleted ==> " + body);
	}

	@Override
	public void handleMessageConfirm(NotifyMessageConfirmDTO body) {
		System.out.println("messageConfirm ==> " + body);
	}

	@Override
	public void handleCommandRsp(NotifyCommandRspDTO body) {
		System.out.println("commandRsp ==> " + body);
	}

	@Override
	public void handleDeviceEvent(NotifyDeviceEventDTO body) {
		System.out.println("deviceEvent ==> " + body);
	}

	@Override
	public void handleDeviceModelAdded(NotifyDeviceModelAddedDTO body) {
		System.out.println("deviceModelAdded ==> " + body);
	}

	@Override
	public void handleDeviceModelDeleted(NotifyDeviceModelDeletedDTO body) {
		System.out.println("deviceModelDeleted ==> " + body);
	}

	@Override
	public void handleRuleEvent(NotifyRuleEventDTO body) {
		System.out.println("ruleEvent ==> " + body);
	}

	@Override
	public void handleDeviceDesiredStatusChanged(NotifyDeviceDesiredStatusChangedDTO body) {
		System.out.println("deviceDesiredStatusChanged ==> " + body);
	}

	@Override
	public void handleSwUpgradeStateChanged(NotifySwUpgradeStateChangedDTO body) {
		System.out.println("swUpgradeStateChanged ==> " + body);
	}

	@Override
	public void handleSwUpgradeResult(NotifySwUpgradeResultDTO body) {
		System.out.println("swUpgradeResult ==> " + body);
	}

	@Override
	public void handleFwUpgradeStateChanged(NotifyFwUpgradeStateChangedDTO body) {
		System.out.println("fwUpgradeStateChanged ==> " + body);
	}

	@Override
	public void handleFwUpgradeResult(NotifyFwUpgradeResultDTO body) {
		System.out.println("fwUpgradeResult ==> " + body);
	}

	@Override
	public void handleNBCommandStateChanged(NotifyNBCommandStatusChangedDTO body) {
		System.out.println("NBCommandStateChanged ==> " + body);
	}
	
}
