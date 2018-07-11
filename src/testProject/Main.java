package testProject;

public class Main {
    public static void main(String[] args) {
        NumbersArray list = new NumbersArray();
        RemoveThread rt = new RemoveThread("RemoveThread", list);
        AddThread at = new AddThread("AddThread", list);
        try {
            at.thrd.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        rt.cancel();
    }
}
