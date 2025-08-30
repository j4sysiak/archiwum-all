package com.in28minutes.rest.webservices.restfulwebservices;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@Value("${envname}")
	private String envname;

	//    http://localhost:8080/hello-world
	//docker prod    http://localhost:8000/hello-world
	//docker test    http://localhost:7000/hello-world
	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Hello World v10 " + envname;
	}

	//    http://localhost:8080/hello-world-bean
	//docker prod    http://localhost:8000/hello-world-bean
	//docker test    http://localhost:7000/hello-world-bean
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		// throw new RuntimeException("Some Error has Happened! Contact Support at
		// ***-***");
		return new HelloWorldBean("Hello World v10");
	}

	//   http://localhost:8080/hello-world/path-variable/in28minutes
	//   http://localhost:8000/hello-world/path-variable/in28minutes
	//   http://localhost:7000/hello-world/path-variable/in28minutes
	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World v10, %s", name));
	}
}
