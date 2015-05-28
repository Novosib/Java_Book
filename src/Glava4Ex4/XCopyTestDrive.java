package Glava4Ex4;
class XCopyTestDrive {
    public static void main(String[] args) {
    int orig = 42;
    XCopy x = new XCopy();
    int y = x.go(orig);
    System.out.println(orig + " " + y);
    }//main
}//class
