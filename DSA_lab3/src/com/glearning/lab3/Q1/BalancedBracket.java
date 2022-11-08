package com.glearning.lab3.Q1;

import java.util.Stack;
import java.util.Scanner;

public class BalancedBracket {

	private static boolean BalancedBrackets(String str) {
		Stack<Character> stack = new Stack<Character>();

		char[] charArray = str.toCharArray();

		for (int i = 0; i < charArray.length; i++) {
			char x = charArray[i];

			if (x == '(' || x == '{' || x == '[') {
				stack.push(x);
				continue;
			}

			if (stack.isEmpty()) {
				return false;
			}
			char check;
			switch (x) {
			case '}':
				check = (char) stack.pop();
				if (check == '(' || check == '[')
					return false;
				break;

			case ']':
				check = (char) stack.pop();
				if (check == '(' || check == '{')
					return false;
				break;

			case ')':
				check = (char) stack.pop();
				if (check == '{' || check == '[')
					return false;
				break;
			}

		}

		return (stack.isEmpty());

	}

	public static void main(String[] args) {

		String inputString;
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the expression to check for balancing brackets");
		inputString = sc.nextLine();

		if (BalancedBrackets(inputString))
			System.out.println("The entered Strings" + inputString + "has Balanced Bracket");
		else {
			System.out.println("The entered Strings" + inputString + "do not contain Balanced Bracket");
		}
		sc.close();

	}
}
