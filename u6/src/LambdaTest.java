import javax.swing.*;
import java.util.Arrays;
import java.util.Date;
import javax.swing.Timer;

public class LambdaTest {
    public static void main(String[] args) {
        String[] plants=new String[]{
                "gsgsgg","vvvvvvvvv","ddd","ddsdfg","nnnfgt","yyyyyyyyyy"
        };

        System.out.println(Arrays.toString(plants));

        System.out.println("sorted in dictionary order");
        Arrays.sort(plants);
        System.out.println(Arrays.toString(plants));

        System.out.println("sorted by length");
        Arrays.sort(plants,(first,second)->first.length()-second.length());
        System.out.println(Arrays.toString(plants));

        Timer t=new Timer(1000,(event)-> System.out.println("the time is "+new Date()));
        t.start();

        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);

    }
}
