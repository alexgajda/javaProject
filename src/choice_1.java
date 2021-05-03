import java.util.ArrayList; //for the array lists
import java.util.Random; //for the random code
import java.util.Scanner; //for the Scanner input

public class choice_1 {
    /**************************ARTICLE*******************************/
    //article variables
    private static ArrayList<String> articleTitle = new ArrayList<String>();
    private ArrayList<String> articleKey = new ArrayList<String>();
    private static ArrayList<String> articleType1 = new ArrayList<String>(); //full paper or paper in progress
    private static ArrayList<String> articleType2 = new ArrayList<String>(); //regular or case-study
    private ArrayList<String> articleEnvironment = new ArrayList<String>();
    private ArrayList<String> articleEnvironmentName = new ArrayList<String>();
    private ArrayList<Integer> articlePages = new ArrayList<Integer>();
    private static ArrayList<Integer> articleCode = new ArrayList<Integer>();

    Scanner input = new Scanner(System.in); //Creates scanner for all methods
    public void articleChoice1(){
        //title
        getTitle();

        //keyword
        System.out.print("Enter article's keywords: ");
        int word; //counts the keyword length
        String articleKeyTemp;
        do {
            articleKeyTemp = input.nextLine();
            word = countWords(articleKeyTemp); //calls method that count the words
            if (word > 3 || word == 0){
                System.out.print("Keyword must be from 1 up to 3 words, try again: ");
            }
        }while (word > 3 || word == 0);
        articleKey.add(articleKeyTemp);

        //pages
        System.out.print("Enter article's pages: ");
        int articlePagesTemp;
        do { //checks the pages length
            articlePagesTemp = input.nextInt();
            if (articlePagesTemp < 0 || articlePagesTemp > 12){
                System.out.print("Article must have 1-12 pages, Try again: ");
            }
        }while (articlePagesTemp < 0 || articlePagesTemp > 12);
        articlePages.add(articlePagesTemp);

        //Full paper or Paper in progress
        if (articlePagesTemp >=8){
            articleType1.add("Full paper");
        }else {
            articleType1.add("Paper in progress");
        }

        //regular or case study
        int choice;
        System.out.printf("Type of your %s's article type (1: Regular \\ 2: Case-Study): ",articleType1.get(articleType1.size()-1));
        do {    //checks if choice is 1 or 2
            choice = input.nextInt();
            if (choice != 1 && choice != 2){
                System.out.print("1: Regular \\ 2: Case-Study, Try again: ");
            }
        }while(choice != 1 && choice != 2);
        if (choice == 1){
            articleType2.add("Regular");
        }else{
            articleType2.add("Case Study");
        }
        input.nextLine();

        //Public or private organism
        int choice2;
        if (choice == 2){ //if it is case study
            System.out.print("Enter your application environment type (1: Public \\ 2: Private): ");
            do{ //checks if choice is 1 or 2
                choice2 = input.nextInt();
                if (choice2 != 1 && choice2 != 2){
                    System.out.print("1: Public \\ 2: Private, Try again: ");
                }
            }while (choice2 != 1 && choice2 != 2);
            if (choice2 == 1){  //sets environment to public or private
                articleEnvironment.add("Public");
            }else{
                articleEnvironment.add("Private");
            }
            input.nextLine(); // skips newline character after reading int
            System.out.print("Give your application's environment name: ");
            articleEnvironmentName.add(input.nextLine());
        }else{  //if it is not case study
            articleEnvironment.add("NA");
            articleEnvironmentName.add("NA");
        }
        summonCode();   //Goes to function and generates random unique number
        showArticle(); //Shows the article's properties to user
    }

    public void showArticle(){ //Shows the article's properties to user
        System.out.printf("""
                                
                                
                Title: %s
                Keyword: %s
                Pages: %s
                Article's code: %s
                Article type: %s
                %s's Type: %s
                Application Environment Type: %s
                Application Environment Name: %s
                                
                                
                """, articleTitle.get(articleTitle.size()-1), articleKey.get(articleKey.size()-1), articlePages.get(articlePages.size()-1),
                articleCode.get(articleCode.size()-1),articleType1.get(articleType1.size()-1),
                articleType1.get(articleType1.size()-1), articleType2.get(articleType2.size()-1),
                articleEnvironment.get(articleEnvironment.size()-1), articleEnvironmentName.get(articleEnvironmentName.size()-1));
    } //Shows the specs of the article

    public int countWords(String word) { //Gives how many words have been typed
        if (word == null || word.isEmpty()) {
            return 0;
        }
        String[] words = word.split("\\s+");
        return words.length;
    }

