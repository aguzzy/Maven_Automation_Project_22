package Day3_043022;

public class Multiple_Conditional_Statements {

    public static void main(String[] args) {

        int a = 2;
        int b = 2;
        int c = 3;

        //if a+b is less than c then print the result
        //if a+b is greater than c then print the result
        //finally print a+b is equal to c
        if (a+b < c){
            System.out.println("a & b is less that c");
        }else if(a+b > c){
            System.out.println("a & b is greater than c");
        }else {
            System.out.println("a & b is equal to c");
        }//end of conditions

        //declare additional variable
        int d = 4;
        int e = 5;
        int f = 6;
        //or operator with if statement
        // || is used for or operator -- one of the condition need to be true only
        // && is used for and operator -- both conditions need to be true
        if (d < e && f < e) {
            System.out.println("d is less than e or f is less the e");
        }else {
            System.out.println("condition is not true");
        }



    }//end of main
}//end of java class
