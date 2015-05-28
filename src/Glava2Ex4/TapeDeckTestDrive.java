package Glava2Ex4;
class TapeDeckTestDrive {
    public static void main(String[] args) {

        TapeDeck t = new TapeDeck();//создаем объект t типа TapeDeck
        t.canRecord = true;
        t.playTape();
        
        if (t.canRecord == true) {
            t.recordTape();
        }
    }//конец main
}//конец класса
