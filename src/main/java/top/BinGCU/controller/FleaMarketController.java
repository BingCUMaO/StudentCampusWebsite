package top.BinGCU.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.BinGCU.service.FleaProductService;
import top.BinGCU.service.Impl.FleaProductServiceImpl;
import top.BinGCU.vo.FleaProductCoverVO;

import java.util.List;

@Controller
public class FleaMarketController {
    private FleaProductService fleaProductService = new FleaProductServiceImpl();

    @RequestMapping("/fleaMarketPage")
    public String fleaMarketPage(){
        return "/html/fleaMarket";
    }

    @RequestMapping(value = "/flea/market/loader/covers", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String obtainFleaProductCovers() throws JsonProcessingException {
        List<FleaProductCoverVO> covers = fleaProductService.obtainCovers();

        ObjectMapper objectMapper = new ObjectMapper();

        String json = objectMapper.writeValueAsString(covers);
        return json;
    }


}
