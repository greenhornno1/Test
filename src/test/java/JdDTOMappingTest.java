import DTO.JdApiResultDTO;
import DTO.JdGetOrdersListResponseDTO;
import Util.JdTestData;
import Util.JsonUtil.JsonHelper;
import org.junit.jupiter.api.Test;

public class JdDTOMappingTest {

    @Test
    void testDTOMap (){
        JdGetOrdersListResponseDTO jdOrderDTO = JsonHelper.convertToPojo(JdTestData.JD_ERROR_DTO_1, JdGetOrdersListResponseDTO.class);
        System.out.println(jdOrderDTO);
        System.out.println(jdOrderDTO.getApiResult());
        System.out.println(jdOrderDTO.isResponseSuccess());

    }

}
