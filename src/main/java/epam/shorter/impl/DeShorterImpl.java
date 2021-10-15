package epam.shorter.impl;

import epam.shorter.DeShortedService;
import epam.shorter.repository.URLRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeShorterImpl implements DeShortedService {

    private final URLRepository urlRepository;

    @Override
    public String restoreOriginal(String url) {
        return urlRepository.getOriginal(url);
    }
}
