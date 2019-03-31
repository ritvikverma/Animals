/**
 * @author Ritvik Verma (UID- 3035453610)
 */
import java.util.Scanner;
import java.util.Random;

public class ForestNew{
    private char forest[][] = new char[15][15];//forest setup for demonstration, animals are represented by characters
    private Animal animals[][] = new Animal[15][15];//Animal array for storing the exact kind of animals
    private String deadList[] = new String[224];//Stores all the dead animal strings for printing 
    private int deadCount = 0;//Sees how many animals are dead. 
    private char animalArray[] = {'c','i','d','f','j','k','l','u','w'}; //Array character matching
    private String animalName[] = {"Cat","Dinosaur","Dog","Fox","Jaguar","Kitten","Lion","Turtle","Wolf"};//Array character matching
    /**
     * Method main for driving the whole programme
     * @param args A parameter that is an empty string array for JRE to enter its control
     */
    public static void main(String args[])
    {
        Scanner in = new Scanner (System.in);//Scanner object
        Random rand = new Random();//Random object
        ForestNew f = new ForestNew(); //New forest object
        f.printForest();
        while(true) //While inserting animals
        {

            f.printMenu();//Prints menu
            int inp = in.nextInt();
            int random1 = rand.nextInt(15);//Makes a random number for assignment
            int random2 = rand.nextInt(15);//Makes a random number for assignment
            while(f.animals[random1][random2] != null)//Checks if the spot is assigned, if assigned, then repeat. 
            {
                random1 = rand.nextInt(15);
                random2 = rand.nextInt(15);
            }

            if(inp == 0){ //Break adding animals
                f.printForest();
                break;
            }

            else{
                if(inp == 1) //New Dog
                {   
                    f.animals[random1][random2] = new Dog(); 
                    f.forest[random1][random2] = 'd'; //Assigns character
                    f.animals[random1][random2].setx(random1);
                    f.animals[random1][random2].sety(random2);                    
                    System.out.println("Added Dog at (" + random1 +", " + random2 + "): Dog is Canine, Canine moves in four directions, one or two steps at a time.");
                    f.printForest();
                }

                else if(inp == 2)//New Fox
                {   
                    f.animals[random1][random2] = new Fox();
                    f.forest[random1][random2] = 'f';//Assigns character
                    f.animals[random1][random2].setx(random1);
                    f.animals[random1][random2].sety(random2);

                    System.out.println("Added Fox at (" + random1 +", " + random2 + "): Fox is Canine, Canine moves in four directions, one or two steps at a time.");
                    f.printForest();
                }

                else if(inp == 3)//New Wolf
                {   
                    f.animals[random1][random2] = new Wolf();
                    f.forest[random1][random2] = 'w';  //Assigns character                 
                    f.animals[random1][random2].setx(random1);
                    f.animals[random1][random2].sety(random2);

                    System.out.println("Added Wolf at (" + random1 +", " + random2 + "): Wolf is Canine, Canine moves in four directions, one or two steps at a time.");
                    f.printForest();
                }

                else if(inp == 4)//New Jaguar
                {   
                    f.animals[random1][random2] = new Jaguar();
                    f.forest[random1][random2] = 'j';//Assigns character
                    f.animals[random1][random2].setx(random1);
                    f.animals[random1][random2].sety(random2);

                    System.out.println("Added Jaguar at (" + random1 +", " + random2 + "): Jaguar is Feline, Feline moves in all eight directions, one step at a time.");
                    f.printForest();
                }

                else if(inp == 5)//New Lion
                {   
                    f.animals[random1][random2] = new Lion();
                    f.forest[random1][random2] = 'l';//Assigns character
                    f.animals[random1][random2].setx(random1);
                    f.animals[random1][random2].sety(random2);

                    System.out.println("Added Lion at (" + random1 +", " + random2 + "): Lion is Feline, Feline moves in all eight directions, one step at a time.");
                    f.printForest();
                }

                else if(inp == 6)//New Cat
                {   
                    f.animals[random1][random2] = new Cat();
                    f.forest[random1][random2] = 'c';//Assigns character
                    f.animals[random1][random2].setx(random1);
                    f.animals[random1][random2].sety(random2);

                    System.out.println("Added Cat at (" + random1 +", " + random2 + "): Cat is Feline, Feline moves in all eight directions, one step at a time.");
                    f.printForest();
                }

                else if(inp == 7)//New Kitten
                {   
                    f.animals[random1][random2] = new Kitten();
                    f.forest[random1][random2] = 'k';//Assigns character
                    f.animals[random1][random2].setx(random1);
                    f.animals[random1][random2].sety(random2);

                    System.out.println("Added Kitten at (" + random1 +", " + random2 + "): Kitten is Cat, Kitten has 30% chance stay in the same position, and 70% chance move in all eight directions, one step at a time.");
                    f.printForest();
                }

                else if(inp == 8)//New Dinosaur
                {
                    f.animals[random1][random2] = new Dinosaur();
                    f.forest[random1][random2] = 'i';//Assigns character
                    f.animals[random1][random2].setx(random1);
                    f.animals[random1][random2].sety(random2);

                    System.out.println("Added Dinosaur at (" + random1 +", " + random2 + "): Dinosaur moves in four directions, three steps at a time.");
                    f.printForest();
                }

                else if(inp == 9)//New Turtle
                {
                    f.animals[random1][random2] = new Turtle();
                    f.forest[random1][random2] = 'u';//Assigns character
                    f.animals[random1][random2].setx(random1);
                    f.animals[random1][random2].sety(random2);

                    System.out.println("Added Turtle at (" + random1 +", " + random2 + "): Turtle has 50% chance stay in the same position, and 50% chance move in four directions, one step at a time.");
                    f.printForest();
                }

            }
        }
        System.out.println("Press enter to iterate, type 'print' to print the Forest or 'exit' to quit: "); //Prompts the user
        String inp;
        inp = in.nextLine();
        inp = in.nextLine();
        while(inp!="exit") //If you write exit, it exits the prompt. 
        {

            if(inp.equals("")){
                f.iterate(); //Invokes the iterate function
                f.refreshMoves(); //Invokes the refreshmoves function for refreshing the moves of the objects, so that we can iterate again. 
                f.printForest();
            }
            else if(inp.equals("print"))
                f.printForest();
            else if(inp.equals("exit"))//Prints the forest, dead animals and leaves
            {
                f.printForest(); 
                for(int i = 0; i<f.deadCount; i++)
                {
                    System.out.println(f.deadList[i]);            
                }
                break; //Exits
            }
            System.out.println("Press enter to iterate, type 'print' to print the Forest or 'exit' to quit: ");
            inp = in.nextLine();
        }
    }

