import java.util.*;
import java.io.*;

public class USACO{
  private static int[][] pastureBronze;
  private static char[][] pastureSilver;


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








  public static String silver(String filename) throws FileNotFoundException{
      File imput = new File(filename);  //scanning file
      Scanner directions = new Scanner(imput);

      int N = directions.nextInt();    //setting variables with values from first line
      int M = directions.nextInt();    //N is amount of rows, M is amount of columns
      int T = directions.nextInt();    //T is time

      char[][] pastureSilver = new char[N][M]; //making pasture from values in first line

      for (int r=0;r<pastureSilver.length;r++){
        String line = directions.nextLine();
          for (int c=0;c<pastureSilver[r].length;c++){  //adding values to pasture from the big block of numbers
              pastureSilver[r][c]='*';
          }
      }

      String visual = "";

      for (int r=0;r<pastureSilver.length;r++){
          for (int c=0;c<pastureSilver[r].length;c++){  //adding values to pasture from the big block of numbers
              visual += pastureSilver[r][c];
          }
          visual += "\n";
      }

      return visual;
  }



  /*public int solve(){
            int row=0;                             //find the location of the S.
            int col=0;                             //erase the S
            for (int i1=0;i1<maze.length;i1++){    //and start solving at the location of the s.
              for (int i2=0;i2<maze[i1].length;i2++){
                if (maze[i1][i2]=='S'){
                  row=i1; col=i2; maze[i1][i2]='@';
                }
              }
            }
            if (solve(row,col))return count();    //depending on whether solve helper returns true or false;
            return -1;
      }


      /*
        Recursive Solve function:
        A solved maze has a path marked with '@' from S to E.
        Returns the number of @ symbols from S to E when the maze is solved,
        Returns -1 when the maze has no solution.
        Postcondition:
          The S is replaced with '@' but the 'E' is not.
          All visited spots that were not part of the solution are changed to '.'
          All visited spots that are part of the solution are changed to '@'
      */
    /*  private boolean solve(int row, int col){ //solve helper



          for (int i=0;i<moves.length;i++){   //looping through all possible moves (moves[][])
            if (maze[row+moves[i][0]][col+moves[i][1]]=='E')return true;   //check the spaces ahead of current position for E
            if (maze[row+moves[i][0]][col+moves[i][1]]!='#' && maze[row+moves[i][0]][col+moves[i][1]]!='@' && maze[row+moves[i][0]][col+moves[i][1]]!='.'){
              maze[row+moves[i][0]][col+moves[i][1]]='@';
              if (solve(row+moves[i][0],col+moves[i][1]))return true;
              maze[row+moves[i][0]][col+moves[i][1]]='.';
            }

          }
          return false;
      }
*/





  public static void main(String[] args){
    try{
      System.out.println(silver(args[0]));
    }catch(FileNotFoundException e){
      System.out.println("File Not Found");
    }
  }


}
