/**
* @author Ritvik Verma (UID- 3035453610)
*/
class Lion extends Feline{ //Class Lion that inherits Feline (which, in turn, inherits Animal)
    /**
     * Method attackSuccessful
     * Overrides the super attackSuccessful method if the animal that is passed is of type Hippo (defined in the special rules)
     * @param animal an object of Animal type
     * @return returns whether the attack will be successful, depending on what the attack rules and Random permits. 
     */
    boolean attackSuccessful(Animal animal)
    {
        if(animal instanceof Hippo)
            return true;
        else
            return super.attackSuccessful(animal); //If not Hippo, then follow parental rules
    }
}