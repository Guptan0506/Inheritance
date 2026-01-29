public class SalaryWorker extends Worker {
    double annualSalary;

    //Constructor
    public SalaryWorker(String IDNum, String firstName, String lastName, String title, int YOB, double hourlyPayRate, double annualSalary) {
        super(IDNum, firstName, lastName, title, YOB, hourlyPayRate);
        this.annualSalary = annualSalary;
    }

    //Setters and Getters
    public double getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(double annualSalary) {
        this.annualSalary = annualSalary;
    }

    @Override
    public double calculateWeeklyPay(double hoursWorked) {
        super.calculateWeeklyPay(hoursWorked);
        return annualSalary / 52;
    }

    @Override
    public void displayWeeklyPay(double hoursWorked) {
        double weeklyPay = calculateWeeklyPay(hoursWorked);
        System.out.println("Annual Salary: $" + annualSalary);
        System.out.printf("Weekly Pay for %s %s: $%.2f%n", getFirstName(), getLastName(), weeklyPay);
        return;
    }

    public String toCSVDataString() {
        super.toCSVDataString();
        return String.format("%s,%.2f", super.toCSVDataString(), annualSalary);
    }

    public String toXMLDataString() {
        super.toXMLDataString();
        return String.format("%s\n\t<annualSalary>%.2f</annualSalary>", super.toXMLDataString(), annualSalary);
    }

    public  String toJSONDataString() {
        super.toJSONDataString();
        return String.format("%s,\n\t\"annualSalary\": %.2f", super.toJSONDataString(), annualSalary);
    }
}
