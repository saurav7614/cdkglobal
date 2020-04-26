package com.cdkglobal.customer.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.cdkglobal.customer.Customer;
import com.cdkglobal.customer.impl.PremiumCustomerImpl;
import com.cdkglobal.customer.impl.RegularCustomerImpl;

/**
 * @author Saurav Sharma
 *
 */
public class CustomerFactory {
	
	static Map<String, Customer> customerMap = new HashMap<String, Customer>();
    static {
    	customerMap.put("regular", new RegularCustomerImpl());
    	customerMap.put("premium", new PremiumCustomerImpl());
    }

    public static Optional<Customer> getCustInstance(String customerType) {
        return Optional.ofNullable(customerMap.get(customerType));
    }
}
