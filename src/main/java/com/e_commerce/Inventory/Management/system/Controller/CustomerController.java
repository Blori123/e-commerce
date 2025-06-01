package com.e_commerce.Inventory.Management.system.Controller;

import com.e_commerce.Inventory.Management.system.Dto.CustomerDto;
import com.e_commerce.Inventory.Management.system.Entity.Customer;
import com.e_commerce.Inventory.Management.system.Service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/register")
    public Customer createCustomer(@RequestBody CustomerDto customerDto){
        return customerService.createCustomer(customerDto);

    }
    @PatchMapping("/{id}")
    public Customer updateCustomer(@RequestBody CustomerDto customerDto,Long id){
        return customerService.updateCustomer(customerDto,id);
    }
    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id){
        return customerService.getCustomerById(id);
    }
    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomer();
    }
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id){
        customerService.delete(id);
    }

}
