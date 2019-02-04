package se.lexicon.streams_and_lambda;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

import se.lexicon.streams_and_lambda.utility.Gender;
import se.lexicon.streams_and_lambda.utility.Person;

/**
 * All exercises should be completed using Lambda expressions and the new
 * methods added to JDK 8 where appropriate. There is no need to use an explicit
 * loop in any of the code.
 *
 */
public class Lab {
	private List<Person> persons;

	public Lab(List<Person> persons) {
		this.persons = persons;
	}

	/**
	 * Exercise1 Create print out the first names of each person in the list
	 */
	public void exercise1() {
		System.out.println("\nRunning exercise 1:\n");

		persons.stream().forEach(p -> System.out.println(p.getFirstName()));
		/* Your code here */

	}

	/**
	 * Exercise2 Remove the words that have odd lengths from the local list using
	 * removeIf() Print out the remainder
	 */
	public void exercise2() {
		System.out.println("\nRunning exercise 2:\n");
		List<String> list = new ArrayList<>(Arrays.asList("alpha", "bravo", "charlie", "delta", "echo", "foxtrot"));

		/* Your code here */
		list.removeIf(x -> x.length() % 2 > 0);
		System.out.println(list);

	}

	/**
	 * Exercise 3 Replace every word in the list with its upper case equivalent
	 * using replaceAll() Print out the remainder
	 */
	public void exercise3() {
		System.out.println("\nRunning exercise 3:\n");
		List<String> list = new ArrayList<>(Arrays.asList("alpha", "bravo", "charlie", "delta", "echo", "foxtrot"));

		/* Your code here */

		list.replaceAll(x -> x.toUpperCase());
		System.out.println(list);
	}

	/**
	 * Exercise 4 Convert every key-value pair of the map into a string and append
	 * them all into a single string Hint: Maps forEach takes a BiConsumer...
	 */
	public void exercise4() {
		System.out.println("\nRunning exercise 4:\n");
		Map<String, Integer> map = new HashMap<>();
		map.put("c", 3);
		map.put("b", 2);
		map.put("a", 1);

		StringBuilder sb = new StringBuilder();

		/* Your code here */

		BiConsumer<String, Integer> biConsumer = (s, i) -> sb.append(s + i);

		map.forEach(biConsumer);
		// this also works
		// map.forEach(biConsumer::accept);
		System.out.println(sb);

//System.out.println(map.forEach((String s, Integer i)-> sb.append(s).append(i).toString()));
	}

	/**
	 * Exercise 5 Create a new thread that prints the numbers from the local list
	 */
	public void exercise5() {
		System.out.println("\nRunning exercise 5:\n");
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		/* Your code here */

		Runnable runnable = () -> {
			System.out.println(list);
		};
		Thread t1 = new Thread(runnable);
		t1.start();

	}

	/**
	 * Exercise 6 By using stream create a new list with all the strings from the
	 * original list converted to lower case and print them out. Hint: Use .collect
	 * as a terminal operation(closing and ending)
	 */
	public void exercise6() {
		System.out.println("\nRunning exercise 6:\n");
		List<String> list = Arrays.asList("The", "Quick", "BROWN", "Fox", "Jumped", "Over", "The", "LAZY", "DOG");

		/* Your code here */
		Function<String, String> func = s -> s.toLowerCase();

		List<String> lowerC = list.stream().map(func::apply).collect(Collectors.toList());

		System.out.println(lowerC);
	}

	/**
	 * Exercise 7 Modify exercise 6 so that the new list only contains strings that
	 * have an odd length
	 */
	public void exercise7() {
		System.out.println("\nRunning exercise 7:\n");
		List<String> list = Arrays.asList("The", "Quick", "BROWN", "Fox", "Jumped", "Over", "The", "LAZY", "DOG");

		/* Your code here */

		List<String> oddLength = list.stream().filter(s -> s.length() % 2 != 0).collect(Collectors.toList());

		System.out.println(oddLength);
	}

	/**
	 * Exercise 8 Turn list persons into a stream and print all elements whose
	 * lastName starts with 'A' Use a forEach as a terminal operation
	 */
	public void exercise8() {
		System.out.println("\nRunning exercise 8:\n");

		/* Your code here */

		persons.stream().filter(p -> p.getLastName().startsWith("A")).forEach(System.out::println);

	}

	/**
	 * Exercise 9 Create a new list from this.persons that should be sorted by
	 * lastName
	 */
	public void exercise9() {
		System.out.println("\nRunning exercise 9:\n");

		/* Your code here */
		Comparator<Person> compareTor = (x, x1) -> x.getLastName().compareTo(x1.getLastName());

		System.out.println("med stream ");

		persons.stream().sorted(compareTor).collect(Collectors.toList()).forEach(System.out::println);
		
//		System.out.println("sorterad lista");
//		Collections.sort(persons, compareTor);
//		persons.forEach(System.out::println);
		

	}

	/**
	 * Exercise 10 Create a new list from persons that should only contain those
	 * with lastname "Ali". then change the first name of all inside the stream to
	 * Muhammad
	 */
	public void exercise10() {
		System.out.println("\nRunning exercise 10:\n");

		/* Your code here */
		 
		Predicate<Person> pred = x -> x.getLastName().equals("Ali") && x.getGender().equals(Gender.MALE);
//		Predicate<Person> pred and Predicate<Person> pred2= x->x.getGender().equals(Gender.MALE);
//		Predicate<Person> pred2= x->x.getGender().equals(Gender.MALE);
		persons.stream().filter(pred).peek(x-> x.setFirstName("Mohammed")).forEach(System.out::println);

	}

	/**
	 * Exercise 11 Count how many persons is of female gender in this.persons.
	 * Present the result
	 */
	public void exercise11() {
		System.out.println("\nRunning exercise 11:\n");

		/* Your code here */
		
		persons.stream().allMatch(x->x.getGender().equals(Gender.FEMALE);

	}

}