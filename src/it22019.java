import java.util.InputMismatchException;
import java.util.Scanner;

public class it22019 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        choice_1 article = new choice_1(); //object to choice1
        choice_2 article2 = new choice_2(); //object to choice2
        choice_3 article3 = new choice_3(); //object to choice3
        choice_4 article4 = new choice_4(); //object to choice4
        choice_5 article5 = new choice_5(); //object to choice5

        int answer = 0; //choice of table of content (1-6)
        do { //prints the choices
            System.out.print("""
                    
                    1. Insert new article
                    2. Search article and import evaluator
                    3. Import article rating
                    4. Display article's ratings
                    5. Display reports
                    6. Exit
                    Enter your choice:\t""");
            do {    //checks the answer (1-6)
                while (!input.hasNextInt()) { //checks if it is a number
                    System.err.println("That's not a number!");
                    input.next();
                }
                answer = input.nextInt();
                if (answer < 1 || answer > 6) {
                    System.out.print("Input must be 1-6, Try again: ");
                }
            }while (answer < 1 || answer > 6);
            input.nextLine();

            switch (answer){ //executes the choice
                case 1:
                    article.articleChoice1(); //provides all the characteristics of the article
                    article.authorChoice1();  //provides all the characteristics of the Author/Co-Author
                    break;
                case 2:
                    article2.showChoice2(); //Shows the elements of the exercise
                    article2.addEvaluator(); //adds the evaluator on the system
                    break;
                case 3:
                    article3.ShowChoice3(); //Shows the elements of the exercise
                    article3.addRating();  //adds the ratings of the elevator
                    break;
                case 4:
                    article4.printRatings();
                    break;
                case 5:
                    article5.showAllArticles();
                    break;
                default:
                    System.out.println("Byeeee, and don't come back! :)");
                    break;
            }
        }while (answer != 6);
    }
}
