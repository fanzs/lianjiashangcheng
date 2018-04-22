package com.fanzs.service.house;

import com.fanzs.controller.house.SupportAddressDTO;
import com.fanzs.entity.SupportAddress;
import com.fanzs.repository.SupportAddressRepository;
import com.fanzs.service.user.ServiceMultiResult;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fzs on 2018/4/20.
 */
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private SupportAddressRepository supportAddressRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ServiceMultiResult<SupportAddressDTO> findAllCities() {
        List<SupportAddress> address=supportAddressRepository.findAllByLevel(SupportAddress.Level.CITY.getValue());
        ServiceMultiResult<SupportAddressDTO> addressDTOs=new ServiceMultiResult<SupportAddressDTO>();
        for(SupportAddress supportAddress:address){
            SupportAddressDTO target=modelMapper.map(supportAddress,SupportAddressDTO.class);
            addressDTOs.getResult().add(target);
        }
        return addressDTOs;
    }
}
