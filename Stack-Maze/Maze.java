
import java.io.PrintStream;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Maze {

  public static final char WALL = '*', EMPTY = '.', VISITED = '+', DEADEND = '-', START = '0';

  /** Representation of maze as a mutable char array. */
  private final char[][] mazeData;






  /**
   * Constructs a maze instance from a nonempty list of same-length strings. Each string represents
   * a row in the maze.
   *
   * @param rawData a nonempty list of same-length strings
   * @throws IllegalArgumentException if rawData is empty or some strings are longer than others
   */
  public Maze(final List<String> rawData) {

    this(rawData.toArray(new String[0]));  
  }





  /**
   * Constructs a maze instance from a nonempty array of same-length strings. Each string represents
   * a row in the maze.
   *
   * @param rawData a nonempty array of same-length strings
   * @throws IllegalArgumentException if rawData is empty or some strings are longer than others
   */
  public Maze(final String[] rawData) {
    // TODO your job
    // make sure raw data is not empty
     if(rawData == null){
       throw new IllegalArgumentException();
     }
     else{
       mazeData = new char[rawData.length][rawData[0].toCharArray().length];  // the second brackets creates columns by taking in the first row and counting the chars through .toChar and . length
       // ^initialize char array
       for(int i = 0; i < rawData.length;i++){
         mazeData[i] = rawData[i].toCharArray();
         //^populate char array from raw data, checking consistent width in the process
       }
     }
 

  

  }




  /**
   * Prints the maze to the given destination.
   *
   * @param output the output destination
   */

  public void print(final PrintStream output) {
    // TODO your job
    // print row by row
    PrintStream rowPrinter = new PrintStream(output);
    for ( char[] x : mazeData){
      rowPrinter.println(x);
    }
  }



  /**
   * Attempts to find a way out of this maze from the given starting position.
   *
   * @param //row the row (y) index of the starting position
   * @param //col the row (x) index of the starting position
   * @return whether or not there is a way out
   * @throws IllegalArgumentException if the starting position is outside the maze
   */
  public boolean solve(final int startRow, final int startCol) {

    // TODO
    // validate arguments: ensure position is within maze area

    if(mazeData [startRow][startCol] == WALL) {
      throw new IllegalArgumentException(" we're in a wall buddy");
    }
    else if (startRow > mazeData.length-1 || startCol > mazeData.length-1 ){
      throw new IllegalArgumentException(" we're out of bounds ");
    }





    // TODO create local class for row/col positions
    class Position {
      private int row;
      private int col;

      // TODO add instance variables
      public Position(final int row, final int col) {
        this.row = row;
        this.col= col;
      }



      // TODO toString if desired
      public String toString() {
        return "Row: " + this.row + "Column: "+ this.col;
      }


    }


    // define the stack (work queue)
    final var queue = Collections.asLifoQueue(new LinkedList<Position>());
    //Queue<Position>  queue = new LinkedList<Position>();  // EXTRA CREDIT PART 2

    // put starting position in queue
    queue.add(new Position(startRow, startCol));





    // look for a way out of the maze from the current position
    while (!queue.isEmpty()) {


      final Position pos = queue.remove();

      // if this is a wall, then ignore this position (and skip the remaining steps of the loop body)
      if (mazeData [pos.row][pos.col]== WALL){
        continue; // jumps to next spot in que , by skipping to next iteration of loops by saying continue
      }


      // otherwise mark this place as visited (drop a breadcrumb)
      if (mazeData [pos.row][pos.col]== VISITED){
        continue; // jumps to next spot in que , by skipping to next iteration of loops by saying continue
      }
      else if(mazeData [pos.row][pos.col]== EMPTY){
        mazeData [pos.row][pos.col]= VISITED;
      }

      // if we're already on the perimeter, then this is a way out and we should return success (true) right away
      if (pos.row == 0|| pos.col ==0 || pos.row == mazeData.length-1 || pos.col == mazeData[0].length-1){
        mazeData[startRow][startCol] = START;
        return true;
      }

      queue.add(new Position(pos.row+1,pos.col ));//down
      queue.add(new Position(pos.row-1,pos.col ));//up
      queue.add(new Position(pos.row,pos.col-1 )); //left
      queue.add(new Position(pos.row, pos.col + 1)); //right


    }//end of while



    // mark starting position
    mazeData[startRow][startCol] = START;

    // if we've looked everywhere but haven't gotten out, then return failure (false)
    return false;
  }//end of solve

  




  /**
   * Returns the char at the given row and column. Mainly for testing.
   *
   * @param row the row
   * @param col the column
   * @return the char at the given row and column
   * @throws IndexOutOfBoundsException if the row or column are outside the valid range
   */
  public char get(final int row, final int col) {
    // TODO your job
    return mazeData [row][col] ;


  };
}
