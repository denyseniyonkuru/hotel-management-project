package org.kkempireofcode.model;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

@Entity
@Table(name = "room")
@Transactional
public class Room {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int roomId;

    @Column
    private String description;

    @Column
    private String status;

    @Column
    private Double price;

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
