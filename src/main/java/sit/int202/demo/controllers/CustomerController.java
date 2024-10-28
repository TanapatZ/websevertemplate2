package sit.int202.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sit.int202.demo.entities.Customer;
import sit.int202.demo.services.CustomerService;

import java.util.List;

@Controller

@RequestMapping("/customers")
public class CustomerController {

    private CustomerService service;
    public CustomerController(CustomerService service){
        this.service = service;
    }
    @GetMapping("/all")
    public String getAllCustomer(ModelMap model){
        List<Customer> customer = service.getAllCustomer();
        model.addAttribute("customer",customer);
        return "customer_home";
    }
 

}






















//
//@Controller
//@RequestMapping("/customer")
//public class CustomerController {
//    private CustomerService customerService;
//    public CustomerController(CustomerService customerService){
//        this.customerService = customerService;
//    }
//    @GetMapping("/all")
//    public String getAllCustomers(ModelMap modelMap){
//        List<Customer> customer= customerService.getAllCustomer();
//        modelMap.addAttribute("cust",customer);
//        return "customer_home";
//    }
//    @GetMapping("")
//    public String getCustomerById(@RequestParam Integer custId,ModelMap modelMap){
//        Customer customer = customerService.getCustomerByCode(custId);
//        modelMap.addAttribute("cust",customer);
//        return  "customer_detail";
//    }
//    @GetMapping("/delete-customer")
//    public String deleteCustomer(@RequestParam int custId,ModelMap modelMap){
//        boolean iscustomergone = customerService.deleteCustomer(custId);
//        modelMap.addAttribute("cust",iscustomergone);
//        return  "customer_detail";
//
//    }
//    @PostMapping("/create-office")
//    public String createCustomer(HttpServletRequest request,ModelMap modelMap){
//        Customer customer = new Customer();
//        customer.setId(Integer.valueOf(request.getParameter("customerId")));
//        customer.setCustomername((request.getParameter("customerName")));
//        customer.setCountry((request.getParameter("country")));
//        customer.setContactfirstname((request.getParameter("contractFirstName")));
//        customer.setContactlastname((request.getParameter("contractLastName")));
//        customer.setCity((request.getParameter("city")));
//        customer.setAddressline1((request.getParameter("addressLine")));
//        customer.setPhone((request.getParameter("phone")));
//        Customer newcust = customerService.createCustomer(customer);
//        modelMap.addAttribute("cust",newcust);
//return "offices_detail";
//    }
//    @PostMapping("/update-office")
//    public String updateCustomer(HttpServletRequest request,ModelMap modelMap){
//        Customer customer = new Customer();
//        customer.setId(Integer.valueOf(request.getParameter("customerId")));
//        customer.setCustomername((request.getParameter("customerName")));
//        customer.setCountry((request.getParameter("country")));
//        customer.setContactfirstname((request.getParameter("contractFirstName")));
//        customer.setContactlastname((request.getParameter("contractLastName")));
//        customer.setCity((request.getParameter("city")));
//        customer.setAddressline1((request.getParameter("addressLine")));
//        customer.setPhone((request.getParameter("phone")));
//        Customer newcust = customerService.updateCustomer(customer);
//        modelMap.addAttribute("cust",newcust);
//        return "offices_detail";
//    }
//    @GetMapping("/office-form")
//
//    @GetMapping("/update-form")
//
//}


