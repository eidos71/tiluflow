package org.tiluflow.service.ws;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.tiluflow.service.ws.handler.HeaderHandlerResolver;

import tilufwlow.webservices.Account;
import tilufwlow.webservices.accountservice.AccountDetailsRequest;
import tilufwlow.webservices.accountservice.AccountServices;
@Service
@Qualifier("simpleTiluAccountClient")
public class SimpleTiluAccountClient implements TiluAccountClient {
	  @Resource
	    private AccountServices accountPort;

	    /* (non-Javadoc)
		 * @see org.tiluflow.service.ws.TilluAccountClient#getProductNameByid(java.lang.String)
		 */
	    @Override
		public Account getProductNameByid(String productId) {

	    	AccountDetailsRequest request = new AccountDetailsRequest();
	        request.setAccountNumber(productId);
	       return  accountPort.accountDetails(request).getAccountDetails();
	    }

	    public SimpleTiluAccountClient(){
	    	
	    }
}
