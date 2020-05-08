package com.bridgelabz.codingclub.utils;

import com.bridgelabz.codingclub.models.Person;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.IOException;

/**
*WriteCSV class
*@author Pavitra
*/
public class WriteCSV{
	public static void write(ArrayList<Person> data){
		try{
			PrintWriter printwriter=new PrintWriter("com/bridgelabz/codingclub/utils/data/AddressBook.csv");
			for(Person obj : data){
				String csv=obj.getFirstName()+","+obj.getLastName()+","+obj.getAddress()+","+obj.getState()
				+","+obj.getState()+","+obj.getPhone()+","+obj.getZIP()+","+obj.getEmail();
                printwriter.println(csv);
			}
			printwriter.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		System.out.println("Done Successfully");
	}
}