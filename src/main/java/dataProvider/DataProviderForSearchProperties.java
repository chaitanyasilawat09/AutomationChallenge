package dataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;

public class DataProviderForSearchProperties {

    @DataProvider(name = "testDPMultipleData")
    public Object[][] MultipleData() {
        return new Object[][]{{"Abc@gmail.com","Abc$123"}};
    }
}
