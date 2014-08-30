package net.viralpatel.contact.dao;
 
import java.util.List;

import net.viralpatel.contact.form.User;
 
public interface ContactDAO {
     
    public void addContact(User contact);
    public List<User> listContact();
    public void removeContact(Integer id);
}