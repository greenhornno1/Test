package OOPTest.application;

import OOPTest.api.model.Request;
import OOPTest.api.model.Response;
import OOPTest.application.bu.Factory;
import OOPTest.application.bu.FactoryProducer;
import OOPTest.application.channel.Channel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Application {

    public Response appendAttachments(Request cmd) {
        try {
            if (log.isDebugEnabled()) {
                log.debug("appendAttachments with input = {}", cmd);
            }
            Factory factory = FactoryProducer.getBUFactory(cmd.getBuId());

            Channel channel = factory.getChannel(cmd.getMarketplace());

            Response response = channel.createLabel(cmd);

            log.info("Response: {}", response);

            return response;
        } catch (Exception e) {
            log.error("Exception found", e);
        }
        return null;
    }
}
