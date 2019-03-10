import java.util.*;
import java.io.*;

public class USACO{
  private int[][] pasture;
  private int R;
  private int C;
  private int E;
  private int N;

  public static int bronze(String filename) throws FileNotFoundException{
    File imput = new File(filename);
    Scanner directions = new Scanner(imput);

    //String temp = directions.nextLine();
    int R = directions.nextInt();    //setting variables with values from first line
    int C = directions.nextInt();
    int E = directions.nextInt();
    int N = directions.nextInt();

    int[][] pasture = new int[R][C]; //making pasture from values in first line

    for (int r=0;r<pasture.length;r++){
      for (int c=0;c<pasture[r].length;c++){  //adding values to pasture from the big block of numbers
        pasture[r][c]=directions.nextInt();
      }
    }

    while (N>0){  //going through all directions using N (number of directions)
      dig(directions.nextInt(),directions.nextInt(),directions.nextInt());
    }

    return calculateDepth();
  }

  private void dig(int row, int col, int depth){
    int largest = pasture[row][col];
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

  private int calculateDepth(){
    int sum = 0;
    for (int r=0;r<pasture.length;r++){
      for (int c=0;c<pasture[r].length;c++){
        sum+=pasture[r][c];
      }
    }
    return sum*72*72;
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
