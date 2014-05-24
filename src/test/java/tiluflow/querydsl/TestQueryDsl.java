package tiluflow.querydsl;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tiluflow.domain.Account;
import org.tiluflow.domain.Hotel;
import org.tiluflow.service.RepositoryAccountService;
import org.tiluflow.service.RepositoryHotelService;
import org.tiluflow.service.RepositoryUserService;

import tiluflow.guava.GuavaMapsTest;
@ContextConfiguration("classpath:account-data.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestQueryDsl {
	@Autowired
	private RepositoryAccountService repositoryAccountService;
	@Autowired
	private RepositoryUserService repositoryUserService;
	@Autowired
	private  RepositoryHotelService  repositoryHotelService;



	private Set<Hotel> hotels;
	private Set<Account> accounts;


	static final Logger LOG = LoggerFactory.getLogger(GuavaMapsTest.class);

	@Before
	public void setup() {
		accounts = new HashSet<Account>(repositoryAccountService.findAll());
		hotels = new HashSet<Hotel>(repositoryHotelService.findAll());
	}
}
