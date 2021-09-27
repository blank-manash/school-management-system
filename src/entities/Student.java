package entities;

import java.util.TreeSet;

public class Student implements Comparable<Student> {
	private String name;
	private Integer grade;
	private TreeSet<Subject> courses;
	private TreeSet<String> coursesName;
	public TreeSet<String> getCoursesName() {
		return coursesName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public void addCourse(Subject s) {
		this.courses.add(s);
		this.coursesName.add(s.getName());
	}

	public long fees() {
		long ret = 0;
		for (Subject s : courses) {
			ret += s.getPrice();
		}
		return ret;
	}

	@Override
	public int compareTo(Student o) {
		return name.compareTo(o.name);
	}

}
