package epam.shorter.repository;

public interface URLRepository {

    void save(String shortUrl, String originalURL);

    String getOriginal(String shortURL);
    String getShortURL(String original);

    boolean containsShort(String shortURL);
    boolean containsOriginal(String originalURL);
}
