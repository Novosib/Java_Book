package Glava4Ex5;
class Puzzle4b {
    int ivar;
    public int doStuff(int factor) {
        if (ivar > 100){
            return ivar * factor;
        } else {
            return ivar * (5 - factor);
        }
    }//method doStuff
}//class