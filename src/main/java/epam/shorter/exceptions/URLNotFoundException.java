package epam.shorter.exceptions;

public class URLNotFoundException extends RuntimeException {
    public URLNotFoundException(String message) {
        super("URL %s has not found in the repo.");
    }
}