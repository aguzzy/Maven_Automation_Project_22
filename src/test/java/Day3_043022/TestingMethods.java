package Day3_043022;

import ReusableLibraries.ReusableMethods;

public class TestingMethods {

    public static void main(String[] args) {

        //call the add two number method and execute it
        ReusableMethods.addTwoNumbers(40,100);

        //call the result method and store it in a variable to preform something else
        int finalResult = ReusableMethods.subtractTwoNumbers(20,10);
        int newResult = finalResult + 10;
        System.out.println("new result is " + newResult);
    }

}//end of java class

