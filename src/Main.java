import java.lang.reflect.Array;
import java.util.*;

/*
Du har en lista av heltal.
Din uppgift är att skapa en funktion eller algoritm som hittar det största unika talet i listan.
Ett unikt tal är ett tal som bara förekommer en gång i listan. Om det inte finns något unikt tal ska funktionen returnera ett meddelande om detta.
Skapa även en funktion som skapar upp en lista med många tal som du kan testa med.

Version 2

Gör en ny version av funktionen där du skapar en HashMap där nycklarna är heltalen i listan och värdena är antalet gånger varje tal förekommer i listan.

 */

public class Main {
    static ArrayList<Integer> myList = new ArrayList<>();
    static final int NUMBER_OF_ROWS = 10;

    public static void main(String[] args) {

        createList(myList);
        System.out.println(myList);

        System.out.println("-----");

        showSortedList(myList);

        System.out.println("-----");
    
    }

    static void showSortedList(ArrayList<Integer> myList){

        //Sort arraylist from highest to lowest
        Collections.sort(myList, Collections.reverseOrder());

        for (int number : myList){
            System.out.println("- " + number);
        }
    }
    //Create list of random numbers.
    static ArrayList<Integer> createList(ArrayList<Integer> myList){

        for (int i = 0; i < NUMBER_OF_ROWS; i++) {

            int random = (int) (Math.random() * 50 + 1);
            myList.add(random);
        }

        return myList;
    }
}