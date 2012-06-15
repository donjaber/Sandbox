package api;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import static junit.framework.Assert.*;
import bean.Person;

@ContextConfiguration("file:war/WEB-INF/Sandbox-servlet.xml")
public class PersonAPITests extends AbstractJUnit4SpringContextTests {
	
	@Autowired
    private PersonAPI personAPI;

    
    public void setPersonAPI(PersonAPI personAPI) {
        this.personAPI = personAPI;
    }

    @Test
    public void testGetPerson() {
        Person person = personAPI.getPerson(1);
        assertNotNull(person);
    }
    
    @Test
    public void testGetPeople() {
        List<Person> people = personAPI.getPeople("Joe", null, "Doe", null, null, null);
        assertEquals("Only one Joe Doe exists", 1, people.size());
    }
}