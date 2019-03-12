import java.util.*;
import java.io.*;

public class USACO{
  private static int[][] pastureBronze;
  private static int[][] pastureSilver;
  private static int[][] temp1;
  private static int[][] temp2;


  public static int bronze(String filename) throws FileNotFoundException{
      File imput = new File(filename);  //scanning file
      Scanner directions = new Scanner(imput);

      //------------------------------------------------------------------------------------------------------

      int R = directions.nextInt();    //setting variables with values from first line
      int C = directions.nextInt();    //R is amount of rows, C is amount of columns
      int E = directions.nextInt();    //E is final elevation
      int N = directions.nextInt();    //N is number of commands

      int[][] pastureBronze = new int[R][C]; //making pasture from values in first line

      for (int r=0;r<pastureBronze.length;r++){
          for (int c=0;c<pastureBronze[r].length;c++){  //adding values to pasture from the big block of numbers
              pastureBronze[r][c]=directions.nextInt();
          }
      }

      //------------------------------------------------------------------------------------------------------

      while (N>0){  //going through all directions using N
          int row = directions.nextInt()-1;   //getting the row and columns from each set of commands
          int col = directions.nextInt()-1;
          int largest = pastureBronze[row][col];
          int d = directions.nextInt();
          for (int r=0;r<3;r++){
              for (int c=0;c<3;c++){
                  if (pastureBronze[r+row][c+col]>largest )largest = pastureBronze[r+row][c+col];
              }                                                                     //find largest and subtract depth from it and if the numbers in that area are
          }                                                                         //bigger than largest-depth then the cows will be able to catch up and start digging together
          for (int r=0;r<3;r++){
              for (int c=0;c<3;c++){
                  if (pastureBronze[r+row][c+col]>largest-d) pastureBronze[r+row][c+col] = largest - d;
              }
          }
          N--;
      }

      //------------------------------------------------------------------------------------------------------

      for (int r=0;r<pastureBronze.length;r++){   //setting the final elevation
          for (int c=0;c<pastureBronze[r].length;c++){
              if (pastureBronze[r][c] - E < 0 )pastureBronze[r][c] = -1 * (pastureBronze[r][c]-E);
              else pastureBronze[r][c]=0;
          }
      }

      //------------------------------------------------------------------------------------------------------

      int sum = 0;    //calculating the total depth of lake
      for (int r=0;r<pastureBronze.length;r++){
          for (int c=0;c<pastureBronze[r].length;c++){
              sum+=pastureBronze[r][c];
          }
      }

      //------------------------------------------------------------------------------------------------------

      return sum*72*72;
  }

  private static void dig(int row, int col, int depth){
    int largest = USACO.pastureBronze[row][col];
    for (int r=0;r<3;r++){
      for (int c=0;c<3;c++){
        if (pastureBronze[r][c]>largest )largest = pastureBronze[r][c];
      }
    }
    for (int r=0;r<3;r++){
      for (int c=0;c<3;c++){
        if (pastureBronze[r][c]>largest-depth) pastureBronze[r][c] = largest - depth;
      }
    }

  }








  public static int silver(String filename) throws FileNotFoundException{
     File imput = new File(filename);  //scanning file
     Scanner directions = new Scanner(imput);

     int N = directions.nextInt();    //setting variables with values from first line
     int M = directions.nextInt();    //N is amount of rows, M is amount of columns
     int T = directions.nextInt();    //T is time

     int[][] pastureSilver = new int[N][M]; //making pasture from values in first line
     int[][] temp1 = new int[N][M];
     int[][] temp2 = new int[N][M];

     String line = directions.nextLine();

     for (int r=0;r<N;r++){
     line = directions.nextLine();
         for (int c=0;c<M;c++){  //adding values to pasture from the big block of numbers
             if (line.charAt(c)=='*'){
                pastureSilver[r][c]=-1;
             }
             else{pastureSilver[r][c]=0;}
         }
     }

     pastureSilver[directions.nextInt()-1][directions.nextInt()-1]=1;
     temp1=pastureSilver.clone();

     for (int r=0;r<temp1.length;r++){
       for (int c=0;c<temp1[r].length;c++){
         pastureSilver[r][c]=temp1[r][c];
       }
     }

     return pastureSilver[directions.nextInt()-1][directions.nextInt()-1];
 }


 public static String visual(){
   return "s";
 }




  public static void main(String[] args){
    try{
      System.out.println(silver(args[0]));
    }catch(FileNotFoundException e){
      System.out.println("File Not Found");
    }
  }


}
