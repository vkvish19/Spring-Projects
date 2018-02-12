package vishu.springframework.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import vishu.springframework.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	Map<Integer, Customer> customers;
	
	public CustomerServiceImpl(){
		loadAllCustomers();
	}

	@Override
	public List<Customer> listAllCustomers() {
		return new ArrayList<Customer>(customers.values());
	}

	@Override
	public Customer getCustomerById(Integer id) {
		return customers.get(id);
	}

	@Override
	public Customer saveOrUpdateCustomer(Customer customer) {
		if(customer != null){
			if(customer.getId() == null){
				customer.setId(getNextKey());
			}
			customers.put(customer.getId(), customer);
			return customer;
			
		}
		else{
			throw new RuntimeException("No Customer :: It's NULL");
		}
	}

	@Override
	public void deleteCustomer(Integer id) {
		customers.remove(id);
	}
	
	private Integer getNextKey(){
		if(customers.isEmpty()){
			return 1;
		}
		else{
			return Collections.max(customers.keySet()) + 1;
		}
	}

	private void loadAllCustomers() {
		customers = new HashMap<>();
		
		Customer c1 = new Customer();
		c1.setId(1);
		c1.setFirstName("Vishwanath");
		c1.setLastName("Kulkarni");
		c1.setAddressLineOne("Guruprasad Colony");
		c1.setAddressLineTwo("Tilakwadi");
		c1.setCity("Belagavi");
		c1.setState("Karnataka");
		c1.setPincode("590006");
		
		customers.put(c1.getId(), c1);
		
		Customer c2 = new Customer();
		c2.setId(2);
		c2.setFirstName("Nitya");
		c2.setLastName("D");
		c2.setAddressLineOne("B-103");
		c2.setAddressLineTwo("Doddathogur");
		c2.setCity("Bengaluru");
		c2.setState("Karnataka");
		c2.setPincode("560100");
		
		customers.put(c2.getId(), c2);
		
		Customer c3 = new Customer();
		c3.setId(3);
		c3.setFirstName("Jack");
		c3.setLastName("Shukla");
		c3.setAddressLineOne("Puri");
		c3.setAddressLineTwo("Tilakwadi");
		c3.setCity("Patna");
		c3.setState("Bihar");
		c3.setPincode("710006");
		
		customers.put(c3.getId(), c3);
				
	}
}
