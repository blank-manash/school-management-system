package entities;

import java.util.TreeSet;

public class Subject implements Comparable<Subject> {
	private String name = "";
	private String code = "";
	private Integer price;
	private String teacher = "";
	private TreeSet<Student> students = new TreeSet<>();

	public void addStudent(Student s) {
		this.students.add(s);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Subject(String name, String code, Integer price, String teacher) {
		super();
		this.name = name;
		this.code = code;
		this.price = price;
		this.teacher = teacher;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	@Override
	public int compareTo(Subject o) {
		return name.compareTo(o.name);
	}

}
