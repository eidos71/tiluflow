package tiluflow.guava;

import java.nio.charset.Charset;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tiluflow.domain.Account;
import org.tiluflow.service.AccountService;
import org.tiluflow.service.HotelService;
import org.tiluflow.service.RepositoryAccountService;
import org.tiluflow.service.RepositoryHotelService;
import org.tiluflow.service.RepositoryCustomerService;
import org.tiluflow.service.CustomerService;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnel;
import com.google.common.hash.PrimitiveSink;

@ContextConfiguration("classpath:account-data.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class GuavaCollectionsTest {
	@Autowired
	private AccountService repositoryAccountService;
	@Autowired
	private CustomerService repositoryUserService;
	@Autowired
	private  HotelService  repositoryHotelService;
	
	  private Set<Account> accounts;
	  
	

	static final Logger LOG = LoggerFactory.getLogger(GuavaCollectionsTest.class);
	
	private static Set<String> buildSetStrings(){
		final  Set<String> setStrings= new HashSet<String>();
		setStrings.add("Java");  
		setStrings.add("Groovy");  
		setStrings.add("Jython");  
		setStrings.add("JRuby");  
		setStrings.add("Python");  
		setStrings.add("Ruby");  
		setStrings.add("Perl");  
		setStrings.add("C");  
		setStrings.add("C++");  
		setStrings.add("C#");  
		setStrings.add("Pascal");  
		setStrings.add("Fortran");  
		setStrings.add("Cobol");  
		setStrings.add("Scala");  
		setStrings.add("Clojure");  
		setStrings.add("Basic");  
		setStrings.add("PHP");  
		setStrings.add("Flex/ActionScript");  
		setStrings.add("JOVIAL");
		return setStrings;  
	}
	@Before
	public void setup(){
		 accounts =new HashSet<Account>(repositoryAccountService.findAll() );
	}
	@Test
	public void demostrateFilter(){
		final Set<String> strings = buildSetStrings();  
		 final Collection<String> filteredStrings =  
	              Collections2.filter(strings, Predicates.containsPattern("^J"));  
		 LOG.debug("{}",filteredStrings.size() );
		assertThat("Total Lenguages with 4", filteredStrings.size(), equalTo(4));

	}
	@Test
	/**
	 * Aplies a filter to recover all Accounts that are enabled.
	 */
	public void demostratePredicates(){
	
		
		Set<Account> enabled = ImmutableSet.copyOf(Iterables.filter(accounts,
			    new Predicate<Account>() {
			    public boolean apply(Account account) {
			        return account.isEnabled(); 
			    }
			}));
		 LOG.debug("enabled {}",enabled.size() );
		 assertThat("Total Account with ", enabled.size(), equalTo(6));
	}
	/**
	 * 
	 * Find elements.
	 */
	@Test
	public void  findForGuavaValue(){
		String valueToFind="Henry";
		Account element = findAccount(accounts, valueToFind);
		 LOG.debug("element account containing Henry is found {}", element) ;
		assertThat("element found", element.getFirstname() , equalToIgnoringCase(valueToFind)  );
	}
	/**
	 * private method that finds an Account
	 * @param setAccount Set 
	 * @param name Value to find on the name
	 * @return the First Account that matches
	 */
	private Account findAccount(Set<Account> setAccount,  final String name) {
		
		return Iterables.find(setAccount, new Predicate<Account>() {
			@Override
			public boolean apply(Account account) {
				return account.getFirstname().equalsIgnoreCase(name);
			}
		});
	}
	
	@Test
	public void BloomFindSearchTest(){
		BloomFilter<Account> bloomFilter=null;
		Funnel<Account> accountFunnel = new Funnel<Account>() {
			@Override
			public void funnel(Account account, PrimitiveSink intoAccountfunnel) {
				intoAccountfunnel.putString(
						(CharSequence) account.getFirstname() ,
						Charset.defaultCharset());
			}

		};
		// Student Filter for a funnel type Account with expected insertion 10
		BloomFilter<Account> accountBloomFilter = BloomFilter.create(
				accountFunnel, 10, 0.01);
		//We place all the accounts inside the bloomfilter.
		for (Account account: accounts ){
			accountBloomFilter.put(account);
		}
		
		Account testAccount= new Account();
		testAccount.setFirstname("Not Exists" );
		boolean mightContain = accountBloomFilter.mightContain(testAccount);
		LOG.debug("Filter has  found that countains 'Not Exists is' {} ", mightContain );  
			  
	}
	  // Creating a Student Funnel
	 
	/**
	 *  How to apply Transformation
	 */
	@Test
	public void applyTransformation(){
		Set<Integer> keys = ImmutableSet.copyOf(Iterables.transform(accounts,
				new Function<Account, Integer>() {
				@Override
					public Integer apply(Account currentAccount) {
						return currentAccount.getId();
					}
				}));
		for (Integer key: keys){
			LOG.debug("keys-{}",key);
		}
		 assertThat("Total Account with ", keys.size(), equalTo(6));
	}

}
