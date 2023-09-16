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

    static HashMap<Integer, Integer> scoreboardHash = new HashMap<Integer, Integer>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("1. Första versionen \n" +
                "2. HashMap-versionen");
        int choice = scanner.nextInt();
        scanner.nextLine();

        //Run hashmap version
        if (choice == 2) {

            //Create list
            createList(myList);
            System.out.println(myList);
            System.out.println("-----");

            //Display hashmap
            createHashMapList(scoreboardHash, myList);
            System.out.println(scoreboardHash);

        } else { //Run standard version

            //Create list
            createList(myList);
            System.out.println(myList);
            System.out.println("-----");

            //Sort & Show list
            sortList(myList);
            showSortedList(myList);
            System.out.println("-----");

            //Get the highest number
            int highest = showHighestUnique(myList);

            if (highest == -1) {
                System.out.println("Det finns inget unikt heltal.");
            } else {
                System.out.println(highest);
            }
        }

    }

    static int showHighestUnique(ArrayList<Integer> myList) {

        //Loop thru list to check which number is the highest
        for (int i = 0; i < NUMBER_OF_ROWS; i++) {

            int currentNumber = myList.get(i);
            if (Collections.frequency(myList, currentNumber) == 1) {
                return currentNumber; //return highest unique. If more than 1, it is not unique; The loop will stop and return value if freq. in list is 1. If more than 1 it will continue to run until next one is found.
            }
        }
        return -1; //fallback
    }

    static void showSortedList(ArrayList<Integer> myList) {

        for (int number : myList) {
            System.out.println("- " + number);
        }
    }

    static ArrayList<Integer> sortList(ArrayList<Integer> myList) {

        //Sort arraylist from highest to lowest
        Collections.sort(myList, Collections.reverseOrder());

        return myList;
    }

    //Create list of random numbers. 1-50.
    static ArrayList<Integer> createList(ArrayList<Integer> myList) {

        for (int i = 0; i < NUMBER_OF_ROWS; i++) {

            int random = (int) (Math.random() * 50 + 1);
            myList.add(random);
        }

        return myList;
    }

    static HashMap<Integer, Integer> createHashMapList(HashMap<Integer, Integer> scoreboardHash, ArrayList<Integer> myList) {


        for (int number : myList) {
            scoreboardHash.put(number, 0);
        }

        for (int checkNumber : myList) {
            if (scoreboardHash.containsKey(checkNumber)) {

                int updateValue = scoreboardHash.get(checkNumber);
                scoreboardHash.put(checkNumber, updateValue + 1);
            }
        }

        return scoreboardHash;
    }
}