package com.karan.cms.service;

import com.karan.cms.dao.CustomerDao;
import com.karan.cms.exemption.CustomerNotFoundExemption;
import com.karan.cms.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    private int customerIdCount = 1;

    private List<Customer> customerList = new CopyOnWriteArrayList<>();

    public Customer addCustomer(Customer customer){

          return customerDao.save(customer);
    }

    public List<Customer> getCustomers(){

       return customerDao.findAll();

    }

    public Customer getCustomer(int customerId){
        Optional<Customer> optionalCustomer = customerDao.findById(customerId);
        if (!optionalCustomer.isPresent())
            throw new CustomerNotFoundExemption("Customer Data not Available");
        return optionalCustomer.get();
    }
    public Customer updateCustomer(int customerId, Customer customer){

        customer.setCustomerId(customerId);

        return customerDao.save(customer);
    }
    public void deleteCustomer(int customerId) {

        customerDao.deleteById(customerId);
    }

}
