package Shortcuts;

import java.util.ArrayList;

public class Shortcuts {
    public static void main(String[] args) {

        //Print Command
        System.out.println("Enter Command");

        //Declaring a String with some variable
        String variable = "Enter variable"; //"" not needed if number variable

        //Declaring Integer with some variable
        int number = 00;

        //Print with Concatenation ( + )
        System.out.println("Enter statement " + variable + " enter statement " + number);

        //Creating an Array List for topic as String //SIZE
        ArrayList<String> topic = new ArrayList<>();
        topic.add("TopicDetail");
        //You can continue to add variables to the list

        //Creating an Array List for topic as Integer
        ArrayList<Integer> NumberTopic = new ArrayList<>();
        NumberTopic.add(number);
        //You can continue tp add variables to the list

        //List starts at 0 so when printing enter format to pull variable from list
        topic.get(0);  //Enter list number that variable falls on

        //Creating a Linear Array for topic as String //LENGTH
        String[] Topic = new String[]{"variable","variable1","variable2"};

        //Creating a Linear Array for topic as Integer
        int[] NumberTopic1 = new int[]{0,1,2,3};

        //ForLoop
        for (int i = 0; i < topic.size(); i++){     //can also be >= or as length is int

        }







    }//end of main method
}//end of shortcuts
