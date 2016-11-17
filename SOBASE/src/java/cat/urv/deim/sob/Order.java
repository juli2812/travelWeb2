/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.urv.deim.sob;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Daniel
 */
public class Order {
private float total_price;
private int order_id;
private Calendar order_date;
private Time order_time;
private int offer_id; 
private int people;
private String user_id;
public static int numCom=5;

    public Order(float total_price, int order_id, Calendar order_date, Time order_time, int offer_id, int people, String user_id) {
        this.total_price = total_price;
        this.order_id = order_id;
        this.order_date = order_date;
        this.order_time = order_time;
        this.offer_id = offer_id;
        this.people = people;
        this.user_id = user_id;
    }
    public Order(float total_price, Calendar order_date, Time order_time, int offer_id, int people, String user_id) {
        this.total_price = total_price;
        this.order_date = order_date;
        this.order_time = order_time;
        this.offer_id = offer_id;
        this.people = people;
        this.user_id = user_id;
        this.order_id=numCom;
        numCom++;
    }
    public Order (){
    }

    public float getTotal_price() {
        return total_price;
    }

    public int getOrder_id() {
        return order_id;
    }

    public Calendar getOrder_date() {
        return order_date;
    }

    public Time getOrder_time() {
        return order_time;
    }

    public int getOffer_id() {
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

    public void setOrder_date(Calendar order_date) {
        this.order_date = order_date;
    }

    public void setOrder_time(Time order_time) {
        this.order_time = order_time;
    }

    public void setOffer_id(int offer_id) {
        this.offer_id = offer_id;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
    public String getComandaInfo() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date data =  getOrder_date().getTime();
        String date = sdf.format(data);
        return "<b>#"+order_id+"</b> Aquesta comanda ha estat realitzada per un total de "+people+" persones. El preu total és de "+total_price+" euros, reservat amb data "+date+" a les "+getOrder_time().toString()+" la oferta és la núm. "+offer_id;
    }
    public String getComandaReserva() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date data =  getOrder_date().getTime();
        String date = sdf.format(data);
        return "<b>Comanda #"+order_id+"</b> reservada.<br>Aquesta comanda ha estat "
                + "realitzada per un total de "+people+" persones.<br>El preu total "
                + "és de "+total_price+" euros, reservat amb data "+date+" a les "+getOrder_time().toString()+
                " la oferta és la núm. "+offer_id;
    }
  
}