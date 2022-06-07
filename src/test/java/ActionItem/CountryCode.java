package ActionItem;

import java.util.ArrayList;

public class CountryCode {
    public static void main(String[] args) {
        //create ArrayList for countries
        ArrayList<String> countries = new ArrayList<>();
        countries.add("Paraguay");
        countries.add("Aruba");
        countries.add("Bolivia");
        countries.add("Ecuador");

        //create Integer ArrayList for CountryCode
        ArrayList<Integer> CountryCode = new ArrayList<>();
        CountryCode.add(595);
        CountryCode.add(297);
        CountryCode.add(591);
        CountryCode.add(593);

        for (int i = 0; i < countries.size(); i++ ){
            System.out.println("The country code for " + countries.get(i) + " is " + CountryCode.get(i));
        }
    }//end of main
}//end of action item
