package tiluflow.test.log;

import static org.junit.Assert.assertEquals;

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
import org.tiluflow.domain.Customer;
import org.tiluflow.service.AccountService;
import org.tiluflow.service.HotelService;
import org.tiluflow.service.RepositoryAccountService;
import org.tiluflow.service.RepositoryHotelService;
import org.tiluflow.service.RepositoryCustomerService;
import org.tiluflow.service.CustomerService;




@ContextConfiguration("classpath:account-data.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestLogger {

	@Autowired
	private AccountService repositoryAccountService;
	@Autowired
	private CustomerService repositoryUserService;
	@Autowired
	private  HotelService  repositoryHotelService;

	static final Logger LOG = LoggerFactory.getLogger(TestLogger.class);
	@Test
	public void testElement() {
		LOG.trace("trace!");
		LOG.debug("debug");
		LOG.info("info.");
		LOG.warn("warn.");
		LOG.error("error");
		assertEquals(true, true);
	}
	@Test
	public void testCriteriaCheck() {
	
			final List<Account> result =repositoryAccountService.findAll();
			LOG.info("result {}", result.size() );
			Assert.assertEquals("Expected result 6",6, result.size() );
	}
	@Test
	public void testCriteriaHotelUsers(){
		final List<Customer> result= repositoryUserService.findAll();
		LOG.info("result: {}", result.size());
		Assert.assertEquals("Expected result 4",4, result.size() );
	}
	@Test
	public void testCriteriaInsertuser(){

		Customer entity = new Customer("eidos71", "c0rp3t1t1", "Ernest Petit", "Z32342341");
		//userDaoService.save(entity);
		final List<Customer> result = repositoryUserService.findAll();
		LOG.info("result{}", result.size());
		Assert.assertEquals("Expected result 5",5, result.size() );
	}
	@Test
	public void testUpdatecheck(){
		Account entity = new Account();
		entity.setAddresses(null);
		entity.setEmail("ernest@test.test");
		//accountDaoService.save(entity);
		Assert.fail();
	}
}
