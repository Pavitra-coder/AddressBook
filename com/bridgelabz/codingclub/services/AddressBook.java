package com.bridgelabz.codingclub.services;

import com.bridgelabz.codingclub.models.Person;
import com.bridgelabz.codingclub.utils.WriteCSV;
import com.bridgelabz.codingclub.utils.AddressBookUtil;
import com.bridgelabz.codingclub.utils.LoadData;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
*AddressBook class
*@author Pavitra
*/
// AddressBook.java
// Observable class to add, modify, and delete person array

public class AddressBook implements AddressBookService{

	final private List<Person> addressBook = new ArrayList<>();
       
	 public void addPerson() {
        
        AddressBookUtil.getUserString();
        
        System.out.print("Enter contact's First name: ");
        final String firstName = AddressBookUtil.getUserString();

        System.out.print("Enter contact's Last name: ");
        final String lastName = AddressBookUtil.getUserString();

        System.out.print("Enter contact's Address: ");
        final String address = AddressBookUtil.getUserString();

        System.out.print("Enter contact's City: ");
        final String city =  AddressBookUtil.getUserString();

        System.out.print("Enter contact's State: ");
        final String state = AddressBookUtil.getUserString();

        System.out.print("Enter contact's Zip code: ");
        final String zip = AddressBookUtil.getUserString();

        System.out.print("Enter contact's Phone number: ");
        final String phone = AddressBookUtil.getUserString();

		System.out.print("Enter contact's EmailID: ");
        final String email = AddressBookUtil.getUserString();


        final Person person = new Person(firstName, lastName, address, city, state, zip, phone, email);
        addressBook.add(person);
    }

   //@Override
   public void updatePerson() {
        Person obj = getName();
        if(obj != null ){
            System.out.print("Enter person's Address: ");
            final String address = AddressBookUtil.getUserString();
            obj.setAddress(address);

            System.out.print("Enter person's City: ");
            final String city =  AddressBookUtil.getUserString();
            obj.setCity(city);

            System.out.print("Enter person's State: ");
            final String state = AddressBookUtil.getUserString();
            obj.setState(state);

            System.out.print("Enter person's Zip code: ");
            final String zip = AddressBookUtil.getUserString();
            obj.setZip(zip);

            System.out.print("Enter person's Phone number: ");
            final String phone = AddressBookUtil.getUserString();
            obj.setPhone(phone);
			
			System.out.print("Enter person's Email ID: ");
            final String email = AddressBookUtil.getUserString();
            obj.setEmail(email);
            save();

        }else{
            System.out.println("Invalid data");
        }
    }
  
 
  //@Override
  public void removePerson() {
     Person obj = getName();
        if(obj != null ){
            addressBook.remove(obj);
            System.out.println("contact deleted");
            save();
        }else{
            System.out.println("contact not found.");
        }
    }
  

 

	private Person getName(){
        AddressBookUtil.getUserString();
        display();
        System.out.print("Enter first name of contact you want delete/edit: ");
        String firstName = AddressBookUtil.getUserString();
        Person obj = serach(firstName);
        return obj;
    }
    @Override
    public void display(){
        for(Person obj : addressBook){
            System.out.println("------------------");
            System.out.println("Name: "+obj.getName());
            System.out.println("Address: "+obj.getAddress());
            System.out.println("Phone: "+obj.getPhone());
            System.out.println("Zip: "+obj.getZip());
			System.out.println("email: "+obj.getEmail());
        }
    }

  @Override
    public void save(){
        WriteCSV.writeAll(addressBook);
    }

    @Override
    public void loadData(){
        ArrayList<Person> tmp = LoadData.load();
        if(tmp.isEmpty()){
            System.out.println("Nothing to load from file.");
        }else{
            if(!addressBook.isEmpty()){
                addressBook.clear();
            }
            for(Person obj : tmp){
                addressBook.add(obj);
            }
            System.out.println("Data loaded from file");
        }
    }
	 public void sort(){
      System.out.println("1. sort by Name \n2. sort by zip");
      System.out.print("Enter your choice: ");
      int choice = AddressBookUtil.getUserNumber();
      switch(choice){
            case 1:
                sortByName();
                break;
            case 2:
                sortByZIP();
                break;
            default:
                System.out.println("invalid value");
      }
  }
   
    void sortByName() {
    Collections.sort(this.collection, new Person.CompareByName());
  }

  void sortByZIP() {
    Collections.sort(this.collection, new Person.CompareByZIP());
  }
   private Person serach(String firstName){
        Person returnObj = null;
        for(Person obj : addressBook){
            if(firstName.equalsIgnoreCase(obj.getFirstName())){
                returnObj = obj;
                break;
            }
        }
        return returnObj;
    }
}