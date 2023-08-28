import java.util.List;

public abstract class AbsTestOverride {
    public  String getValue(){
        String a = getCheckedMPOrders();
        return a;
    }

    protected  String getCheckedMPOrders() {
        return "aaaaaaaaa,abs";
    }
}
