package com.in28minutes.rest.webservices.restfulwebservices;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.Spring;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
@RestController
public class HelloWorldController {

	@GetMapping(path = "/hello-world")
	public String helloWorld() throws UnknownHostException {
		InetAddress IP=InetAddress.getLocalHost();
		System.out.println(IP.toString());
		String response = "IP : " + IP.toString();
		return response;
	}

	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World - Changed - V3");
	}

	
	@GetMapping(path = "/health")
	public HelloWorldBean health() {
		return new HelloWorldBean("health-check success");
	}
	
	
	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World, %s", name));
	}




	@RequestMapping(value = "/greeting", method = RequestMethod.POST , consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String greetingJson(@RequestBody  String raw) {
		System.out.println("recieved below request");
		System.out.println(raw);
		System.out.println();
		System.out.println("done");
		return "OK";
	}

}
