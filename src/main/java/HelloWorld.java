import Test.*;
//import Test.U.ListValidator;
import Test.Lombok.LombokDTO;
import Test.U.ListValidator;
import Test.U.NullValidator;
import ThreadTest.PrivateCounter;
import exception.TestException;
import lombok.extern.slf4j.Slf4j;
import map.dto.AddressDTO;
import map.dto.Request;
import map.util.MapUtil;
import org.springframework.util.CollectionUtils;

import javax.net.ssl.SSLContext;
import java.nio.file.FileSystems;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//import org.json.*;


@Slf4j
public class HelloWorld {

    public static Boolean isMatch(String regexPattern, String sequence) {
        Pattern pattern = Pattern.compile(regexPattern);
        return pattern.matcher(sequence).find();
    }


    public static String checkOpDocuvvvmentType(String sequence) {
        Pattern pdfFilePattern = Pattern.compile("^Infinity_(?:Store|HiLife)Order_(\\d{8})\\d*\\.zip$");
        if (pdfFilePattern.matcher(sequence).find()) {
            Matcher m = pdfFilePattern.matcher(sequence);
            m.matches();
            return m.group(1);
        } else {
            return "not found";
        }
    }

    public static String checkLocalDir(String dir) {
        String fileSeparator = FileSystems.getDefault().getSeparator();
        return dir.endsWith(fileSeparator) ? dir : dir + fileSeparator;
    }

    public static Boolean checkOpDocumentType(String sequence) {
        Pattern pdfFilePattern = Pattern.compile(".*[C|c][A|a][S|s][H|h].*\\.pdf$");
        if (pdfFilePattern.matcher(sequence).find()) {
            return true;
        } else {
            return false;
        }
    }

    public static String getDocumentOrderNo(String regexPattern, String sequence) {
        Pattern pattern = Pattern.compile(regexPattern);
        String orderNo = "";
        try {
            if (pattern.matcher(sequence).find()) {
                Matcher m = pattern.matcher(sequence);
                m.matches();
                orderNo = m.group(1);
            }
        } catch (Exception e) {
            System.out.println("[OPService] {} Hybis Order No is not found." + sequence);
            e.printStackTrace();
        }
        return orderNo;
    }

    public static String testChangeNull(String aa) {
        if (aa == null) {
            aa = "";
        }

        return "yes";
    }

    public static void changeStudent(Student student){
        student.setId(999);
    }

    public static String OPCodValue = "COD";

    public static Set<String> getOPCodValue() {
        return OPCodValue == null ? Collections.emptySet() : new HashSet<>(Arrays.asList(OPCodValue.split(",")));
    }

    public static final Set<String> OP_COD = new HashSet<>(Arrays.asList("COD - N/A", "COD"));

    private static final TestFinal testFinal = new TestFinal();

    public static Boolean getIsReprint(Boolean isReprint) {
        return isReprint != null && isReprint;
    }