    public void summonCode() {
        Random rand = new Random(); //creates the random object
        int upperRandom = 1000000000, randTemp; //maximum length of different codes
        boolean isUnique = true; //helps for the for loop below
        if (articleCode.size() == 0) {
            articleCode.add(rand.nextInt(upperRandom));
        } else {
            do {
                randTemp = rand.nextInt(upperRandom);
                for (int i = 0; i < articleCode.size(); i++) { //checks if code is unique
                    isUnique = true; //initializes true after the false statement
                    if (randTemp == articleCode.get(i)) {
                        isUnique = false;
                        break;
                    }
                }
            } while (!isUnique);
            articleCode.add(randTemp);
        }
    }

    public void getTitle() {
        String titleTemp;
        boolean isUnique = true;    //helps to find if the title is unique
        System.out.print("Enter article's title: ");
        if (articleTitle.size() == 0) { //initializes the first element of the array
            articleTitle.add(input.nextLine());
        } else {
            do {    //repeats if it is not unique
                titleTemp = input.nextLine();
                for (int i = 0; i < articleTitle.size(); i++) {
                    isUnique = true;
                    if (titleTemp.equals(articleTitle.get(i))) {
                        System.out.println("Title must be unique, Try again: ");
                        isUnique = false;   //sets condition to false and loops again
                        break;
                    }
                }
            } while (!isUnique);
            articleTitle.add(titleTemp); //adds the unique title to the arraylist
        }
    }


    /**************************AUTHOR*******************************/

    /* TIP: I created two string arrays for email for authors and co authors
    *       and in every input i search for the email given in each array
    *       of Authors and co-Authors
     */
    //Author variables
    private static ArrayList<String> authorMail= new ArrayList<String>();
    private static ArrayList<String> authorName = new ArrayList<String>();
    private ArrayList<String> authorTitle = new ArrayList<String>();
    private ArrayList<String> authorOrganism = new ArrayList<String>();
    //Co-Author variables
    private static ArrayList<String> coauthorMail= new ArrayList<String>();
    private ArrayList<String> coauthorName = new ArrayList<String>();
    private ArrayList<String> coauthorTitle = new ArrayList<String>();
    private ArrayList<String> coauthorOrganism = new ArrayList<String>();

    public void authorChoice1(){
        int find1,find2;    //variables that help to see if email is in database or not
        String mailTemp;
        boolean isValid;    //variable for email validation
        System.out.print("Enter Author's mail: ");
        do {
            mailTemp = input.nextLine();
            isValid = isValidEmailAddress(mailTemp);    //calls the email validation method
            if (!isValid){
                System.out.println("Wrong email address, Try again: "); //if it is not valid email
            }
        }while(!isValid);

        find1 = findAuthor(mailTemp); //calls method that looks if email is in Authors database or not
        if (find1 == -1){ //if the mail is not in Authors database
            find2 = findCoAuthor(mailTemp); //calls method that looks if email is in Co-Authors database or not
            if (find2 == -1) { //if email is not in authors and co-Authors database
                authorMail.add(mailTemp); //adds new email address
                //adds name
                System.out.print("Give Author's Name and Surname: ");
                authorName.add(input.nextLine());

                //adds organism
                System.out.print("Give Author's Organism (Press 1 to skip): ");
                String organismTemp = input.nextLine();
                if (organismTemp.equals("1")) { //if the input is 1 it skips
                    authorOrganism.add("NA");
                } else {
                    authorOrganism.add(organismTemp);
                }

                //adds authors title
                System.out.print("Give Author's Title (Press 1 to skip): ");
                String titleTemp = input.nextLine();
                if (titleTemp.equals("1")) { //if the input is 1 it skips
                    authorTitle.add("NA");
                } else {
                    authorTitle.add(titleTemp);
                }
            } else {    //if  the email is already in co-Authors database
                System.out.println("Author has been found in database!\n");
                authorMail.add(coauthorMail.get(find2));
                authorName.add(coauthorName.get(find2));
                authorTitle.add(coauthorTitle.get(find2));
                authorOrganism.add(coauthorOrganism.get(find2));
            }
        }else{ //The author is already Authors in database
            System.out.println("Author has been found in database!\n");
            authorMail.add(authorMail.get(find1));
            authorName.add(authorName.get(find1));
            authorTitle.add(authorTitle.get(find1));
            authorOrganism.add(authorOrganism.get(find1));
        }


        /***********************CO-AUTHOR***************************/
        System.out.print("Does the article have a Co-Author (1: Yes \\ 2: No)");
        int hasCoAuthor; //variable that checks if the re co-author
        do { //checks the input if it is 1 or 2
            hasCoAuthor = input.nextInt();
            if (hasCoAuthor != 1 && hasCoAuthor != 2) {
                System.out.print("1: Yes \\ 2: No, Try again: ");
            }
        }while (hasCoAuthor != 1 && hasCoAuthor != 2);
        input.nextLine();   //resets scanner after int to not be confused with \n
        if (hasCoAuthor == 1){ //if there is co-author
            System.out.print("Give Co-Author's Mail: ");
            do {
                mailTemp = input.nextLine();
                isValid = isValidEmailAddress(mailTemp);
                if (!isValid){
                    System.out.println("Wrong email address, Try again: ");
                }
            }while(!isValid); //same as before (see above)
            find1 = findAuthor(mailTemp); //returns -1 if the mail isn't in author database
            if (find1 == -1){ //if the mail is new (same code as above)
                find2 = findCoAuthor(mailTemp);
                if (find2 == -1) {
                    coauthorMail.add(mailTemp);
                    //adds name
                    System.out.print("Give Co-Author's Name and Surname: ");
                    coauthorName.add(input.nextLine());

                    //adds organism
                    System.out.print("Give Co-Author's Organism (Press 1 to skip): ");
                    String organismTemp = input.nextLine();
                    if (organismTemp.equals("1")) { //if the input is 1 it skips
                        coauthorOrganism.add("NA");
                    } else {
                        coauthorOrganism.add(organismTemp);
                    }

                    //adds authors title
                    System.out.print("Give Co-Author's Title (Press 1 to skip): ");
                    String titleTemp = input.nextLine();
                    if (titleTemp.equals("1")) { //if the input is 1 it skips
                        coauthorTitle.add("NA");
                    } else {
                        coauthorTitle.add(titleTemp);
                    }
                } else { //if email is already in co-Authors database
                    System.out.println("Co-Author has been found in database!\n");
                    coauthorMail.add(coauthorMail.get(find2));
                    coauthorName.add(coauthorName.get(find2));
                    coauthorTitle.add(coauthorTitle.get(find2));
                    coauthorOrganism.add(coauthorOrganism.get(find2));
                }
            }else { //if email is already in Authors database
                System.out.println("Co-Author has been found in database!\n");
                coauthorMail.add(authorMail.get(find1));
                coauthorName.add(authorName.get(find1));
                coauthorTitle.add(authorTitle.get(find1));
                coauthorOrganism.add(authorOrganism.get(find1));
            }
        }else{ //if there is not co-author
            coauthorMail.add("NA"); //i put NA not to lose the count of the list
            coauthorName.add("NA");
            coauthorTitle.add("NA");
            coauthorOrganism.add("NA");
        }

        printAuthors(hasCoAuthor);
    }

