package com.hamsoft.soapclientdemo;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

/**
 * Created By kabiruahmed on Sep 2019
 */

public class SOAPConnector  extends WebServiceGatewaySupport {

    public Object callWebService(String url, Object request){
        return getWebServiceTemplate().marshalSendAndReceive(url, request);
    }


}
