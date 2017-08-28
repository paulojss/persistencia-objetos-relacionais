package br.com.senai.test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory f = Persistence.createEntityManagerFactory("jpatest");
		f.close();
		System.out.println("Terminei!!");
		
	}

}