    //Searches if the email is in Authors database
    public int findAuthor(String mailTemp){
        for (int i = 0; i < authorMail.size(); i++){
            if(mailTemp.equals(authorMail.get(i))){
                return i;
            }
        }
        return -1;
    }

    //Searches if the email is in Co-Authors database
    public int findCoAuthor(String mailTemp){
        for (int i = 0; i < coauthorMail.size(); i++){
            if(mailTemp.equals(coauthorMail.get(i))){
                return i;
            }
        }
        return -1;
    }

    //Prints author and co-Author in terminal
    public void printAuthors(int hasCoAuthor){
        if (hasCoAuthor == 1) {
            System.out.printf("""
                              
                              
                            Author's Email: %s
                            Author's name and surname: %s 
                            Author's title: %s
                            Author's organism: %s
                               
                            Co-Author's Email: %s
                            Co-Author's name and surname: %s 
                            Co-Author's title: %s
                            Co-Author's organism: %s
                              
                              
                            """,
                    authorMail.get(authorMail.size() - 1),
                    authorName.get(authorName.size() - 1),
                    authorTitle.get(authorTitle.size() - 1),
                    authorOrganism.get(authorOrganism.size() - 1),

                    coauthorMail.get(coauthorMail.size() - 1),
                    coauthorName.get(coauthorName.size() - 1),
                    coauthorTitle.get(coauthorTitle.size() - 1),
                    coauthorOrganism.get(coauthorOrganism.size() - 1));
        }else{
            System.out.printf("""
                              
                              
                              Author's Email: %s
                              Author's name and surname: %s
                              Author's title: %s
                              Author's organism: %s
                               
                              Co-Author : NO
                              
                              
                              """,
                    authorMail.get(authorMail.size() - 1),
                    authorName.get(authorName.size() - 1),
                    authorTitle.get(authorTitle.size() - 1),
                    authorOrganism.get(authorOrganism.size() - 1));
        }
    }

    //checks if email address given is valid or not
    public static boolean isValidEmailAddress(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    //get the ArrayStrings that helps us with the other choices
    public ArrayList<String> getAuthorName() {
        return authorName;
    }

    public ArrayList<String> getArticleTitle() {
        return articleTitle;
    }

    public ArrayList<Integer> getArticleCode() {
        return articleCode;
    }

    public ArrayList<String> getArticleType1() {
        return articleType1;
    }

    public ArrayList<String> getArticleType2() {
        return articleType2;
    }

    public ArrayList<String> getAuthorMail() {
        return authorMail;
    }

    public ArrayList<String> getCoauthorMail() {
        return coauthorMail;
    }
}
