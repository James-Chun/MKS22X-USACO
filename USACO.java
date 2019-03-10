import java.util.*;
import java.io.*;

public class USACO{
  private static int[][] pasture;


  public static int bronze(String filename) throws FileNotFoundException{
      File imput = new File(filename);  //scanning file
      Scanner directions = new Scanner(imput);

      //------------------------------------------------------------------------------------------------------

      int R = directions.nextInt();    //setting variables with values from first line
      int C = directions.nextInt();    //R is amount of rows, C is amount of columns
      int E = directions.nextInt();    //E is final elevation
      int N = directions.nextInt();    //N is number of commands

      int[][] pasture = new int[R][C]; //making pasture from values in first line

      for (int r=0;r<pasture.length;r++){
        for (int c=0;c<pasture[r].length;c++){  //adding values to pasture from the big block of numbers
          pasture[r][c]=directions.nextInt();
        }
      }

      //------------------------------------------------------------------------------------------------------

      while (N>0){  //going through all directions using N
          int row = directions.nextInt()-1;   //getting the row and columns from each set of commands
          int col = directions.nextInt()-1;
          int largest = pasture[row][col];
          int d = directions.nextInt();
          for (int r=0;r<3;r++){
            for (int c=0;c<3;c++){
              if (pasture[r+row][c+col]>largest )largest = pasture[r+row][c+col];
            }                                                                       //find largest and subtract depth from it and if the numbers in that area are
          }                                                                         //bigger than largest-depth then the cows will be able to catch up and start digging together
          for (int r=0;r<3;r++){
            for (int c=0;c<3;c++){
              if (pasture[r+row][c+col]>largest-d) pasture[r+row][c+col] = largest - d;
            }
          }
          N--;
      }

      //------------------------------------------------------------------------------------------------------

      for (int r=0;r<pasture.length;r++){   //setting the final elevation
          for (int c=0;c<pasture[r].length;c++){
              if (pasture[r][c] - E < 0 )pasture[r][c] = -1 * (pasture[r][c]-E);
              else pasture[r][c]=0;
          }
      }

      //------------------------------------------------------------------------------------------------------

      int sum = 0;    //calculating the total depth of lake
      for (int r=0;r<pasture.length;r++){
          for (int c=0;c<pasture[r].length;c++){
              sum+=pasture[r][c];
          }
      }

      //------------------------------------------------------------------------------------------------------

      return sum*72*72;
  }

  private static void dig(int row, int col, int depth){
    int largest = USACO.pasture[row][col];
    for (int r=0;r<3;r++){
      for (int c=0;c<3;c++){
        if (pasture[r][c]>largest )largest = pasture[r][c];
      }
    }
    for (int r=0;r<3;r++){
      for (int c=0;c<3;c++){
        if (pasture[r][c]>largest-depth) pasture[r][c] = largest - depth;
      }
    }


  }

  private static int calculateDepth(){
    return 1;
  }




  public static int silver(String filename){
    return 1;
  }


  public static void main(String[] args){
    try{
      System.out.println(bronze(args[0]));
    }catch(FileNotFoundException e){
      System.out.println("File Not Found");
    }
  }


}
