package sit.int202.demo.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import sit.int202.demo.entities.Customer;
import sit.int202.demo.entities.Office;
import sit.int202.demo.repositories.CustomerRepository;
import sit.int202.demo.repositories.OfficeRepository;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository ;
    private Customer getCustomer(Integer custId){
        return customerRepository.findById(custId).orElse(null);
    }
    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();

    }
    public Customer createCustomer(Customer customer){
        Customer isItExsit = getCustomer(customer.getId());
        if(isItExsit != null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,String.format("This customer %d is already exsit",
                    isItExsit.getId()));
        }

        return customerRepository.save(customer);
    }
    public Customer updateCustomer(Customer customer){
        Customer isItExsit = getCustomer(customer.getId());
        if(isItExsit == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("This customer %d is not found",
                    isItExsit.getId()));
        }
        return customerRepository.save(customer);

    }
    //updateOffice
    public boolean deleteCustomer(Integer customer){
        Customer isItExsit = getCustomer(customer);
        if(isItExsit == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("This customer %d is not found",
                    isItExsit.getId()));
        }else{
            customerRepository.delete(isItExsit);
            return true;
        }
    }
    //deleate
    public Customer getCustomerByCode(Integer custId){
        return getCustomer(custId);
    }
    //getOfficeByCode

}
