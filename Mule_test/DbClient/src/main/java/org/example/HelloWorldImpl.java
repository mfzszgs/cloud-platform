package org.example;
 
import javax.jws.WebService;
 
@WebService(endpointInterface = "org.example.HelloWorld",
            serviceName = "HelloWorld")
public class HelloWorldImpl implements HelloWorld {
 
    public String sayHi(String text) {
        return "Hello " + text;
    }
}