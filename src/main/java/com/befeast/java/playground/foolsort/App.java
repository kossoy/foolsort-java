package com.befeast.java.playground.foolsort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void setTimeout(Runnable runnable, int delay) {
        new Thread(() -> {
            try {
                Thread.sleep(delay + 100L);
                runnable.run();
            } catch (InterruptedException e) {
                logger.error(e.getMessage());
                Thread.currentThread().interrupt();
            }
        }).start();
    }

    public static void main(String[] args) {

        int[] arr = {13, 7, 60, 45, 21, 9, 101, 102};
        for (int num : arr) {
            setTimeout(() -> logger.info(String.valueOf(num)), num);
        }
    }
}
