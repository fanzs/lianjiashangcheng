package com.fanzs.service.house;

import com.fanzs.controller.house.SupportAddressDTO;
import com.fanzs.service.user.ServiceMultiResult;

/**
 * Created by fzs on 2018/4/20.
 */
public interface AddressService {
    ServiceMultiResult<SupportAddressDTO> findAllCities();
}
