package com.er5bus.ws.soap.white.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.er5bus.ws.soap.consume.WhiteTestsClasses.StudentRequest;
import com.er5bus.ws.soap.consume.WhiteTestsClasses.WhiteTestResponse;

@Service
public class SoapClient {
	@Autowired
	private Jaxb2Marshaller marshaller;
	
	private WebServiceTemplate template;
	
	public WhiteTestResponse registerWhiteTest(StudentRequest request) {
		template = new WebServiceTemplate(marshaller);
		WhiteTestResponse response = (WhiteTestResponse) template.marshalSendAndReceive("http://localhost:8080/ws", request);
		return response;
	}

}
