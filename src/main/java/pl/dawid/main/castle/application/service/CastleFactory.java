package pl.dawid.main.castle.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dawid.main.castle.domain.Castle;

@Service
@RequiredArgsConstructor
public class CastleFactory {

    public Castle createCastle(String name) {
        Castle castle = new Castle();
        castle.setName(name);
        return castle;
    }
}
