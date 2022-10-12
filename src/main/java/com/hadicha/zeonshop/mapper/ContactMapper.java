package com.hadicha.zeonshop.mapper;

import com.hadicha.zeonshop.dto.ContactRequest;
import com.hadicha.zeonshop.dto.ContactResponse;
import com.hadicha.zeonshop.entity.Contact;
import org.springframework.stereotype.Component;

@Component
public class ContactMapper extends AbstractMapper<Contact, ContactResponse> {
    public ContactMapper() {
        super(Contact.class, ContactResponse.class);
    }

    public Contact save(ContactRequest request) {
        Contact contact = new Contact();
        contact.setEmail(request.getEmail());
        contact.setPhoneNumber(request.getPhoneNumber());
        contact.setSecondPhoneNumber(request.getSecondPhoneNumber());
        return contact;
    }
}
