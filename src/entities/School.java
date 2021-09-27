package entities;

import java.util.Scanner;
import java.util.TreeMap;

public class School {
	private final static Scanner sc = new Scanner(System.in);
	private final TreeMap<String, Teacher> teachers = new TreeMap<>();
	private final TreeMap<String, Student> students = new TreeMap<>();

	private final TreeMap<String, Subject> courses = new TreeMap<>();

	public void addCourse() {
		System.out.println("Enter Course Details : ");
		// Scanner sc = new Scanner(System.in);
		final String name = sc.next();
		final String code = sc.next();
		final Integer price = sc.nextInt();
		final String teacher = sc.next() + " " + sc.next();
		final Subject s = new Subject(name, code, price, teacher);

		if (!teachers.containsKey(teacher)) {
			System.out.println("Teacher is Not Registered");
			// sc.close()
			return;
		}
		Integer num = sc.nextInt();
		while (num-- > 0) {
			final String st = sc.next() + " " + sc.next();
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
		final String name = sc.next() + " " + sc.next();
		final Integer grade = sc.nextInt();
		final Student s = new Student();
		s.setGrade(grade);
		s.setName(name);

		students.put(name, s);
		succ();
		// sc.close()
	}

	public void addTeacher() {
		System.out.println("Enter Teacher Details");
		// Scanner sc = new Scanner(System.in);
		final String name = sc.next() + " " + sc.next();
		final Teacher t = new Teacher();
		t.setName(name);

		teachers.put(name, t);
		succ();
		// sc.close()
	}

	public void feesOfStudent() {
		System.out.println("Enter Student Name");

		final String st = sc.next() + " " + sc.next();

		final Integer ret = this.courses.values().stream().filter(s -> s.hasStudent(st)).map(Subject::getPrice)
				.reduce(0, Integer::sum);

		System.out.println(ret);

	}

	public void listCoursesForStudent() {
		System.out.println("Enter Course Name : ");
		// Scanner sc = new Scanner(System.in);
		final String name = sc.next();
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
		final Integer g = sc.nextInt();
		System.out.println("Students with grade " + g + "\n-------------------");
		students.values().stream().filter(s -> s.getGrade() == g).forEach(System.out::println);

	}

	public void listStudentBySubject() {
		System.out.println("Enter Course Name : ");
		// Scanner sc = new Scanner(System.in);
		final String course = sc.next();
		// sc.close()
		for (final Student s : students.values()) {
			if (s.getCoursesName().contains(course)) {
				System.out.println(s.getName());
			}
		}

	}

	public void listSubjectOfStudent() {
		System.out.println("Enter Student Name : ");
		// Scanner sc = new Scanner(System.in);
		final String std = sc.next() + " " + sc.next();
		// sc.close()
		this.students.get(std).getCoursesName().forEach(System.out::println);
	}

	public void listSubjectsOfTeacher() {
		System.out.println("Enter Name of Teacher : ");
		// Scanner sc = new Scanner(System.in);
		final String name = sc.next() + " " + sc.next();
		// sc.close()
		for (final Subject s : teachers.get(name).getCourses()) {
			System.out.println(s.getName());
		}
	}

	public void listTeachers() {
		System.out.println("Teachers\n---------------------");
		teachers.keySet().forEach(System.out::println);
	}

	private final void succ() {
		System.out.println("\n----------------------------------");
		System.out.print("Operation Done Successfully! Please Select a new Choice : ");
	}

}
