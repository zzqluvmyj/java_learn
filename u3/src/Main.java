/**
 * 第3章主要讲解一些基本的java程序设计概念
 * 本文件中有简单输入输出,数据类型,操作符,枚举类型,String,StringBuilder,
 * 注释,文档api使用,格式化输出,文件输入输出,控制语句(if,while,do-while,for,switch,带标签的break类似goto,continue,)
 * 大数值(BigInteger,BigDecimal),数组,for each 循环,数组复制,命令行参数,
 * 二维数组
 * 这是java文档注释的测试
 */
//行注释
/*
多行注释
*/

import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

import static java.lang.Math.*;

public class Main {
    public static final double INCH = 2.54;//类常量

    enum Size {SMALL, MEDIUM, LARGE, EXTRA_LARGE}

    ;//枚举不能为本地类型

    public static void main(String[] args) throws IOException {
        System.out.println("Hello World!");
        System.out.println(1_0000_0000);//下划线会在编译时删除,只是为了可读性
        System.out.println(Double.isNaN(10));
        int a;
        short b;
        long c;
        byte d;
        float e;
        double f;
        boolean g;
        final double DOU = 0.34;//final表示常量
        double x = 4;
        double y = Math.sqrt(x);
        System.out.println(y);
        System.out.println(Math.pow(x, y));

        double x1 = 9.999;
        int x2 = (int) x1;//强制类型转换

        //+=
        //++,--
        //==,!=,<,>,<=,>=

        //位运算符
        //& | ^ ~

        //&& || !

        //枚举类型
        Size s = Size.LARGE;

        String str = "";
        String greeting = "你好啊hello";
        str = greeting.substring(0, 3);
        str = str + greeting;
        //字符串不可变,变的只是指针
        System.out.println(str.equals(str));
        //忽略大小写检测字符串是否相等s.equalsIgnoreCase(s)
        ///////////////////////无法使用==来判断字符串是否相等
        //str.length()返回UTF-16编码的自定字符串所需要的代码单元数量
        //null
        //码点数量
        int cpCount = greeting.codePointCount(0, greeting.length());
        System.out.println(greeting.length());
        System.out.println(cpCount);
        System.out.println(greeting.charAt(1));
        System.out.println(greeting.codePointAt(0));
        int index = greeting.offsetByCodePoints(0, 1);
        int cp = greeting.codePointAt(index);//得到第1个码点
        System.out.println(index);
        System.out.println(cp);
        //码点到底是什么?
        //代码单元是组成字符的最小单位,因为utf-16,所以有些字符可能需要多个代码单元
        //代码点就是实际的字符
        //所以length()计算代码单元,CodePointCount()计算代码点
        //所以码点是实际的字符数,代码单元是比较底层的
        //码点是一个数字


        //构建字符串,高效拼接字符串
        StringBuilder builder = new StringBuilder();
        builder.append("dsgg");
        builder.append(100);
        String s3 = builder.toString();
        System.out.println(s3);
        //其他方法见文档

        //输入
        //Scanner in = new Scanner(System.in);
        //System.out.println("what's your name?");
        //String name=in.nextLine();//读取一行直到遇到换行符
        //System.out.println("input a word:");
        //name=in.next();//遇到空格就停止了
        //System.out.println("input a int:");
        //int h=in.nextInt();
        //System.out.println(h);
        //in.nextDouble();
        //Console cons=System.console();
        //String username=cons.readLine("username:");
        //char[] passwd=cons.readPassword("password:");
        //为了安全,将密码放在一维数组中,
        //上面代码无法运行,暂时未知原因
        //System.out.println(username);
        //System.out.println(passwd);

        //格式化输出
        System.out.printf("%10.3f\n",122.34355);
        System.out.printf("%-10.3s","gsg");
        //格式化字符串创建但不输出
        String message=String.format("hello,%s","limang");
        System.out.printf("%tc\n",new Date());
        System.out.printf("%1$s %2$tB %2$te,%2$tY\n","due date",new Date());
        System.out.printf("%s %tB %<te,%<tY\n","due date",new Date());

        //文件输入输出
        //Scanner input =new Scanner(Path.get("test.txt"),"UTF-8");//读文件
        //Scanner可以读字符串,比如Scanner input=new Scanner("gsg");
        //PrintWriter out=new PrintWriter("test.txt","UTF-8");//写文件

        BigInteger n1=BigInteger.valueOf(10000);
        BigInteger n2=BigInteger.valueOf(1000000);
        BigInteger n3=n1.add(n2);
        BigInteger n4=n3.multiply(n2);
        BigInteger n5=n3.multiply(n2).multiply(n4).multiply(n4);
        System.out.println(n3);
        System.out.println(n4);
        System.out.println(n5);

        int[] numlist=new int[100];
        int[] smallPrimes={4,56,7,5};//数组初始化
        //new int[]{4,4,53,4};//匿名数组
        //数组使用=只能传递引用,无法复制数组,使用下面的语句复制数组
        int[] copiedNumbers= Arrays.copyOf(numlist,numlist.length);//第2个参数是新复制数组的长度

        //java没有在存储程序名称到args中,比如在python中或者c++中,args[0]是程序的绝对地址名称
        for(int i=0;i<args.length;i++){
            System.out.println(args[i]);
        }

        //数组排序
        Arrays.sort(numlist);
        for(int r:numlist)
            System.out.println(r);

        int[][] nums=new int[10][10];
        for(int[] i:nums)
            for(int j:i)
                System.out.println(j);
        System.out.println(Arrays.deepToString(nums));//多维数组元素列表输出

        final int MAX=10;
        //不规则数组
        int[][] odds=new int[MAX+1][];
        for(int i=0;i<=MAX;i++){
            odds[i]=new int[i+1];
        }

        //这个java的简略写法也是够简略了,只要后面跟着一句,就不用大括号,并且在for嵌套中如果只有一个语句,哪怕它是还是for,也可以不写最外面的大括号
        //这个java语法的写法,对我这种守规矩的人来说,太棒了啊,有意思
        for(int n=0;n<odds.length;n++)
            for(int k=0;k<odds[n].length;k++){
                int lotterOdds=1;
                for(int i=1;i<=k;i++)
                    lotterOdds=lotterOdds*(n-i+1)/i;
                odds[n][k]=lotterOdds;
            }
        for(int[] row:odds){
            for(int odd:row)
                System.out.printf("%4d",odd);
            System.out.println();
        }
    }
}
