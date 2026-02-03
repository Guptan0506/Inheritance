import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SalaryWorkerTest {

    private SalaryWorker salaryWorker;

    @BeforeEach
    public void setUp() {
        salaryWorker = new SalaryWorker(
                "55555",
                "John",
                "Doe",
                "Mr.",
                1985,
                25.00,
                52000.00
        );
    }

    @Test
    public void testConstructorAndGetters() {
        assertEquals("55555", salaryWorker.getIDNum());
        assertEquals("John", salaryWorker.getFirstName());
        assertEquals("Doe", salaryWorker.getLastName());
        assertEquals("Mr.", salaryWorker.getTitle());
        assertEquals(1985, salaryWorker.getYOB());
        assertEquals(25.00, salaryWorker.getHourlyPayRate());
        assertEquals(52000.00, salaryWorker.getAnnualSalary());
    }

    @Test
    public void testSetAnnualSalary() {
        salaryWorker.setAnnualSalary(60000.00);
        assertEquals(60000.00, salaryWorker.getAnnualSalary());
    }

    @Test
    public void testCalculateWeeklyPay() {
        // Salary workers always get annualSalary / 52
        double expected = 52000.00 / 52;
        assertEquals(expected, salaryWorker.calculateWeeklyPay(10));
        assertEquals(expected, salaryWorker.calculateWeeklyPay(40));
        assertEquals(expected, salaryWorker.calculateWeeklyPay(100));
    }

    @Test
    public void testToCSVDataString() {
        String expected = "55555, John, Doe, Mr., 1985,25.00,52000.00";
        assertEquals(expected, salaryWorker.toCSVDataString());
    }

    @Test
    public void testToXMLDataString() {
        String expected =
                "<Person>\n" +
                        "   <IDNum>55555</IDNum>\n" +
                        "   <FirstName>John</FirstName>\n" +
                        "   <LastName>Doe</LastName>\n" +
                        "   <Title>Mr.</Title>\n" +
                        "   <YOB>1985</YOB>\n" +
                        "</Person>\n" +
                        "\t<hourlyPayRate>25.00</hourlyPayRate>\n" +
                        "\t<annualSalary>52000.00</annualSalary>";

        assertEquals(expected, salaryWorker.toXMLDataString());
    }

    @Test
    public void testToJSONDataString() {
        String expected =
                "{ \"IDNum\": \"55555\", \"firstName\": \"John\", \"lastName\": \"Doe\", \"title\": \"Mr.\", \"YOB\": 1985 },\n" +
                        "\t\"hourlyPayRate\": 25.00,\n" +
                        "\t\"annualSalary\": 52000.00";

        assertEquals(expected, salaryWorker.toJSONDataString());
    }

    @Test
    public void testToString() {
        String result = salaryWorker.toString();
        assertTrue(result.contains("Worker{"));
        assertTrue(result.contains("hourlyPayRate"));
        assertFalse(result.contains("annualSalary"));
    }
}