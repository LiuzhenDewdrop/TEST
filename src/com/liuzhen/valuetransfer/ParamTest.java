package com.liuzhen.valuetransfer;

public class ParamTest {

	public static void main(String[] args) {
		Person a = new Person();
		a.setName("AAAA");
		a.setSalary(10000);
		Person b = new Person();
		b.setName("BBBB");
		b.setSalary(9999);
		System.out.println("Before a:" + a.getName() + " " + a.getSalary());
		System.out.println("Before b:" + b.getName() + " " + b.getSalary());
		swap(a, b);
		System.out.println("After a:" + a.getName() + " " + a.getSalary());
		System.out.println("After b:" + b.getName() + " " + b.getSalary());
		swap1(a, b);
		System.out.println("After a:" + a.getName() + " " + a.getSalary());
		System.out.println("After b:" + b.getName() + " " + b.getSalary());
		int x = 1;
		int y = 0;
		System.out.println("Before swap a:" + x);
		System.out.println("Before swap b:" + y);
		swap(x, y);
		System.out.println("After swap a:" + x);
		System.out.println("After swap b:" + y);
	}
	
	private static void swap(int a, int b) {
		int c = a;
		a = b;
		b = c;
		System.out.println("After Method a:" + a);
		System.out.println("After Method b:" + b);
	}
	
	private static void swap(Person a, Person b) {
		Person temp = a;
		a = b;
		b = temp;
		System.out.println("After Method a:" + a.getName() + " " + a.getSalary());
		System.out.println("After Method b:" + b.getName() + " " + b.getSalary());
	}
	
	private static void swap1(Person a, Person b) {
		String temp = a.getName();
		int tem = a.getSalary();
		a.setName(b.getName());
		a.setSalary(b.getSalary());
		b.setName(temp);
		b.setSalary(tem);
		System.out.println("After Method a:" + a.getName() + " " + a.getSalary());
		System.out.println("After Method b:" + b.getName() + " " + b.getSalary());
	}
}

class Person {
	private String name;
	private int salary;
	public Person(){};
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
}
