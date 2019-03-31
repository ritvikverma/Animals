/**
 * @author Ritvik Verma (UID- 3035453610)
 */
import java.util.Random;
abstract class Feline extends Animal{
    /**
     * Method move
     * This method moves the specific feline according to how Felines tend to move generally. 
     */
    void move()
    {
        Random rand = new Random();
        int move = rand.nextInt(8);//1/8th chance for every feline to move in a specific direction out of the 8 directions they can move in. 
        if(move == 0) //Right
        {          
            setx(getx()+1);
            if(getx()<0 || getx() > 14 || gety() < 0 || gety() > 14)
            {
                setx(getx() - 1);
                move();
            }
        }

        if(move == 1) //Up to the right
        {   
            setx(getx()+1);
            sety(gety()+1);
            if(getx()<0 || getx() > 14 || gety() < 0 || gety() > 14)
            {
                setx(getx()-1);
                sety(gety()-1);
                move();
            }
        }

        if(move == 2) //Top 
        {        
            sety(gety()+1);
            if(getx()<0 || getx() > 14 || gety() < 0 || gety() > 14)
            {

                sety(gety()-1);
                move();
            }
        }

        if(move == 3) //Up to the left
        {          
            setx(getx()-1);
            sety(gety()+1);
            if(getx()<0 || getx() > 14 || gety() < 0 || gety() > 14)
            {
                setx(getx()+1);
                sety(gety()-1);
                move();
            }
        }

        if(move == 4) //To the left
        {          
            setx(getx()-1);
            if(getx()<0 || getx() > 14 || gety() < 0 || gety() > 14)
            {
                setx(getx()+1);
                move();
            }
        }

        if(move == 5) //Bottom to the left
        {          
            setx(getx()-1);
            sety(gety()-1);
            if(getx()<0 || getx() > 14 || gety() < 0 || gety() > 14)
            {
                setx(getx()+1);
                sety(gety()+1);
                move();
            }
        }

        if(move == 6) //Bottom
        {          
            sety(gety()-1);
            if(getx()<0 || getx() > 14 || gety() < 0 || gety() > 14)
            {
                sety(gety()+1);
                move();
            }
        }

        if(move == 7) //Bottom to the right
        {          
            setx(getx()+1);
            sety(gety()-1);
            if(getx()<0 || getx() > 14 || gety() < 0 || gety() > 14)
            {
                setx(getx()-1);
                sety(gety()+1);
                move();
            }
        }

    }

    /**
     * Method attackSuccessful
     * Sees if the attack was successful, feline beats canine, otherwise goes to a generalised super attackSuccessful method. 
     * @param animal an object of type Animal, to see if the attack was successful or not based on rules that define Felines, such as Feline beats Canine.
     * @return The return value of whether the animal of class Feline won the attack.
     */
    boolean attackSuccessful(Animal animal)
    {
        Random rand = new Random();        
        if(animal instanceof Canine)
            return true;
        else
            return super.attackSuccessful(animal);
    }
}