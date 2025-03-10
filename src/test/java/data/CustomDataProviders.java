package data;

import org.testng.annotations.DataProvider;

public class CustomDataProviders {
    public static final String DP_ITEM = "Data item";

    @DataProvider(name = DP_ITEM)
    public Object[][] itemsDataProvider() {
        final var itemList = ExcelReader.readItemList();
        final var n = itemList.size();
        final var object = new Object[n][];

        for (var i = 0; i < n; i++) {
            object[i] = new Object[]{itemList.get(i)};
        }

        return object;
    }
}
