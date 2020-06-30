package TestService;

import org.junit.Test;
import org.springframework.http.ResponseEntity;
import top.BinGCU.service.Impl.ResourcesParsingServiceImpl;

import java.io.IOException;


public class TestResourcesParsingServiceImpl {

    @Test
    public void obtainAvatarReponseEntityTest(){
        ResourcesParsingServiceImpl rps = new ResourcesParsingServiceImpl();

        String readPath = "J:\\IdeaProjects\\StudentCampusWebsite\\out\\artifacts\\StudentCampusWebsite_war_exploded\\WEB-INF\\static\\img\\avatar\\defaultAvatar.jpg";
        String downName = "defaultAvatar.jpg";

        ResponseEntity<byte[]> responseEntity = null;
        try {
            responseEntity = rps.obtainAvatarReponseEntity(downName, readPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(">>>>>>>>>>>>><");
        System.out.println("Headers："+responseEntity.getHeaders());
        System.out.println("Body："+responseEntity.getBody());
        System.out.println("StatusCode："+responseEntity.getStatusCode());
        System.out.println("StatusCodeValue："+responseEntity.getStatusCodeValue());


    }
}
