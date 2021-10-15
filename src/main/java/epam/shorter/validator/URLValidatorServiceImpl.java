package epam.shorter.validator;

import epam.shorter.exceptions.InvalidURLException;

import java.net.MalformedURLException;
import java.net.URL;

public class URLValidatorServiceImpl implements URLValidatorService {
    @Override
    public void validateURL(String inputUrl) {
        try {
            var url = new URL(inputUrl);
            var protocol = url.getProtocol();
            if (!(protocol.equals("http") || protocol.equals("https"))) {
                throw new InvalidURLException("Supported protocols: [http, https]");
            }
        } catch (MalformedURLException e) {
            throw new InvalidURLException(String.format("Provided URL is not valid: %s", inputUrl));
        }

    }
}
