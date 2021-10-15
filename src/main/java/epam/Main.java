package epam;

import epam.shorter.impl.DeShorterImpl;
import epam.shorter.impl.ShorterImpl;
import epam.shorter.repository.HashMapURLRepository;
import epam.shorter.validator.URLValidatorServiceImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        var urlRepo = new HashMapURLRepository();
        var urlValidatorService = new URLValidatorServiceImpl();
        var shorter = new ShorterImpl(urlRepo, urlValidatorService);
        var deShorted = new DeShorterImpl(urlRepo);
        String inputUrl = "https://www.revolut.com/en-US/about-revolut";

        ExecutorService executorService = Executors.newFixedThreadPool(100);

        List<Callable<String>> callables = IntStream.range(0, 100)
                .mapToObj(i -> (Callable<String>) () -> shorter.shortUrl(inputUrl))
                .collect(Collectors.toList());

        List<Future<String>> futures = executorService.invokeAll(callables);

        Set<String> set = new HashSet<>();
        for (Future<String> future : futures) {
            String s1 = future.get();
            set.add(s1);
        }

        System.out.println(set.size());
        executorService.shutdown();
    }
}