    /**
     * Method refreshMoves to freshen the moves of each object, so that it is reiterable. 
     */
    void refreshMoves()
    {
        for(int i = 0; i<15; i++)
        {
            for(int j = 0; j<15; j++)
            {
                if(animals[i][j] != null)
                    animals[i][j].sethasMoved(false);   //Set the hasMoved to false. 
            }
        }

    }

    /**
     * Method iterate every object gets iterated alphabetically, 
     */
    void iterate()
    {

        char currName;
        int oldx;//Stores the previous x value of the object
        int oldy;//Stores the previous y value of the object
        int newx;//Stores the new x value of the object
        int newy;//Stores the new y value of the object
        int medx;//Stores the intermediate x value of the object
        int medy;//Stores the intermediate y value of the object
        char captureMove = ' ';//Stores the dinosaur move
        boolean success = false;//Sees if the current object is a winner
        for(int i = 0; i<9; i++) //Iterate alphabetically
        {   
            currName = animalArray[i];//Current object character
            for(int j = 0; j<15; j++)
            {
                for(int k = 0; k<15; k++)
                {
                    if(animals[j][k] != null && forest[j][k] == currName && animals[j][k].gethasMoved() == false)//If the current iteration has an animal
                    {
                        oldx = (animals[j][k].getx());
                        oldy = (animals[j][k].gety());                        
                        animals[j][k].move();//Animal will move, move function is invoked. 
                        newx = animals[j][k].getx();
                        newy = animals[j][k].gety();
                        medx = animals[j][k].getmedx();
                        medy = animals[j][k].getmedy();

                        if(animals[j][k] instanceof Dinosaur)//Special case if it is a dinosaur 
                        {
                            if(newx-oldx == 3)//Going right, in this case, we'll move 3 times, at x+1, x+2 and x+3
                            {   
                                execute(oldx, oldy, oldx+1, newy, currName, i, j, k, oldx, oldy, false);
                                execute(oldx+1, oldy, oldx+2, newy, currName, i, j, k, oldx, oldy, false);
                                execute(oldx+2, oldy, oldx+3, newy, currName, i, j, k, oldx, oldy, true);
                                // printMove(i, oldx, oldy, oldx+3, newy);
                            }
                            else if(newy - oldy == 3)//Going up, in this case, we'll move 3 times, at y+1, y+2 and y+3
                            {
                                execute(oldx, oldy, newx, oldy+1, currName, i, j, k, oldx, oldy, false);
                                execute(oldx, oldy+1, newx, oldy+2, currName, i, j, k, oldx, oldy, false);
                                execute(oldx, oldy+2, newx, oldy+3, currName, i, j, k, oldx, oldy, true);
                                //printMove(i, oldx, oldy, newx, oldy+3);
                            }
                            else if(newy - oldy == -3)//Going down, in this case, we'll move 3 times, at y-1, y-2 and y-3
                            {
                                execute(oldx, oldy, oldx, oldy-1, currName, i, j, k, oldx, oldy, false);
                                execute(oldx, oldy-1, oldx, oldy-2, currName, i, j, k, oldx, oldy, false);
                                execute(oldx, oldy-2, oldx, oldy-3, currName, i, j, k, oldx, oldy, true);
                                //printMove(i, oldx, oldy, newx, oldy-3);
                            }
                            else if(newx - oldx == -3)//Going left, in this case, we'll move 3 times, at x-1, x-2, x-3
                            {
                                execute(oldx, oldy, oldx-1, newy, currName, i, j, k, oldx, oldy, false);
                                execute(oldx-1, oldy, oldx-2, newy, currName, i, j, k, oldx, oldy, false);
                                execute(oldx-2, oldy, oldx-3, newy, currName, i, j, k, oldx, oldy, true);
                                //printMove(i, oldx, oldy, oldx-3, newy);
                            }
                        }
                        else{
                            if(animals[j][k] instanceof Canine && animals[j][k].gettwo() == true && animals[medx][medy]!=null){ //If special case Canine with 2 moves.                         
                                success = animals[oldx][oldy].attackSuccessful(animals[medx][medy]); //See if the animal was successful in killing the animal at target.                     
                                if(success){
                                    System.out.println(animalName[i] + " from (" + oldx + ", " + oldy + ") attacks " + getClassName(animals[medx][medy]) + " at (" + medx + ", " + medy +") and wins");
                                    System.out.println(getClassName(animals[medx][medy]) + " dies at (" + medx + ", " + medy + ")");
                                    deadList[deadCount++] = (getClassName(animals[medx][medy]) + " died at location (" + medx + " ," + medy + ")");
                                    oldx = medx;//Animal won, so now the oldx becomes medx for its next move
                                    oldy = medy;//Animal won, so now the oldy becomes medy for its next move
                                }
                                else{
                                    System.out.println(animalName[i] + " from (" + oldx + ", " + oldy + ") attacks " + getClassName(animals[medx][medy]) + " at (" + medx + ", " + medy +") and loses");
                                    System.out.println(animalName[i] + " dies at (" + medx + ", " + medy + ")");
                                    deadList[deadCount++] = ((animalName[i]) + " died at location (" + medx + " ," + medy + ")");
                                    animals[oldx][oldy] = null;//Animal lost, it dies
                                    forest[oldx][oldy] = '.';

                                }

                            }
                            execute(oldx, oldy, newx, newy, currName, i, j, k, oldx, oldy, false);//Will make the move even if it is a canine

                        }
                    }
                }
            }
        }
    }

