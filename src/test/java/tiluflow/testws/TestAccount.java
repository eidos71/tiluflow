package tiluflow.testws;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tiluflow.service.ws.TiluAccountClient;

import tilufwlow.webservices.Account;
import tilufwlow.webservices.EnumAccountStatus;



@ContextConfiguration("classpath:account-data.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestAccount {
	static final Logger LOG = LoggerFactory.getLogger(TestAccount.class);
	@Autowired
	@Qualifier("simpleTiluAccountClient")
	public TiluAccountClient service;
	@Test
	public void testAccount(){
		Account response = service.getProductNameByid("33");
		
		LOG.debug("{}", response.toString() );
		Assert.assertEquals("Expected result ACTIVE", EnumAccountStatus.ACTIVE ,
				response.getAccountStatus()   );
		
		
	}
}
