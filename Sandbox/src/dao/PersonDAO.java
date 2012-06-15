package dao;

import java.util.Date;
import java.util.List;

import bean.Person;

//Interface that all PersonDAOs must support
public interface PersonDAO {
	public int insertPerson(Person person);
	public boolean updatePerson(Person person);
	public boolean deletePerson(Person person);
	public boolean deletePerson(Integer personId);
	public List<Person> getPeople(String firstNameFragment, String middleNameFragment, String lastNameFragment, Date birthDateRangeStart, Date birthDateRangeEnd, Person.Gender gender);
	public Person getPerson(Integer personId);
}