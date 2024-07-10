import java.util.*;
public class WheelOfFortune
{

    //Creates a new board
    private static GameBoard fortuneBoard = new GameBoard("ABCDEFGHIJKLMNOPQRSTUVWXYZ",
            "The Secret Life of Bees", "Movies");

    public static void displayBoard()
    {

        fortuneBoard.displayLetters();

        fortuneBoard.updatePuzzle();

        fortuneBoard.displayPuzzle();

    }

    public static void play (Player player)
    {
        Wheel fortuneWheel = new Wheel();
        int playerChoice=-1;
        boolean goAgain = true, puzzleSolved=false;
        Scanner keyboard;


        while (goAgain==true && puzzleSolved==false)
        {

            boolean wasGuessed=false;


            do
            {
                keyboard = new Scanner(System.in);


                try
                {
                    System.out.print("Player " + player.getPlayerNumber() + " - would you like to Spin (1)"
                            + " or Guess (2) the puzzle? ");

                    playerChoice = keyboard.nextInt();

                }
                catch (InputMismatchException e)
                {
                    playerChoice=-1;

                }

            }while(playerChoice != 1 && playerChoice!=2);

            if(playerChoice == 1)
            {
                fortuneWheel.spin();


                if (fortuneWheel.getWheelValue()>0.0)
                {


                    do
                    {
                        //Prompts player to select a letter
                        System.out.print("Selecteaza litera din cele disponibile mai sus: ");

                        player.setPlayerGuess(keyboard.next().charAt(0));

                        wasGuessed = fortuneBoard.isLetterGuessed(player.getPlayerGuess());

                    }while (wasGuessed);


                    fortuneBoard.setCharacter(player.getPlayerGuess());

                    System.out.println();

                    fortuneBoard.updateAvailableLetters();


                    if (fortuneBoard.isLetterInPuzzle(player.getPlayerGuess())==true)
                        displayBoard();
                    else {
                        goAgain=false;
                        System.out.println("Incorect!");
                        System.out.println();
                    }

                }

                else
                {
                    goAgain = false;
                }
            }
            else
            {
                System.out.print("Introdu varianta ta de raspuns: ");
                keyboard = new Scanner(System.in);
                String playerGuess = keyboard.next().trim();

                if (!playerGuess.equalsIgnoreCase(fortuneBoard.getPuzzle()))
                {
                    System.out.println("\nIncorect!\n");
                    goAgain = false;
                }

                else {
                    fortuneBoard.setPendingPuzzle(playerGuess);
                }




            }


            if(checkSolved()==true)
            {

                goAgain=false;
                System.out.println("Felicitari! Ai rezolvat puzzle-ul!\n"+
                        "Jucatorul " + player.getPlayerNumber()+ " e invingator!");
            }
        }

    }//End Play

    public static boolean checkSolved()
    {
        boolean solved;
        if (fortuneBoard.getPendingPuzzle().equalsIgnoreCase(fortuneBoard.getPuzzle())) {
            solved = true;

        }
        else
            solved =  false;

        return solved;
    }

    public static void main (String [] args)
    {
        //Prints welcome message
        System.out.println("Bine ai venit la roata norocului\n");

        //Creates 3 new players
        Player player1 = new Player(1);
        Player player2 = new Player(2);
        Player player3 = new Player(3);

        do {
            displayBoard();
            play(player1);

            if (checkSolved()==true)
                break;

            displayBoard();
            play(player2);

            if (checkSolved()==true)
                break;

            displayBoard();
            play(player3);

            if (checkSolved()==true)
                break;

        }while(checkSolved()==false);


    }


}
