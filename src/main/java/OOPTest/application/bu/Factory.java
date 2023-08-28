package OOPTest.application.bu;

import OOPTest.application.channel.Channel;

public interface Factory {

    Channel getChannel(String marketplace) throws Exception;
}
