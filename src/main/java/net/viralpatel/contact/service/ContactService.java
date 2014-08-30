package net.viralpatel.contact.service;
 
import java.util.List;

import net.viralpatel.contact.form.User;
 
public interface ContactService {
     
    public void addContact(User contact);
    public List<User> listContact();
    public void removeContact(Integer id);
}