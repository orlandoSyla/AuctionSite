package com.sda.auctionsite.controllers;

import com.sda.auctionsite.dto.ContactRequest;
import com.sda.auctionsite.entities.Contact;
import com.sda.auctionsite.services.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/contact")
public class ContactController {
    protected final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("")
    public String index(ModelMap modelMap) {
        if (!modelMap.containsKey("contact"))
            modelMap.addAttribute("contact", new Contact());
        return "website/contact-index";
    }

    @PostMapping("/save")
    public RedirectView save(@ModelAttribute ContactRequest contact, RedirectAttributes modelMap) {
        //contactService.save(contact);
        //modelMap.put("result", );
        String saveResult = contactService.save(contact);
        if ("OK".equalsIgnoreCase(saveResult)) {

            modelMap.addFlashAttribute("success", "ok");
            modelMap.addFlashAttribute("message", "Contact saved successfully!");
        }
        else {
            modelMap.addFlashAttribute("success", "ko");
            modelMap.addFlashAttribute("message", saveResult);
            modelMap.addFlashAttribute("contact", contact);
        }

        return new RedirectView("/contact");
    }
}
