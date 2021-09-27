package entities;

import java.util.TreeSet;

public class Teacher implements Comparable<Teacher> {
	private String name;
	private final TreeSet<Subject> courses = new TreeSet<>();

	public void addCourse(final Subject s) {
		this.courses.add(s);
	}

	@Override
	public int compareTo(final Teacher o) {
		return name.compareTo(o.name);
	}

	public Subject[] getCourses() {
		return (Subject[]) courses.toArray();
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

}
