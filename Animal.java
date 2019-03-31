/**
* @author Ritvik Verma (UID- 3035453610)
*/
import java.util.Random;
abstract class Animal{
    private int x;//x, the value of the current x coordinate of the object
    private int y;//y, the value of the current y coordinate of the object
    private boolean hasMoved; //to see if the object has moved already, for non-repeat purposes. 
    private int medx; //median x coordinate of the object
    private int medy; //median y coordinate of the object
    private boolean two = false; //by default, the object will not make two moves like Canines. 
    /**
     * Method move to see how animals move in general. They move in 4 directions in general. 
     */
    void move()
    {
        Random rand = new Random(); 
        int move = rand.nextInt(4); //25% chance for moving directions. 
        if(move == 0) //Left
        {
            this.x = this.x + 1;
            if(this.x<0 || this.x>14)//Reverses on a boundary case
            {
                this.x = this.x - 1;
                move();
            }
        }
        else if(move == 1) //Top
        {
            this.y = this.y + 1;
            if(this.y<0 || this.y>14)//Reverses on a boundary case
            {
                this.y = this.y - 1;
                move();
            }
        }

        else if(move == 2) //Left
        {
            this.x = this.x - 1;
            if(this.x<0 || this.x>14)//Reverses on a boundary case
            {
                this.x = this.x + 1;
                move();
            }
        }

        else if(move == 3) //Bottom
        {
            this.y = this.y - 1;
            if(this.y<0 || this.y>14) //Reverses on a boundary case
            {
                this.y = this.y + 1;
                move();
            }
        }

    }

    /**
     * Method getx
     *
     * @return x of current object for assignment. 
     */
    int getx()
    {
        return this.x;
    }

    /**
     * Method gety
     *
     * @return y of current object for assignment. 
     */
    int gety()
    {
        return this.y;
    }

    /**
     * Method setx
     *
     * @param x of current object for assignment. 
     */
    void setx(int x)
    {
        this.x = x;
    }

    /**
     * Method sety
     *
     * @param y of current object for assignment. 
     */
    void sety(int y)
    {
        this.y = y;
    }    

    /**
     * Method gethasMoved
     *
     * @return The return value of whether the object has moved. 
     */
    boolean gethasMoved()
    {
        return this.hasMoved;
    }

    /**
     * Method sethasMoved
     *
     * @param move A parameter to set when the object has moved. 
     */
    void sethasMoved(boolean move)
    {
        this.hasMoved = move;
    }

    /**
     * Method gettwo
     *
     * @return The return value returns the two of the current object. 
     */
    boolean gettwo()
    {
        return this.two;
    }

    /**
     * Method settwo
     *
     * @param two A parameter sets if the object has to move twice. 
     */
    void settwo(boolean two)
    {
        this.two = two;
    }

    /**
     * Method getmedx
     *
     * @return The return value gets the median x value for move. 
     */
    int getmedx()
    {
        return this.medx;
    }

    /**
     * Method getmedy
     *
     * @return The return value gets the median y value for move. 
     */
    int getmedy()
    {
        return this.medy;
    }

    /**
     * Method setmedx
     *
     * @param x A parameter for setting the medx of the current object. 
     */
    void setmedx(int x)
    {
        this.medx = x;
    }

    /**
     * Method setmedy
     *
     * @param y A parameter for setting the medy value of the current object. 
     */
    void setmedy(int y)
    {
        this.medy = y;
    }

    /**
     * Method attackSuccessful
     *
     * @param animal A parameter
     * @return The return value sees if the attack is successful based on the animal moving rules. If Turtle, 20% chance that the animal wins. Otherwise, 
     * if it is the same class, then 50 % chance that the animal wins. BY DEFAULT, ATTACKER LOSES. 
     */
    boolean attackSuccessful(Animal animal)
    {
        Random rand = new Random();
        if(animal instanceof Turtle)
        {
            int kill = rand.nextInt(5); //20% chance. 
            if(kill == 0)
                return true;
            else
                return false;
        }

        else if(this.getClass() == animal.getClass())
        {
            int winMaybe = rand.nextInt(2);//50% chance. 
            if(winMaybe == 0)
                return true;
            else
                return false;
        }
        return false;
    }
}