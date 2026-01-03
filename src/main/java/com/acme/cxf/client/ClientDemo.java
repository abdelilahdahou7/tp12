package com.acme.cxf.client;

import com.acme.cxf.api.HelloService;
import javax.xml.namespace.QName;
import jakarta.xml.ws.Service;
import java.net.URL;
import java.net.MalformedURLException;

public class ClientDemo {
    public static void main(String[] args) {
        try {
            URL wsdl = new URL("http://localhost:8080/services/hello?wsdl");
            QName qname = new QName("http://api.cxf.acme.com/", "HelloService");
            Service svc = Service.create(wsdl, qname);
            HelloService port = svc.getPort(HelloService.class);

            System.out.println(port.sayHello("ClientJava"));
            System.out.println("Person found: " + port.findPersonById("P-777").getName());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
