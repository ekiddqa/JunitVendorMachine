package vendormachine;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import vendormachine.users.Person;
import vendormachine.users.util.Wallet;
import vendormachine.vendors.DrinkVendingMachine;

public class DrinkVendingMachineIntegrationTest {

	Wallet wallet = new Wallet();
	
	
	@InjectMocks
	Person person = new Person("Bob");
	
	DrinkVendingMachine drinkMachine = new DrinkVendingMachine();
	
	@Test
	void testCreateBRANDS() {
		
	}
	
	@Test
	void testGiveCredit() {
		when(wallet.getAllCredit()).thenReturn(20f);
		
		this.mvc.perform(drinkMachine.giveCredit(person, 10f)).andExcept();
	}

}
