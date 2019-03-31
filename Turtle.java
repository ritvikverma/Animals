/**
* @author Ritvik Verma (UID- 3035453610)
*/
import java.util.Random;
class Turtle extends Animal{//Class Turtle that inherits Animal
    /**
     * Method move
     * Returns nothing and makes a move (or not, since 50% chance) randomly depending on how the rules define turtle movements. 
     */
    void move()
    {
        Random rand = new Random();
        int moveOrNot = rand.nextInt(2);//50% chance
        if(moveOrNot == 1)
            super.move();
    }

    /**
     * Method attackSuccessful
     * @param animal an object of class Animal
     * @return a boolean, whether the attack was successful based on the attacking rules, definied through the Random class. 
     */
    boolean attackSuccessful(Animal animal)
    {
        Random rand = new Random();
        int r = rand.nextInt(2);//50% chance
        return(r==1);//50% chance
    }
}