package epam.shorter.repository;

import epam.shorter.exceptions.URLNotFoundException;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class HashMapURLRepository implements URLRepository {

    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Map<String, String> repository = new HashMap<>();

    @Override
    public void save(String shortUrl, String originalURL) {
        try {
            lock.writeLock().lock();
            repository.put(shortUrl, originalURL);
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public String getOriginal(String shortURL) {
        try {
            lock.readLock().lock();

            if (!repository.containsKey(shortURL)) {
                throw new URLNotFoundException(String.format("Shorted URL is not present: %s", shortURL));
            }
            return repository.get(shortURL);
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public String getShortURL(String original) {
        try {
            lock.readLock().lock();

            return repository.keySet().stream()
                    .filter(key -> repository.get(key).equals(original))
                    .findFirst()
                    .orElseThrow(() -> new URLNotFoundException(String.format("Original URL is not present: %s", original)));

        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public boolean containsShort(String shortURL) {
        try {
            lock.readLock().lock();
            return repository.containsKey(shortURL);
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public boolean containsOriginal(String originalURL) {
        try {
            lock.readLock().lock();
            return repository.containsValue(originalURL);
        } finally {
            lock.readLock().unlock();
        }
    }
}
