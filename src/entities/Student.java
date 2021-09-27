package entities;

import java.util.TreeSet;

public class Student implements Comparable<Student> {
	private String name;
	private Integer grade;
	private final TreeSet<String> coursesName = new TreeSet<>();

	public void addCourse(final Subject s) {
		this.coursesName.add(s.getName());
	}

	@Override
	public int compareTo(final Student o) {
		return name.compareTo(o.name);
	}

	public TreeSet<String> getCoursesName() {
		return coursesName;
	}

	public Integer getGrade() {
		return grade;
	}

	public String getName() {
		return name;
	}

	public void setGrade(final Integer grade) {
		this.grade = grade;
	}

	public void setName(final String name) {
		this.name = name;
	}

}
