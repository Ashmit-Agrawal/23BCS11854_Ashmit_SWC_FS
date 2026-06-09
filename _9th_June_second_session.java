public class _9th_June_second_session {
    public static void main(String[] args) {
        Employee emp1 = new Manager(50000, 10000);
        Employee emp2 = new Developer(40000, 5000);

        emp1.calculateSalary();
        emp2.calculateSalary();

        System.out.println("Manager Salary: ₹" + emp1.getSalary());
        System.out.println("Developer Salary: ₹" + emp2.getSalary());

        emp1.displayDetails();
        emp2.displayDetails();
    }
}
class Employee{
    private double baseSalary;
    protected double salary;
    public Employee(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    void calculateSalary() {
        salary = baseSalary;
    }

    double getSalary() {
        return salary;
    }

    void displayDetails() {
        System.out.println("Base Salary: ₹" + baseSalary);
    }
}

class Manager extends Employee {
    private double bonus;
    public Manager(double baseSalary, double bonus) {
        super(baseSalary);
        this.bonus = bonus;
    }

    void calculateSalary() {
        super.salary = super.getSalary() + bonus;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Bonus: ₹" + bonus);
    }
}


class Developer extends Employee {
    private double bonus;
    public Developer(double baseSalary, double bonus) {
        super(baseSalary);
        this.bonus = bonus;
    }

    void calculateSalary() {
        super.salary = super.getSalary() + bonus;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Bonus: ₹" + bonus);
    }
}



