import java.util.Scanner;

public class it22019 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        choice_1 article = new choice_1(); //object to choice1
        choice_2 article2 = new choice_2(); //object to choice2
        choice_3 article3 = new choice_3(); //object to choice3
        choice_4 article4 = new choice_4(); //object to choice4
        choice_5 article5 = new choice_5(); //object to choice5

        int answer; //choice of table of content (1-6)
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

            int hasEvaluatorOrExit;
            switch (answer) { //executes the choice
                case 1 -> {
                    article.articleChoice1(); //provides all the characteristics of the article
                    article.authorChoice1();  //provides all the characteristics of the Author/Co-Author
                }
                case 2 -> {
                    hasEvaluatorOrExit = article2.showChoice2(); //Shows the elements of the exercise
                    if (hasEvaluatorOrExit != -1) { //-1 if there s no evaluator in the article's database, or the user didnt press exit
                        article2.addEvaluator(hasEvaluatorOrExit); //if there is no evaluator (or exit), it adds the evaluator on the system
                    }
                }
                case 3 -> {
                    hasEvaluatorOrExit = article3.ShowChoice3(); //Shows the elements of the exercise
                    if (hasEvaluatorOrExit != -1){ //if the input is not exit (-1)
                        article3.addRating(hasEvaluatorOrExit);  //adds the ratings of the elevator
                    }
                }
                case 4 -> article4.printRatings();
                case 5 -> article5.showAllArticles(); //prints all the types of articles
                default -> System.out.println("Byeeee, and don't come back! :)");
            }
        }while (answer != 6);
    }
}
