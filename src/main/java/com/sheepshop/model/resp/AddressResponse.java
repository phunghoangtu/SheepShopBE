package com.sheepshop.model.resp;

public interface AddressResponse {
    Integer getId();
    String getFullname();
    String getPhone();
    String getAddress();
    String getCityName();
    String getDistrictName();
    String getWardName();
    Integer getCityId();
    Integer getDistrictId();
    Integer getWardId();
    Integer getIdCustomer();
    Integer getStatus();

}
