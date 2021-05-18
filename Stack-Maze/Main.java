
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

  public static void main(final String[] args) {

    // create scanner for data input
    final var input = new Scanner(System.in);

    // TODO read row and column for the starting point
    final var startRow = input.nextInt();
    final var startCol = input.nextInt();


    // TODO read maze data as rows
    final var rawData = new ArrayList<String>();
   while( input.hasNextLine()){   // add each row line by line

     rawData.add(input.next()); // add each element in row

   }



    // TODO read one line at a time into rawData

    // attempt to solve the maze and print the result
    final var maze = new Maze(rawData);
    final var result = maze.solve(startRow, startCol);
    maze.print(System.out);
    System.out.println();
    System.out.println(result ? "We're so out of here!" : "Bummer, we're stuck...");
  }
}
