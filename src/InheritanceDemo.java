import java.util.ArrayList;

public class InheritanceDemo {
    public static void main(String[] args) {
        // Create 3 Worker objects and add them to an array
//        ArrayList<Worker> workers = new ArrayList<Worker>();
//        Worker worker = new Worker("W123", "John", "Doe", "Worker", 1985, 20.0);
//        System.out.println(worker.toString());
//        worker.displayWeeklyPay(40);
//        workers.add(worker);
//
//        Worker worker1 = new Worker("W234", "Alice", "Johnson", "Worker", 1992, 18.0);
//        System.out.println(worker1.toString());
//        worker1.displayWeeklyPay(50);
//        workers.add(worker1);
//
//        Worker worker2 = new Worker("W345", "Bob", "Brown", "Worker", 1978, 22.0);
//        System.out.println(worker2.toString());
//        worker2.displayWeeklyPay(40);
//        workers.add(worker2);
//
//
//        // Create 3 SalaryWorker objects
//        SalaryWorker salaryWorker = new SalaryWorker("SW456", "Jane", "Smith", "Salary Worker", 1990, 25.0, 52000.0);
//        System.out.println(salaryWorker.toString());
//        salaryWorker.displayWeeklyPay(40);
//        workers.add(salaryWorker);
//
//        SalaryWorker salaryWorker1 = new SalaryWorker("SW567", "Tom", "White", "Salary Worker", 1988, 30.0, 78000.0);
//        System.out.println(salaryWorker1.toString());
//        salaryWorker1.displayWeeklyPay(45);
//        workers.add(salaryWorker1);
//
//        SalaryWorker salaryWorker2 = new SalaryWorker("SW678", "Emma", "Davis", "Salary Worker", 1995, 28.0, 65000.0);
//        System.out.println(salaryWorker2.toString());
//        salaryWorker2.displayWeeklyPay(40);
//        workers.add(salaryWorker2);
//
//        System.out.println(workers);

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
            System.out.println("Week " + (week + 1) + " - Hours Worked: " + hoursWorked[week]);
            for (Worker w : workers) {
                w.displayWeeklyPay(hoursWorked[week]);
            }
            System.out.println();
        }

    }
}