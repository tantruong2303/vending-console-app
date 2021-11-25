/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Order;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.util.TimeZone;

/**
 *
 * @author Lenovo
 */
public class OrderService extends ArrayList<Order> {

    public OrderService() {
        super();
    }

    public boolean isWin(float winRate) {
        Random generator = new Random();
        float test = generator.nextFloat();
        return test <= winRate;
    }

    public boolean isEnoughCondition() {
        if (this.size() < 3) {
            return false;
        }
        return this.get(this.size() - 1).getProduct().getName().equals(this.get(this.size() - 2).getProduct().getName())
                && this.get(this.size() - 1).getProduct().getName().equals(this.get(this.size() - 3).getProduct().getName());
    }

    public float calculateWinRate(int budget, float winRate) {
        if (budget > 0 && isResetBudget()) {
            return winRate += winRate * 0.5;
        } else if (budget == 0 && isResetBudget()) {
            return 0.1F;
        }
        return winRate;
    }

    public boolean isResetBudget() {
        if (this.size() < 2) {
            return false;
        }

        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Vietnam/Hanoi"));
        calendar.setTime(this.get(this.size() - 1).getOrderDate());
        int day1 = calendar.get(Calendar.DAY_OF_MONTH);
        calendar.setTime(this.get(this.size() - 2).getOrderDate());
        int day2 = calendar.get(Calendar.DAY_OF_MONTH);
        return day1 > day2;
    }
}
