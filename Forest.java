/**
 * @author Ritvik Verma (UID- 3035453610)
 */
import java.util.Scanner;
import java.util.Random;

public class Forest{
    private char forest[][] = new char[15][15];//forest setup for demonstration, animals are represented by characters
    private Animal animals[][] = new Animal[15][15];//Animal array for storing the exact kind of animals
    private String deadList[] = new String[224];//Stores all the dead animal strings for printing 
    private int deadCount = 0;//Sees how many animals are dead. 
    /**
     * Method main for driving the whole programme
     * @param args A parameter that is an empty string array for JRE to enter its control
     */
    public static void main(String args[])
    {
        Scanner in = new Scanner (System.in);//Scanner object
        Random rand = new Random();//Random object
        Forest f = new Forest(); //New forest object

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

            if(inp == 0) //Break adding animals
                break;

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

                else if(inp == 4)//New Cat
                {   
                    f.animals[random1][random2] = new Cat();
                    f.forest[random1][random2] = 'c';//Assigns character
                    f.animals[random1][random2].setx(random1);
                    f.animals[random1][random2].sety(random2);

                    System.out.println("Added Cat at (" + random1 +", " + random2 + "): Cat is Feline, Feline moves in all eight directions, one step at a time.");
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

                else if(inp == 6)//New Tiger
                {   
                    f.animals[random1][random2] = new Tiger();
                    f.forest[random1][random2] = 't';//Assigns character
                    f.animals[random1][random2].setx(random1);
                    f.animals[random1][random2].sety(random2);

                    System.out.println("Added Tiger at (" + random1 +", " + random2 + "): Tiger is Feline, Feline moves in all eight directions, one step at a time.");
                    f.printForest();
                }

                else if(inp == 7)//New Hippo
                {   
                    f.animals[random1][random2] = new Hippo();
                    f.forest[random1][random2] = 'h';//Assigns character
                    f.animals[random1][random2].setx(random1);
                    f.animals[random1][random2].sety(random2);

                    System.out.println("Added Hippo at (" + random1 +", " + random2 + "): Hippo moves in four directions, one step at a time");
                    f.printForest();
                }

                else if(inp == 8)//New Turtle
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
            }
            else if(inp.equals("print"))
                f.printForest();
            else if(inp.equals("exit"))//Prints the forest, dead animals and leaves
            {
                System.out.println("Final forest:");
                f.printForest(); 
                System.out.println("Dead animal list: ");
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
                    animals[i][j].sethasMoved(false); //Set the hasMoved to false. 
            }
        }

    }

    /**
     * Method iterate every object gets iterated alphabetically, 
     */
    void iterate()
    {
        char animalArray[] = {'c','d','f','h','l','t','u','w'}; //Array character matching
        String animalName[] = {"Cat","Dog","Fox","Hippo","Lion","Tiger","Turtle","Wolf"};//Array character matching
        char currName;
        int oldx;//Stores the previous x value of the object
        int oldy;//Stores the previous y value of the object
        int newx;//Stores the new x value of the object
        int newy;//Stores the new y value of the object
        int medx;//Stores the intermediate x value of the object
        int medy;//Stores the intermediate y value of the object
        boolean success = false;//Sees if the current object is a winner
        for(int i = 0; i<8; i++) //Iterate alphabetically
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
                        forest[j][k] = '.';//Animal will move SOMEWHERE at least, therefore we can create a dot there
                        animals[j][k].move();//Animal will move, move function is invoked. 
                        newx = animals[j][k].getx();
                        newy = animals[j][k].gety();
                        medx = animals[j][k].getmedx();
                        medy = animals[j][k].getmedy();
                        if(animals[j][k] instanceof Canine && animals[j][k].gettwo() == true && animals[medx][medy]!=null){ //If special case Canine with 2 moves.                         
                            success = animals[oldx][oldy].attackSuccessful(animals[medx][medy]); //See if the animal was successful in killing the animal at target.                     
                            if(success){
                                System.out.println(animalName[i] + " from (" + oldx + ", " + oldy + ") attacks " + getClassName(animals[medx][medy]) + " at (" + medx + ", " + medy +") and wins");
                                System.out.println(getClassName(animals[medx][medy]) + " dies at (" + medx + ", " + medy + ")");
                                deadList[deadCount++] = (getClassName(animals[medx][medy]) + " died at (" + medx + " ," + medy + ")");
                                oldx = medx;//Animal won, so now the oldx becomes medx for its next move
                                oldy = medy;//Animal won, so now the oldy becomes medy for its next move
                            }
                            else{
                                System.out.println(animalName[i] + " from (" + oldx + ", " + oldy + ") attacks " + getClassName(animals[medx][medy]) + " at (" + medx + ", " + medy +") and loses");
                                System.out.println(animalName[i] + " dies at (" + medx + ", " + medy + ")");
                                deadList[deadCount++] = ((animalName[i]) + " died at (" + medx + " ," + medy + ")");
                                animals[oldx][oldy] = null;//Animal lost, it dies
                                forest[oldx][oldy] = '.';

                            }

                        }

                        if(animals[oldx][oldy] != null && (animals[newx][newy] == null || ( (oldx==newx) && (oldy==newy) ) ) ){//Animal not Canine, just moving
                            forest[newx][newy] = currName;
                            animals[oldx][oldy].sethasMoved(true);//Has moved now. 
                            animals[newx][newy] = animals[oldx][oldy];                            
                            animals[oldx][oldy] = null;//Nothing in the old place, therefore null.                           
                            if(animalName[i]!="Turtle")//Special Turtle moving case
                                System.out.println(animalName[i] + " moved from (" + oldx+", " + oldy + ") to (" + newx +", " + newy + ")");
                            else
                            if(oldx==newx && oldy==newy)//Special Turtle staying case
                                System.out.println("Turtle stayed in ("+ oldx+", "+oldy+")");
                            else//All other general moving cases
                                System.out.println(animalName[i] + " moved from (" + oldx+", " + oldy + ") to (" + newx +", " + newy + ")");
                        }
                        else if(animals[j][k] != null && animals[newx][newy]!=null){//Animal exists at desired location               
                            success = animals[oldx][oldy].attackSuccessful(animals[newx][newy]);//See if the animal was successful in killing the animal at target.                  
                            if(success){//Animal won
                                System.out.println(animalName[i] + " from (" + oldx + ", " + oldy + ") attacks " + getClassName(animals[newx][newy]) + " at (" + newx + ", " + newy +") and wins");
                                System.out.println(getClassName(animals[newx][newy]) + " dies at (" + newx + ", " + newy + ")");
                                deadList[deadCount++] = (getClassName(animals[newx][newy]) + " died at (" + newx + " ," + newy + ")");//Animal at new location is dead
                                forest[newx][newy] = currName;
                                animals[oldx][oldy].sethasMoved(true);
                                animals[newx][newy] = animals[oldx][oldy];//Animal object moves positions after successful attack.
                                animals[oldx][oldy] = null;//Animal at old location has moved, therefore no animal. 
                            }

                            else{//Animal lost
                                System.out.println(animalName[i] + " from (" + oldx + ", " + oldy + ") attacks " + getClassName(animals[newx][newy]) + " at (" + newx + ", " + newy +") and loses");
                                System.out.println(animalName[i] + " dies at (" + newx + ", " + newy + ")");
                                deadList[deadCount++] = ((animalName[i]) + " died at (" + newx + " ," + newy + ")");//Dead location stored in list. 
                                animals[oldx][oldy] = null;//Animal dead

                            }
                        }

                    }
                }
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
        else if(animal instanceof Hippo)
            return "Hippo";
        else if(animal instanceof Turtle)
            return "Turtle";
        else if(animal instanceof Tiger)
            return "Tiger";
        return "";

    }

    /**
     * Forest Constructor for initialising animal objects and forest characters. 
     *
     */
    Forest()
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
        System.out.println("4. Cat (c)");
        System.out.println("5. Lion (l)");
        System.out.println("6. Tiger (t)");
        System.out.println("7. Hippo (h)");
        System.out.println("8. Turtle (u)");
        System.out.println("What would you like to add to the forest?");    
        System.out.println();
        System.out.println("Please enter your choice (1-8, or 0 to finish the animal input):");   
        System.out.println();
    }

}

