/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package recursion;

/**
 *
 * @author Thanh Hang
 */
public class Recursion {

    public static int factorial(int n){
        if(n==1) return 1;
        return n*factorial(n-1);
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    }
    
}
