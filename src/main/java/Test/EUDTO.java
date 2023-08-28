//package Test;
//
//import lombok.Builder;
//import lombok.NonNull;
//
//import java.io.Serializable;
//import java.util.Date;
//import java.util.List;
//
//public class EUDTO {
//
//    @NonNull
//    private Long buId;
//    @NonNull
//    private String marketPlace;
//    @NonNull
//    private String deliveryMode;
//    /**
//     * Default carrier = LogisticsCarrierEnum.DefaultCarrier
//     * */
//    @NonNull
//    private String carrier;
//    @NonNull
//    private String deliveryOrderId;
//    @NonNull
//    private String trackingId;
//    // NEW ???
//    private String customerOrderId;
//    private String externalOrderId;
//    List<TrackDTO> tracks;
//
//}
//
//public class TrackDTO implements Serializable {
//    // mapped OMM consignment status
//    @NonNull
//    private String deliveryStatus;
//    // raw status of external platform OR 3pl
//    // Do we have this in KVN ?
//    private String externalDeliveryStatus;
//    private String message;
//    private String location;
//    private String country;
//    private String state;
//    private String city;
//    // 3pl status update time
//    private Date carrierUpdateTime;
//    // afterShip / other external platform update time
//    private Date externalUpdateTime;
//}