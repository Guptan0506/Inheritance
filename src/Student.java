public class Student extends Person{
    int gradeLevel;

    public Student(String IDNum, String firstName, String lastName, String title, int YOB) {
        super(IDNum, firstName, lastName, title, YOB);
    }

    @Override
    public String toString() {
        return "Student{" +
                super.toString() +
                "gradeLevel=" + gradeLevel +
                '}';
    }

    public Student(String IDNum, String firstName, String lastName, int YOB, int gradeLvl) {
        super(IDNum, firstName, lastName, "Student", YOB);
        this.gradeLevel = gradeLvl;
    }

    public Student(Person p, int gradeLvl) {
        super(p.getIDNum(), p.getFirstName(), p.getLastName(), p.getTitle(), p.getYOB());
        this.gradeLevel = gradeLvl;
    }
}
