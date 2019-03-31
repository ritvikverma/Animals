/**
 * @author Ritvik Verma (UID- 3035453610)
 */
import java.util.Random;
class Fox extends Canine{//Fox inherits Canine (which, in turn inherits Animal)
    /**
     * Method attackSuccessful 
     * Sees if attack is successful using defined rules of defeat (Fox will always beat Cat), or otherwise will use parental defeat rules. 
     * @param animal an object of type Animal
     * @return boolean value of whether the Fox won or lost. If passed Animal animal in the parameters is not a Cat object, it will invoke the super function.
     */
    boolean attackSuccessful(Animal animal)
    {
        Random rand = new Random();        
        if(animal instanceof Cat)
            return true;
        else
            return super.attackSuccessful(animal);
    }
}