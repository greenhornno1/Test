package OOPTest.application.bu;

import OOPTest.application.channel.Channel;
import OOPTest.application.channel.TWYahoo;
import OOPTest.util.SpringApplicationContextUtils;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WTCTHFactory implements Factory {

    private WTCTHFactory() {
    }

    private static class SingleWTCTH {
        private static final WTCTHFactory INSTANCE = new WTCTHFactory();
    }

    public static WTCTHFactory getInstance() {
        return SingleWTCTH.INSTANCE;
    }

    @Override
    public Channel getChannel(@NonNull String marketplace) throws Exception {
        switch (marketplace) {
            case "OP":
                return SpringApplicationContextUtils.getBeanByClass(TWYahoo.class);
            case "JD":
            case "SHOPEE":
            default:
                String errorMessage = String.format("Invalid request. Marketplace: %s is not supported.", marketplace);
                log.error("{} Marketplace is defined but no handling class was found.", errorMessage);
                throw new Exception(errorMessage);
        }
    }
}
