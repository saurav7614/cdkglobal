/**
 * 
 */
package com.cdkglobal.customer;

import com.cdkglobal.exception.EcommerceException;

/**
 * @author Saurav Sharma
 *
 */
public interface Customer {
	public abstract Double calculateDiscountedBill(Double billAmount) throws EcommerceException;

}
