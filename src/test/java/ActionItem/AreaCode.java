package ActionItem;

public class AreaCode {
    public static void main(String[] args) {

        //create String LinearArray for Region
        String[] Region = new String[]{"Manhattan","Brooklyn","Queens","Staten Island"};

        //create Integer LinearArray for AreaCode
        int[] AreaCode = new int[]{212,347,718,917};

        //initialize your starting point before calling while loop
        int i = 0;

        while (i < AreaCode.length){
        System.out.println("The AreaCode for "+ Region[i] + " is " + AreaCode[i]);

            //incrementing
            i = i +1;
        }

    }//end of main
}//end of action item
