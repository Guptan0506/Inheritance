public class Person
{
    private String IDNum;
    private String firstName;
    private String lastName;
    private String title;
    private int YOB;

    //Constructor

    public Person(String IDNum, String firstName, String lastName, String title, int YOB) {
        this.IDNum = IDNum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.YOB = YOB;
    }

    //Getters and Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getIDNum() {
        return IDNum;
    }

    public void setIDNum(String IDNum) {
        this.IDNum = IDNum;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYOB() {
        return YOB;
    }

    public void setYOB(int YOB) {
        this.YOB = YOB;
    }
    //Override toString()
    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", IDNum='" + IDNum + '\'' +
                ", lastName='" + lastName + '\'' +
                ", title='" + title + '\'' +
                ", YOB=" + YOB +
                '}';
    }

    /**
     * Convert the Person object to a CSV data string.
     * @return a csv data string that can be written to a text file
     */
    public String toCSVDataString()
    {
        return IDNum + ", " + firstName + ", " + lastName + ", " + title + ", " + YOB;
    }

    public String fullName()
    {
        return firstName + " " + lastName;
    }

    public String formalName()
    {
        return title + " " + firstName + " " + lastName;
    }

    public String getAge() {
        int currentYear = java.time.Year.now().getValue();
        int age = currentYear - YOB;
        return Integer.toString(age);
    }

    public String getAge(int year) {
        int age = year - YOB;
        return Integer.toString(age);
    }


    public String toXMLDataString()
    {
        return "<Person>\n" +
                "   <IDNum>" + IDNum + "</IDNum>\n" +
                "   <FirstName>" + firstName + "</FirstName>\n" +
                "   <LastName>" + lastName + "</LastName>\n" +
                "   <Title>" + title + "</Title>\n" +
                "   <YOB>" + YOB + "</YOB>\n" +
                "</Person>";
    }

    public String toJSONDataString()
    {
        return "{ \"IDNum\": \"" + IDNum +
                "\", \"firstName\": \"" + firstName +
                "\", \"lastName\": \"" + lastName +
                "\", \"title\": \"" +
                title + "\", \"YOB\": " +
                YOB + " }";
    }



}
