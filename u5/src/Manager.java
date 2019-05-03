public class Manager extends Employee {

    public Manager(int age, int wage, String name, int bonus) {
        super(age, wage, name);
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }
    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getWage(){
        return super.getWage()+this.bonus;
    }

    @Override
    public String getDescription(){
        return "I'm Manager,my name is "+super.getName();//此处无法直接访问name,因为name是private,不是protected
    }
    @Override
    public boolean equals(Object otherObject){
        if(!super.equals(otherObject)) return false;
        Manager other=(Manager) otherObject;
        return bonus==other.bonus;
    }

    private int bonus;
    public static void main(String[] args) {
        Manager boss=new Manager(23,3400,"tom",500);

        Employee[] staff =new Employee[3];

        staff[0]=boss;
        staff[1]=new Employee(25,10000,"smith");
        staff[2]=new Employee(27,13000,"jerry");


        for(Employee e:staff)
            System.out.println("name:"+e.getName()+" wage:"+e.getWage()+" is instance of Manager?"+(e instanceof Manager));
    }
}
