package com.cdkglobal;

import com.cdkglobal.controller.EcommerceController;
import com.cdkglobal.customer.Customer;
import com.cdkglobal.customer.impl.PremiumCustomerImpl;
import com.cdkglobal.customer.impl.RegularCustomerImpl;
import com.cdkglobal.exception.EcommerceException;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for EcommerceAPI.
 */
public class EcommerceAPITest extends TestCase {

	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public EcommerceAPITest(String testName) {
		super(testName);
	}

	// This is a positive test for regular customer
	public void testCalcDiscountedPriceForRegularCust() throws EcommerceException {
		System.out.println("Running positive getFinalDiscountedPrice() for Regular Customer..");
		Double finalPrice = EcommerceController.getFinalDiscountedPrice("regular", 15000.00);
		assertEquals(finalPrice, 13500.00);
	}

	// This is an another positive test for regular customer
	public void testCalcDiscountedPriceForRegularCust1() throws EcommerceException {
		System.out.println("Running positive getFinalDiscountedPrice() for Regular Customer..");
		Double finalPrice = EcommerceController.getFinalDiscountedPrice("regular", 5000.00);
		assertEquals(finalPrice, 5000.00);
	}

	// This is a positive test for premium customer
	public void testCalcDiscountedPriceForPremiumCust() throws EcommerceException {
		System.out.println("Running positive getFinalDiscountedPrice() for Premium Customer..");
		Double finalPrice = EcommerceController.getFinalDiscountedPrice("premium", 20000.00);
		assertEquals(finalPrice, 15800.00);
	}

	// This is an another positive test for premium customer
	public void testCalcDiscountedPriceForPremiumCust1() throws EcommerceException {
		System.out.println("Running positive getFinalDiscountedPrice() for Premium Customer..");
		Double finalPrice = EcommerceController.getFinalDiscountedPrice("premium", 8000.00);
		assertEquals(finalPrice, 7000.00);
	}
	
	// This is an another positive test for premium customer with negative amount
		public void testCalcDiscountedPriceForPremiumCust2() throws EcommerceException {
			System.out.println("Running positive getFinalDiscountedPrice() for Premium Customer..");
			Double finalPrice = EcommerceController.getFinalDiscountedPrice("premium", -8000.00);
			assertEquals(finalPrice, -8000.00);
		}

	// This is a negative test using illicit customer type
	public void testCalculatePriceNegative() {
		try {
			System.out.println("Running negative getFinalDiscountedPrice()..");
			Double finalPrice = EcommerceController.getFinalDiscountedPrice("Unexpected-Cust-Type", -8000.00);
			assertEquals(finalPrice, 13500.00);
		} catch (Exception e) {
			e.printStackTrace();
			assertEquals(e.getMessage(), "Invalid Customer Type");
		}
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(EcommerceAPITest.class);
	}

	/**
	 * Rigourous Test
	 */
	public void testApp() {
		assertTrue(true);
	}
}
