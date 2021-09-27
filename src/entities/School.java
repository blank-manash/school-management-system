package entities;

import java.util.Scanner;
import java.util.TreeMap;

public class School {
	private final static Scanner sc = new Scanner(System.in);
	private TreeMap<String, Teacher> teachers = new TreeMap<>();
	private TreeMap<String, Student> students = new TreeMap<>();

	private TreeMap<String, Subject> courses = new TreeMap<>();

	public void addCourse() {
		System.out.println("Enter Course Details : ");
		// Scanner sc = new Scanner(System.in);
		String name = sc.next();
		String code = sc.next();
		Integer price = sc.nextInt();
		String teacher = sc.next() + " " + sc.next();
		Subject s = new Subject(name, code, price, teacher);

		if (!teachers.containsKey(teacher)) {
			System.out.println("Teacher is Not Registered");
			// sc.close()
			return;
		}

		while (sc.hasNext()) {
			String st = sc.next() + " " + sc.next();
			if (this.students.containsKey(st)) {
				s.addStudent(students.get(st));
				students.get(st).addCourse(s);

			} else {
				System.out.println("Student " + st + " is not registered");
				// sc.close()
				return;
			}
		}
		// sc.close()
		this.courses.put(name, s);
		succ();
	}
	
	public void addStudent() {
		System.out.println("Enter Student Details :");
		// Scanner sc = new Scanner(System.in);
		String name = sc.next() + " " + sc.next();
		Integer grade = sc.nextInt();
		Student s = new Student();
		s.setGrade(grade);
		s.setName(name);
		
		students.put(name, s);
		succ();
		// sc.close()
	}

	public void addTeacher() {
		System.out.println("Enter Teacher Details");
		// Scanner sc = new Scanner(System.in);
		String name = sc.next() + " " + sc.next();
		Teacher t = new Teacher();
		t.setName(name);

		teachers.put(name, t);
		succ();
		// sc.close()
	}

	public void feesOfStudent() {
		System.out.println("Enter Student Name");
		// Scanner sc = new Scanner(System.in);
		String st = sc.next() + " " + sc.next();
		// sc.close()
		System.out.println(this.students.get(st).fees());

	}

	public void listCoursesForStudent() {
		System.out.println("Enter Course Name : ");
		// Scanner sc = new Scanner(System.in);
		String name = sc.next();
		// sc.close()
		students.get(name).getCoursesName().forEach(System.out::println);
	}

	public void listPopulation() {
		System.out.println("Teachers\n------------------");
		teachers.keySet().forEach(System.out::println);
		System.out.println("\nStudents\n-----------------");
		students.keySet().forEach(System.out::println);
	}

	public void listStudentByGrade() {
		Integer g = sc.nextInt();
		System.out.println("Students with grade " + g + "\n-------------------");
		students.values().stream().filter((s) -> s.getGrade() == g).forEach(System.out :: println);

	}

	public void listStudentBySubject() {
		System.out.println("Enter Course Name : ");
		// Scanner sc = new Scanner(System.in);
		String course = sc.next();
		// sc.close()
		for (Student s : students.values()) {
			if (s.getCoursesName().contains(course)) {
				System.out.println(s.getName());
			}
		}

	}

	public void listSubjectOfStudent() {
		System.out.println("Enter Student Name : ");
		// Scanner sc = new Scanner(System.in);
		String std = sc.next() + " " + sc.next();
		// sc.close()
		this.students.get(std).getCoursesName().forEach(System.out::println);
	}

	public void listSubjectsOfTeacher() {
		System.out.println("Enter Name of Teacher : ");
		// Scanner sc = new Scanner(System.in);
		String name = sc.next() + " " + sc.next();
		// sc.close()
		for (Subject s : teachers.get(name).getCourses()) {
			System.out.println(s.getName());
		}
	}

	public void listTeachers() {
		System.out.println("Teachers\n---------------------");
		teachers.keySet().forEach(System.out::println);
	}

	private final void succ() {
		System.out.println("\nOperation Done Successfully! Please Select a new Choice");
	}

}
