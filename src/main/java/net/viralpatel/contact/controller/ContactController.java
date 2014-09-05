package net.viralpatel.contact.controller;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import net.viralpatel.contact.form.Address;
import net.viralpatel.contact.form.User;
import net.viralpatel.contact.form.UserAddress;
import net.viralpatel.contact.service.ContactService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
public class ContactController {
	private static final Logger log=LoggerFactory.getLogger(ContactController.class);
 
    @Autowired
    private ContactService contactService;
 
    @Autowired
    @Qualifier("userValidator")
    private Validator validator;
    @InitBinder
    private void initBinder(WebDataBinder binder){
    	binder.setValidator(validator);
    }
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
    @Valid UserAddress contact, BindingResult result,Model model,Map<String, Object> map) {
    	if(result.hasErrors()){
    		log.info("<----------------Has Some errors--------->");
    		return "contact";
    	}
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
 
        return "contactSuccess";
 
    }
 
    @RequestMapping("/delete/{contactId}")
    public String deleteContact(@PathVariable("contactId")
    Integer contactId) {
 
        contactService.removeContact(contactId);
 
        return "redirect:/index";
    }
}