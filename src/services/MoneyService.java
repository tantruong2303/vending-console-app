/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Money;
import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class MoneyService extends ArrayList<Money> {

    public MoneyService() {
        super();
    }

    public boolean isExist(Money money) {
        return this.stream().anyMatch((item) -> (item.getValue() == money.getValue()));
    }

    public boolean addMoney(Money money) {
        if (this.isExist(money)) {
            return false;
        }
        this.add(money);
        return true;
    }
}
