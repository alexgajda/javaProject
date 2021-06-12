public class choice_5 {
    choice_1 article = new choice_1();     //object to choice 1

    public void showAllArticles(){
        //PRINT THE SUM OF ALL TYPES
        System.out.printf("""
                
                
                Total Articles: %s
                Total Full Paper Articles: %s
                Total Paper in Progress Articles: %s
                Regular Articles: %s
                Case Study Articles: %s
                
                
                """, article.getArticleType1Size(),
                //CALCULATES THE TOTAL TYPES IN EACH METHOD, WHICH RETURNS THE SUM
                fullPaper(),
                PaperInProgress(),
                Regular(),
                caseStudy());
    }

    //EACH METHOD RETURNS THE SUM TYPE OF ALL THE ARTICLES
    public int fullPaper(){
        int counter = 0;
        for (int i = 0; i < article.getArticleType1Size(); i++){
            if (article.getArticleType1(i).equals("Full paper")){
                counter++;
            }
        }
        return counter;
    }

    public int PaperInProgress(){
        int counter = 0;
        for (int i = 0; i < article.getArticleType1Size(); i++){
            if (article.getArticleType1(i).equals("Paper in progress")){
                counter++;
            }
        }
        return counter;
    }

    public int Regular(){
        int counter = 0;
        for (int i = 0; i < article.getArticleType2Size(); i++){
            if (article.getArticleType2(i).equals("Regular")){
                counter++;
            }
        }
        return counter;
    }

    public int caseStudy(){
        int counter = 0;
        for (int i = 0; i < article.getArticleType2Size(); i++){
            if (article.getArticleType2(i).equals("Case Study")){
                counter++;
            }
        }
        return counter;
    }
}
