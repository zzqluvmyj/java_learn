import java.util.GregorianCalendar;

public class CloneTest {
    public static void main(String[] args) {
        try{
            Employee original=new Employee(5000,"tom");
            Employee copy=original.clone();
            copy.raiseSalary(1000);
            copy.setHireDay(new GregorianCalendar(3000,1,4).getTime());
            System.out.println(original);
            System.out.println(copy);
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
    }
}
