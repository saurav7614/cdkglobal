
package com.cdkglobal.controller;

import com.cdkglobal.customer.Customer;
import com.cdkglobal.customer.factory.CustomerFactory;
import com.cdkglobal.exception.EcommerceException;

/**
 * @author Saurav Sharma
 * This class is responsible to calculate final price of the order
 */
public class EcommerceController {

	public static void main(String[] args) throws EcommerceException {
		getFinalDiscountedPrice("regular", 15000.00);
	}

	public static Double getFinalDiscountedPrice(String custType, Double initialPrice) throws EcommerceException {
		Customer targetCustomer = CustomerFactory.getCustInstance(custType)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Customer Type"));

		Double finalPrice = targetCustomer.calculateDiscountedBill(initialPrice);
		return finalPrice;
	}

}
