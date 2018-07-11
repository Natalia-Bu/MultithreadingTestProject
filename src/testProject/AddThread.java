package testProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddThread implements Runnable {
    Thread thrd;
    private NumbersArray list;

    AddThread(String name, NumbersArray list) {
        thrd = new Thread(this, name);
        this.list = list;
        thrd.start();
    }

    public void run() {
        System.out.println("Начало потока " + thrd.getName());

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        System.out.println("Print text numbers from 'one' to 'nine thousand nine hundred ninety nine'");
        System.out.println("To stop the program print 'stop'");
        do {
            try {
                str = br.readLine();
                if (!str.equals("") && !str.equals("stop")) {
                    try {
                        list.addNumber(Text2Digits.convertText(str));
                    } catch (RuntimeException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (!str.equals("stop"));
    }
}
