package tiluflow.test.webflow;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.webflow.config.FlowDefinitionResource;
import org.springframework.webflow.config.FlowDefinitionResourceFactory;
import org.springframework.webflow.core.collection.LocalAttributeMap;
import org.springframework.webflow.core.collection.MutableAttributeMap;
import org.springframework.webflow.test.MockExternalContext;
import org.springframework.webflow.test.MockFlowBuilderContext;
import org.springframework.webflow.test.execution.AbstractXmlFlowExecutionTests;
import org.tiluflow.domain.Account;
import org.tiluflow.service.AccountService;

public class TiluFlowExecution extends AbstractXmlFlowExecutionTests {

	@Autowired
	@Qualifier("messageSource")
	private MessageSource messageSource;

	private AccountService accountService;

	@Override
	protected FlowDefinitionResource getResource(
			FlowDefinitionResourceFactory resourceFactory) {
		return resourceFactory
				.createFileResource("src/main/webapp/WEB-INF/flows/home/home-flow.xml");
	}

	@Override
	protected void configureFlowBuilderContext(
			MockFlowBuilderContext builderContext) {
		builderContext.registerBean("accountService", accountService);
	}

	@Before
	protected void setUp() {
		accountService = EasyMock.createMock(AccountService.class);
	}

	@Test
	public void testStartAccountFlow() {
		Account account = createTestAccount();
		EasyMock.expect(accountService.get('1')).andReturn(account);
		EasyMock.replay(accountService);
		MutableAttributeMap input = new LocalAttributeMap();
		input.put("accountId", "25");
		MockExternalContext context = new MockExternalContext();
		context.setCurrentUser("ernest");
		startFlow(input, context);
		assertCurrentStateEquals("home");
	}

	private Account createTestAccount() {
		Account account = new Account();
		account.setId(25);
		account.setFirstname("ernest");
		return account;

	}

}
