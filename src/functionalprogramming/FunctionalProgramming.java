package functionalprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FunctionalProgramming {
	
	static class Person {

		String name;
		int age;
		String nationality;

		public Person(String name, int age, String nationality) {
			this.name = name;
			this.age = age;
			this.nationality = nationality;
		}
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getNationality() {
			return nationality;
		}

		public void setNationality(String nationality) {
			this.nationality = nationality;
		}
	}
	
	public static class Timing {
		
		int turns = 0;
		long t0 = 0;
		long t1 = 0;
		
		public void start() {
			t0 = System.nanoTime();
		}
		
		public void stop() {
			t1 += System.nanoTime() - t0;
			turns ++;
		}
		
		public void average() {
			System.out.printf("Average time[%d turns]:\t%d ns \t(%f seconds)\n", turns, t1, t1 / Math.pow(10, 9));
			turns = 0;
			t0 = 0;
			t1 = 0;
		}

		
	}
	
	public static void main(String[] args) {
		
		// Convert elements of a collection to upper case
		List<String> listToUpper = Arrays.asList("Yoshimi", "Naomi", "Okja", "Lailah", "Liam", "Ocakci");
		Stream<String> streamToUpper = listToUpper.stream();
		streamToUpper.map(p -> p.toUpperCase()).forEach(System.out::println);
		System.out.println();
		
		// Filter collection so that only elements with less than 4 characters 
		// are returned. ["hola", "chau", "marzo", "saraza"]
		List<String> listLessThan = Arrays.asList("hola", "chau", "marzo", "saraza", "luz", "dos");
		Stream<String> streamLessThan = listLessThan.stream();
		streamLessThan.filter(p -> p.length() < 4).forEach(System.out::println);
		System.out.println();
		
		
		// Flatten multidimensional collection (Example, a list of lists)
		List<List<Integer>> listMultidimensional = new ArrayList<>();
		IntStream streamInnerValues1 = IntStream.rangeClosed(1, 10);
		IntStream streamInnerValues2 = IntStream.rangeClosed(100, 110);
		IntStream streamInnerValues3 = IntStream.rangeClosed(1000, 1010);
		IntStream streamInnerValues4 = IntStream.rangeClosed(3, 6);
		listMultidimensional.add(streamInnerValues1.boxed().collect(Collectors.toList()));
		listMultidimensional.add(streamInnerValues2.boxed().collect(Collectors.toList()));
		listMultidimensional.add(streamInnerValues3.boxed().collect(Collectors.toList()));
		listMultidimensional.add(streamInnerValues4.boxed().collect(Collectors.toList()));
		
		List<Integer> listFlattened = listMultidimensional.stream().flatMap(p -> p.stream()).collect(Collectors.toList());
		listFlattened.stream().forEach(System.out::print);
		System.out.println();
		System.out.println();
		
		
		// Get oldest person from the collection 
		List<Person> listOfPersons = new ArrayList<>(
				Arrays.asList(new Person("Yoshimi", 23, "JP"), new  Person("Naomi", 33, "MX"), 
						      new Person("Okja", 27, "MX"), new Person("Lailah", 41, "CA"), 
						      new Person("Liam", 17, "CA"), new Person("Ocakci", 5, "UK")));
		
		listOfPersons.stream().mapToInt(p -> p.getAge()).max().ifPresent(System.out::println);
		System.out.println();
		
		
		// Get names of all under age of 18
		listOfPersons.stream().filter(p -> p.getAge() < 18).map(p -> p.getName()).collect(Collectors.toList()).forEach(System.out::println);
		System.out.println();
		
		
		// Get people statistics: average age, count, maximum age, minimum age 
		// and sum of all ages
		listOfPersons.stream().mapToInt(p -> p.getAge()).average().ifPresent(System.out::println);
		listOfPersons.stream().mapToInt(p -> p.getAge()).min().ifPresent(System.out::println);
		listOfPersons.stream().mapToInt(p -> p.getAge()).max().ifPresent(System.out::println);
		System.out.println(listOfPersons.stream().mapToInt(p -> p.getAge()).sum());
		System.out.println(listOfPersons.stream().mapToInt(p -> p.getAge()).count());
		
		
		// Partition adults and kids
		Map<Boolean, List<Person>> partionedByAge = listOfPersons.stream().collect(Collectors.partitioningBy(p -> p.getAge() < 18));
		partionedByAge.size();
		System.out.println();		
		
		
		// Group people by nationality: Person(name, age, nationality)
		Map<String, List<Person>> partionedByNationality = listOfPersons.stream().collect(Collectors.groupingBy(p -> p.getNationality()));
		partionedByNationality.size();
		System.out.println();		
		
		
		// Return people names separated by comma
		System.out.println(listOfPersons.stream().map(p -> p.getName()).collect(Collectors.joining(", ")));
		System.out.println();
		
		
		// Sum all elements of a collection
		Set<Integer> setToReduceBySum = IntStream.rangeClosed(10, 20).boxed().collect(Collectors.toSet());
		System.out.println(setToReduceBySum.stream().reduce(0, Integer::sum));
		
		
		// ----------------------------
		// Start with a List of Strings
		// ----------------------------
		List<String> words =  Arrays.asList("Yoshimi", "Naomi", "Okja", "Lailah", "Liam", "Ocakci");
		
		// Produce a single String that is the result of concatenating the 
		// uppercase versions of all of the Strings.
		// Use a single reduce operation, without using map.
		words.stream().reduce((a, b) -> a.toUpperCase() + b.toUpperCase()).ifPresent(System.out::println);
		System.out.println();
		
		
		// Produce the same String as above, but this time via a map operation that turns 
		// the words into upper case, followed by a reduce operation that concatenates them.
		words.stream().map(f -> f.toUpperCase()).reduce((a, b) -> a + b).ifPresent(System.out::println);
		System.out.println();
		
		
		// Produce a String that is all the words concatenated together, but with commas in between. 
		// No comma at the beginning and also no comma at the end, after the last word. 
		// Major hint: there are two versions of reduce discussed in the notes
		System.out.println(words.stream().collect(Collectors.joining(", ")));
		System.out.println();
		
		
		// Find the total number of characters (i.e., sum of the lengths) of the strings in the List.
		System.out.println(words.stream().collect(Collectors.joining()).length());
		System.out.println(words.stream().mapToInt(w -> w.length()).sum());
		
		
		// Find the number of words that contain an “h”
		System.out.println(words.stream().filter(w -> w.contains("h")).count());
		
		
		// ----------------------------
		// Make a very large array of random doubles, each of which ranges from 0 to 1
		// ----------------------------
		int max = 100000000;
		double[] randomDoubles = new Random().doubles(0, 1).limit(max).toArray();
		DoubleStream streamRandomDoubles;
		
		
		// Compute the sum of the square roots of the numbers in the array. Find a shorter and simpler 
		// way than making a loop to tally the sum.
		streamRandomDoubles = DoubleStream.of(randomDoubles);
		System.out.println(streamRandomDoubles.map(d -> Math.sqrt(d)).sum());
		System.out.println();

		
		// Repeat the process in parallel.
		streamRandomDoubles = DoubleStream.of(randomDoubles);
		System.out.println(streamRandomDoubles.parallel().map(d -> Math.sqrt(d)).sum());
		System.out.println();
		
		
		// Verify that you get the “same” answer with the parallel approach as with the sequential 
		// approach. Why do I have “same” in quotes in the previous sentence?
		System.out.println("Because the answer is not always the same, we loose pressition, i.e.: ");
		System.out.println("6.6667911798980206E7");
		System.out.println("6.666791179898021E7");
		System.out.println();
		
		
		// Test whether the parallel approach is faster than the sequential approach. Doing the 
		// timing is a little bit tedious, but if you think it simplifies things. 
		Timing timing = new Timing();
		System.out.println("Random Doubles");
		for(int i=0; i < 10; i++) {
			timing.start();
			streamRandomDoubles = DoubleStream.of(randomDoubles);
			System.out.println(streamRandomDoubles.map(d -> Math.sqrt(d)).sum());
			timing.stop();
		}
		timing.average();
		System.out.println();
		
		
		System.out.println("Parallel Random Doubles");
		for(int i=0; i < 10; i++) {
			timing.start();
			streamRandomDoubles = DoubleStream.of(randomDoubles);
			System.out.println(streamRandomDoubles.parallel().map(d -> Math.sqrt(d)).sum());
			timing.stop();
		}
		timing.average();
		System.out.println();
		

		System.out.println("Non functional P");
		for(int i=0; i < 10; i++) {
			timing.start();
			double sum = 0;
			for(int j=0; j < max; j++) {
				sum += Math.sqrt(randomDoubles[j]);
			}
			System.out.println(sum);
			timing.stop();
		}
		timing.average();
		System.out.println();
		
		// Random Doubles
		// 6.6665563011956036E7
		// Average time[10 turns]:	 9088956296 ns 	(9.088956 seconds)
		// Parallel Random Doubles 
		// 6.666556301195604E7
		// Average time[10 turns]:	 3962445639 ns 	(3.962446 seconds)
		// Non functional P 
		// 6.666556301195258E7
		// Average time[10 turns]:	 5617576084 ns 	(5.617576 seconds)  

		
		
		// ----------------------------
		//Make an “infinite” stream that generates random doubles between 0 and 10.
		// ----------------------------
		DoubleStream infinite; // = new Random().doubles(0, 10);
		
		// Print 5 random doubles
		infinite = new Random().doubles(0, 10);
		infinite.limit(5).forEach(System.out::println);
		System.out.println();
		
		// Make a List of 10 random doubles
		infinite = new Random().doubles(0, 10);
		System.out.println(infinite.limit(10).boxed().map(d -> d.toString()).collect(Collectors.joining(", ")));
		System.out.println();
		
		// Make an array of 20 random doubles
		infinite = new Random().doubles(0, 10);
		Arrays.asList(infinite.limit(20).toArray()).forEach(System.out::print);
		System.out.println();
		
	}

}
