package com.GFG.DS.stack;

import java.util.Stack;

/*
	 * 
	 * Check for balanced parentheses in an expression
	 * 
	 * */
public class balancedParentheses {

	static boolean isPraenthesesBlanced(String str) {
		
		Stack<Character> stack = new Stack<Character>();
		
		for(int i=0; i<str.length(); i++) 
		{
			char ch = str.charAt(i);
			if(ch =='{' || ch =='[' || ch == '(') {
				stack.push(ch);
				continue;
			}
			
			if(stack.isEmpty()) {
				return false;
			}
			
			switch(ch) {
			case ')':
				stack.pop();
				if(ch=='{' || ch=='[') 
					return false;
				break;
			case '}':
				stack.pop();
				if (ch=='(' || ch=='[') 
					return false;
				break;
			case ']':
				stack.pop();
				if(ch=='(' || ch=='{')
					return false;
				break;
			}
		}
		return (stack.isEmpty());
	}
	public static void main(String[] args) {
		
		String str = "[()]{}{[()()]()}";   //  "[(])";   //  "([{}])";
		if (isPraenthesesBlanced(str)) {
			System.out.println("Balanced");
		}else {
			System.out.println("Not Balanced");
		}
	}

}
