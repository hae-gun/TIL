package com.spring.ex01;

public class test {
	public static void main(String[] args) {
		int p=10;
		int q = p++>10 ? p+3:p-3;
		System.out.printf("p:%d, q:%d",p,q);
	}
}
