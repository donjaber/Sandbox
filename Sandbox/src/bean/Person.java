package bean;

import java.util.Date;

public class Person {
	public enum Gender {
		MALE {public String toString() {return "M";}},
		FEMALE {public String toString() {return "F";}},
		OTHER {public String toString() {return "O";}}
	}
	
	private Integer id;
	private String aliasName;
	private String firstName;
	private String middleName;
	private String lastName;
	private String fullName;
	private Date birthDate;
	private Gender gender;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAliasName() {
		return aliasName;
	}
	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public void setGender(String gender) {
		for (Gender g : Gender.values()) {
			if (g.toString().equalsIgnoreCase(gender)) {
				this.gender = g;
				break;
			}
		}
	}
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("PERSON\n");
		sb.append("Id:\t\t" + this.id + "\n");
		sb.append("Full Name:\t" + this.fullName + "\n");
		sb.append("Alias Name:\t" + this.aliasName + "\n");
		sb.append("First Name:\t" + this.firstName + "\n");
		sb.append("Middle Name:\t" + this.middleName + "\n");
		sb.append("Last Name:\t" + this.lastName + "\n");
		sb.append("BirthDate:\t" + this.birthDate + "\n");
		sb.append("Gender:\t\t" + this.gender);
		
		return sb.toString();
	}
}