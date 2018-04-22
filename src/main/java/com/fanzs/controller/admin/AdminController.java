package com.fanzs.controller.admin;

import com.fanzs.base.APIResponse;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;

/**
 * Created by fzs on 2018/4/19.
 */

@Controller
@RequestMapping("/admin")
public class AdminController {
    @GetMapping("/center")
    public String adminCenterPage(){
//        System.out.println("public String adminCenterPage()");
        return "admin/center";
    }

    @GetMapping("/welcome")
    public String welcomeCenterPage(){
        return "admin/welcome";
    }

    @GetMapping("/login")
    public String adminLoginPage(){
        return "admin/login";
    }

    @GetMapping("/add/house")
    public String adminAddHousePage(){
        return "admin/house-add";
    }

    @PostMapping(value = "admin/upload/photo",consumes= MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseBody
    public APIResponse uploadPhoto(@RequestParam("file")MultipartFile file){
        if(file.isEmpty()){
            return APIResponse.ofStatus(APIResponse.Status.NOT_VALID_PARAM);
        }
        String filename=file.getOriginalFilename();
        File target = new File("D:/javacode/April/lianjia/src/main/resources/tmp/"+filename);
        try {
            file.transferTo(target);
        } catch (IOException e) {
            e.printStackTrace();
            return APIResponse.ofStatus(APIResponse.Status.INTERNAL_SERVER_ERROR);
        }
        return APIResponse.ofSuccess(null);
    }

}
