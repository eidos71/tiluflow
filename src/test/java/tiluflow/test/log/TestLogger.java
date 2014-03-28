package tiluflow.test.log;

import java.util.List;



import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tiluflow.domain.Account;




@ContextConfiguration("classpath:account-data.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestLogger {

	  @Autowired
	  private org.tiluflow.dao.AccountDaoService accountDaoService;
	
	static final Logger LOG = LoggerFactory.getLogger(TestLogger.class);
	@Test
	public void testElement() {
		LOG.trace("Hello World!");
		LOG.debug("How are you today?");
		LOG.info("I am fine.");
		LOG.warn("I love programming.");
		LOG.error("I am programming.");
	}
	@Test
	public void testCriteriaCheck() {
	
			List<org.tiluflow.domain.Account> result = accountDaoService.getAll(true);
			LOG.info("result {}", result.size() );
			Assert.assertEquals("Expected result 4",6, result.size() );
	}
	@Test
	public void testUpdatecheck(){
		Account entity = new Account();
//		entity.setAddresses(null);
//		entity.setEmail("ernest@test.test");
//		accountDaoService.save(entity);
	}
}
