package com.acme.a3csci3130;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Class that defines how the data will be stored in the
 * Firebase databse. This is converted to a JSON format
 */

/**
 * @author AJ
 * @version 1.0
 */

public class Contact implements Serializable {
    public  String name;
    public  String number;
    public String business;
    public String address;
    public String location;


    /**
     * Getter and setter methods for the business variables
     *
     * @return
     */


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {return name;}

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public Contact() {
        // Default constructor required for calls to DataSnapshot.getValue
    }

    /**
     *
     * @param name
     * @param number
     * @param business
     * @param address
     * @param location
     */
    public Contact(String name, String number, String business, String address, String location){
        this.name = name;
        this.number = number;
        this.business = business;
        this.address = address;
        this.location = location;
    }

    /**
     *
     * @return
     */
    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("name", name);
        result.put("number", number);
        result.put("business", business);
        result.put("address", address);
        result.put("location", location);
        return result;
    }
}
