package com.sheepshop.model.resp;

import java.util.Date;

public interface BillTaiQuayResponse {
    Integer getId();
    String getCode();
    Date getPurchaseDate();
    Integer getStatus();
}
