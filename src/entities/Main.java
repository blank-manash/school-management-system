package entities;

import java.util.Scanner;

public class Main {

	private final static School school = new School();
	final static Scanner sc = new Scanner(System.in);

	public static void main(final String[] args) {
		prompt();
		while (true) {

			final Integer i = sc.nextInt();
			if (i == 0) {
				break;
			} else {
				switch (i) {
				case 1:
					school.addCourse();
					break;
				case 2:
					school.addTeacher();
					break;
				case 3:
					school.addStudent();
					break;
				case 4:
					school.listPopulation();
					break;
				case 5:
					school.listTeachers();
					break;
				case 6:
					school.listStudentByGrade();
					break;
				case 7:
					school.listStudentBySubject();
					break;
				case 8:
					school.listSubjectsOfTeacher();
					break;
				case 9:
					school.listSubjectOfStudent();
					break;
				case 10:
					school.feesOfStudent();
					break;
				case 11:
					prompt();
				default:
					break;
				}
			}

		}
		System.out.println("\n Closing Application!");
	}

	public static final void prompt() {
		System.out.println("\n\nSchool Management\n======================\n");

		System.out.println("0 : Exit the Program");
		System.out.println("1 : Add a Course");
		System.out.println("2 : Add a Teacher");
		System.out.println("3 : Add a Student");
		System.out.println("4 : List All The School Population");
		System.out.println("5 : List all the teachers");
		System.out.println("6 : List all the students by grade");
		System.out.println("7 : List the students enrolled in a subject");
		System.out.println("8 : List all the subjects taught by a teacher.");
		System.out.println("9 : List all the subjects enrolled for a student.");
		System.out.println("10 : Present the fees payable by a particular student.");
		System.out.println("11 : Repeat This Prompt");

		System.out.print("Enter a choice : ");
	}

}
