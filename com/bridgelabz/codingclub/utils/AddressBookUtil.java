package com.bridgelabz.codingclub.utils;

import java.util.Scanner;

/**
*AddressBookUtil class
*@author Pavitra
*/

public final class AddressBookUtil{
	private final static Scanner scanner=new Scanner(System.in);

	private AddressBookUtil(){
		//default
	}

	public static int getUserNumber(){
		return scanner.nextInt();
	}

	public static String getUserString(){
		return scanner.nextLine();
	}
}