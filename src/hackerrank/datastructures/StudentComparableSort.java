package hackerrank.datastructures;

import java.util.*;
public class StudentComparableSort {

	static class Student implements Comparable<Student> {
		private int id;
		private String fname;
		private double cgpa;

		public Student(int id, String fname, double cgpa) {
			super();
			this.id = id;
			this.fname = fname;
			this.cgpa = cgpa;
		}

		public int getId() {
			return id;
		}

		public String getFname() {
			return fname;
		}

		public double getCgpa() {
			return cgpa;
		}    

		public int hashCode() {
			return fname.hashCode() + Double.valueOf(cgpa).hashCode() + Integer.valueOf(id).hashCode();
		}

		public boolean equals(Object o) {
			if(o == null) {
				return false;
			}
			if (!(o instanceof Student)) {
				return false;
			}
			Student student = (Student)o;
			return student.id == this.id && student.fname.equals(this.fname) && student.cgpa == this.cgpa;
		}

		public int compareTo(Student s) {
			int comparison = 0;
			if(this.cgpa > s.cgpa) {
				comparison = -1;
			}
			else if(this.cgpa < s.cgpa) {
				comparison = 1;
			}
			if(comparison == 0) {
				comparison = this.fname.compareTo(s.fname);
			}
			if(comparison == 0) {
				if(this.id > s.id) {
					comparison = 1;
				}
				else if(this.id < s.id) {
					comparison = -1;
				}
			}
			return comparison;
		}

	}

	//Complete the code

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());

		List<Student> studentList = new ArrayList<Student>();
		while(testCases>0){
			int id = in.nextInt();
			String fname = in.next();
			double cgpa = in.nextDouble();

			Student st = new Student(id, fname, cgpa);
			studentList.add(st);

			testCases--;
		}

		Collections.sort(studentList);

		for(Student st: studentList){
			System.out.println(st.getFname());
		}
		in.close();
	}

}
