import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Bensadi_HoussemEddine_TP03 {
    static Semaphore SH, SE, SL, SO;

    public static class PH extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    SH.acquire();
                    System.out.print('H');
                    SE.release();
                } catch (InterruptedException e) {
                    Logger.getLogger(Bensadi_HoussemEddine_TP03.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }

    public static class PE extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    SE.acquire();
                    System.out.print('E');
                    SL.release();
                    SL.release();
                } catch (InterruptedException e) {
                     Logger.getLogger(Bensadi_HoussemEddine_TP03.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }

    }

    public static class PL extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    SL.acquire();
                    System.out.print('L');
                    SO.release();
                } catch (InterruptedException e) {
                     Logger.getLogger(Bensadi_HoussemEddine_TP03.class.getName()).log(Level.SEVERE,null, e);
                }
            }
        }

    }

    public static class PO extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    SO.acquire();
                    SO.acquire();
                    System.out.print("O\n");
                    SH.release();
                } catch (InterruptedException e) {
                     Logger.getLogger(Bensadi_HoussemEddine_TP03.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }

    }

    public static void main(String[] args) {
        SH = new Semaphore(1);
        SE = new Semaphore(0);
        SL = new Semaphore(0);
        SO = new Semaphore(0);
        PH ph = new PH();
        ph.start();
        PE pe = new PE();   
        pe.start();
        PL pl = new PL();
        pl.start();
        PO po = new PO();
        po.start();
    }
}
