import java.util.Random;
/**
 * @author Ritvik Verma (UID- 3035453610)
 */
class Kitten extends Cat{ //Class Kitten that inherits Cat (which, in turn, inherits Feline, inturn inheriting Animal)
    /**
     * Method attackSuccessful
     * Overrides the Cat class attackSuccessful method if the animal that is passed is any Animal (defined in the special rules)
     * And overrides the Cat class attackSuccessful method if the animal that is passed is a Cat (defined in the special rules)
     * @param animal an object of Animal type
     * @return returns whether the attack will be successful, depending on what the attack rules and Random permits. 
     */
    
    void move()
    {
        Random rand = new Random();
        int m = rand.nextInt(10);
        if( !(m == 0 || m == 1 || m==2) )
        {
            super.move();
        }
    }
    /**
     * Method attackSuccessful
     *
     * @param animal A parameter for the exact Animal type that the current (this) animal object happens to attack
     * @return The return value is a boolean to check whether the attack was successful or not
     */
    boolean attackSuccessful(Animal animal)
    {
        Random rand = new Random();
        if(animal instanceof Cat)
        {
            int won = rand.nextInt(10);
            if(won == 7 || won == 8 || won == 9) //Only 3 in 10 chances of winning if the Kitten attacks a Cat 
            {
                return true;
            }
            else
                return false; //Rest 7 in 10 chances
        }

        else if (animal instanceof Kitten) //Same type, then 50% (follow parental rules)

            return super.attackSuccessful(animal);           
        else 
            return false;//If not Cat or Animal (not kitten), then dead
    }
}