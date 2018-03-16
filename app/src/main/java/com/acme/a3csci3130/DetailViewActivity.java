package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * @author AJ
 * @version 1.0
 */
public class DetailViewActivity extends Activity {
    private MyApplicationData appState;
    private EditText nameField, numberField,businessField,addressField, locationField;
    Contact receivedPersonInfo;
    /**
     *Gets field from saved instance
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedPersonInfo = (Contact)getIntent().getSerializableExtra("businesses");
        appState = ((MyApplicationData) getApplicationContext());
        nameField = (EditText) findViewById(R.id.name);
        numberField = (EditText) findViewById(R.id.number);
        businessField = (EditText) findViewById(R.id.business);
        addressField = (EditText) findViewById(R.id.address);
        locationField = (EditText) findViewById(R.id.location);
        if(receivedPersonInfo != null){
            numberField.setText(receivedPersonInfo.number);
            nameField.setText(receivedPersonInfo.name);
            businessField.setText(receivedPersonInfo.business);
            addressField.setText(receivedPersonInfo.address);
            locationField.setText(receivedPersonInfo.location);
        }

    }

    /**
     * Updates fields in database
     *
     * @param v
     */
    public void updateContact(View v){
        //Gets the required fields then instantiates a new contact object to set the value of the chosen userID
        String name = nameField.getText().toString();
        String number = numberField.getText().toString();
        String business = businessField.getText().toString();
        String address = addressField.getText().toString();
        String location = locationField.getText().toString();

        Contact contact = new Contact();

        contact.setName(name);
        contact.setBusiness(business);
        contact.setAddress(address);
        contact.setLocation(location);
        contact.setNumber(number);
        String ID = appState.firebaseReference.child(name).getKey();
        appState.firebaseReference.child(ID).setValue(contact);
        finish();
    }

    /**
     * Erases business from database
     *
     * @param v
     */
    public void eraseContact(View v)
    {
        String name = nameField.getText().toString();
        String ID = appState.firebaseReference.child(name).getKey();
        appState.firebaseReference.getDatabase().getReference("businesses").child(ID).removeValue();
        finish();
    }
}
