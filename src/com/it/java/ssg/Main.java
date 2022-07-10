package com.it.java.ssg;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("==program start==");
		Scanner sc = new Scanner(System.in);
		System.out.printf("Enter the command : ");
		String command = sc.next();
		System.out.println("input command : "+command);
		command = sc.next();
		System.out.println("input command : "+command);
		sc.close();
		System.out.println("==program end==");
	}
}
