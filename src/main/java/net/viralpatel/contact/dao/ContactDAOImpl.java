package net.viralpatel.contact.dao;
 
import java.util.List;

import net.viralpatel.contact.form.Contact;
import net.viralpatel.contact.form.User;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
 
@Repository
public class ContactDAOImpl implements ContactDAO {
 
    @Autowired
    private SessionFactory sessionFactory;
 
    public void addContact(User contact) {
        sessionFactory.getCurrentSession().save(contact);
    }
 
    public List<User> listContact() {
 
        return sessionFactory.getCurrentSession().createQuery("from User u left join fetch u.address ")
                .list();
    }
 
    public void removeContact(Integer id) {
        Contact contact = (Contact) sessionFactory.getCurrentSession().load(
                Contact.class, id);
        if (null != contact) {
            sessionFactory.getCurrentSession().delete(contact);
        }
 
    }
}
