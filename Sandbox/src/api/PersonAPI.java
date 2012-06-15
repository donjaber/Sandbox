package api;

import java.util.Date;
import java.util.List;

import bean.Person;

public interface PersonAPI  {
	public List<Person> getPeople(String firstNameFragment, String middleNameFragment, String lastNameFragment, Date birthDateRangeStart, Date birthDateRangeEnd, Person.Gender gender);
	public Person getPerson(Integer personId);
}