/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.urv.deim.sob;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 *
 * @author Daniel
 */
public class Offer {
    
private int offer_id;
private String offer_title; 
private String description;
private int available_sits;
private float price_pperson;
private String destination;
private Calendar departure_date;
private Calendar arrival_date; //comprobar que es igual a departure_date + stay_days
private int stay_days;
private String big_description;

    public Offer(int offer_id, String offer_title, String description, int available_sits, float price_pperson, String destination, int stay_days,Calendar departure_date,Calendar arrival_date,String big_description) {
        this.offer_id = offer_id;
        this.offer_title = offer_title;
        this.description = description;
        this.available_sits = available_sits;
        this.price_pperson = price_pperson;
        this.destination = destination;
        this.stay_days = stay_days;
        this.departure_date = departure_date;
        this.arrival_date = arrival_date;
        this.big_description=big_description;
    }



    public int getOffer_id() {
        return offer_id;
    }

    public String getOffer_title() {
        return offer_title;
    }

    public String getDescription() {
        return description;
    }

    public int getAvailable_sits() {
        return available_sits;
    }

    public float getPrice_pperson() {
        return price_pperson;
    }

    public String getDestination() {
        return destination;
    }

    public Calendar getDeparture_date() {
        return departure_date;
    }
    
    public String getArrival_dateString(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date data =  getArrival_date().getTime();
        String date = sdf.format(data);
        return date;
    }
    
    public String getDeparture_dateString(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date data =  getDeparture_date().getTime();
        String date = sdf.format(data);
        return date;
    }

    public Calendar getArrival_date() {
        return arrival_date;
    }

    public int getStay_days() {
        return stay_days;
    }

    public void setOffer_id(int offer_id) {
        this.offer_id = offer_id;
    }

    public void setOffer_title(String offer_title) {
        this.offer_title = offer_title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAvailable_sits(int available_sits) {
        this.available_sits = available_sits;
    }

    public void setPrice_pperson(float price_pperson) {
        this.price_pperson = price_pperson;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDeparture_date(Calendar departure_date) {
        this.departure_date = departure_date;
    }

    public void setArrival_date(Calendar arrival_date) {
        this.arrival_date = arrival_date;
    }

    public void setStay_days(int stay_days) {
        this.stay_days = stay_days;
    }
    
    public String getBig_description() {
        return big_description;
    }

    public void setBig_description(String big_description) {
        this.big_description = big_description;
    }
      
}