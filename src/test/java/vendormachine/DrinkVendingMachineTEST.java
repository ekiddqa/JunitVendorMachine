package vendormachine;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import vendormachine.users.Person;
import vendormachine.users.util.Wallet;
import vendormachine.vendors.DefaultSnacks;
import vendormachine.vendors.DrinkVendingMachine;
import vendormachine.vendors.enums.BRANDS;
import vendormachine.vendors.item.Snack;

@RunWith(MockitoJUnitRunner.class)
public class DrinkVendingMachineTEST {
	
	@Mock
	Wallet wallet = new Wallet();
	
	@Mock
	DefaultSnacks  snackList = new DefaultSnacks();
	
	@InjectMocks
	Person person = new Person("Bob");
	
	/** 
	 * Task 2:
	 * 	Objective:
	 * 		Test the Wallet class from:
	 * 		'vendormachine.vendors.DrinkVendingMachine'
	 * 
	 * 	Goal: 
	 * 		80% code/line coverage
	 * 		TDD: analyse code and add missing methods.
	 * */

	DrinkVendingMachine drinkMachine = new DrinkVendingMachine();
	
	DrinkVendingMachine drinkMachineStuff = new DrinkVendingMachine(20f, BRANDS.CaramelSprinkle);
    
	@BeforeEach
	public void init() {
	    MockitoAnnotations.initMocks(this);
	}
	
	@Test
	void testEmptyConstructureCredit() {
		assertEquals(0, drinkMachine.getAvailableCredit());
	}
	
	@Test
	void testConstructureBrand() {
		assertEquals(BRANDS.CaramelSprinkle, drinkMachineStuff.getBrandName());
	}
	
	@Test
	void testConstructureCredit() {
		assertEquals(20f, drinkMachineStuff.getAvailableCredit());
	}
	
	@Test
	void testSelectDrinkFailureExistHigh() {
		assertEquals(null, drinkMachineStuff.selectDrink(5));
	}
	
	@Test
	void testSelectDrinkFailureExistLow( ) {
		assertEquals(null, drinkMachineStuff.selectDrink(-1));
	}
	
	@Test
	void testSelectDrinkFailureCredit() {
		assertEquals(null, drinkMachine.selectDrink(1));
	}
	
	@Test
	void testSelectDrinkSuccess() {
		when(Arrays.asList(DefaultSnacks.snackList)).thenReturn(
            new Snack("Water",0.20f),
            new Snack("VanillaBurst", 1.75f),
            new Snack("GoblinSpring",0.90f),
            new Snack("Comet Trails", 2.15f));
		
		assertEquals(drinkMachineStuff.getDrinkList().get(0), drinkMachineStuff.selectDrink(0));
	}
	
	@Test
	void testGiveCredit() {
	    when(wallet.getAllCredit()).thenReturn(10f);
	    when(wallet.getCredit(10f)).thenReturn(10f);
	    
		drinkMachine.giveCredit(person, 10f);
		
		assertEquals(10f, drinkMachine.getAvailableCredit());
	}
	
	@Test
	void testGetDrinkList() {
		
	}
}
