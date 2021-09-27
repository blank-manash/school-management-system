package entities;

import java.util.TreeSet;

public class Teacher implements Comparable<Teacher> {
	private String name;
	private TreeSet<Subject> courses;
	public Subject[] getCourses() {
		return (Subject[]) courses.toArray();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addCourse(Subject s) {
		this.courses.add(s);
	}

	@Override
	public int compareTo(Teacher o) {
		return name.compareTo(o.name);
	}

}
