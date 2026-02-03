import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WorkerTest {

    private Worker worker;

    @BeforeEach
    public void setUp() {
        worker = new Worker("12345", "John", "Smith", "Mr.", 1990, 20.00);
    }

    @Test
    public void testConstructorAndGetters() {
        assertEquals("12345", worker.getIDNum());
        assertEquals("John", worker.getFirstName());
        assertEquals("Smith", worker.getLastName());
        assertEquals("Mr.", worker.getTitle());
        assertEquals(1990, worker.getYOB());
        assertEquals(20.00, worker.getHourlyPayRate());
    }

    @Test
    public void testSetHourlyPayRate() {
        worker.setHourlyPayRate(25.50);
        assertEquals(25.50, worker.getHourlyPayRate());
    }

    @Test
    public void testCalculateWeeklyPayUnder40() {
        double pay = worker.calculateWeeklyPay(30);
        assertEquals(600.00, pay);
    }

    @Test
    public void testCalculateWeeklyPayExactly40() {
        double pay = worker.calculateWeeklyPay(40);
        assertEquals(800.00, pay);
    }

    @Test
    public void testCalculateWeeklyPayOver40() {
        double pay = worker.calculateWeeklyPay(45);
        // Regular: 40 * 20 = 800
        // Overtime: 5 * 20 * 1.5 = 150
        // Total = 950
        assertEquals(950.00, pay);
    }

    @Test
    public void testToCSVDataString() {
        String expected = "12345, John, Smith, Mr., 1990,20.00";
        assertEquals(expected, worker.toCSVDataString());
    }

    @Test
    public void testToXMLDataString() {
        String expected =
                "<Person>\n" +
                        "   <IDNum>12345</IDNum>\n" +
                        "   <FirstName>John</FirstName>\n" +
                        "   <LastName>Smith</LastName>\n" +
                        "   <Title>Mr.</Title>\n" +
                        "   <YOB>1990</YOB>\n" +
                        "</Person>\n" +
                        "\t<hourlyPayRate>20.00</hourlyPayRate>";

        assertEquals(expected, worker.toXMLDataString());
    }

    @Test
    public void testToJSONDataString() {
        String expected =
                "{ \"IDNum\": \"12345\", \"firstName\": \"John\", \"lastName\": \"Smith\", \"title\": \"Mr.\", \"YOB\": 1990 },\n" +
                        "\t\"hourlyPayRate\": 20.00";

        assertEquals(expected, worker.toJSONDataString());
    }

    @Test
    public void testToString() {
        String result = worker.toString();
        assertTrue(result.contains("Worker{"));
        assertTrue(result.contains("hourlyPayRate=20.0"));
    }
}