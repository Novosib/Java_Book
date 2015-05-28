package Glava4Ex2;
class Parametr {
    void Chetnost (double x) {
        double d = x / 2;
        int d_round = (int) d;
        if (d == d_round){
            System.out.println((int) x + " - четное число");
        } else {
            System.out.println((int) x + " - НЕчетное число");
        }
    }//method SimpleNum
}//class
