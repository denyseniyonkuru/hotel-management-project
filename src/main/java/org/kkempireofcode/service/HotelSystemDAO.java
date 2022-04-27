package org.kkempireofcode.service;

import org.kkempireofcode.model.*;

import java.sql.Date;
import java.util.List;

public interface HotelSystemDAO {
    public User getUSer(String username, String password);
    public List<User> getAllUSers();
    public List<Room> getAllRooms();
    public List<Reservation> getAllReservation();
    public void addUser(User user);
    public void saveReservation(Reservation reservation);
    public void editUser(User user);
    public void removeUser(User user);
    public void editRoom(Room room);
    public void removeRoom(Room room);
    public Room getRoom(String description,double price,String status);
    public void addRoom(Room room);
    public User getUSer(int id);
    public Room getRoom(int id);
    public List<Reservation> getAllPendingReservations();
    public List<Room> getAllAvailableRooms();
    public void addBooking(Booking booking);
    public List<Reservation> getAllReservationsFromDate(Date dateFrom);
    public List<Booking> getAllBookingsFromDate(Date dateFrom);
    public Booking getBooking(int id);
    public List<Booking> getAllBookingsByStartDateAndEndDate(Date startDate,Date endDate);
    public void addItem(Item item);
    public List<Item> getAllItems();
    public void addSellItem(Sell sell);

}
