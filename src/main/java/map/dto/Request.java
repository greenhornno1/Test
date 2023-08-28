package map.dto;

import lombok.Data;

@Data
public class Request {
    private AddressDTO shipFrom;
    private AddressDTO shipTo;
}
