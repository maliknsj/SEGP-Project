package application;

public class Student extends Entity{
	String name;
	int year;
	String email;
	String id;
	String pat;
	public Student(String name, String id, int year, String email, String pat) {
		this.name = name;
		this.year = year;
		this.email = email;
		this.id = id;
		this.pat = pat;
	}

	public int getYear() {
		return year;
	}

	public String getEmail() {
		return email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPat(String pat) {
		this.pat = pat;
	}

	public String getId() {
		return id;
	}

	public String getPat() {
		return pat;
	}

	public String getName() {
		return name;
	}

}
