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

    String temp = directions.nextLine();
    int [][] pasture = new int[Integer.parseInt(temp.substring(0,1))][Integer.parseInt(temp.substring(2,3))];
    return pasture[0].length;
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
