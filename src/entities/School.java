package entities;

import java.util.Scanner;
import java.util.TreeMap;

public class School {
	private TreeMap<String, Teacher> teachers;
	private TreeMap<String, Student> students;
	private TreeMap<String, Subject> courses;
	private TreeMap<Integer, Student> studentByGrade;

	public void listPopulation() {
		System.out.println("Teachers");
		teachers.keySet().forEach(System.out::println);
		System.out.println("Students");
		students.keySet().forEach(System.out::println);
	}

	public void listTeachers() {
		System.out.println("Teachers");
		teachers.keySet().forEach(System.out::println);
	}

	public void listStudentByGrade(int G) {
		for (Student s : studentByGrade.values()) {
			System.out.println(s.getGrade() + " : " + s.getName());
		}
	}

	public void listStudentBySubject(String course) {
		for (Student s : students.values()) {
			if (s.getCoursesName().contains(course)) {
				System.out.println(s.getName());
			}
		}
	}

	public void listSubjectsOfTeacher(String name) {
		for (Subject s : teachers.get(name).getCourses()) {
			System.out.println(s.getName());
		}
	}

	public void listCoursesForStudent(String name) {
		students.get(name).getCoursesName().forEach(System.out::println);
	}

	public void addStudent() {
		System.out.println("Enter Student Details :");
		Scanner sc = new Scanner(System.in);
		String name = sc.next() + " " + sc.next();
		Integer grade = sc.nextInt();
		Student s = new Student();
		s.setGrade(grade);
		s.setName(name);
		while (sc.hasNext()) {
			String c = sc.next();
			if (courses.containsKey(c)) {
				s.addCourse(courses.get(c));
			} else {
				System.out.println("Course " + c + " is not registered");
				sc.close();
				return;
			}
		}
		students.put(name, s);
		sc.close();
	}

	public void addTeacher() {
		System.out.println("Enter Teacher Details");
		Scanner sc = new Scanner(System.in);
		String name = sc.next() + " " + sc.next();
		Teacher t = new Teacher();
		t.setName(name);
		while (sc.hasNext()) {
			String c = sc.next();
			if (courses.containsKey(c)) {
				t.addCourse(courses.get(c));
			} else {
				System.out.println("Course " + c + " is not registered");
				sc.close();
				return;
			}
		}
		teachers.put(name, t);
		sc.close();
	}

	public void addCourse(String name, String code, Integer price, String teacher) {
		Subject s = new Subject(name, code, price, teacher);
		if(teachers.containsKey(teacher)) {
			teachers.get(teacher).addCourse(s);
		} else {
			Teacher t = new Teacher();
			t.setName(name);
			t.addCourse(s);
			teachers.put(teacher, t);
		}
		this.courses.put(name, s);
	}
}
