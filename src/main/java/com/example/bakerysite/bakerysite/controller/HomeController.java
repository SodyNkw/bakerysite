package com.example.bakerysite.bakerysite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.bakerysite.bakerysite.model.Customer;
import com.example.bakerysite.bakerysite.repository.CustomerRepository;
import com.example.bakerysite.bakerysite.service.CustomerService;
import com.example.bakerysite.bakerysite.service.MailSenderService;

import org.apache.commons.lang3.RandomStringUtils;

@Controller
public class HomeController {

    private final CustomerService customerService;
    private final MailSenderService mailSenderService;

    //private final CustomerRepository customerRepository;

    public HomeController(CustomerService customerService, MailSenderService mailSenderService) {
        this.customerService = customerService;
        this.mailSenderService = mailSenderService;
    }

    // public HomeController(CustomerService customerService) {
    //     this.customerService = customerService;
    // }

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
        customerService.addCustomer(customer);
        String orderNum = RandomStringUtils.randomAlphanumeric(16);
        String reciever = customer.getEmailAddress();
        String subject = "Order + " + orderNum + " + Confirmation";
        String body = "Thank you for your order";
        mailSenderService.sendConfirmationEmail(reciever, subject, body);
        return "redirect:/create"; // redirect to avoid template errors
    }

    // @GetMapping("/email")
    // public void sendConfirmationEmail(){
    //     String orderNum = RandomStringUtils.randomAlphanumeric(16);
    //     String reciever = "";
    //     String subject = "Order +" + orderNum + "+Confirmation";
    //     String body = "Thank you for your order";
    //     mailSenderService.sendConfirmationEmail(reciever, subject, body);
    // }

}
