package org.tiluflow.service.ws.handler;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;
import java.util.TimeZone;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class UserPassInjectHandler implements SOAPHandler<SOAPMessageContext> {

	private static final SimpleDateFormat df = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

	static {
		df.setTimeZone(TimeZone.getTimeZone("UTC"));
	}
	@Override
	public boolean handleMessage(SOAPMessageContext context) {
	
		Boolean isRequest = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		if(isRequest){
			SOAPMessage soapMsg = context.getMessage();
            SOAPEnvelope soapEnv;
            SOAPHeader soapHeader;
			try {
				soapEnv = soapMsg.getSOAPPart().getEnvelope();
				   soapHeader = soapEnv.getHeader();
				   if (soapHeader == null){
		            	soapHeader = soapEnv.addHeader();
		            }
				//   QName qname = new QName("http://ws.mkyong.com/", "macAddress");
				  // SOAPHeaderElement soapHeaderElement = soapHeader.addHeaderElement(qname);				   
				   //soapHeaderElement.setActor(SOAPConstants.URI_SOAP_ACTOR_NEXT);
				 
		           // soapHeaderElement.addTextNode(mac);
				   SOAPElement security =
						   soapHeader.addChildElement("Security", "wsse", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd");

		            SOAPElement usernameToken =
		                    security.addChildElement("UsernameToken", "wsse");
		            usernameToken.addAttribute(new QName("xmlns:wsu"), "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd");

		            SOAPElement username =
		                    usernameToken.addChildElement("Username", "wsse");
		            username.addTextNode("admin");

		            SOAPElement password =
		                    usernameToken.addChildElement("Password", "wsse");
		            password.setAttribute("Type", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText");
		           password.addTextNode("secret");
		           
		   		SOAPElement timestampToken = security
						.addChildElement(
								"Timestamp",
								"wsu",
								"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd");
		   		Calendar createdTime = Calendar.getInstance();

				long currentTime = createdTime.getTimeInMillis();
				currentTime += 1200 * 1000; 

				Calendar expiresTime = Calendar.getInstance();
				expiresTime.setTimeInMillis(currentTime);

				SOAPElement created = timestampToken.addChildElement("Created");
				created.addTextNode(df.format(createdTime.getTime()));

				SOAPElement expires = timestampToken.addChildElement("Expires");
				expires.addTextNode(df.format(expiresTime.getTime()));    
				
		           soapMsg.writeTo(System.out);
		            soapMsg.saveChanges();
			} catch (SOAPException e) {
				// TODO Auto-generated catch block
				e.printStackTrace(); 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
          
				
		
		}
		return isRequest;
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void close(MessageContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<QName> getHeaders() {
		  final QName securityHeader = new QName(
		            "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd",
		            "Security", "wsse");

		    final HashSet headers = new HashSet();
		    headers.add(securityHeader);

		    return headers;
		}


}
