package TestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import top.BinGCU.controller.FleaMarketController;

public class TestFleaMarketController {

    @Test
    public void obtainFleaProductCoversTest() throws JsonProcessingException {
        FleaMarketController fleaMarketController = new FleaMarketController();

        String json = fleaMarketController.obtainFleaProductCovers();

        System.out.println("json："+json);
    }
}
