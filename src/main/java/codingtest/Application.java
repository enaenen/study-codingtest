package codingtest;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

import java.io.*;
import java.util.*;

public class Application {

	static class Location {

		int x;
		int y;
		int z;

		public Location(int y, int x, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	static class Person {
		public int age;
		public String name;

		public Person(int age, String name) {
			this.age = age;
			this.name = name;
		}
		public int diff(Person other){
			return age - other.age;
		}

		@Override
		public String toString() {
			return "Person{" +
					"age=" + age +
					", name='" + name + '\'' +
					'}';
		}
	}

	public static void main(String[] args) throws IOException {
		ArrayList<Person> list = new ArrayList<Person>();
		Person p1 = new Person(10, "ABC");
		Person p2 = new Person(20, "EFG");
		Person p3 = new Person(30, "HIK");
		list.add(p1);
		list.add(p2);
		list.add(p3);

//		list.sort(
//				(Person o1,Person o2) -> p1.name.compareTo(p2.name)
//		);
		Comparator<Person> comp = Comparator.comparing(h -> h.name);
		list.sort(comp.reversed());
//		list.sort(comp);

		for (Person person : list) {
			System.out.println("person = " + person);
		}


	}
}