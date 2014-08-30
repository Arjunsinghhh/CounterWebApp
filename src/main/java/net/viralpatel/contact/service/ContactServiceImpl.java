package net.viralpatel.contact.service;
 
import java.util.List;

import net.viralpatel.contact.dao.ContactDAO;
import net.viralpatel.contact.form.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
@Service
public class ContactServiceImpl implements ContactService {
 
    @Autowired
    private ContactDAO contactDAO;
     
    @Transactional
    public void addContact(User contact) {
        contactDAO.addContact(contact);
    }
 
    @Transactional
    public List<User> listContact() {
 
        return contactDAO.listContact();
    }
 
    @Transactional
    public void removeContact(Integer id) {
        contactDAO.removeContact(id);
    }
}