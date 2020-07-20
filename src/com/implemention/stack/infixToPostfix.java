package com.implemention.stack;

import java.util.Stack;

public class infixToPostfix {

	static int Prec(char ch) {
		
		switch(ch) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '^':
			return 3;
		}
		return -1;
	}
	
	static String infixTopost(String exp) {
		
		String result = new String("");
		
		Stack<Character> stack = new Stack<Character>();
		
		for(int i=0; i<exp.length(); i++) {
			char c = exp.charAt(i);
			
			if(Character.isLetterOrDigit(c)) {
				result += c;
			}else if(c=='(') {
				stack.push(c);
			}else if(c==')') {
				while(!stack.isEmpty() && stack.peek()!='(') {
					result+=stack.pop();
				}
				if(!stack.isEmpty() && stack.peek()!='(') {
					return "Invalid expression";
				}else {
					stack.pop();
				}
			}else {
				while(!stack.empty() && Prec(c) <= Prec(stack.peek())) {
					if (stack.peek()=='(') {
						return "Invalid Expresion";
					}
					result += stack.pop();
				}
				stack.push(c);
			}
		}
		
		while(!stack.isEmpty()) {
			if(stack.peek()=='(') {
				return "Invalid Expression";
			}
			result+=stack.pop();
		}
		return result;
	}
	
	public static void main(String[] args) {

		String exp = "a+b*(c^d-e)^(f+g*h)-i";
		System.out.println(infixTopost(exp));
	}

}
