package vendormachine.users.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import vendormachine.users.Person;



public class WalletTEST {
	
	Wallet emptyWallet = new Wallet();
	
    @Test
    void testAddCredit(){
    	Wallet wallet = new Wallet(0f);
    	
    	wallet.addCredit(1f);
    	
    	assertEquals(1f, wallet.getAllCredit());
    }
    
    @Test
    void testGetCreditLessThan() {
    	Wallet wallet = new Wallet(0f);
    	
    	assertEquals(0, wallet.getCredit(1f));
    }
    
    @Test
    void testGetCreditSuccess() {
    	Wallet wallet = new Wallet(1f);
    	
    	assertEquals(1f, wallet.getCredit(1f));
    	
    }
    
    @Test
    void testGetCreditSuccessStoredCredit() {
    	Wallet wallet = new Wallet(1f);
    	
    	wallet.getCredit(1f);
    	assertEquals(0f, wallet.getAllCredit());
    }
    
    @Test
    void testWalletConstructorCredit() {
    	Wallet wallet = new Wallet(0f);
    	assertEquals(true, wallet.equals(wallet));
    }
    
    @Test
    void testWalletConstructorCreditBrand() {
    	Wallet wallet = new Wallet("Pepsi", 0f);
    	
    	assertEquals(true, wallet.equals(wallet));
    }
    
    @Test
    void testWalletEmptyConstructor() {
    	assertEquals(true, emptyWallet.equals(emptyWallet));
    }
    
    @Test
    void testWalletStartingBrand() {
    	assertEquals("Generic", emptyWallet.getBrand(null));
    }
    
    @Test
    void testWalletStartingCredit() {
    	assertEquals(0.5f, emptyWallet.getAllCredit());
    }
    
    @Test
    void testSetCredit() {
    	Wallet wallet = new Wallet(0f);
    	
    	wallet.setCredit(5f);
    	
    	assertEquals(5f, wallet.getAllCredit());
    }
    
    @Test
    void testSetBrand() {
    	emptyWallet.setBrand("Volka");
    	
    	assertEquals("Volka", emptyWallet.getBrand(null));
    }
    
    @Test
    void testEqualsNull() {
    	assertEquals(false, emptyWallet.equals(null));
    }
    
    @Test
    void testEqualsClass() {
    	Person person = new Person("Bob");
    	
    	assertEquals(false, emptyWallet.equals(person));
    }
    
    @Test
    void testWalletVsWallet() {
    	Wallet wallet2 = new Wallet("Beep", 0f);
    	
    	assertEquals(false, emptyWallet.equals(wallet2));
    }
    
    @Test
    void testEqualsBrandNull() {
    	Wallet wallet2 = new Wallet(null, 0f);
    	
    	assertEquals(false, emptyWallet.equals(wallet2));
    }
    
    @Test
    void testEqualsDiffCredit() {
    	Wallet wallet2 = new Wallet(5f);
    	
    	assertEquals(false, emptyWallet.equals(wallet2));
    }
}
