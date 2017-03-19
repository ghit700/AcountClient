package com.nan.acountclient.event;

import com.nan.acountclient.entity.Bill;

/**
 * Created by wzn on 2017/3/12.
 */

public class AddBillEvent {
    private Bill bill;

    public AddBillEvent(Bill bill) {
        this.bill = bill;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }
}
