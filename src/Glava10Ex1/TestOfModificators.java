package Glava10Ex1;
public class TestOfModificators {
    public static void main(String[] args) {
        Foo f0 = new Foo();
        f0.go();
        Foo4 f4 = new Foo4();
        f4.go();
        Foo5 f5 = new Foo5();
        f5.go(Foo5.x);
        Foo6 f6 = new Foo6();
        f6.go(f6.x);
    }//main
}//class