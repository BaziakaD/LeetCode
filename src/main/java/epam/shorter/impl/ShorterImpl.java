package epam.shorter.impl;

import epam.shorter.ShorterService;
import epam.shorter.repository.URLRepository;
import epam.shorter.validator.URLValidatorService;
import lombok.RequiredArgsConstructor;

import java.util.concurrent.ThreadLocalRandom;

@RequiredArgsConstructor
public class ShorterImpl implements ShorterService {

    private final URLRepository repository;
    private final URLValidatorService urlValidatorService;

    @Override
    public String shortUrl(String inputUrl) {
        urlValidatorService.validateURL(inputUrl);

        synchronized (this) {
            if (repository.containsOriginal(inputUrl)) {
                return repository.getShortURL(inputUrl);
            }
            var shortedURL = "https://revo.lut/" + generateRandomString();
            repository.save(shortedURL, inputUrl);
            return shortedURL;
        }
    }

    private String generateRandomString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < PATH_LENGTH / 2; i++) {
            ThreadLocalRandom random = ThreadLocalRandom.current();
            result.append((char) random.nextInt('a', 'z' + 1));
            result.append(random.nextInt(10));
        }
        return result.toString();
    }
}


