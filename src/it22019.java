import java.util.Scanner;

public class it22019 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        choice_1 article = new choice_1(); //object to choice_1
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
                    article.articleChoice1();
                    article.authorChoice1();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    break;
            }
        }while (answer != 6);
    }
}
