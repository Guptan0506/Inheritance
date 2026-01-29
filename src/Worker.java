public class Worker extends Person{
    double hourlyPayRate;
    double overtimeHours;

    //Constructor
    public Worker(String IDNum, String firstName, String lastName, String title, int YOB, double hourlyPayRate) {
        super(IDNum, firstName, lastName, title, YOB);
        this.hourlyPayRate = hourlyPayRate;
    }

    //Setters and Getters
    public double getHourlyPayRate() {
        return hourlyPayRate;
    }

    public void setHourlyPayRate(double hourlyPayRate) {
        this.hourlyPayRate = hourlyPayRate;
    }

    @Override
    public String toString() {
        return "Worker{" +
                super.toString() +
                "hourlyPayRate=" + hourlyPayRate +
                '}';
    }

    //If the worker works 40 hours, it's 40 * hourlyPayRate
    //If the worker works more than 40 hours, it's 40 * 1.5 * hourlyPayRate

    double calculateWeeklyPay(double hoursWorked) {
        if (hoursWorked == 40) {
            return hourlyPayRate * hoursWorked;
        } else if (hoursWorked >= 40) {
            double regularPay = hourlyPayRate * 40;
            overtimeHours = hoursWorked - 40;
            double overtimePay = overtimeHours * hourlyPayRate * 1.5;
            return regularPay + overtimePay;
        }
        return hourlyPayRate * hoursWorked;
    }

    public void displayWeeklyPay(double hoursWorked) {
        double weeklyPay = calculateWeeklyPay(hoursWorked);
        System.out.println("Regular Hourly Pay Rate: $" + hourlyPayRate);
        System.out.println("Overtime hours: " + overtimeHours);
        System.out.printf("Weekly Pay for %s %s: $%.2f%n", getFirstName(), getLastName(), weeklyPay);
        return;
    }

    public String toCSVDataString() {
        super.toCSVDataString();
        return String.format("%s,%.2f", super.toCSVDataString(), hourlyPayRate);
    }

    public String toXMLDataString() {
        super.toXMLDataString();
        return String.format("%s\n\t<hourlyPayRate>%.2f</hourlyPayRate>", super.toXMLDataString(), hourlyPayRate);
    }

    public String toJSONDataString() {
        super.toJSONDataString();
        return String.format("%s,\n\t\"hourlyPayRate\": %.2f", super.toJSONDataString(), hourlyPayRate);
    }
}
