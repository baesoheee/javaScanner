package com.it.java.ssg;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("== program start ==");
		Scanner sc = new Scanner(System.in);
		int lastID = 0;
		
		while(true) {
			System.out.printf("Enter the command : ");
			String command = sc.nextLine();
			command = command.trim();    //공백 처리
			if (command.length()==0) {
				continue;
			}							 // 띄어쓰기만 했을 때 위로 다시 올라가기
			
			if(command.equals("exit")) {
				break;
			}else if(command.equals("article write")) {
				int id = lastID + 1;
				lastID = id;   // ID 갱신
				System.out.printf("title : ");
				String title = sc.nextLine();
				System.out.printf("contents : ");
				String body = sc.nextLine();
				
				System.out.printf("%d post has been created.\n",id);
				System.out.printf("title : %s\n",title);
				System.out.printf("body : %s\n",body);
				
			}else if(command.equals("article list")) {
				System.out.println("There are no posts.");
			}else {
				System.out.printf("%s is a non-existent command.\n", command);
				
			}
		}
		sc.close();
		System.out.println("== program end ==");
	}
}
