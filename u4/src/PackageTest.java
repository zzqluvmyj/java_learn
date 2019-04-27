import static java.lang.System.*;
import com.horstmann.corejava.*;

public class PackageTest
{
    public static void main(String[] args)
    {
        // because of the import statement, we don't have to use
        // com.horstmann.corejava.Employee here
        //因为外面还有同名类,所以我就用完整路径了
        com.horstmann.corejava.Employee harry = new com.horstmann.corejava.Employee("Harry Hacker", 50000, 1989, 10, 1);

        harry.raiseSalary(5);

        // because of the static import statement, we don't have to use System.out here
        out.println("name=" + harry.getName() + ",salary=" + harry.getSalary());
    }
}