package com.tav;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        final ExecutorService executor = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 4; i++) {
            final Message msg = new Message(new Random().nextLong(), "Hello");
            executor.execute(new MessageProcessor(msg));
        }

        executor.shutdown();

        while (!executor.isTerminated()) {}

        System.out.println("Processed all messages");

        for (Map.Entry<Long, ProcessedMessage> entry : ProcessedMessagesStore.instance.getEntrySet()) {
            System.out.println(entry.getValue().getValue());
        }
    }
}
