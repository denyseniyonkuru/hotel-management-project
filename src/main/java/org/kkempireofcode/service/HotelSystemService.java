package org.kkempireofcode.service;

import org.kkempireofcode.model.*;

import java.sql.Date;
import java.util.List;

public interface HotelSystemService {
    public User getUSer(String username, String password);
    public Room getRoom(String description,double price,String status);
    public List<User> getAllUSers();
    public List<Room> getAllRooms();
    public void addUser(User user);
    public void addRoom(Room room);
    public void saveReservation(Reservation reservation);
    public List<Reservation> getAllReservation();
    public List<Reservation> getAllPendingReservations();
    public void editUser(User user);
    public void removeUser(User user);
    public void editRoom(Room room);
    public void removeRoom(Room room);
    public User getUSer(int id);
    public Room getRoom(int id);
    public List<Room> getAllAvailableRooms();
    public void addBooking(Booking booking);
    public List<Reservation> getAllReservationsFromDate(Date dateFrom);
    public List<Booking> getAllBookingsFromDate(Date dateFrom);
    public List<Booking> getAllBookingsByStartDateAndEndDate(Date startDate,Date endDate);

    public Booking getBooking(int id);

    public void addItem(Item item);
    public List<Item> getAllItems();
    public void addSellItem(Sell sell);



}
