package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * @author AJ
 * @version 1.0
 */

public class CreateContactAcitivity extends Activity {


    private Button submitButton;
    private EditText nameField, numberField,businessField, addressField, locationField;
    private MyApplicationData appState;

    /**
     * Gets field from last instance
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact_acitivity);
        //Get the app wide shared variables
        appState = ((MyApplicationData) getApplicationContext());
        submitButton = (Button) findViewById(R.id.submitButton);

        nameField = (EditText) findViewById(R.id.name);
        numberField = (EditText) findViewById(R.id.number);
        businessField = (EditText) findViewById(R.id.business);
        addressField = (EditText) findViewById(R.id.address);
        locationField = (EditText) findViewById(R.id.location);
    }
    /**
     * Creates business from inputted fields into database
     *
     * @param v
     */
    public void submitInfoButton(View v) {
        //each entry needs a unique ID
        String name = nameField.getText().toString();
        String number = numberField.getText().toString();
        String business = businessField.getText().toString();
        String address = addressField.getText().toString();
        String location = locationField.getText().toString();
        Contact person = new Contact(name, number,business,address,location);

        appState.firebaseReference.child(name).setValue(person);
        finish();
    }

    /**
     * Used to test if created viable contact
     *
     * @param contact
     * @return
     */
    public boolean beenCreated(Contact contact){
        boolean created=false;
        if(contact.getAddress().length()<50 &&
                (contact.getBusiness().equalsIgnoreCase("Fisher")||contact.getBusiness().equalsIgnoreCase("Distributor")||contact.getBusiness().equalsIgnoreCase("Processor")||contact.getBusiness().equalsIgnoreCase("Fish Monger")) &&
                (contact.getLocation().equalsIgnoreCase("AB")||contact.getLocation().equalsIgnoreCase("BC")||contact.getLocation().equalsIgnoreCase("MB")||contact.getLocation().equalsIgnoreCase("NB")||contact.getLocation().equalsIgnoreCase("NL")||contact.getLocation().equalsIgnoreCase("NS") ||contact.getLocation().equalsIgnoreCase("NT")||contact.getLocation().equalsIgnoreCase("NU")||contact.getLocation().equalsIgnoreCase("ON")||contact.getLocation().equalsIgnoreCase("PE")||contact.getLocation().equalsIgnoreCase("QC")||contact.getLocation().equalsIgnoreCase("SK")||contact.getLocation().equalsIgnoreCase("YT") ||contact.getLocation().equalsIgnoreCase(" "))&&
                contact.getNumber().length()==9&&
                (contact.getName().length()<49&&contact.getName().length()>1))
            created = true;
        return created;
    }
}
