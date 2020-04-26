/**
 * 
 */
package com.cdkglobal.customer.impl;

import java.text.DecimalFormat;

import com.cdkglobal.customer.Customer;
import com.cdkglobal.exception.EcommerceException;

/**
 * @author Saurav Sharma
 *
 */
public class RegularCustomerImpl implements Customer{

	
	private static final double[] max = { 0, 5000, 10000, Double.MAX_VALUE };
	private static final double[] rate = { 0, 0.10, 0.20};

	public Double calculateDiscountedBill(Double billAmount) throws EcommerceException {
		try {
			Double totalBill = billAmount;
			
			double left = totalBill;
			double discount = 0.0d;
			for (int i = 1; i < max.length && left > 0; i++) {
				double df = Math.min(max[i] - max[i - 1], left);
				discount += rate[i-1] * df;
				left -= df;
			}

			DecimalFormat formatter = new DecimalFormat("###,###,###.00");
			System.out.println("Your total bill is $" + formatter.format(totalBill) + ", your applied discount is: $"
					+ formatter.format(discount) + ". \nYour final bill as regular customer after discount is: $"
					+ formatter.format(totalBill - discount));
			Double finalBill = totalBill - discount;
			return finalBill;
		} catch (Exception e) {
			e.printStackTrace();
			throw new EcommerceException("TicketAPIException", e.getCause());
		}
	}

}
