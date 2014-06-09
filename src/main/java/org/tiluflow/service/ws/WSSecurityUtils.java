package org.tiluflow.service.ws;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;


import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeaderElement;



public class WSSecurityUtils {

	private static final SimpleDateFormat df = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

	static {
		df.setTimeZone(TimeZone.getTimeZone("UTC"));
	}

	public static SOAPElement createWSSecurityHeader(String pUsername,
			String pCredential, boolean pIsWSPolicyCompliant , SOAPHeaderElement soapHeader)
			throws SOAPException {
		   SOAPElement elWsSecurity =
				   soapHeader.addChildElement("Security", "wsse", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd");

		elWsSecurity.setPrefix("wsse");

		SOAPElement timestampToken = elWsSecurity
				.addChildElement(
						"Timestamp",
						"wsu",
						"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd");

		Calendar createdTime = Calendar.getInstance();

		long currentTime = createdTime.getTimeInMillis();
		currentTime += 1200 * 1000; // 20 minutos

		Calendar expiresTime = Calendar.getInstance();
		expiresTime.setTimeInMillis(currentTime);

		SOAPElement created = timestampToken.addChildElement("Created");
		created.addTextNode(df.format(createdTime.getTime()));

		SOAPElement expires = timestampToken.addChildElement("Expires");
		expires.addTextNode(df.format(expiresTime.getTime()));

		SOAPElement seToken = elWsSecurity.addChildElement("UsernameToken");

		SOAPElement seTokenUser = seToken.addChildElement("Username");
		seTokenUser.addTextNode(pUsername);

		if (pCredential != null) {
			SOAPElement seTokenPassword = seToken.addChildElement("Password");

			seTokenPassword
					.setAttribute(
							"Type",
							"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText");

			seTokenPassword.addTextNode(pCredential);
		}

		return elWsSecurity;
	}

}