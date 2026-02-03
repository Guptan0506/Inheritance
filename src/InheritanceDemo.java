import java.util.ArrayList;

public class InheritanceDemo {
    public static void main(String[] args) {

        ArrayList<Worker> workers = new ArrayList<>();
        workers.add(new Worker("W123", "John", "Doe", "Worker", 1985, 20.0));
        workers.add(new Worker("W234", "Alice", "Johnson", "Worker", 1992, 18.0));
        workers.add(new Worker("W345", "Bob", "Brown", "Worker", 1978, 22.0));
        workers.add(new SalaryWorker("SW456", "Jane", "Smith", "Salary Worker", 1990, 25.0, 52000.0));
        workers.add(new SalaryWorker("SW567", "Tom", "White", "Salary Worker", 1988, 30.0, 78000.0));
        workers.add(new SalaryWorker("SW678", "Emma", "Davis", "Salary Worker", 1995, 28.0, 65000.0));

        //Write a loop that simulates 3 weekly pay periods. Week 1 is a 40 hour week. For week 2  assume it is crunch time and everyone worked 50 hours. Week 3 is back to normal with 40 hours. Generate a display showing the weekly pay for each of the workers for each week in a reasonable tabular format.
        int[] hoursWorked = {40, 50, 40};

        for (int week = 0; week < hoursWorked.length; week++) {
            System.out.println("====================================================");
            System.out.println("                 WEEK " + (week + 1) + " PAYROLL");
            System.out.println("====================================================");
            System.out.printf("Hours Worked: %d%n%n", hoursWorked[week]);

            System.out.printf("%-12s %-15s %-15s %-12s%n",
                    "ID", "Name", "Type", "Weekly Pay");
            System.out.println("----------------------------------------------------");

            for (Worker w : workers) {
                double pay = w.calculateWeeklyPay(hoursWorked[week]);

                String type = (w instanceof SalaryWorker) ? "SalaryWorker" : "Worker";
                String fullName = w.getFirstName() + " " + w.getLastName();

                System.out.printf("%-12s %-15s %-15s $%-12.2f%n",
                        w.getIDNum(), fullName, type, pay);
            }

            System.out.println();
        }
    }
}