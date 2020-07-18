package com.implemention.stack;

public class stack {

	static final int MAX = 100;
	int top;
	int[] a = new int[MAX];
	
	public boolean isEmpyt() {
		return(top < 0);
	}
	
	public stack(){
		top = -1;
	}
	
	public boolean push(int x) {
		 if(top >= (MAX-1)) {
			 System.out.println("stack overflow");
			 return false;
		 }else {
			 a[++top]=x;
			 System.out.println(x+" value pushed");
			 return true;
		 }
	 }
	 
	public int pop() {
		 if(top < 0) {
			 System.out.println("stack underflow");
			 return 0;
		 }else {
			 return a[top--];
		 }
	 }
	 
	 public int peek() {
		 if(top < 0) {
			 System.out.println("Stack is underflow");
			 return 0;
		 }else {
			 return a[top];
		 }
	 }
}
