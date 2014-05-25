package tiluflow.querydsl;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tiluflow.domain.Account;
import org.tiluflow.domain.Hotel;
import org.tiluflow.dto.HotelDTO;
import org.tiluflow.service.AccountService;
import org.tiluflow.service.HotelService;
import org.tiluflow.service.RepositoryAccountService;
import org.tiluflow.service.RepositoryHotelService;
import org.tiluflow.service.RepositoryUserService;
import org.tiluflow.service.UserService;

import tiluflow.guava.GuavaMapsTest;
@ContextConfiguration("classpath:account-data.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestQueryDsl {
	@Autowired
	private AccountService accountService;
	@Autowired
	private UserService userService;
	@Autowired
	private  HotelService  hotelService;



	private Set<Hotel> hotels;
	private Set<Account> accounts;


	static final Logger LOG = LoggerFactory.getLogger(TestQueryDsl.class);

	@Before
	public void setup() {
		accounts = new HashSet<Account>(accountService.findAll());
		hotels = new HashSet<Hotel>(hotelService.findAll());
	}
	@Test
	public void testSearchHotel(){
		 List<Hotel> searchList = hotelService.search("Hotel");
		 LOG.debug(" size: {}",searchList.size() );
		 assertThat("Total Hotels with the word Hotel with 3", searchList.size() , equalTo(3));
	}
	/**
	 * 
	 */
	@Test public void testCreateHotel(){
		int initialList=hotelService.findAll().size() ;
		testInsert();
		 assertThat("Total Hotels ", hotelService.findAll().size()  , equalTo(initialList +1));
	}
	/**
	 * createst a test Insert.
	 * @return
	 */
	private Hotel testInsert(){
	
			HotelDTO hotel= new HotelDTO();
			hotel.setAddress("address");
			hotel.setCity("city");
			hotel.setCountry("Country");
			hotel.setName("Hotel Casino");
			hotel.setPrice(new BigDecimal(34));
			hotel.setState("state");
			hotel.setZip("zip");
			return hotelService.create(hotel);
	}
}
