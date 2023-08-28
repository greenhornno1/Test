public enum TestEnum {

    AIRWAY_BILL(1, "Airway-Bill"),
    INVOICE(2, "Invoice"),
    RETURN_FORM(3, "Return-Form"),
    SHIPPING_LABEL(4, "Shipping-Label"),
    SHOPPING_LIST(5, "Shopping-List"),
    PICK_UP_LABEL(6, "pickup-label"),
    CASH_LABEL(7, "cash-label");


    private int code;

    private String desc;

    TestEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }


    public void setCode(int code) {
        this.code = code;
    }


    public String getDesc() {
        return desc;
    }


    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static TestEnum fromName(String test) {
        TestEnum result = null;

        for (TestEnum candidate : values()) {
            System.out.println(candidate.name());
            if (candidate.name().equalsIgnoreCase(test)) {
                result = candidate;
                break;
            }
        }
        return result;
    }

}
