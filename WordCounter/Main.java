package edu.luc.cs271.wordcount;

import java.util.*;

public class Main {

  public static void main(final String[] args) throws InterruptedException {

    // set up the scanner so that it separates words based on space and punctuation
    final Scanner input = new Scanner(System.in).useDelimiter("[^\\p{Alnum}]+");

    // TODO complete this main program


    // 0. create suitable map instance
    final Map<String, Integer > wordTally = new HashMap<>();

    // 1. create a WordCounter instance
    final WordCounter wordCounter = new WordCounter(wordTally);


    // 2. use this to count the words in the input
    wordCounter.countWords(input);
    //System.err.println(wordTally);


    // 3. determine the size of the resulting map
    final int size = wordTally.size();


    // 4. create an ArrayList of that size and
    //    store the map's entries in it (these are of type Map.Entry<String, Integer>
    ArrayList<Map.Entry<String, Integer>> listForWords = new ArrayList<>(size);

    for (Map.Entry<String, Integer> entry: wordTally.entrySet()){
      listForWords.add(entry);
    }



    // 5. sort the ArrayList in descending order by count
    //    using Collections.sort and an instance of the provided comparator (after fixing the latter)
    Collections.sort(listForWords,new DescendingByCount());


    // 6. print the (up to) ten most frequent words in the text
    for (int i = 0; i <10 ; i++){
      System.out.println(listForWords.get(i).getKey()+ " | is seen | "+ listForWords.get(i).getValue()+" times");

    }

  }//end of body
}//end of main