    /**
     * Method printMove prints the move after the move is made
     *
     * @param i A parameter to see the current iteration for the i variable in the loop, which relates to the animal name in the array animalname[]
     * @param oldx A parameter to see the original x location of the animal
     * @param oldy A parameter to see the original y location of the animal
     * @param newx A parameter to see the new x location of the animal
     * @param newy A parameter to see the new y location of the animal
     */
    void printMove(int i, int oldx, int oldy, int newx, int newy)
    {
        System.out.println(animalName[i] + " moved from (" + oldx+", " + oldy + ") to (" + newx +", " + newy + ")");
    }

    /**
     * Method execute executes a move, have put it in a different function for readability purposes. 
     * @return true if the animal is dead for printing purposes
     * @param oldx A parameter to see the old location of x of the animal
     * @param oldy A parameter to see the old location of y of the animal
     * @param newx A parameter to see the new location of x of the animal
     * @param newy A parameter to see the new location of y of the animal
     * @param currName A parameter to see the current initial of the name of the animal in the forest
     * @param i A parameter to see the current iteration for the i variable in the loop, which relates to the animal name in the array animalname[]
     * @param j A parameter to see the current iteration of the j variable in the loop, which relates to the animal x coordinates while iterating through the forest
     * @param k A parameter to see the current iteration of the k variable in the loop, which relates to the animal y corrdinates whilte iterating through the forest
     * @param originalx A parameter to see the very first original x coordinate just in case the animal is a dinosaur and makes many moves
     * @param originaly A parameter to see the very first original y coordinate just in case the animal is a dinosaur and makes many moves
     */
    void execute(int oldx, int oldy, int newx, int newy, char currName, int i, int j, int k, int originalx, int originaly, boolean toPrint){
        boolean success;
        forest[oldx][oldy] = '.';//Animal will move SOMEWHERE at least, therefore we can create a dot there
        if(animals[oldx][oldy] != null && (animals[newx][newy] == null || ( (oldx==newx) && (oldy==newy) ) ) ){//Animal not Canine, just moving
            forest[newx][newy] = currName;
            animals[oldx][oldy].sethasMoved(true);//Has moved now. 
            //Nothing in the old place, therefore null. 
            if(oldx==newx && oldy==newy)//Special Turtle and Kitten staying case
                System.out.println(animalName[i] + " stayed in ("+ oldx+", "+oldy+")");                     

            else{//All other general moving cases
                //System.out.println(animalName[i] + " moved from (" + oldx+", " + oldy + ") to (" + newx +", " + newy + ")");
                animals[newx][newy] = animals[oldx][oldy];                            
                animals[oldx][oldy] = null;
                if(currName!='i' || toPrint==true)   
                    printMove(i, originalx, originaly, newx, newy);
            }

        }

        else if(animals[oldx][oldy] != null && animals[newx][newy]!=null){//Animal exists at desired location               
            success = animals[oldx][oldy].attackSuccessful(animals[newx][newy]);
            if(success){//Animal won
                System.out.println(animalName[i] + " from (" + originalx + ", " + originaly + ") attacks " + getClassName(animals[newx][newy]) + " at (" + newx + ", " + newy +") and wins");
                System.out.println(getClassName(animals[newx][newy]) + " dies at (" + newx + ", " + newy + ")");
                deadList[deadCount++] = (getClassName(animals[newx][newy]) + " died at location (" + newx + " ," + newy + ")");//Animal at new location is dead
                forest[newx][newy] = currName;
                animals[oldx][oldy].sethasMoved(true);
                animals[newx][newy] = animals[oldx][oldy];//Animal object moves positions after successful attack.
                animals[oldx][oldy] = null;//Animal at old location has moved, therefore no animal. 
                if(currName!='i' || toPrint==true)   
                    printMove(i, originalx, originaly, newx, newy);

            }

            else{//Animal lost
                System.out.println(animalName[i] + " from (" + originalx + ", " + originaly + ") attacks " + getClassName(animals[newx][newy]) + " at (" + newx + ", " + newy +") and loses");
                System.out.println(animalName[i] + " dies at (" + newx + ", " + newy + ")");
                deadList[deadCount++] = ((animalName[i]) + " died at location (" + newx + " ," + newy + ")");//Dead location stored in list. 
                animals[oldx][oldy] = null;//Animal dead

            }

        }
    }

