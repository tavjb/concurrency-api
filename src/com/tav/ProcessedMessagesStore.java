package com.tav;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ProcessedMessagesStore {
    private ProcessedMessagesStore() {}

    public static final ProcessedMessagesStore instance = new ProcessedMessagesStore();

    private final ConcurrentMap<Long, ProcessedMessage> processedMessages = new ConcurrentHashMap<>();

    public void put(final long id, final ProcessedMessage message) {
        this.processedMessages.put(id, message);
    }

    public ProcessedMessage get(final long id) {
        return this.processedMessages.get(id);
    }

    public Set<Map.Entry<Long, ProcessedMessage>> getEntrySet() {
        return processedMessages.entrySet();
    }
}
