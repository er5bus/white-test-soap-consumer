package com.er5bus.ws.soap.white.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.er5bus.ws.soap.consume.WhiteTestsClasses.StudentRequest;
import com.er5bus.ws.soap.consume.WhiteTestsClasses.WhiteTestResponse;
import com.er5bus.ws.soap.white.cons.clients.SoapClient;



@RestController
public class TestSoapWS {

	@Autowired
	private SoapClient client;
	
	@GetMapping(path="/test",produces = MediaType.APPLICATION_XML_VALUE)
	public WhiteTestResponse testConsumer() {
		
		StudentRequest request = new StudentRequest();
		request.setExamCode("003k");
		request.setStudentId(5);
		
		return client.registerWhiteTest(request);
	}
}
