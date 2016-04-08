/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test21_jeffreyforhan;

import java.util.Random;

/**
 *
 * @author jefor2991
 */
public class Player {
    private Random randy = new Random();
    private int cardNum;
    private int score;
    
    /**
     * Constructor
     * Pre: none
     * Post: Initializes the player's score
     */
    Player(){
        //Give value of 1-13
        drawCard();
    }
    /**
     * description: Adds to the player's score
     * pre: none
     * post: Adds new card to the player's hand
     */
    public void drawCard(){
        //Give value of 1-13
        cardNum = randy.nextInt(13)+1;
    }
    /**
     * description: Alter score based on the card drawn
     * pre: player chooses to draw new card
     * post: Add score of new card to old score
     */
    public void setValue(){
        
        drawCard();
        
        if(cardNum == 1){
            if(score <= 10){
                score += 11;
            }else{
                score += 1;
            }
        }else if(cardNum < 10){
            score += cardNum;
        }else{
            score += 10;
        }
    }    
    /**
     * description: Shows the player's current score
     * pre: player asks to see score
     * post: Display player score
     * @return the player's current score
     */
    public int getValue(){
        return score;
    }
    /**
     * description: Checks if the computer or the player wins
     * pre: The player submits score
     * post: Compare the scores
     * @param obj the object that this object is being compared to
     * @return 1(this player has a higher score), -1(other player has a higher score), 0(both scores are the same)
     */
    public int compareTo(Object obj){
        Player other = (Player)obj;
        if(getValue() <= 21 && other.getValue() > 21){
            return 1;
        }else if(getValue() > 21 && other.getValue() < 21){
            return -1;
        }else if(getValue() > 21 && other.getValue() > 21){
            return 0;
        }else{
            if(score > other.getValue()){
                return 1;
            }else if(score < other.getValue() ){
                return -1;
            }else{
                return 0;
            }
        }
    }
}
