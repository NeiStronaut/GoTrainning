package onthego;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Exercise:
 * Assuming you have infinite memory space. Create a sorting algorithm for all of the 
 * students in Mexico attending Primary School. Sort them by age only.
 * 
 * IMPORTANT: Make sure that the algorithm's complexity is O(n)
 * 
 * @author miriam.mecate
 *
 */
public class PrimarySchoolStudents {

    public enum Ages {

    }

    /**
     * Sorting students
     * @param students all of the students of Mexico's Primary School
     * @return A list of students sorted by age ONLY.
     */
    public List<Student> sortStudentsByAgeOnly(Student[] students) {
    	
    	//Expected ages will go between 5-12 years old. Log2 of 8 is 3 which will be constant.
        Map<Integer, List<Student>> mapOfStudents = new TreeMap<Integer, List<Student>>();

        //Complexity O(n)
        for(Student student : students) {
        	Integer age = student.getAge();
            List<Student> listOfSameAge = mapOfStudents.getOrDefault(age, new ArrayList<Student>());
            listOfSameAge.add(student);
            mapOfStudents.put(age, listOfSameAge);
        }

        //According to previous discussion traversing this tree will have complexity Log2 of 8
        List<Student> sortedStudents = new ArrayList<Student>(students.length);
        for (Integer age : mapOfStudents.keySet()) { 
        	List<Student> s = mapOfStudents.get(age);
        	sortedStudents.addAll(s);
        }

        // So O(n) + O(n) = O(n)
        return sortedStudents;
    }

    public Student[] generateStudents()
    {
        Student[] students = new Student[6];
        Student sA = new Student("FulanitoA", 6);
        Student sB = new Student("FulanitoB", 7);
        Student sC = new Student("FulanitoC", 8);
        Student sD = new Student("FulanitoD", 9);
        Student sE = new Student("FulanitoE", 9);
        Student sF = new Student("FulanitoF", 7);

        students[0] = sA;
        students[1] = sB;
        students[2] = sC;
        students[3] = sD;
        students[4] = sE;
        students[5] = sF;
        
        return students;
    }

    public class Student {
        private String name;
        private int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return name + " - " + age;
        }
    }

    public static void main (String[] args) {
        PrimarySchoolStudents pss = new PrimarySchoolStudents();
        Student[] students = pss.generateStudents();
        List<Student> sortedStudents = pss.sortStudentsByAgeOnly(students);
        for(Student s : sortedStudents) {
            System.out.println(s.toString());
        }

    }
}
//cheers
