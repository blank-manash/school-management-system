package entities;

import java.util.TreeSet;

public class Teacher implements Comparable<Teacher> {
	private String name;
	private final TreeSet<String> courses = new TreeSet<>();

	public void addCourse(final Subject s) {
		this.courses.add(s.getName());
	}

	@Override
	public int compareTo(final Teacher o) {
		return name.compareTo(o.name);
	}

	public String[] getCourses() {
		return (String[]) courses.toArray();
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public void removeCourse(String name2) {
		this.courses.remove(name2);
	}

}
