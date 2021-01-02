package star.wars.utils;

public class StarWarsUtils {
    private static final String EMPTY_OBJECT = "{}";

//    public static Response retrieveResponseDataList(feign.Response response) {
//        List<String> dataList = new ArrayList<>();
////        if (!isResponseEmpty(response)) {
////            try {
////                JsonParser parser = new JsonParser();
//////                String responseBodyString = response.body().asInputStream();
////            } catch (IOException e) {
////
////            }
////        }
//    }

    private static boolean isResponseEmpty(feign.Response response) {
        return response.body() == null || EMPTY_OBJECT.equals(response.body().toString());
    }
}
