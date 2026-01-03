# Exemples de Requêtes SOAP (TP 12)

Voici des exemples de corps de requêtes (XML) à utiliser dans SoapUI ou Postman pour tester votre service.

**URL du service** : `http://localhost:8080/services/hello`
**Méthode** : `POST`
**Header** : `Content-Type: text/xml`

## 1. Opération : SayHello

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:api="http://api.cxf.acme.com/">
   <soapenv:Header/>
   <soapenv:Body>
      <api:SayHello>
         <!-- Modifiez le nom ci-dessous -->
         <name>Etudiant CXF</name>
      </api:SayHello>
   </soapenv:Body>
</soapenv:Envelope>
```

## 2. Opération : FindPerson

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:api="http://api.cxf.acme.com/">
   <soapenv:Header/>
   <soapenv:Body>
      <api:FindPerson>
         <!-- Modifiez l'ID ci-dessous -->
         <id>P-777</id>
      </api:FindPerson>
   </soapenv:Body>
</soapenv:Envelope>
```

## 3. Exemple avec Authentification (Pour l'étape Sécurité)

Si vous testez le serveur sécurisé (`SecureServer` sur `http://localhost:8080/services/hello-secure`), ajoutez l'entête WS-Security :

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:api="http://api.cxf.acme.com/">
   <soapenv:Header>
      <wsse:Security soapenv:mustUnderstand="1" xmlns:wsse="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd" xmlns:wsu="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd">
         <wsse:UsernameToken wsu:Id="UsernameToken-1">
            <wsse:Username>student</wsse:Username>
            <wsse:Password Type="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText">secret123</wsse:Password>
         </wsse:UsernameToken>
      </wsse:Security>
   </soapenv:Header>
   <soapenv:Body>
      <api:SayHello>
         <name>Admin Secure</name>
      </api:SayHello>
   </soapenv:Body>
</soapenv:Envelope>
```
