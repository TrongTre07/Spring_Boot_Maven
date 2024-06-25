package com.springbasic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
//@ComponentScan(basePackages = "com.springbasic")
//@EnableAutoConfiguration
@RestController
@RequestMapping("api/v1/customers")
public class Main {

    private final CustomerRepository customerRepository;

    public Main(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(Main.class, args);

        Dress dress1 = context.getBean(Dress.class);
        Dress dress2 = context.getBean(Dress.class);
        System.out.println("ADDRESS: " + dress1);
        System.out.println("ADDRESS: " + dress2);
    }

    @GetMapping
    public List<Customer> getCustomer() {
        return customerRepository.findAll();
    }


    record NewCustomerRequest(String name, String email, Integer age) {
    }

    @PostMapping
    public void addCustomer(@RequestBody NewCustomerRequest request) {
        Customer customer = new Customer();
        customer.setName(request.name());
        customer.setEmail(request.email());
        customer.setAge(request.age());
        customerRepository.save(customer);
    }

    @DeleteMapping("customerId={customerId}")
    public void deleteCustomer(@PathVariable("customerId") Integer id) {
        customerRepository.deleteById(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> editCustomer(@PathVariable("id") Integer id, @RequestBody NewCustomerRequest request) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if (customerOptional.isPresent()) {
            Customer customer = customerOptional.get();
            customer.setName(request.name());
            customer.setAge(request.age());
            customer.setEmail(request.email());
            customerRepository.save(customer);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
