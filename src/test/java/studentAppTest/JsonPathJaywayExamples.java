package studentAppTest;

import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class JsonPathJaywayExamples {
    static String jsonResponse;
    @BeforeAll
    public static void init(){
        RestAssured.baseURI="http://localhost";
        RestAssured.port = 3030;
        RestAssured.basePath="/products";
        jsonResponse = RestAssured.get().asString();
    }

    @Test
    public void getRoot(){
        Map<String, ?> rootElement = JsonPath.read(jsonResponse,"$");
        System.out.println(rootElement.toString());
    }

    @Test
    public void getTotalFromResponse(){
        int total = JsonPath.read(jsonResponse, "$.total");
        System.out.println(total);
    }

    @Test
    public void getAllTheDataItems(){
//         List<?> list = JsonPath.read(jsonResponse,"$.data");
//         for(Object item : list){
//             System.out.println(item);
//         }

        List<HashMap<String, Object>> dataItems = JsonPath.read(jsonResponse, "$.data");
        dataItems.stream().forEach(item -> System.out.println(item.toString()));
    }
    @Test
    public void getFirstDataElement(){
        Map<String, Object> dataItem = JsonPath.read(jsonResponse, "$.data[0]");
        System.out.println(dataItem.toString());
    }

    @Test
    public void getAllIdsUnderData(){
        List<Integer> allIdsUnderData = JsonPath.read(jsonResponse, "$.data[*].id");
        allIdsUnderData.stream().forEach(System.out::println);

    }

    @Test
    public void getAllIds(){
        List<Object> allIds = JsonPath.read(jsonResponse, "$..[*]..id");
        System.out.println(allIds);
    }

    @Test
    public void getNamesOfProductsWithPriceLessThanFive(){
        List<Object> namesOf = JsonPath.read(jsonResponse, "$.data[?(@.price>5)].name,price");
        System.out.println(namesOf);

    }
}
