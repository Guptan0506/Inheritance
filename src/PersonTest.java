import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    private Person person;

    @BeforeEach
    public void setUp() {
        person = new Person("12345", "John", "Smith", "Mr.", 2000);
    }

    @Test
    public void testConstructorAndGetters() {
        assertEquals("12345", person.getIDNum());
        assertEquals("John", person.getFirstName());
        assertEquals("Smith", person.getLastName());
        assertEquals("Mr.", person.getTitle());
        assertEquals(2000, person.getYOB());
    }

    @Test
    public void testSetters() {
        person.setIDNum("99999");
        person.setFirstName("Alex");
        person.setLastName("Johnson");
        person.setTitle("Dr.");
        person.setYOB(1995);

        assertEquals("99999", person.getIDNum());
        assertEquals("Alex", person.getFirstName());
        assertEquals("Johnson", person.getLastName());
        assertEquals("Dr.", person.getTitle());
        assertEquals(1995, person.getYOB());
    }

    @Test
    public void testFullName() {
        assertEquals("John Smith", person.fullName());
    }

    @Test
    public void testFormalName() {
        assertEquals("Mr. John Smith", person.formalName());
    }

    @Test
    public void testToCSVDataString() {
        String expected = "12345, John, Smith, Mr., 2000";
        assertEquals(expected, person.toCSVDataString());
    }

    @Test
    public void testToJSONDataString() {
        String expected = "{ \"IDNum\": \"12345\", \"firstName\": \"John\", \"lastName\": \"Smith\", \"title\": \"Mr.\", \"YOB\": 2000 }";
        assertEquals(expected, person.toJSONDataString());
    }

    @Test
    public void testToXMLDataString() {
        String expected =
                "<Person>\n" +
                        "   <IDNum>12345</IDNum>\n" +
                        "   <FirstName>John</FirstName>\n" +
                        "   <LastName>Smith</LastName>\n" +
                        "   <Title>Mr.</Title>\n" +
                        "   <YOB>2000</YOB>\n" +
                        "</Person>";

        assertEquals(expected, person.toXMLDataString());
    }

    @Test
    public void testGetAgeCurrentYear() {
        int currentYear = java.time.Year.now().getValue();
        int expectedAge = currentYear - 2000;
        assertEquals(Integer.toString(expectedAge), person.getAge());
    }

    @Test
    public void testGetAgeSpecificYear() {
        assertEquals("20", person.getAge(2020));
    }
}