    public static void main(String[] args) {

        String jsonString = "{\n" +
                "    \"NinjaVan\": {\n" +
                "        \"config\": {\n" +
                "            \"apiKey\": \"ccccccccc\",\n" +
                "            \"retry\": false,\n" +
                "            \"rate\": false\n" +
                "        },\n" +
                "        \"data\": {\n" +
                "            \"async\": false,\n" +
                "            \"paperSize\": \"default\",\n" +
                "            \"returnShipment\": false,\n" +
                "            \"isDocument\": false,\n" +
                "            \"serviceType\": null,\n" +
                "            \"shipperAccount\": {\n" +
                "                \"id\": \"cccccccccc\"\n" +
                "            },\n" +
                "            \"references\": null,\n" +
                "            \"shipment\": {\n" +
                "                \"parcels\": {\n" +
                "                    \"boxType\": \"custom\",\n" +
                "                    \"description\": \"Parcel Description\",\n" +
                "                    \"weight\": {\n" +
                "                        \"value\": 1000,\n" +
                "                        \"unit\": \"g\"\n" +
                "                    },\n" +
                "                    \"dimension\": {\n" +
                "                        \"width\": 30,\n" +
                "                        \"height\": 30,\n" +
                "                        \"depth\": 30,\n" +
                "                        \"unit\": \"cm\"\n" +
                "                    },\n" +
                "                    \"items\": [\n" +
                "                        {\n" +
                "                            \"description\": \"ProductName\",\n" +
                "                            \"originCountry\": \"THA\",\n" +
                "                            \"quantity\": 1,\n" +
                "                            \"price\": {\n" +
                "                                \"amount\": 0,\n" +
                "                                \"currency\": \"THB\"\n" +
                "                            },\n" +
                "                            \"weight\": {\n" +
                "                                \"value\": 1,\n" +
                "                                \"unit\": \"g\"\n" +
                "                            }\n" +
                "                        }\n" +
                "                    ]\n" +
                "                },\n" +
                "                \"shipFrom\": {\n" +
                "                    \"contactName\": \"Watsons Thailand\",\n" +
                "                    \"companyName\": \"Watsons Thailand\",\n" +
                "                    \"street1\": \"Venue: 1/1 Frasers Property Logistics Center (Bangplee 1)\",\n" +
                "                    \"street2\": \"(Banga-Trad 22) 45/1 Moo1\",\n" +
                "                    \"street3\": \"Sisa Chorakhe Yai\",\n" +
                "                    \"city\": \"Bang Sao Thong\",\n" +
                "                    \"state\": \"Samut Prakarn\",\n" +
                "                    \"postalCode\": \"10570\",\n" +
                "                    \"country\": \"THA\",\n" +
                "                    \"phone\": \"026652000\",\n" +
                "                    \"email\": null,\n" +
                "                    \"type\": \"business\"\n" +
                "                },\n" +
                "                \"shipTo\": {\n" +
                "                    \"contactName\": \"shipTo_contactName\",\n" +
                "                    \"companyName\": null,\n" +
                "                    \"street1\": \"shipTo_street1\",\n" +
                "                    \"street2\": null,\n" +
                "                    \"city\": \"shipTo_city\",\n" +
                "                    \"state\": \"shipTo_state\",\n" +
                "                    \"postalCode\": \"shipTo_postcode\",\n" +
                "                    \"country\": \"THA\",\n" +
                "                    \"phone\": \"shipTo_phone\",\n" +
                "                    \"email\": \"shipTo_email\",\n" +
                "                    \"type\": null\n" +
                "                }\n" +
                "            },\n" +
                "            \"service_options\": [\n" +
                "                {\n" +
                "                    \"type\": \"pickup\",\n" +
                "                    \"start_time\": \"09:00:00\",\n" +
                "                    \"end_time\": \"18:00:00\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    }\n" +
                "}";

        Request request = new Request();
        AddressDTO shipTo = new AddressDTO();
        AddressDTO shipFrom = new AddressDTO();
        shipTo.setAddressLine1("shipTo addr line1");
        shipTo.setAddressLine2("shipTo addr line2");
        shipTo.setAddress("shipTo addr");
        shipTo.setCompany("shipTo company");
        shipTo.setContact("shipTo contact");
        shipFrom.setAddressLine1("shipFrom addr line1");
        shipFrom.setAddressLine2("shipFrom addr line2");
        shipFrom.setAddress("shipFrom addr");
        shipFrom.setCompany("shipFrom company");
        shipFrom.setContact("shipFrom contact");

        request.setShipFrom(shipFrom);
        request.setShipTo(shipTo);

        Map<String, Object> requestMap = MapUtil.toMap(request);

        log.debug("Map : {}",requestMap);

//        try{
//            System.out.println(Arrays.toString(SSLContext.getDefault().getSupportedSSLParameters().getProtocols()));
//        }catch (Exception e){
//            // do nothing
//        }


//        Student studentA = Student.builder()
//                .id(123)
//                .build();
//
//        log.info("Student before: {}",studentA);
//        changeStudent(studentA);
//        log.info("Student after: {}",studentA);

//        try {
//            throw new TestException("AAA");
//        } catch (Exception e) {
//            log.error("Exception found.", e);
//        }
//
//        try {
//            NullValidatorB.of(studentA, TestException.class)
//                    .notNull(Student::getId, "Student Id cannot be null")
//                    .notNull(Student::getAge, new NullPointerException("age is nulllllll"));
//            log.info("all good");
//        } catch (Exception e) {
//            log.error("Exception found.", e);
//        }


//        TestBoolean test = new TestBoolean();
//
//        System.out.println(test.isNeedAlert());
//
//        Map<String, Boolean> map = new HashMap<>();
//
//        log.info(String.valueOf(map.get(null)));
//        Date date = new Date();
//        log.info("{}",date);


//        try {
//            int code = test.getErrorCode().intValue();
//        } catch (Exception e) {
//            log.error("exception Name :{}, exception Message: {}", e.getClass().getCanonicalName(), e.getMessage().substring(0,20), e);
//        }
//        System.out.println(code);

//        ThreadPoolExecutor
//        // Split the string into lines
//
//        String content = "line1. \n line2.";
//
//        String[] lines = content.split("\\r?\\n");
//
//// Remove the first line
//        String newContent = "";
//        for (int i = 1; i < lines.length; i++) {
//            newContent += lines[i] + "\n";
//        }
//
//// Output the new string without the first line
//        System.out.println(newContent);

//        //设定子线程工作时间
//        long subThreadWorkTime = 7;
//        Callable<Integer> pAccount = new PrivateCounter(subThreadWorkTime);
//        //注意使用类：FutureTask
//        FutureTask<Integer> futureTask = new FutureTask<>(pAccount);
//        // 使用futureTask创建一个线程
//        Thread pAccountThread = new Thread(futureTask);
//        long timeout = 8000;
//        log.info("主线程：设定等待时间是：{}ms", timeout);
//
//        pAccountThread.start();
//        try {
//            Integer result = futureTask.get(timeout, TimeUnit.MILLISECONDS);
//            log.info("{}ms 工作完成，响应结果是：{}", timeout, result);
//        } catch (InterruptedException | ExecutionException | TimeoutException e1) {
//            log.info("{}ms 没有响应结果，系统退出", timeout);
//            e1.printStackTrace();
//            pAccountThread.interrupt();
//        }


//        testFinal.setA("AAAAAA");
//        log.info(testFinal.getA());
//        testFinal.setA("BBBBB");
//        log.info(testFinal.getA());
//        Queue<String> queue = new LinkedList<>();
//        Stack<String> stack = new Stack<>();

//        String a = "AAAAAA";
//        try{
//
//            throw new RuntimeException();
//        }catch (Exception e){
//            log.error("Error : {} ",e);
//        }
//
//        List<String> l1 = null;
//        boolean empty = CollectionUtils.isEmpty(l1);
//
//        log.info("empty : {}",empty,l1);
//
//
//
////        Set<String> a = new HashSet<>(Arrays.asList("A","B"));
//        List<String> a = new ArrayList<>(Arrays.asList("A","B"));
//        List<String> b = new ArrayList<>(Arrays.asList("C","D"));
//        List<String> c = new ArrayList<>(Arrays.asList("E","F"));
////        Set<String> b = new HashSet<>(Arrays.asList("A","B"));
//        a.removeAll(b);
//
//        log.info("a: {}",a.size());
//
//        List<String> cc = Collections.emptyList();
//        Map<Boolean, List<String>> cancelResult = new HashMap<>();
//
//        cancelResult.putIfAbsent(true, Arrays.asList("A"));
//        cancelResult.putIfAbsent(false,Arrays.asList("V"));
////        cancelResult.computeIfAbsent(true, key -> new ArrayList<>()).addAll(c);
//
//        log.info("Cancel result {}",cancelResult);
//        log.info("cc: {}", cc.stream().count());
//        Student test = Student.builder().build();
//        Student test2 = null;
//        Teacher t1 = Teacher.builder().name("aaa").build();
//        Teacher t2 = Teacher.builder().name("bbb").build();
//        Teacher t3 = Teacher.builder().name("").build();
//        Teacher t4 = Teacher.builder().name("  ").build();
//        Teacher t5 = Teacher.builder().build();
//        Student test4a = Student.builder().contacts(Arrays.asList(t1, t2)).build();
//        Student test4b = Student.builder().contacts(Arrays.asList(t3, t4, t5)).build();

//        List<Teacher> list = test4a.getContacts();
//        boolean success = list.stream().filter(teacher -> teacher.getName().equals("")).peek(teacher -> log.info("filtered :{}",teacher)).allMatch(teacher -> teacher.getName().equals("aaa"));
//
//        log.info("success: {}",success);


        //
//        try {
//            NullValidator.of(test4a, new IllegalArgumentException("default"))
//                    .notEmpty(Student::getContacts, new IllegalArgumentException("contacts is required but received null"))
//                    .call(Student::getContacts);
//        } catch (IllegalArgumentException ex) {
//            log.error("Sample 4a: IllegalArgumentException>>>>>>>>>>>>>", ex);
//        } catch (Throwable ex) {
//            log.error("Sample 4a: Throwable>>>>>>>>>>>>>", ex);
//        }
//
//        try {
//            List<Teacher> test5a = test4a.getContacts();
//            ListValidator.of(test5a, new IllegalArgumentException("default"))
//                    .notEmptyStringEach(Teacher::getName);
//        } catch (IllegalArgumentException ex) {
//            log.error("Sample 5a: IllegalArgumentException>>>>>>>>>>>>>", ex);
//        } catch (Throwable ex) {
//            log.error("Sample 5a: Throwable>>>>>>>>>>>>>", ex);
//        }
//
//        try {
//            NullValidator.of(test4b, new IllegalArgumentException("default")).notEmpty(Student::getContacts, new IllegalArgumentException("contacts is required but received null"));
//        } catch (IllegalArgumentException ex) {
//            log.error("Sample 4b: IllegalArgumentException>>>>>>>>>>>>>", ex);
//        } catch (Throwable ex) {
//            log.error("Sample 4b: Throwable>>>>>>>>>>>>>", ex);
//        }
//
//        try {
//            List<Teacher> test5b = test4b.getContacts();
//            ListValidator.of(test5b, new IllegalArgumentException("default"))
//                    .notEmptyStringEach(Teacher::getName);
//        } catch (IllegalArgumentException ex) {
//            log.error("Sample 5b: IllegalArgumentException>>>>>>>>>>>>>", ex);
//        } catch (Throwable ex) {
//            log.error("Sample 5b: Throwable>>>>>>>>>>>>>", ex);
//        }


//        try {
//            NullValidator.of(test, new IllegalArgumentException("default")).notNull(Student::getAge, new IllegalArgumentException("age is required but received null"));
//        } catch (Throwable ex) {
//            log.error("Sample 1>>>>>>>>>>>>>", ex);
//        }
//
//        try {
//            NullValidator.of(test, new IllegalArgumentException("default")).notNull(Student::getAge);
//        } catch (Throwable ex) {
//            log.error("Sample 2>>>>>>>>>>>>>", ex);
//        }
//
//        try {
//            NullValidator.of(test2, new IllegalArgumentException("default")).notNull(Student::getAge, new IllegalArgumentException("age is required but received null"));
//        } catch (Throwable ex) {
//            log.error("Sample 3>>>>>>>>>>>>>", ex);
//        }
//
//        try {
//            NullValidator.of(test2, new IllegalArgumentException("default")).notNull(Student::getAge, new IllegalArgumentException("age is required but received null"));
//        } catch (IllegalArgumentException ex) {
//            log.error("Sample 3: IllegalArgumentException>>>>>>>>>>>>>", ex);
//        } catch (Throwable ex) {
//            log.error("Sample 3: Throwable>>>>>>>>>>>>>", ex);
//        }


//
//        try {
//            ListValidator.of(test3, new IllegalArgumentException("default")).notEmpty(Student::getContacts, new IllegalArgumentException("contacts is required but received null")).notEmptyContent(Student::getContacts,String);
//        } catch (IllegalArgumentException ex) {
//            log.error("Sample 4: IllegalArgumentException>>>>>>>>>>>>>", ex);
//        } catch (Throwable ex) {
//            log.error("Sample 4: Throwable>>>>>>>>>>>>>", ex);
//        }


//
//        log.info("Compare byte :{} , {}: Result {} ", "0","0",(byte)1 > 0);
//
//
//        List<Integer> listaaaa = new ArrayList<Integer>(10);
//
//        Optional<String> test = Optional.empty();
//
//        log.info("test isPresent: {}",test.isPresent());
//        log.info("test get: {}",test.get());
//        log.info("listaaaa's size : {}",listaaaa.size());
//
//        listaaaa.add(1);
//        listaaaa.add(2);
//        listaaaa.add(3);
//        listaaaa.add(4);
//        log.info("listaaaa's size 2 : {}",listaaaa.size());
//
//        log.info("Objects.toString{}",Objects.toString(null , ""));
//
//
//        String aa = Objects.toString(null);
//
//        log.info("aa is {}",aa);
//        if(aa.isEmpty()){
//            log.info("aa is empty");
//        }
////        String var = "10.11";
////
////        Course course;
////
//////        Boolean isExist = OP_COD.contains(null);
//////        log.info("isExist:{}",isExist);
////
////        Boolean isExist2 = getOPCodValue().contains("COD");
////        log.info("getOPCodValue:{}",getOPCodValue());
////        log.info("isExist2:{}",isExist2);
//
//        log.info("getIsReprint :{} ",getIsReprint(true));
//        log.info("getIsReprint :{} ",getIsReprint(null));
//        log.info("getIsReprint :{} ",getIsReprint(false));
//
//
//        log.info("a,b = {1,1} : {}",Objects.equals((byte)1,(byte)0));
//
////        try{
//            Long result = Long.parseLong(var);
//            log.info("result :{}",result);
//        }catch (Exception e){
//            log.error("Convert failed : {}",var,e);
//        }

//        TrackingNumberDTO ttt = TrackingNumberDTO.builder().build();
//
//        Optional.ofNullable(ttt.getTeacher().getAge()).orElse(0);

//        try {
//            Date testDate = new Date();
//
//            log.info("Test date :{}, timestamp:{}", testDate, testDate.getTime());
//
////            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
//            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
//            SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
////            format.setTimeZone(TimeZone.getTimeZone("GMT"));
//            String data3 = format.format(testDate);
//            log.info("Test format date :{} , timestamp : {}", data3, testDate.getTime());
//
//            Date date2 = format.parse("2022-09-28T09:50:25+0000");
//            log.info("Test format date :{} , timestamp : {}", date2, date2.getTime());
//
//            Date date3 = format2.parse("2022-09-28T09:50:25+00:00");
//            log.info("Test format date3 :{} , timestamp : {}", date3, date3.getTime());
//
//        } catch (Exception e) {
//            log.error("error",e);
//        }


//        JSONPObject json =


//        List<TrackingNumberDTO> trackingNumberList= Arrays.asList(TrackingNumberDTO.builder().success(false).build(),TrackingNumberDTO.builder().success(true).build());
//
//        log.debug("{}", trackingNumberList.stream().allMatch(TrackingNumberDTO::getSuccess));
//
//        Integer a = Integer.valueOf("-13");
//
//
//
//        log.info(" -13 : {}",a);

//        try{
//            log.debug("{}",new URL("sandbox-download.postmen.com/label/2022-09-07/8a49f9fc-5cf4-4915-a060-f723a38447a8-1662549427236682.pdf","aswproxyhk2.aswatson.net","8080"));
//        }catch (Exception e){
//            log.error("error :",e);
//        }


//        log.info("Testing print null : {} ", uuu);
//        Set<String> retryOrders = Sets.newConcurrentHashSet();
//
//        List<Number> a = Arrays.asList(0);
//        log.debug("size : {}, b:{}",a.size(),a.size()>0);
//
//        List<TestEnum> uuu = new ArrayList<>();
//
//        uuu.add(TestEnum.fromName("CASH_LABEL"));
//
//        System.out.println(uuu);


//        List<Number> a = Arrays.asList(0,11,2222,1000,0.00,1);
//
//        Long b = a.stream()
//                .map(Number::toString)
//                .map(BigDecimal::new)
//                .filter(price -> price.compareTo(BigDecimal.ZERO) == 0)
//                .count();
//
//
//        log.debug("output : {}" ,b);

////        retryOrders.add("1");
//        List<String> aaa = Arrays.asList("1", "2","444","0","00.00");
//        List<String> bbb = Arrays.asList("444");
//        List<String> ccc = Arrays.asList("1", "2","444","4441");
//        List<String> ddd = Collections.emptyList();
//
//        int aauu = (int) aaa.stream().map(BigDecimal::new).filter(price -> price.compareTo(BigDecimal.ZERO) == 0).count();
//        log.debug("1 : {}",aauu);
//        int dduu = (int) ddd.stream().map(BigDecimal::new).filter(BigDecimal.ZERO::equals).count();
//        log.debug("2 : {}",dduu);
//        log.debug(String.valueOf(new BigDecimal("00.00")));
//        log.debug(String.valueOf(new BigDecimal("0")));
//        log.debug(String.valueOf(BigDecimal.ZERO));
//
//        BigDecimal a = new BigDecimal("10");
//
//        log.debug("Compare 10 to .... : {}",a.compareTo(BigDecimal.ZERO));
//
//        AtomicInteger counter = new AtomicInteger(1);
//        log.debug("counter : {}" ,counter);
//        log.debug("counter : {}" ,counter);
//        log.debug("counter : {}" ,counter);
//        log.debug("counter : {}" ,counter);
//        log.debug("counter : {}" ,counter.getAndIncrement());
//        log.debug("counter : {}" ,counter.getAndIncrement());
//
//
////
//
////        if (ccc.size() == aaa.size()+ bbb.size()){
////            log.info("yessssss {} ", ccc.size() == aaa.size()+ bbb.size());
//
//        Map<String, String> doubleBraceMap  = new HashMap<String, String>() {{
//            put("key1", "value1");
//            put("key2", "value2");
//        }};
////        }
//        for (String key : doubleBraceMap.keySet() ){
//            log.debug("key :{}",key);
//            log.debug("value :{}",doubleBraceMap.get(key));
//            log.debug(">>>>>>>>>>"+doubleBraceMap.get("1"));
//
//
//        }
//        doubleBraceMap.values().forEach(v-> System.out.println(v));
//
//
//        Map<String, String> orderDetailItemList = Collections.emptyMap();
//        System.out.println(orderDetailItemList.isEmpty());
//        System.out.println(orderDetailItemList);
//        orderDetailItemList = doubleBraceMap;
//        System.out.println(orderDetailItemList.isEmpty());
//        System.out.println(orderDetailItemList);

//////        retryOrders.addAll(aaa);
//        String uuu = "List" + aaa;
//
//        System.out.println(uuu);

//        Optional<String> optional1 = Optional.ofNullable(null);
//
//
//        System.out.println(optional1.orElse("Response DTO is null"));
////
//        Teacher drChan = Teacher.builder()
//                .name("Chan Ka Ka")
//                .age(40)
//                .id("T20220100021")
//                .gender("F")
//                .educationalBackground("Doctor")
//                .build();
//
//        Student st1 = Student.builder()
//                .name("st1")
//                .gender("F")
//                .id(0)
//                .build();
//
//        ClassRoom room = ClassRoom.builder()
//                .roomNumber(1)
//                .students(Collections.singletonList(st1))
//                .build();
//
//        Course english = Course.builder()
//                .id("CE20220102")
//                .name("Advanced English")
//                .teachers(Collections.singletonList(drChan))
//                .classRooms(room)
//                .build();
//
//        List<Student> studentList = new ArrayList<>();
//
//        Set<Course> testCollectionsSingletonList = new HashSet<>();
//
//        List<Integer> loopList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//
//        loopList.forEach(n -> {
//
//            Student st2 = Student.builder()
//                    .name("st1")
//                    .gender("F")
//                    .id(n)
//                    .build();
//
//            studentList.add(st2);
//        });
//
//        studentList.forEach(s->{
//
//            Course currentEnglish = BeanHelper.copyForBean(Course::new,english);
//            log.debug("current english1: {}", currentEnglish);
//
//            currentEnglish.getClassRooms().setStudents(Collections.singletonList(s));
//
//
////            english.setStudents(Collections.singletonList(st1));
//
//            testCollectionsSingletonList.add(currentEnglish);
//
//            log.debug("current english2: {}", currentEnglish);
//
//        });
//
//        log.debug("testCollectionsSingletonList: {}", testCollectionsSingletonList);


//        log.info("List :{}", retryOrders);
//
//        aaa.forEach(a->{
//            try{
//                log.debug(a);
//                if (a != null){
//                    uuu.add(a);
//                }
//            }catch(Exception e){
//                log.error("now Error :{}",a,e);
//                return;
//            }
//            log.info("finished");
//        });
//        if (uuu == null){
//            log.error("hit");
//        }


//        // ENUM
//        List<OrderIdPair> orderIds = new ArrayList<>();
//        OrderIdPair a = OrderIdPair.builder()
//                        .customerOrderId("1").externalOrderId("123123").build();
//        OrderIdPair b = OrderIdPair.builder()
//                .customerOrderId("2").externalOrderId("223223").build();
//        Map<OrderIdPair,String> map = new HashMap<>();
////        orderIds.add(a);
////        orderIds.add(b);
////        System.out.println(orderIds);
////        orderIds.remove("2");
////        System.out.println(orderIds);
//
//        map.put(a,"uuuu");
//        map.put(b,"wwww");
//        System.out.println(map);
//        map.remove(a);
//        System.out.println(map);
//        // ENUM


//
//        //BigDecimal test
//
//        BigDecimal aa = BigDecimal.valueOf(33.44);
//        BigDecimal bb = BigDecimal.valueOf(3);
//
//        BigDecimal cc = aa.divide(bb, 4, BigDecimal.ROUND_HALF_UP);
//
//        System.out.println(cc);
//
//        //BigDecimal test


////        RegexTest
//        String ss = "C:\\Users\\USER\\Desktop\\History\\TEST\\ftp_Test";
//        Matcher regex1 = Pattern.compile("^Infinity_(?:Store|HiLife)Order_(\\d{8})\\d*\\.zip$").matcher(""); //0,012
//        Matcher regex2 = Pattern.compile("^Infinity_(Store|HiLife)Order_(\\d{8})\\d*\\.zip$").matcher(""); //0.013
//        long timesToDo = 1000;
//
////        StringBuffer temp = new StringBuffer();
//        List<String> tempList = new ArrayList<>();
//        for (int i = 500; i > 0; i--) {
//            tempList.add("Infinity_HiLifeOrder_20200110012201.zip");
//            tempList.add("Infinity_StoreOrder_20200110012201.zip");
//        }
////        String testString = temp.toString();
//        System.out.println(tempList.size());
//
//        long count = timesToDo;
//        long startTime = System.currentTimeMillis();
//        for (int i = 0 ; i < tempList.size() ; i++) {
//            regex1.reset(tempList.get(i)).find();
//        }
//        double millisSeconds = (System.currentTimeMillis() - startTime) / 1000.0;
//        System.out.println("Seconds " + millisSeconds);
//
////        RegexTest


//        String bb = testChangeNull(null);
//        System.out.println(aa);


//        AtomicReference<Boolean> sendAlert = new AtomicReference<>(false);
//        AtomicBoolean sendAlert = new AtomicBoolean(false);
//        sendAlert.set(true);
//        System.out.println(">>>>>>>>>>>>>>>>"+sendAlert.get());
//        sendAlert.set(true);
//        sendAlert.set(true);
//        sendAlert.set(true);
//        sendAlert.set(false);
//        System.out.println(">>>>>>>>>>>>>>>>"+sendAlert.get());
//        if (sendAlert.get()){
//            System.out.println("okKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK");
//        }
//        Boolean sendttt=false;
////        System.out.println("sendttt>>>>>>>>>>>>>>>>"+sendttt);
////        sendttt=false;
////        sendttt=false;
////        sendttt=false;
////        sendttt=true;
////        System.out.println("sendttt>>>>>>>>>>>>>>>>"+sendttt);
//        for ( int i =0 ; i<10 ; i++){
//            if (i == 5){
//                sendttt = true;
//            }
//            System.out.println("sendttt>>>>>>>>>>>>>>>>"+sendttt);
//        }


//        TestOverride ttt = new TestOverride();
//        System.out.println(ttt.getValue());


//        String a = "520";
//        String b = "NOSKUID";
//
//        System.out.println(a.equalsIgnoreCase(b));


//        Integer itemLimit = 20;
//        List<String> mpItems = new ArrayList<>();
//        mpItems.add("123");
//        mpItems.add("123");
//        mpItems.add("123");
//        mpItems.add("123");
//        mpItems.add("123");
//        mpItems.add("123");
//        mpItems.add("123");
//        mpItems.add("123");
//        mpItems.add("123");
//        mpItems.add("123");
//
//        System.out.println("ok");
//        System.out.println("here"+itemLimit.compareTo(mpItems.size()));
//
//        int result = itemLimit - mpItems.size();
//        System.out.println(result);


//        List<String> mpItems = new ArrayList<>();
//        System.out.println(mpItems.size());

//
//////        Git test
//        try {
//            JGitUtil jGitUtil = new JGitUtil();
//            String index = "C:\\ASWAS\\Git";
//            // with one project
//            ProjectEnum targetRepo = ProjectEnum.MP_SHOPEE;
//            Path repoPath = jGitUtil.getProjectRepo(index, targetRepo);
//            System.out.println("RepoPath :" + repoPath);
////            jGitUtil.getRepoDiff(repoPath);
//            jGitUtil.getLog(repoPath);
//            // with one project
////            Set<Path> RepoPathAll = jGitUtil.getProjectRepo(index);
////            System.out.println("RepoPathAll :" + RepoPathAll);
////            for ( Path repoPath : RepoPathAll) {
////                System.out.println(repoPath);
////                jGitUtil.openRepo2(repoPath);
////                jGitUtil.closeRepo();
//////                jGitUtil.getRef();
////                jGitUtil.getRepoDiff(repoPath);
////
////
////            }
//
//
//
////            File[] repoIndex = new File(index).listFiles(File::isDirectory).;
////            System.out.println(repoIndex.);
//
//
////            jGitUtil.openRepo(repo);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//////        Git test

        // copy file
//        for (int i = 4; i < 100; i++) {
//            String number = String.format("%03d", i).substring(0, 3);
////            System.out.println(number);
//            String filename = "Infinity_EDC-00022222" + number + ".pdf";
////            System.out.println(filename);
//            String folder = "C:\\Users\\USER\\Desktop\\History\\TEST\\ftp_Test_1\\Infinity_StoreOrder_20200110-02\\";
//            File original = new File(folder + "Infinity_EDC-00022222001.pdf");
//            File copied = new File(folder + filename);
//            try (
//                    InputStream in = new BufferedInputStream(
//                            new FileInputStream(original));
//                    OutputStream out = new BufferedOutputStream(
//                            new FileOutputStream(copied))) {
//
//                byte[] buffer = new byte[1024];
//                int lengthRead;
//                while ((lengthRead = in.read(buffer)) > 0) {
//                    out.write(buffer, 0, lengthRead);
//                    out.flush();
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
        // copy file

//
//        String localPath ="C:\\Users\\USER\\Desktop\\History\\TEST\\Testforpath";
//        String localPath2 ="C:\\Users\\USER\\Desktop\\History\\TEST\\Testforpath2";
//        String matchFile ="Infinity_HiLifeOrder_20200110012201.zip";
////
////        File sourceFile = new File(localPath + matchFile);
//
//
//        String filename = "Infinity_EDC-000000001463008.pdf";
//        Boolean match = isMatch("^Infinity_EDC-\\d*(\\d{8})\\.pdf$", filename);
//        System.out.println(match);
//        String checkOrderNo = getDocumentOrderNo("^Infinity_EDC-\\d*(\\d{8})\\.pdf$", filename);
//        System.out.println(checkOrderNo);
//        String reslut = checkOpDocuvvvmentType(matchFile);
//        System.out.println(reslut);


//        String fileSeparator = FileSystems.getDefault().getSeparator();
//        System.out.println(checkLocalDir("vvvvvv\\"));
//        System.out.println(fileSeparator);
//        File testFile = new File(localPath);
//        File testFile2 = new File(localPath2+'/');
//        testFile.mkdir();
//        testFile2.mkdir();
//        System.out.println(testFile2.getName());
//        System.out.println(testFile2+"nanme");


//        not suggested nested try catch
//        try{
//            System.out.println("in 1");
//            try{
//                System.out.println("in 2");
//                try{
//                    System.out.println("in 3");
//                    throw new Exception("e");
//                }catch(Exception e){
//                    System.out.println("in 3 e");
//                }
//                System.out.println("in 2 end");
//            }catch(Exception e){
//                System.out.println("in 2 e");
//            }
//            System.out.println("in 1 end");
//        }catch(Exception e){
//            System.out.println("in 1 e");
//        }
//
//        BigDecimal normalPrice = new BigDecimal(12);
//        BigDecimal totalQuantity = new BigDecimal(10);
//        BigDecimal voucherSeller = new BigDecimal(30);
//
//        System.out.println(normalPrice.multiply(totalQuantity).subtract(voucherSeller));
//
//
//
//
//
//
//
////        System.out.println("Hello World");
////        Date finalDay;
////        Date ddd = new Date(1627421000000L);
////        System.out.println(1111L > 99999999999L);
////        Long dd = ddd.getTime();
////        if ( dd <= 99999999999L){
////            Long longtime = dd*1000L;
////            finalDay = new Date(longtime);
////        }else {
////            finalDay = ddd;
////        }
////        System.out.println(finalDay);
//
////        List<Integer> numList = Arrays.asList(10,21,31,40,59,60);
////        numList.removeAll(numList.stream()
////                .filter(n -> n%10 ==0)
////                .collect(Collectors.toList()));
//
////        System.out.println(numList);
//
//        DataPair test1 = new DataPair();
//        test1.setA("123");
//        test1.setB("321");
//        DataPair test2 = new DataPair();
//        test2.setA("456");
//        test2.setB("654");
//
//        List<DataPair> list1 = new ArrayList<DataPair>();
//        list1.add(test1);
//        list1.add(test2);
//        list1.add(null);
//
//        List<DataPair> list2 = null;
//
////        List<DataPair> testLoop = (List<DataPair>) Optional.ofNullable(list2).orElseGet(Collections::emptyList);
////        for(DataPair i : testLoop ){
////            System.out.println("in testloop: "+i);
////        }
//
//
//        /*
//        if(ddd.getYear() != java.time.YearMonth.now().getYear()){
//            System.out.println(ddd.getYear());
//            System.out.println(java.time.YearMonth.now().getYear());
//        }*/
//        /*
//        List<Integer> numList = Arrays.asList(10,21,31,40,59,60);
//        numList.forEach(n->{
//            System.out.println("Start new for each");
//            if( n%10 == 0 ){
//                System.out.println(n + " is devided by 10" );
//                return;
//            }
//            System.out.println(n+ "+++++++++++out of if" );
//        });
//         */
//        /*
//        try {
//            System.out.println("in try");
//            List<Integer> numList = Arrays.asList(10, 21, 31, 40, 59, 60);
//            numList.forEach(n -> {
//                System.out.println("in try");
//                if (n % 10 == 0) {
//                    Exception devidedByTen = new Exception("eeeeeee");
//                }
//                System.out.println("after e");
//            });
//        } catch (Exception e) {
//
//        }
//        */
//
////        Stream stream = Stream.of("a1", "b1", "c1");
////        Stream stream2 = Stream.of("a1", "b1", "c1");
////        ArrayList<String> arrays1 = new ArrayList<String>(Arrays.asList("normal","thermal", "other", "yyyy", "aaaa", "bcbccc"));
////        String ss1 = "123";
////        NullType ss2 = null;
////        stream.peek(a-> System.out.println("with collect: "+a) ).collect(Collectors.toList());//Print a1b1c1
////        stream2.peek(a-> System.out.println("without collect: "+a) );
////        boolean result = arrays1.stream().anyMatch(a-> a.contains("thermal"));
    }


}
