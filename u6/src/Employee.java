import java.util.*;

public class Employee implements Comparable<Employee>,Cloneable {
    private double salary;
    private String name;
    private Date hireDay;

    public Employee(double salary, String name) {
        this.salary = salary;
        this.name = name;
        this.hireDay=new GregorianCalendar(2000,12,4).getTime();
    }

    public Employee(double salary, String name, Date hireDay) {
        this.salary = salary;
        this.name = name;
        this.hireDay = hireDay;
    }

    public int compareTo(Employee other) {
        return Double.compare(salary, other.salary);
    }

    public Employee clone() throws CloneNotSupportedException{
        Employee cloned=(Employee) super.clone();
        cloned.hireDay=(Date)hireDay.clone();
        return cloned;
    }
//    上面的方法实现接口更好
//    public int compareTo(Object otherObject){
//        Employee other=(Employee) otherObject;
//        return Double.compare(salary,other.salary);
//    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }



    public Date getHireDay() {
        return hireDay;
    }

    public void setHireDay(Date hireDay) {
        this.hireDay = hireDay;
    }


    public static void main(String[] args) {
        //对象数组排序,需要使用Comparable接口
        Employee[] staff=new Employee[3];
        staff[0]=(new Employee(7000,"tom"));
        staff[1]=(new Employee(5000,"tim"));
        staff[2]=(new Employee(6000,"torry"));

        Arrays.sort(staff);
        for(Employee e:staff)
            System.out.println(e.name+" "+e.salary);
    }

    public void raiseSalary(double add){
        this.salary+=add;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "salary=" + salary +
                ", name='" + name + '\'' +
                ", hireDay=" + hireDay +
                '}';
    }
}
