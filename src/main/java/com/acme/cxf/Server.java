package com.acme.cxf;

import com.acme.cxf.impl.HelloServiceImpl;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

public class Server {
    public static void main(String[] args) {
        String address = "http://localhost:8080/services/hello";
        JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
        factory.setServiceClass(HelloServiceImpl.class);
        factory.setAddress(address);
        factory.create();
        System.out.println("Server started!");
        System.out.println("WSDL available at: " + address + "?wsdl");

        // Bloquer pour garder le serveur actif (sinon le main s'arrête)
        // Note: CXF Server démarre un thread Jetty, mais il vaut mieux prévenir la fin
        // du main si nécessaire.
        // Ici, Jetty devrait garder la JVM active via ses threads non-démons.
        try {
            Thread.sleep(Long.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
