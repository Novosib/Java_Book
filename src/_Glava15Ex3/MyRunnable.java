package _Glava15Ex3;
public class MyRunnable implements Runnable {

    public void run() {
        go();
    }
    public void go() {
        doMore();
    }
    public void doMore() {
        System.out.println("На вершине стека в MyRunnable");
    }
}//MyRunnable