package ReusableLibraries;

import net.bytebuddy.asm.Advice;

import javax.xml.transform.Result;

public class ReusableMethods {

    //create a void method to add two numbers
    public static void addTwoNumbers(int num1, int num2){
        int result = num1+num2;
        System.out.println("The result of two numbers is " + result);
    }//end of add two number method

    //create a return integer method to subtract two numbers

    public static int subtractTwoNumbers(int a, int b){

        int result = a - b;
        System.out.println("The result of two numbers for subtraction is " + result);

        return result;

    }//end of subtrack two numbers method

}//end of java class