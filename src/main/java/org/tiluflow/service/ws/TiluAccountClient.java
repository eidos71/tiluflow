package org.tiluflow.service.ws;

import tilufwlow.webservices.Account;

public interface TiluAccountClient {

	public abstract Account getProductNameByid(String productId);

}