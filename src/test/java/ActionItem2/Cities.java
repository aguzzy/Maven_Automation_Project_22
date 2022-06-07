package ActionItem2;

import java.util.ArrayList;
import java.util.concurrent.LinkedTransferQueue;

public class Cities {
    public static void main(String[] args) {

        ArrayList<String>Cities = new ArrayList<>();
        Cities.add("Brooklyn");
        Cities.add("Queens");
        Cities.add("Manhattan");
        Cities.add("Staten Island");


        for ( int i = 0; i < Cities.size(); i++) {

            if (Cities.get(i) == "Brooklyn" || Cities.get(i) == "Manhattan") {
                System.out.println("My city is " + Cities.get(i));
            }
        }
    }// end of main
}//end of ActionItem
