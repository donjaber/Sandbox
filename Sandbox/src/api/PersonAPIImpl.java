package api;

import java.util.Date;
import java.util.List;

import dao.PersonDAO;

import bean.Person;
import bean.Person.Gender;

public class PersonAPIImpl implements PersonAPI {

	private PersonDAO personDAO;
	
	public PersonDAO getPersonDAO() {
		return personDAO;
	}

	public void setPersonDAO(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}

	@Override
	public List<Person> getPeople(String firstNameFragment,
			String middleNameFragment, String lastNameFragment,
			Date birthDateRangeStart, Date birthDateRangeEnd, Gender gender) {
		if (personDAO == null) { return null; }
		return personDAO.getPeople(firstNameFragment, middleNameFragment, lastNameFragment, birthDateRangeStart, birthDateRangeEnd, gender);
	}

	@Override
	public Person getPerson(Integer personId) {
		if (personDAO == null) { return null; }
		return personDAO.getPerson(personId);
	}
}