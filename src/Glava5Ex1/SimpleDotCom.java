package Glava5Ex1;
public class SimpleDotCom {
    int[] locationCells;
    int numOfHits;
    
    void setLocationCells(int[] loc) {
        locationCells = loc;
    }
    
    public String checkYourself(String stringGuess) {
        int guess = Integer.parseInt(stringGuess);
        String result = "Мимо";
        
        for (int cell : locationCells){
            if (guess == cell) {
                numOfHits++;
                result = "Попал";
                break;
            }
        }
        if (numOfHits == locationCells.length){
            result = "Потопил";
        }
        return result;
    }//checkYourself
    
}//class