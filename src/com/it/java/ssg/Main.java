package com.it.java.ssg;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("== program start ==");
		Scanner sc = new Scanner(System.in);
		int lastArticleId = 0;
		List<Article> articles = new ArrayList<>();
		while (true) {
			System.out.printf("Enter the command) ");
			String command = sc.nextLine();
			command = command.trim();
			if (command.length() == 0) {
				continue;
			}
			if (command.equals("system exit")) {
				break;
			}
			if (command.equals("article write")) {
				int id = lastArticleId + 1;
				lastArticleId = id;
				System.out.printf("title : ");
				String title = sc.nextLine();
				System.out.printf("contents : ");
				String body = sc.nextLine();
				Article article = new Article(id, title, body);
				articles.add(article);
				System.out.printf("No.%d post created.\n", id);
			} else if (command.equals("article list")) {
				if (articles.size() == 0) {
					System.out.println("There are no posts.");
					continue;
				}
//				1번게시물부터 2,3,4 순으로 정렬
//				for(int i = 0; i<articles.size();i++) {
//					Article article = articles.get(i);
//				}
//				최신게시물부터 출력
				System.out.println("number  |   title");
				for (int i = articles.size() - 1; i >= 0; i--) {
					Article article = articles.get(i);
					System.out.printf("%d    |  %s\n", article.id, article.title);
				}

			} else if (command.startsWith("article detail")) {
				String[] commandbits = command.split(" ");
				int id = Integer.parseInt(commandbits[2]); // "2" => 2

				Article foundArticle = null;

				for (int i = 0; i < articles.size(); i++) {
					Article article = articles.get(i);
					if (article.id == id) {

						foundArticle = article;
						break;
					}
				}
				if (foundArticle == null) {
					System.out.printf("No.%d post does not exist.\n", id);
					continue;
				}
				System.out.printf("numbr : %d\n", foundArticle.id);
				System.out.printf("date : 2022-07-16 12:41:15\n");
				System.out.printf("title : %s\n", foundArticle.title);
				System.out.printf("contents : %s\n", foundArticle.body);

			}else if (command.startsWith("article delete")) {
				String[] commandbits = command.split(" ");
				int id = Integer.parseInt(commandbits[2]); // "2" => 2

				int foundIndex = -1;

				for (int i = 0; i < articles.size(); i++) {
					Article article = articles.get(i);
					if (article.id == id) {
						foundIndex = i;
						break;
					}
				}
				if (foundIndex == -1) {
					System.out.printf("No.%d doesn't exist.\n", id);
					continue;
				}
//				size()  => 3
//				index : 0, 1, 2
//				id    : 1, 2, 3
				articles.remove(foundIndex);
				System.out.printf("No.%d has been deleted.", id);

			} else {

				System.out.printf("%s is a non-existent command.\n", command);
			}
		}
		sc.close();
		System.out.println("== program end ==");
	}
}
class Article {
	int id;
	String title;
	String body;
	public Article(int id, String title, String body) {
		this.id = id;
		this.title = title;
		this.body = body;
	}
}