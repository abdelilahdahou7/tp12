package com.acme.cxf.impl;

import jakarta.jws.WebService;
import com.acme.cxf.api.HelloService;
import com.acme.cxf.model.Person;

@WebService(serviceName = "HelloService", portName = "HelloServicePort", endpointInterface = "com.acme.cxf.api.HelloService", targetNamespace = "http://api.cxf.acme.com/")
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return "Bonjour, " + (name == null ? "inconnu" : name);
    }

    @Override
    public Person findPersonById(String id) {
        // Simulation d'une recherche
        return new Person(id, "Ada Lovelace", 36);
    }
}
