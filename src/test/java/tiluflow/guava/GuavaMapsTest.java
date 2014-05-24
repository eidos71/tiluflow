package tiluflow.guava;

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
import org.tiluflow.service.AccountService;
import org.tiluflow.service.HotelService;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;

@ContextConfiguration("classpath:account-data.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class GuavaMapsTest {


	@Autowired
	private AccountService  repositoryUserService;
	@Autowired
	private  HotelService  repositoryHotelService;
	@Autowired
	private AccountService repositoryAccountService;

	private Set<Hotel> hotels;
	private Set<Account> accounts;


	static final Logger LOG = LoggerFactory.getLogger(GuavaMapsTest.class);

	@Before
	public void setup() {
		accounts = new HashSet<Account>(repositoryAccountService.findAll());
		hotels = new HashSet<Hotel>(repositoryHotelService.findAll());
	}
	@Test
	public void multiMapTest(){
		LOG.debug("hotel size {}", hotels.size());
	Multimap<Integer, String> multimap = new ImmutableSetMultimap.Builder<Integer, String>()
				.put(1, "a").put(2, "b").put(3, "c").build();
		
	}

	@Test
	public void transformGuavaExample() {
	
		Function<Integer, String> intToEnglish = new Function<Integer, String>() {
			public String apply(Integer i) {
				return new IntToEnglish().english_number(i);
			}
		};
		List<Integer> intList= Lists.newArrayList(1,2,3,4,5,6,8,3,21);
		List<String> wordsList = Lists.transform(intList, intToEnglish);
		LOG.debug(wordsList.toString() );
	}
	
	static private class IntToEnglish {
		public String english_number(Integer i) {
			return Numeral.findNumber(i).name();
		}
	}

	/**
	 * 
	 */
	private void filteringElements( ){
		
	}

	private enum Numeral{
		NOTFOUND(-1),ONE(1),TWO(2),THREE(3),FOUR(4),FIVE(5),SIX(6),SEVEN(7),EIGHT(8),NINE(9),ZERO(0);
		private Integer number;
		Numeral(Integer  pnumber){
			this.number=pnumber;
		}
		private Integer  getNumber(){
			return number;
		}
		static public Numeral findNumber(int i){
			for (Numeral numeral : Numeral.values()){
				if (numeral.getNumber()==i)  return numeral;
			}
			return NOTFOUND;
		}
	}


}
