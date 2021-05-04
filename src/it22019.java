import java.util.Scanner;

public class it22019 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        choice_1 article = new choice_1(); //object to choice1
        choice_2 article2 = new choice_2(); //object to choice2
        choice_3 article3 = new choice_3(); //object to choice3
        choice_5 article5 = new choice_5();
        int counter = 0;

        int answer; //choice of table of content (1-6)
        do { //prints the choices
            System.out.print("""
                    
                    1. Insert new article
                    2. Search article and import evaluator
                    3. Import article rating
                    4. Display article's ratings
                    5. Display reports
                    6. Exit
                    Enter your choice:    """);
            do {    //checks the answer (1-6)
                answer = input.nextInt();
                if (answer < 1 || answer > 6){
                    System.out.print("Input must be 1-6, Try again: ");
                }
            }while (answer < 1 || answer > 6);

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
