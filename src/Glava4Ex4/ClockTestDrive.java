package Glava4Ex4;
class ClockTestDrive {
    public static void main(String[] args) {
        Clock c = new Clock();
        c.setTime("1234");
        String tod = c.getTime();
        System.out.println("время: " + tod);
    }//main
}//class