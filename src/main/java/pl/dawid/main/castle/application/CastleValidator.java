package pl.dawid.main.castle.application;

import lombok.RequiredArgsConstructor;
import pl.dawid.main.aaShare.ValidationException;
import pl.dawid.main.castle.application.port.out.FetchCastlePort;

@RequiredArgsConstructor
public class CastleValidator {

    private static final String CASTLE_NAME_MUST_BE_UNIQUE = "CASTLE_NAME_MUST_BE_UNIQUE";

    private final FetchCastlePort fetchCastlePort;

    public void validateUniqueName(String name) throws ValidationException {
        if (fetchCastlePort.findByName(name).size() > 0) {
            throw new ValidationException(CASTLE_NAME_MUST_BE_UNIQUE);
        }
    }
}
