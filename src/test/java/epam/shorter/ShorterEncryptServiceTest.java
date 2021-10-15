package epam.shorter;

import epam.shorter.exceptions.InvalidURLException;
import epam.shorter.impl.ShorterImpl;
import epam.shorter.repository.HashMapURLRepository;
import epam.shorter.repository.URLRepository;
import epam.shorter.validator.URLValidatorService;
import epam.shorter.validator.URLValidatorServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ShorterEncryptServiceTest {

    URLRepository urlRepo = new HashMapURLRepository();
    URLValidatorService urlValidatorService = new URLValidatorServiceImpl();
    ShorterService shorter = new ShorterImpl(urlRepo, urlValidatorService);

    @ValueSource(strings = {"", "justaword", "ftp://host/path"})
    @ParameterizedTest
    void testInvalidValues(String value) {
        assertThrows(InvalidURLException.class, () -> {
            shorter.shortUrl(value);
        });

        assertThatExceptionOfType(InvalidURLException.class)
                .isThrownBy(() -> shorter.shortUrl(value));
    }

    @Test
    public void testValidValue() {
        var url = "https://www.revolut.com/en-US/about-revolut";
        String shortUrl = shorter.shortUrl(url);

        assertThat(shortUrl).isNotNull();
        assertThat(shortUrl).startsWith("https://revo.lut/");
        assertThat(shortUrl).hasSameSizeAs("https://revo.lut/a1b2c3");

    }

    @Test
    void testDuplicateValues() {
        var url = "https://www.revolut.com/en-US/about-revolut";
        String firstShortUrl = shorter.shortUrl(url);
        String secondShortUrl = shorter.shortUrl(url);

        assertThat(firstShortUrl).isEqualTo(secondShortUrl);
    }
}