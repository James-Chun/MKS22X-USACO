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

    int[][] pasture = new int[R][C]; //making pasture from first line

    for (int r=0;r<pasture.length;r++){
      for (int c=0;c<pasture[r].length;c++){
        pasture[r][c]=directions.nextInt();
      }
    }

    return bronzeHelper(directions.nextInt(),directions.nextInt(),directions.nextInt(), N);
  }


  private int bronzeHelper(int row, int col, int depth, int orders){
    if(N==0)return calculateDepth();
    for (int i =0;i<3;i++){
      //using corner coord access each cow by adding int to coords
    }
    return 1;
  }

  private int calculateDepth(){
    int sum = 0;
    for (int[] c:n){
      sum +=n;
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
