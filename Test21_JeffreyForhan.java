/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test21_jeffreyforhan;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author jefor2991
 */
public class Test21_JeffreyForhan {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Instantiate a player object
        Player user = new Player();
        //Instantiate a computer player object
        Player comp = new Player();
        
        //Make the computer draw more cards while his score is less than 16
        while(comp.getValue() < 16){
            comp.setValue();
        }
        
        System.out.println("Computer scored a " + comp.getValue());
        
        user.setValue();
        System.out.println("Current card value: " + user.getValue());
        makeMenu(user,comp);
        
    }
    /**
     * description: Makes menu, and allows user to pick what to do
     * pre: none
     * post: creates menu for user
     * @param player: the object that is being accessed
     * @param other: the player whose turn it is not
     */
    public static void makeMenu(Player player, Player other){
        Scanner choose = new Scanner(System.in);
        int selection = 0;
        int compareNum;
        
        System.out.print("(1) - Draw a new card\n(2) - Show current card value\n(3) - Compare to computer\n(4-0) - exit\nSelect option: ");
        
        try{
            selection = choose.nextInt();
        }catch(InputMismatchException e){
            System.out.println("Invalid input");
            System.err.println("InputMismatchException: " + e.getMessage());
        }
            
            if(selection == 1){
                player.setValue();
                System.out.println("Current card value: " + player.getValue());
                makeMenu(player,other);
            }else if(selection == 2){
                System.out.println("Current card value: " + player.getValue());
                makeMenu(player,other);
            }else if(selection == 3){
                compareNum = player.compareTo(other);
                winner(compareNum);
            }else{
               System.out.println("You have exited.");
               choose.close(); 
            }
        
    }
    /**
     * 
     * @param num The value to determine the winner of the round
     */
    public static void winner(int num){
        if(num == 1){
            System.out.println("The user wins!");
        }else if(num == -1){
            System.out.println("The computer wins!");
        }else{
            System.out.println("It's a tie!");
        }
    }
}
