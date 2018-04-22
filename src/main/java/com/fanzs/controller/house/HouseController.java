package com.fanzs.controller.house;

import com.fanzs.base.APIResponse;
import com.fanzs.service.house.AddressService;
import com.fanzs.service.user.ServiceMultiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by fzs on 2018/4/20.
 */
@Controller
public class HouseController {
    @Autowired
    private AddressService addressService;

    @GetMapping("address/support/cities")
    @ResponseBody
    public APIResponse getSupportCities(){
        ServiceMultiResult<SupportAddressDTO> result=addressService.findAllCities();
        if(result.getResultSize()==0){
//            return APIResponse.ofSuccess(APIResponse.Status.NOT_FOUND);
        }
//        return APIResponse.ofSuccess(result.getResult());
        return null;
    }


}
