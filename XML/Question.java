package com.javaxml;
import java.util.*;

public class Question {
	static Scanner sc = new Scanner(System.in);
	static Scanner in = new Scanner(System.in);
	private int count;
	private static int nchoice;
	private static String quest;
	private static String choice [] = new String[6];
	
	public void recurse(int counter) {
		for(int i=0; i<counter; i++) {
			this.question();
			this.choice();
		}
	}
	
	public void question() {
		System.out.print("Enter the Question:");
		
		Question.quest = in.nextLine();
		//return Question.quest;
	}
	
	public void choice() {
		System.out.print("Enter the number of choices:");
		Question.nchoice = sc.nextInt();
		
		for(int x = 0; x < Question.nchoice; x++) {
			System.out.print("Enter your choice "+(x+1)+":");
			Question.choice[x] = in.nextLine();
		}
		System.out.print(Question.choice[2]);
	}
	
	public void ans() {
		
	}
	
	public static void main(String[] args) {
		Question obj = new Question();
		
		
		System.out.print("Enter the number of questions to insert:");
		obj.count = sc.nextInt();
		obj.recurse(obj.count);
	}

}
