package queryRunnerHandlerDemo;

/*
 * Bean与 mydb1中的stu表的列完全一样，用来测试queryRunner的Handler
 */
public class testBean {
	private String number;
	private String name;
	private int age;
	private String gender;
	
	public testBean() {
		
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
}
