package com.andy.concurrency.example.syncContainer;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author Leone
 * @since: 2018-05-06 16:31
 **/
@Slf4j
public class VectorExample {

    public static int clientTotal = 5000;
    public static int threadTotal = 200;

    private static Vector<Integer> vector = new Vector<>();

    public static void main(String[] args) throws Exception {

        ExecutorService executorService = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(threadTotal);

        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);

        for (int i = 0; i < clientTotal; i++) {
            final int count = i;
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    update(count);
                    semaphore.release();
                } catch (InterruptedException e) {
                    log.error("exception", e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("size:{}", vector.size());
    }

    private static void update(int i) {
        vector.add(i);
    }

}
