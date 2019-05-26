import java.math.BigInteger;
import java.util.Objects;

public class Employee extends Person {
    private int age;
    private int wage;
    //private String name;//当子类和父类变量名相同,会覆盖掉父类的变量


    public Employee(int age, int wage, String name) {
        super(name);
        this.age = age;
        this.wage = wage;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWage() {
        return wage;
    }

    public void setWage(int wage) {
        this.wage = wage;
    }

    @Override
    public String getDescription() {
        return "I'm Employee,my name is " + this.getName();
    }
    @Override
    public int hashCode(){
        //此处使用静态方法来避免创建新的对象,否则需要Integer对象
//        return 7* Objects.hashCode(name)+
//                11*Integer.hashCode(wage)
//                +13*Integer.hashCode(age);
        //也可以提供多个参数,组合这些散列值
        return Objects.hash(name,wage,age);
    }

    @Override
    public boolean equals(Object otherObject){

        //1.判断是否不是引用同一个对象
        if(this==otherObject) return true;

        //2.判断另一个对象是否为null
        if(otherObject==null) return false;

        //3.如果它们的类不同,则肯定不相同
        //如果在每个子类中相等的语义有改变,就使用getClass(),如果所有子类相等的语义相同,就使用instanceof
        if(this.getClass()!=otherObject.getClass()) return false;
        //if(!(otherObject instanceof Employee)) return false;

        //4.转换
        Employee other=(Employee) otherObject;

        //5.比较域成员,如果在子类重写equals,要调用super.equals(other);
        return this.name.equals(other.name)
                && this.wage==other.wage
                && this.age==other.age;
//        return Objects.equals(this.name,other.name)
//                && this.wage==other.wage
//                && this.age==other.age;
    }

    public static void main(String[] args) {
        Employee employee1=new Employee(30,4000,"tom");
        employee1.setName("jerry");
        Employee employee2=employee1;

        System.out.println(employee1.equals(employee2));
    }
}
