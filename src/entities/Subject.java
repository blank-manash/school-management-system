package entities;

import java.util.TreeSet;

public class Subject implements Comparable<Subject> {
	private String name = "";
	private String code = "";
	private Integer price;
	private String teacher = "";
	private final TreeSet<String> students = new TreeSet<>();

	public Subject(final String name, final String code, final Integer price, final String teacher) {
		this.name = name;
		this.code = code;
		this.price = price;
		this.teacher = teacher;
	}

	public void addStudent(final Student s) {
		this.students.add(s.getName());
	}

	@Override
	public int compareTo(final Subject o) {
		return name.compareTo(o.name);
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public Integer getPrice() {
		return price;
	}

	public String getTeacher() {
		return teacher;
	}

	public boolean hasStudent(final String name) {
		return students.contains(name);
	}

	public void setCode(final String code) {
		this.code = code;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public void setPrice(final Integer price) {
		this.price = price;
	}

	public void setTeacher(final String teacher) {
		this.teacher = teacher;
	}

}
