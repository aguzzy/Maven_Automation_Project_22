package ActionItem2;

public class Grades {

    public static void main(String[] args) {

    int Grade = 76;

        //if grade is greater than or equal to 90 and less than/equal to 100 then print result as A
        //if grade is greater than or equal to 80 and less than 90 then print result as B
        //if grade is greater than or equal to 70 and less than 80 then print result as C
        //if grade is greater than or equal to 60 and less than 70 then print result as D
        //if grade is less than 60 then print result as F

    if (Grade >= 90 && Grade <= 100){
        System.out.println("Print Grade is A");
    } else if(Grade >= 80 && Grade < 90){
        System.out.println("Print grade is B");
    } else if(Grade >= 70 && Grade <80){
        System.out.println("Print grade is C");
    } else if(Grade >= 60 && Grade <70){
        System.out.println("Print grade is D");
    } else if(Grade < 60){
        System.out.println("Print grade is F");
    }

    }//end of main
}//end of ActionItem
