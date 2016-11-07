/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.urv.deim.sob;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author Daniel
 */
public class Order {
private float total_price;
private int order_id;
private Date order_date;
private Time order_time;
private String offer_id; 
private int people;
private String user_id;

    public float getTotal_price() {
        return total_price;
    }

    public int getOrder_id() {
        return order_id;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public Time getOrder_time() {
        return order_time;
    }

    public String getOffer_id() {
        return offer_id;
    }

    public int getPeople() {
        return people;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setTotal_price(float total_price) {
        this.total_price = total_price;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public void setOrder_time(Time order_time) {
        this.order_time = order_time;
    }

    public void setOffer_id(String offer_id) {
        this.offer_id = offer_id;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
/*
    @Override
    public String toString() {
        return "Order{" + "total_price=" + total_price + ", order_id=" + order_id + ", order_date=" + order_date + ", order_time=" + order_time + ", offer_id=" + offer_id + ", people=" + people + ", user_id=" + user_id + '}';
    }
*/

  
}