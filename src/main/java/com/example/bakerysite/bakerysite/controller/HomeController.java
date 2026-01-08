package com.example.bakerysite.bakerysite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.bakerysite.bakerysite.model.Customer;
import com.example.bakerysite.bakerysite.repository.CustomerRepository;
import com.example.bakerysite.bakerysite.service.CustomerService;

@Controller
public class HomeController {

    private final CustomerRepository customerRepository;

    public HomeController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }

    @GetMapping("/aboutus")
    public String aboutus(){
        return "aboutus";
    }

    @GetMapping("/cart")
    public String cart(){
        return "cart";
    }

    @GetMapping("/create")
    public String showForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customers/create"; // Must exist in templates/customers/create.html
    }

    @PostMapping("/create")
    public String saveCustomer(@ModelAttribute Customer customer) {
        System.out.println("Saving customer: " + customer); // DEBUG
        Customer saved = customerRepository.save(customer);
        System.out.println("Saved customer id: " + saved.getId());// directly save
        System.out.println("Saved with id: " + customer.getId()); // confirm id
        return "redirect:/create"; // redirect to avoid template errors
    }

}
