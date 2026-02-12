import java.util.*;
public class Calculator {
    public static double add(double a, double b){
        return a+b;
    }

    public static double subtract(double a, double b){
        return a-b;
    }

    public static double multiply(double a, double b){
        return a*b;
    }

    public static double divide(double a, double b){
        try{
            return a/b;
        }catch(ArithmeticException e){
            System.out.println(e);
            return -1;
        }
    }

    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int choice=0;

        while(choice!=5){
            System.out.println("Calculator");
            System.out.println("Enter your choice: ");
            System.out.println("1.Addition");
            System.out.println("2.Subtraction");
            System.out.println("3.Multiplication");
            System.out.println("4.Division");
            System.out.println("5.Exit");
            choice=sc.nextInt();

            if(choice>=1 && choice<=4){
                System.out.println("Enter first number: ");
                double num1=sc.nextDouble();
                System.out.println("Enter second number: ");
                double num2=sc.nextDouble();

                double result=0;

                switch(choice){
                    case 1:
                        result=add(num1,num2);
                        break;
                    case 2:
                        result=subtract(num1,num2);
                        break;
                    case 3:
                        result=multiply(num1,num2);
                        break;
                    case 4:
                        result=divide(num1,num2);
                        break;
                }
                System.out.println("Result: "+result);
            }
            else if(choice==5){
                System.out.println("Exiting calcualtor!");
            }
            else {
                System.out.println("Invalid choice");
            }
        }
        sc.close();
    }
}
