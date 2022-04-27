package org.kkempireofcode.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "sell")
public class Sell {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int sellId;
    @Column
    private int itemId;
    @Column
    private String name;
    @Column
    private double buyPrice;
    @Column
    private double sellPrice;
    @Column
    private int sellQuantity;
    @Column
    private double interest;
    @Column
    private Date dateCreated;
    @Column
    private String customerIdentifier;

    public int getSellQuantity() {
        return sellQuantity;
    }

    public void setSellQuantity(int sellQuantity) {
        this.sellQuantity = sellQuantity;
    }

    public int getSellId() {
        return sellId;
    }

    public void setSellId(int sellId) {
        this.sellId = sellId;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public Date getDateCreated(Date date) {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getCustomerIdentifier() {
        return customerIdentifier;
    }

    public void setCustomerIdentifier(String customerIdentifier) {
        this.customerIdentifier = customerIdentifier;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }
}
