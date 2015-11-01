/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projekti;
 
//import java.awt.geom.Line2D ;    
/**
 *
 * @author BASTEKI
 */
public class MonteCarlo {
    
    
    int Intersect(int[] x, int[] y, int[] lines, int Xpoint, int Ypoint){
        int i;
        int count=0;
    
    for(i = 0;i<lines.length-1 ; i++){
    if(linesIntersect(x[lines[i]], y[lines[i]], x[lines[i+1]], y[lines[i+1]], Xpoint, Ypoint, 0.0, Ypoint)==true)
        count++;
    
    
    }
    return count;
    }
    
    public static boolean linesIntersect(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4){
      //Sprawdzenie czy punkty nie pokrywają się
      if (x1 == x2 && y1 == y2 ||
            x3 == x4 && y3 == y4){
         return false;
      }
      
      double ax = x2-x1;
      double ay = y2-y1;
      double bx = x3-x4;
      double by = y3-y4;
      double cx = x1-x3;
      double cy = y1-y3;

      double alphaNumerator = by*cx - bx*cy;
      double commonDenominator = ay*bx - ax*by;
      if (commonDenominator > 0){
         if (alphaNumerator < 0 || alphaNumerator > commonDenominator){
            return false;
         }
      }else if (commonDenominator < 0){
         if (alphaNumerator > 0 || alphaNumerator < commonDenominator){
            return false;
         }
      }
      double betaNumerator = ax*cy - ay*cx;
      if (commonDenominator > 0){
         if (betaNumerator < 0 || betaNumerator > commonDenominator){
            return false;
         }
      }else if (commonDenominator < 0){
         if (betaNumerator > 0 || betaNumerator < commonDenominator){
            return false;
         }
      }
      if (commonDenominator == 0){
         double y3LessY1 = y3-y1;
         double collinearityTestForP3 = x1*(y2-y3) + x2*(y3LessY1) + x3*(y1-y2);   
         if (collinearityTestForP3 == 0){
            if (x1 >= x3 && x1 <= x4 || x1 <= x3 && x1 >= x4 ||
                  x2 >= x3 && x2 <= x4 || x2 <= x3 && x2 >= x4 ||
                  x3 >= x1 && x3 <= x2 || x3 <= x1 && x3 >= x2){
               if (y1 >= y3 && y1 <= y4 || y1 <= y3 && y1 >= y4 ||
                     y2 >= y3 && y2 <= y4 || y2 <= y3 && y2 >= y4 ||
                     y3 >= y1 && y3 <= y2 || y3 <= y1 && y3 >= y2){
                  return true;
               }
            }
         }
         return false;
      }
      return true;
   }
}
    
