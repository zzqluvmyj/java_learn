import java.util.ArrayList;

public class Main {

    public static double max(double... values){
        double largest=Double.NEGATIVE_INFINITY;
        for(double v:values) if(v>largest) largest=v;
        return largest;
    }

    enum Size
    {
        SMALL("S"),MEDIUM("M"),LARGE("L");
        private Size(String abbr){
            this.abbr=abbr;
        }
        public  String getAbbr(){
            return this.abbr;
        }
        private String abbr;
    }

    public static void main(String[] args) {

        //1.抽象类测试
        Person[] people=new Person[2];
        people[0]=new Employee(23,200,"Tome");
        people[1]=new Manager(30,4000,"Jerry",100);

        for(Person p:people)
            System.out.println(p.getDescription());

        //2.泛型类测试
        ArrayList<Employee> staff=new ArrayList<>();
        //如果是固定大小的,在填充之前可以采用staff.ensureCapacity(num);
        //或者ArrayList<Employee> staff=new ArrayList<>(100);

        staff.add(new Employee(30,3000,"tome"));
        staff.add(new Manager(30,4355,"dsg",500));
        System.out.println("size:"+staff.size());
        //staff.trimToSize()

        //staff.set(index,value)//此处索引从0开始
        //在不存在的位置使用set会出错
        //staff.get(i)

        Employee[] a=new Employee[staff.size()];
        staff.toArray(a);

        //staff.add(index,value);
        //staff.remove(n)

        //3.装箱拆箱测试
        Integer n1=100;
        int n2=new Integer(200);
        //Integer对象比较请使用equals(),==只是比较是否引用同一对象

        Integer n=null;
        //System.out.println(n*3);
        //抛出NullPointerException异常.

        n=Integer.parseInt("1000");
        System.out.println(n);

        double max=Main.max(34.4,322.324,324,33);
        System.out.println(max);
        System.out.println(Double.NEGATIVE_INFINITY);


        //4.枚举类测试
        Size size1=Enum.valueOf(Size.class,"SMALL");
        //toString 的逆方法是静态方法 valueOf
        System.out.println(size1.getAbbr());

        //5.反射测试

    }
}
