package vishu.springframework.services;

import java.util.List;

import vishu.springframework.model.Customer;

public interface CustomerService {
	List<Customer> listAllCustomers();
	Customer getCustomerById(Integer id);
	Customer saveOrUpdateCustomer(Customer customer);
	void deleteCustomer(Integer id);
}
