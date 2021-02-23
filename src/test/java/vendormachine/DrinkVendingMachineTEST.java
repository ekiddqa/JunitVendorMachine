package vendormachine;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import vendormachine.users.Person;
import vendormachine.users.util.Wallet;
import vendormachine.vendors.DrinkVendingMachine;
import vendormachine.vendors.enums.BRANDS;

public class DrinkVendingMachineTEST {
	
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
		assertEquals(BRANDS.CaramelSprinkle, drinkMachineStuff.selectDrink(0));
	}
	
	@Test
	void testGiveCredit() {
		Person person = new Person("Bob");
		Wallet wallet = new Wallet(10f);
		person.setWallet(wallet);
		
		drinkMachine.giveCredit(person, 10f);
		
		assertEquals(10f, drinkMachine.getAvailableCredit());
	}
}
