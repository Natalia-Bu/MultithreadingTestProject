package testProject;

public class RemoveThread implements Runnable {
    private boolean stop = false;
    private Thread thrd;
    private NumbersArray list;

    RemoveThread(String name, NumbersArray list) {
        thrd = new Thread(this, name);
        this.list = list;
        thrd.start();
    }

    public void run() {
        System.out.println("Начало потока " + thrd.getName());
        while (!stop) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println(thrd.getName() + " interrupted");
            }
            int removedNumber = list.removeNumber();
            if (removedNumber > 0)
                System.out.println("Removed number " + removedNumber);
        }
    }

    void cancel() {
        stop = true;
    }
}
