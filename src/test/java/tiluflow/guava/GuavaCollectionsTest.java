package tiluflow.guava;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
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

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;


@ContextConfiguration("classpath:account-data.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class GuavaCollectionsTest {
	  @Autowired
	  private org.tiluflow.dao.AccountDaoService accountDaoService;
	  @Autowired
	  private org.tiluflow.dao.UserDaoService userDaoService;
	
	  private Set<Account> accounts;
	  
	
	public void setAccountDaoService(
			org.tiluflow.dao.AccountDaoService accountDaoService) {
		this.accountDaoService = accountDaoService;
	}
	static final Logger LOG = LoggerFactory.getLogger(GuavaCollectionsTest.class);
	
	private static Set<String> buildSetStrings(){
		final  Set<String> strings= new HashSet<String>();
	      strings.add("Java");  
	      strings.add("Groovy");  
	      strings.add("Jython");  
	      strings.add("JRuby");  
	      strings.add("Python");  
	      strings.add("Ruby");  
	      strings.add("Perl");  
	      strings.add("C");  
	      strings.add("C++");  
	      strings.add("C#");  
	      strings.add("Pascal");  
	      strings.add("Fortran");  
	      strings.add("Cobol");  
	      strings.add("Scala");  
	      strings.add("Clojure");  
	      strings.add("Basic");  
	      strings.add("PHP");  
	      strings.add("Flex/ActionScript");  
	      strings.add("JOVIAL");
		return strings;  
	}
	@Before
	public void setup(){
		 accounts =new HashSet<Account>(accountDaoService.getAll(true) );
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
	@Test
	/**
	 * 
	 */
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
