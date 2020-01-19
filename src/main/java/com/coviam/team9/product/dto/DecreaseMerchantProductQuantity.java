package com.coviam.team9.product.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DecreaseMerchantProductQuantity {
    private String _id;
    private int quantity;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
