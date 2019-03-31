/**
 * @author Ritvik Verma (UID- 3035453610)
 */
import java.util.Random;
abstract class Canine extends Animal{      

    /**
     * Method move() determines the specific moves for the Canine type. Canines move up, down, left and right - quadrant-wise. Half chance to take two steps.
     *
     */
    void move()
    {
        Random rand = new Random();
        int where = rand.nextInt(2);        
        if(where == 0){ //Half chance to take two steps, in this case one step
            super.move(); //Then moves like all other animals
            settwo(false);//Two steps taken is false
        }

        else //Half chance to take two steps, in this case two steps
        {
            int move = rand.nextInt(4);
            settwo(true); //Two steps taken is true
            //Here medx and medy are dictated by the intermediate steps that the animal takes. 
            if(move == 0) //Moves two steps to the right
            {                
                setx(getx() + 2);//Moves two steps to the right
                setmedx(getx() - 1);//Intermediate move                
                setmedy(gety());
                if(getx()<0 || getx()>14) //Boundary case, will reverse
                {
                    setx(getx()-2);
                    move();
                }
            }
            else if(move == 1)
            {
                sety(gety() + 2);//Moves two steps to the top
                setmedy(gety()-1); //Intermediate move               
                setmedx(getx());
                if(gety()<0 || gety()>14) //Boundary case, will reverse
                {
                    sety(gety()-2);
                    move();
                }
            }

            else if(move == 2)
            {
                setx(getx()-2);//Moves two steps to the left
                setmedx(getx()+1); //Intermediate move    
                setmedy(gety());
                if(getx()<0 || getx()>14) //Boundary case, will reverse
                {
                    setx(getx() + 2);
                    move();
                }
            }

            else if(move == 3) 
            {
                sety(gety() - 2);//Moves two steps to the bottom
                setmedy(gety() + 1); //Intermediate move    
                setmedx(getx());
                if(gety()<0 || gety()>14) //Boundary case, will reverse
                {
                    sety(gety() + 2);
                    move();
                }
            }

        }
    }

    /**
     * Method attackSuccessful
     *
     * @param animal an object of class Animal that is passed to the method to see if the parametrically passed Animal is beaten or not. 
     * @return The return value is a boolean value to tell whether the attack was successful based on if the animal was beaten or not. 
     */
    boolean attackSuccessful(Animal animal) 
    {
        int p = new Random().nextInt(2); //Half chances for if it's a Feline, win or loss. 
        if(animal instanceof Feline && p==1)
            return true;
        else if(animal instanceof Feline && p==0)
            return false;
        else
            return super.attackSuccessful(animal);
    }

}