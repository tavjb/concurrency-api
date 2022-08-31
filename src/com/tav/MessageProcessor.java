package com.tav;

import java.util.Random;

public class MessageProcessor implements Runnable {
    private Message message;

    public MessageProcessor(final Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        System.out.printf("[%s] received Message: %s%n", Thread.currentThread().getName(), this.message.getContent());
        process();
        System.out.printf("[%s] finished processing message: %s%n", Thread.currentThread().getName(), this.message.getContent());
    }

    private void process() {
        try {
            Thread.sleep(new Random().nextInt(3000));
            final String processedValue = String.format("%s-%s", message.getId(), message.getContent());
            ProcessedMessagesStore.instance.put(this.message.getId(), new ProcessedMessage(processedValue));
        } catch (final InterruptedException e) {
            System.out.printf("Failed to process message: %s %n", this.message);
        }
    }
}
