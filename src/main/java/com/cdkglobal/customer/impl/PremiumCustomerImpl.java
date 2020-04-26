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
public class PremiumCustomerImpl implements Customer {
	
	private static final double[] max = { 0, 4000, 8000, 12000, Double.MAX_VALUE };
	private static final double[] rate = { 0, 0.10, 0.15, 0.20, 0.30 };

	public Double calculateDiscountedBill(Double billAmount) throws EcommerceException {
		try {
			Double totalBill = billAmount;
			
			double left = totalBill;
			double discount = 0.0d;
			for (int i = 1; i < max.length && left > 0; i++) {
				double df = Math.min(max[i] - max[i - 1], left);
				discount += rate[i] * df;
				left -= df;
			}

			DecimalFormat formatter = new DecimalFormat("###,###,###.00");
			System.out.println("Your total bill is $" + formatter.format(totalBill) + ", your applied discount is: $"
					+ formatter.format(discount) + ". \n Your final bill as premium customer after discount is: $"
					+ formatter.format(totalBill - discount));
			Double finalBill = totalBill - discount;
			return finalBill;
		} catch (Exception e) {
			e.printStackTrace();
			throw new EcommerceException("TicketAPIException", e.getCause());
		}
	}

}
