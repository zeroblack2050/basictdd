package com.basetdd;

/**
 * Created by Superadmin1 on 07/10/2017.
 */

public class StarPresenter  {


    public int getDiscountPresenter(int count) {
        if(count >= 90){
            return 30;
        }
        if(count >= 40){
            return 15;
        }
        return 0;
    }

    public int getTotalPresenter(int count, int price) {
        int discount = getDiscountPresenter(count);
        int total = (price - price*discount/100)*count;
        return total;
    }
}
