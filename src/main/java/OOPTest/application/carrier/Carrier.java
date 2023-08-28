package OOPTest.application.carrier;

import OOPTest.api.model.Request;
import OOPTest.api.model.Response;

public interface Carrier {

    Response createLabel(Request cmd);
}
