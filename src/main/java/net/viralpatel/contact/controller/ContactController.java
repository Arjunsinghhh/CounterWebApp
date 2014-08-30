package net.viralpatel.contact.controller;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.viralpatel.contact.form.Address;
import net.viralpatel.contact.form.Contact;
import net.viralpatel.contact.form.User;
import net.viralpatel.contact.form.UserAddress;
import net.viralpatel.contact.service.ContactService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
public class ContactController {
 
    @Autowired
    private ContactService contactService;
 
    @RequestMapping("/index")
    public String listContacts(Map<String, Object> map) {
 
        map.put("userAddress", new UserAddress());
        List<User> users=contactService.listContact();
        List<UserAddress> userAddress=new ArrayList<UserAddress>();
        for(User user:users){
        	List<Address> addr=user.getAddress();
        	UserAddress ua=new UserAddress();
        	ua.setName(user.getName());
        	ua.setPassword(user.getPassword());
        	ua.setConfirm(user.getConfirm());
        	ua.setEmail(user.getEmail());
        	ua.setAddress(addr);
        	userAddress.add(ua);
        }
        map.put("contactList",userAddress );
 
        return "contact";
    }
 
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addContact(@ModelAttribute("userAddress")
    UserAddress contact, BindingResult result) {
    	String name=contact.getName();
    	String password=contact.getPassword();
    	String confirm=contact.getConfirm();
    	String email=contact.getEmail();
    	String street1=contact.getStreet1();
    	String street2=contact.getStreet2();
    	String city=contact.getCity();
    	String state=contact.getState();
    	String country=contact.getCountry();
    	User u=new User();
    	u.setName(name);
    	u.setPassword(password);
    	u.setConfirm(confirm);
    	u.setEmail(email);
    	Address a=new Address();
    	a.setStreet1(street1);
    	a.setStreet2(street2);
    	a.setCity(city);
    	a.setState(state);
    	a.setCountry(country);
    	List<Address> list=new ArrayList<Address>();
    	list.add(a);
    	u.setAddress(list);
 
        contactService.addContact(u);
 
        return "redirect:/index";
    }
 
    @RequestMapping("/delete/{contactId}")
    public String deleteContact(@PathVariable("contactId")
    Integer contactId) {
 
        contactService.removeContact(contactId);
 
        return "redirect:/index";
    }
}