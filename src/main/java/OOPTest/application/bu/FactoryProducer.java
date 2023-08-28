package OOPTest.application.bu;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FactoryProducer {

    private FactoryProducer() {
    }

    public static Factory getBUFactory(@NonNull String buId) throws RuntimeException {
        switch (buId) {
            case "102":
                return WTCTWFactory.getInstance();
            case "103":
                return WTCTHFactory.getInstance();
            default:
                String errorMessage = String.format("Invalid request. BuId : %s is not supported.", buId);
                log.error("{} BuId is defined but no handling class was found.", errorMessage);
                throw new RuntimeException(errorMessage);
        }
    }
}
