package com.bridgelabz.codingclub.main;

import com.bridgelabz.codingclub.utils.LoadData;
import com.bridgelabz.codingclub.utils.AddressBookUtil;
import com.bridgelabz.codingclub.services.AddressBookService;
import com.bridgelabz.codingclub.services.AddressBook;


/**
*Main class: This class contains main method and handles others classes in this project
*@author pavitra
*/

public class Main
{
	public static void main(String[] args)
	{
		final AddressBookService addressBookService = new AddressBook();
		addressBookService.loadData();
		System.out.println("Welcome to address book");
		while(true){
		System.out.println("Enter your choice\n 1.Add\n 2.View\n 3.Edit\n 4.Sort\n 5.Delete\n 6.Save changes & Quit\n 7.Quit without saving");
		final int choice = AddressBookUtil.getUserNumber();
        switch(choice){
			case 1:
				System.out.println("Adding contact:");
			    addressBookService.addPerson();
				System.out.println("contact added");
			break;
			case 2:
				System.out.println("Display contact:");
				addressBookService.displayContacts();
			break;
			case 3:
				System.out.println("Edit contact:");
			    addressBookService.updatePerson();
			break;
			case 4:
				System.out.println("Sort contact:");
			    addressBookService.sort();
            break;
			case 5:
				System.out.println("Delete contact:");
			    addressBookService.removePerson();
            break;
			case 6:
				System.out.println("Save contact and Quit:");
                addressBookService.save();
                System.out.println("Quiting...");
                System.exit(0);
            case 7:
                System.out.println("Quiting...");
                System.exit(0);
            default:
                System.out.println("Error: Invalid Data!!, Try again");
            }
       }

    }
}