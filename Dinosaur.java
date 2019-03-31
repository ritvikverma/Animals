/**
 * @author Ritvik Verma (UID- 3035453610)
 */
import java.util.Random;
class Dinosaur extends Animal{//Class Dinosaur that inherits Animal
    /**
     * Method attackSuccessful
     * @param animal an object of class Animal
     * @return a boolean, whether the attack was successful based on the attacking rules, definied through the Random class. 
     */
    boolean attackSuccessful(Animal animal)
    {
        Random rand = new Random();
        if(animal instanceof Dinosaur){
            return super.attackSuccessful(animal);//If dinosaur, follow other rules
        }
        else
            return true;//Dinosaur can kill all other animals if the animal it attacks isn't dinosaur also
    }

    /**
     * Method move for specific movements of the dinosaur, since it has special moves (it is big and can launch a long-range attack with 3 different steps)
     *
     */
    void move()
    {
        //3 steps in each case
        Random rand = new Random(); 
        int move = rand.nextInt(4); //25% chance for moving directions. 
        if(move == 0) //Right
        {
            setx(getx() + 3);
            if(getx()<0 || getx()>14)//Reverses on a boundary case
            {
                setx(getx() - 3);
                move();
            }
        }
        else if(move == 1) //Top
        {
            sety(gety() + 3);
            if(gety()<0 || gety()>14)//Reverses on a boundary case
            {
                sety(gety() - 3);
                move();
            }
        }

        else if(move == 2) //Left
        {
            setx(getx() - 3);
            if(getx()<0 || getx()>14)//Reverses on a boundary case
            {
                setx(getx() + 3);
                move();
            }
        }

        else if(move == 3) //Bottom
        {
            sety(gety() - 3);
            if(gety()<0 || gety()>14) //Reverses on a boundary case
            {
                sety(gety() + 3);
                move();
            }
        }

    }
}
