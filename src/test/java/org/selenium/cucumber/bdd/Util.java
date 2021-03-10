package org.selenium.cucumber.bdd;



import java.util.Random;

public class Util {
    public void sleep() {
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public int randomNumber(int size) {
        Random random = new Random();
        int number = random.nextInt(size - 1);
        System.out.println(number);
        return number;
    }
}