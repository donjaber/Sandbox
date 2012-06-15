package dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import bean.Person;
import bean.Person.Gender;
import dao.PersonDAO;

public class PersonDAOHSQL extends JdbcDaoSupport implements PersonDAO {
	
	/** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

	@Override
	public int insertPerson(Person person) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean updatePerson(Person person) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletePerson(Person person) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletePerson(Integer personId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Person getPerson(Integer personId) {
		Person person = getJdbcTemplate().queryForObject(
                "select id, first_name, middle_name, last_name, alias_name, birthdate, gender from people where id = ?", 
                new PersonMapper(),
                personId);
		return person;
	}

	@Override
	public List<Person> getPeople(String firstNameFragment,
			String middleNameFragment, String lastNameFragment,
			Date birthDateRangeStart, Date birthDateRangeEnd, Gender gender) {
		logger.info("Getting people!");
		
		String whereClause = "1=1";
		List<Object> args = new ArrayList<Object>();
		
		if (firstNameFragment != null) {
			whereClause += " and first_name like ?";
			args.add(firstNameFragment+"%");
		}
		if (middleNameFragment != null) {
			whereClause += " and middle_name like ?";
			args.add(middleNameFragment+"%");
		}
		if (lastNameFragment != null) {
			whereClause += " and last_name like ?";
			args.add(lastNameFragment+"%");
		}
		if (gender != null) {
			whereClause += " and gender like ?";
			args.add(gender.toString());
		}
		if (birthDateRangeStart != null) {
			whereClause += " and birthdate > ?";
			args.add(birthDateRangeStart);
		}
		if (birthDateRangeEnd != null) {
			whereClause += " and birthdate < ?";
			args.add(birthDateRangeEnd);
		}
        
        List<Person> people = getJdbcTemplate().query(
                "select id, first_name, middle_name, last_name, alias_name, birthdate, gender from people where " + whereClause, 
                new PersonMapper(),
                args.toArray());
        
        return people;
	}
	
    private static class PersonMapper implements ParameterizedRowMapper<Person> {
        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
            Person person = new Person();
            person.setId(rs.getInt("id"));
            person.setAliasName(rs.getString("alias_name"));
            person.setFirstName(rs.getString("first_name"));
            person.setMiddleName(rs.getString("middle_name"));
            person.setLastName(rs.getString("last_name"));
            person.setBirthDate(rs.getTimestamp("birthdate"));
            person.setGender(rs.getString("gender"));
            
            //TODO: account for null values in fullName 
            String fullName = person.getFirstName() + " " + person.getMiddleName() + " " + person.getLastName();
            person.setFullName(fullName);
            
            return person;
        }
    }
}