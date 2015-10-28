/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti;
import java.util.Random;
/**
 *
 * @author BASTEKI
 */
public class PGenerator implements Interface{

   
    
    @Override
    public int[] Generate(int n, int Max){
    
        int[] tab = new int[n];
        int i;
        
        Random randomGenerator = new Random();
        
        for(i=0; i<n; i++){
            tab[i] = randomGenerator.nextInt(Max);           
        }
        return tab;
    }
}

