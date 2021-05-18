package edu.luc.cs.cs271.mazesolver;

import java.io.PrintStream;
import java.util.List;

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
   * @param row the row (y) index of the starting position
   * @param col the row (x) index of the starting position
   * @return whether or not there is a way out
   * @throws IllegalArgumentException if the starting position is outside the maze
   */
  public boolean solve(final int row, final int col) {
    // TODO
    // validate arguments
    if(mazeData [row][col] == WALL) {
      throw new IllegalArgumentException(" we're in a wall buddy");
    }
    else if (row > mazeData.length-1 || col > mazeData.length-1 ){
      throw new IllegalArgumentException(" we're out of bounds ");
    }
    // mark starting position
    mazeData[row][col]= START;


    // invoke recursive method starting at row and col
    final boolean result = solve1(row, col);


    // return result
    return result;
  }





  /** Looks for a way out of the maze from the current position using recursive backtracking. */
  protected boolean solve1(final int row, final int col) {
    // TODO your job
    // if we're not allowed to be here, then this is not a way out
    if (mazeData[row][col] == WALL || mazeData[row][col] == DEADEND || mazeData[row][col] == VISITED ) { // if visited not here endless loop, need dead end to make all dead end streams into deadens
      return false; //base case
    }


    // otherwise mark this place as visited (drop a breadcrumb)
     if (mazeData[row][col] == EMPTY) {
      mazeData[row][col] = VISITED;
    }


    boolean result = false;
    // if we're already on the perimeter, then this is a way out
    if ((row == 0 || col == 0 || row == mazeData.length - 1 || col == mazeData[0].length - 1) && mazeData[row][col] != START) { // row 0 length is 10-1 = 9  > col 9 is right of box
      //top of box// left of box// bottom of box           // right of box
      return true; //base case
    }

    else{
      if (row <= mazeData.length - 1 && col + 1 <= mazeData[0].length - 1) {  // added to check if in bounds of perimeter
        if (solve1(row, col + 1)) {
          result = true;
        }
      }
      if (row + 1 <= mazeData.length - 1 && col <= mazeData[0].length - 1) {
        if (solve1(row + 1, col)) {
          result = true;
        }
      }
      if (row  <= mazeData.length - 1 && col -1 <= mazeData[0].length - 1) {
        if (solve1(row, col - 1)) {
          result = true;
        }
      }
      if (row -1 <= mazeData.length - 1 && col <= mazeData[0].length - 1) {
        if (solve1(row - 1, col)) {
          result = true;
        }
      }
      if (!result && mazeData[row][col] != START) {
        mazeData[row][col] = DEADEND;  // if one thing from above returns true, they all do,... so why not dead ends

      }
    }


    return result;  //return result
  }//end of solve1








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
  }
}
