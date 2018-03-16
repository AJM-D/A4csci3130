package com.acme.a3csci3130;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

/**
 * Created by AJ on 2018-03-15.
 */

public class CRUD {
    /**
     * @author AJ
     * @Version 1.0
     *
     */

    private CreateContactAcitivity cca;

    @Before
    public void CreateContactActivity(){
        cca = new CreateContactAcitivity();
    }

    @Test
    public void correctContact() throws Exception{
        Contact contact = new Contact();
        contact.setAddress("DAL");
        contact.setBusiness("Fisher");
        contact.setName("AJ");
        contact.setLocation("NS");
        contact.setNumber("111717186");
        assertTrue(cca.beenCreated(contact));
    }
}
