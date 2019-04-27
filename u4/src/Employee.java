import java.time.LocalDate;
import java.util.Random;

class Employee {
    private static int nextId = 1;

    private String name="";
    private double salary;
    private LocalDate hireDay;
    private int id;

    // static initialization block
    static
    {
        Random generator = new Random();
        // set nextId to a random number between 0 and 9999
        nextId = generator.nextInt(10000);
    }

    // object initialization block
    {
        id = nextId;
        nextId++;
    }

    public Employee(String n, double s, int year, int month, int day) {
        this.name = n;
        this.salary = s;
        this.hireDay = LocalDate.of(year, month, day);
        this.id = 0;
    }

    public Employee(String n, double s) {
        this.name = n;
        this.salary = s;
        this.id = 0;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public void setId() {
        this.id = this.nextId;
        this.nextId++;
    }

    public static int getNextId() {
        return nextId;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    public static void main(String[] args) {
        Employee e = new Employee("gsgsgsg", 100000, 1999, 4, 4);
        System.out.println(e.getName() + " " + e.getSalary());
    }
}

