package com.bridgelabz.codingclub.utils;

import com.bridgelabz.codingclub.models.Person;
import java.io.File;
import java.util.Scanner;
import java.util.*;
import java.util.ArrayList;
import java.io.FileNotFoundException;
/**
*LoadData class
*@author Pavitra
*/
public class LoadData
{
	final private static List<Person> persons=new ArrayList<Person>();

	private static void split(String data){
        ArrayList<String> person = new ArrayList<>();
        int i = 0;
        String temp = "";
        while(data.charAt(i) != ';'){
            while(data.charAt(i) != ',' && data.charAt(i) != ';'){
                temp = temp + data.charAt(i);
                i++;
            }
            person.add(temp);
            temp = "";
            i++;
        }
        addToList(person);
    }

    private static void addToList(ArrayList<String> data){
        Person person = new Person(data.get(0),data.get(1),data.get(2),data.get(3),data.get(4),data.get(5),data.get(6),data.get(7));
        persons.add(person);
    }


    public static ArrayList<Person> load(){
        try{
            File data = new File("com/bridgelabz/codeinclub/utils/data/AddressBook.csv");
            Scanner fileReader = new Scanner(data);
            while(fileReader.hasNextLine()){
                split(fileReader.nextLine());
            }
        }catch(FileNotFoundException e){
            System.out.println("Error: File not found to read data");
        }
        return persons;
    }
}
