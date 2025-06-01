package com.e_commerce.Inventory.Management.system.Service;


import com.e_commerce.Inventory.Management.system.Dto.CustomerDto;
import com.e_commerce.Inventory.Management.system.Entity.Category;
import com.e_commerce.Inventory.Management.system.Entity.Customer;
import com.e_commerce.Inventory.Management.system.Repository.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@Service
public class CustomerService {

    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private CustomerRepository customuerRepository;
    @Autowired
    private CustomerRepository customerRepository;

    public Customer createCustomer(CustomerDto customerDto){
        Customer customer= modelMapper.map(customerDto, Customer.class);
        customer.setId(null);
        return customuerRepository.save(customer);

    }
    public Customer updateCustomer(CustomerDto customerDto,Long id){
        Customer existingCustomer= customerRepository.findById(id).orElseThrow(()
                -> new EntityNotFoundException(" Customer not found"));
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        this.modelMapper.map(customerDto, existingCustomer );
        return customerRepository.save(existingCustomer);
    }


    public Customer getCustomerById(Long id){
        return customerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(" Customer not found"));
    }

    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    public void delete(Long id){
        customerRepository.deleteById(id);
    }

}