    /**
     * Method getClassName gets the class of the passed object. 
     *
     * @param animal A parameter that passes the Animal animal object to see which class it belongs to. 
     * @return The return value is a String value of the class name. 
     */
    String getClassName(Animal animal)
    {
        if(animal instanceof Dog)
            return "Dog";  
        else if(animal instanceof Cat)
            return "Cat";
        else if(animal instanceof Wolf)
            return "Wolf";
        else if(animal instanceof Lion)
            return "Lion";
        else if(animal instanceof Fox)
            return "Fox";
        else if(animal instanceof Dinosaur)
            return "Dinosaur";
        else if(animal instanceof Turtle)
            return "Turtle";
        else if(animal instanceof Kitten)
            return "Kitten";
        else if(animal instanceof Jaguar)
            return "Jaguar";
        return "";

    }

    /**
     * Forest Constructor for initialising animal objects and forest characters. 
     *
     */
    ForestNew()
    {
        for(int i = 0; i<15; i++)
        {
            for(int j = 0; j<15; j++)
            {   
                forest[i][j] = '.'; 
                animals[i][j] = null;
            }
        }
    }

    /**
     * Method printForest to print the characters of the forest. Returns nothing. 
     *
     */
    void printForest()
    {
        for(int i = 0; i<15; i++)
        {
            for(int j = 0; j<15; j++)
            {
                System.out.print(forest[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Method printMenu to print the menu for user prompt. 
     *
     */
    void printMenu()
    {
        System.out.println("1. Dog (d)");
        System.out.println("2. Fox (f)");
        System.out.println("3. Wolf (w)");
        System.out.println("4. Jaguar (j)");
        System.out.println("5. Lion (l)");
        System.out.println("6. Cat (c)");
        System.out.println("7. Kitten (k)");
        System.out.println("8. Dinosaur (i)");
        System.out.println("9. Turtle (u)");
        System.out.println("What would you like to add to the Forest?");    
        System.out.print("Please enter your choice (1-9, or 0 to finish the animal input): ");   
    }

}