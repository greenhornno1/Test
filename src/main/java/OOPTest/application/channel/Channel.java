package OOPTest.application.channel;

import OOPTest.api.model.Request;
import OOPTest.api.model.Response;

public interface Channel {

    Response createLabel(Request cmd);
}
