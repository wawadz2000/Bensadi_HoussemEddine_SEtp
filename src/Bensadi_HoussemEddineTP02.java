import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Bensadi_HoussemEddineTP02 {
    static Semaphore A, B;
    static int na, nb;

    public static class PA extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                try {
                    A.acquire();
                    na++;
                    System.out.println("na= " + na);
                    A.release();
                } catch (InterruptedException e) {
                    Logger.getLogger(Bensadi_HoussemEddineTP02.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }

    public static class PB extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                try {
                    B.acquire();
                    nb++;
                    System.out.println("nb= " + nb);
                    B.release();

                } catch (InterruptedException e) {
                    Logger.getLogger(Bensadi_HoussemEddineTP02.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }

    public static void main(String[] args) {

        na = nb = 0;
        B = new Semaphore(0);
        A = new Semaphore(10);
        PA pa = new PA();
        pa.start();
        PB pb = new PB();
        pb.start();
    };
};