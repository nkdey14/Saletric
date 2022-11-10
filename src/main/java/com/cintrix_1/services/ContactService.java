package com.cintrix_1.services;

import java.util.List;

import com.cintrix_1.entities.Contact;

public interface ContactService {

	public void saveContact(Contact c);

	public List<Contact> findAllContacts();

	public Contact findContactById(int id);

	public Contact findContactByMobile(long mobile);

}
