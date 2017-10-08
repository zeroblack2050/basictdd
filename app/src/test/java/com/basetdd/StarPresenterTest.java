package com.basetdd;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Created by Superadmin1 on 07/10/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class StarPresenterTest {

    StarPresenter starPresenter;

    @Mock   private StarActivity starActivity; //doesn't need for this test

    @Before public void setUp(){
        starPresenter = Mockito.spy(new StarPresenter());
    }

    @Test   public void methodDiscountShouldReturnZero(){

        int count = 0;
        int discount = 0;
        //when(starPresenter.getDiscountPresenter(count)).thenReturn(discount);
        int discountExpected = starPresenter.getDiscountPresenter(count);
        Assert.assertEquals(discountExpected,discount);
    }

    @Test   public void methodDiscountShouldReturnThirty(){

        int count = 90;
        int discount = 30;
        //when(starPresenter.getDiscountPresenter(count)).thenReturn(discount);
        int discountExpected = starPresenter.getDiscountPresenter(count);
        Assert.assertEquals(discountExpected,discount);
    }

    @Test   public void methodDiscountShouldReturnFifteen(){

        int count = 40;
        int discount = 15;
        //when(starPresenter.getDiscountPresenter(count)).thenReturn(discount);
        int discountExpected = starPresenter.getDiscountPresenter(count);
        Assert.assertEquals(discountExpected,discount);
    }

    @Test   public void methodDiscountShouldReturnFifteenRange(){

        int count = 100;
        int discount = 30;
        //when(starPresenter.getDiscountPresenter(count)).thenReturn(discount);
        int discountExpected = starPresenter.getDiscountPresenter(count);
        Assert.assertEquals(discountExpected,discount);
    }

    @Test   public void methodGetTotalShouldReturnWithDiscountZero(){
        int count = 25;
        int price = 400;
        int totalExpected = 10000;
        int total = starPresenter.getTotalPresenter(count,price);
        Assert.assertEquals(totalExpected,total);
    }

    @Test   public void methodGetTotalShouldReturnWithDiscountFifteen(){
        int count = 50;
        int price = 400;
        int totalExpected = 17000;
        int total = starPresenter.getTotalPresenter(count,price);
        Assert.assertEquals(totalExpected,total);
    }

    @Test   public void methodGetTotalShouldReturnWithDiscountThirty(){
        int count = 95;
        int price = 400;
        int totalExpected = 26600;
        int total = starPresenter.getTotalPresenter(count,price);
        Assert.assertEquals(totalExpected,total);
    }

}