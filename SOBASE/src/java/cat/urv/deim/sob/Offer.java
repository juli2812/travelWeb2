/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.urv.deim.sob;
import java.util.Date;


/**
 *
 * @author Daniel
 */
public class Offer {
    
private int oferr_id;
private String offer_title; 
private String description;
private int available_sits;
private float price_pperson;
private String destination;
private Date departure_date;
private Date arrival_date; //comprobar que es igual a departure_date + stay_days
private int stay_days;

    public Offer(int oferr_id, String offer_title, String description, int available_sits, float price_pperson, String destination, int stay_days) {
        this.oferr_id = oferr_id;
        this.offer_title = offer_title;
        this.description = description;
        this.available_sits = available_sits;
        this.price_pperson = price_pperson;
        this.destination = destination;
        this.stay_days = stay_days;
    }



    public int getOferr_id() {
        return oferr_id;
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

    public Date getDeparture_date() {
        return departure_date;
    }

    public Date getArrival_date() {
        return arrival_date;
    }

    public int getStay_days() {
        return stay_days;
    }

    public void setOferr_id(int oferr_id) {
        this.oferr_id = oferr_id;
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

    public void setDeparture_date(Date departure_date) {
        this.departure_date = departure_date;
    }

    public void setArrival_date(Date arrival_date) {
        this.arrival_date = arrival_date;
    }

    public void setStay_days(int stay_days) {
        this.stay_days = stay_days;
    }
      
}