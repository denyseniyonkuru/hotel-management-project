package org.kkempireofcode.service;

import org.kkempireofcode.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Service
@Transactional
public class HotelSystemServiceImpl implements HotelSystemService {

    @Autowired
    private HotelSystemDAO hotelSystemDao;

    public User getUSer(String username, String password) {
        return hotelSystemDao.getUSer(username,password);
    }

    public Room getRoom(String description, double price, String status) {
        return hotelSystemDao.getRoom(description,price,status);
    }

    public List<User> getAllUSers() {
        return hotelSystemDao.getAllUSers();
    }

    public List<Room> getAllRooms() {
        return hotelSystemDao.getAllRooms();
    }

    public void addUser(User user) {
        hotelSystemDao.addUser(user);
    }

    public void addRoom(Room room) {
    hotelSystemDao.addRoom(room);
    }

    public void saveReservation(Reservation reservation) {
        hotelSystemDao.saveReservation(reservation);
    }

    public List<Reservation> getAllReservation() {
        return hotelSystemDao.getAllReservation();
    }

    public void editUser(User user) {
        hotelSystemDao.editUser(user);
    }

    public void removeUser(User user) {
        hotelSystemDao.removeUser(user);
    }

    public void editRoom(Room room) {
        hotelSystemDao.editRoom(room);
    }

    public void removeRoom(Room room) {
        hotelSystemDao.removeRoom(room);
    }

    public User getUSer(int id) {
        return hotelSystemDao.getUSer(id);
    }

    public Room getRoom(int id) {
        return hotelSystemDao.getRoom(id);
    }

    public List<Room> getAllAvailableRooms() {
        return hotelSystemDao.getAllAvailableRooms();
    }

    public void addBooking(Booking booking) {
        hotelSystemDao.addBooking(booking);
    }

    public List<Reservation> getAllReservationsFromDate(Date dateFrom) {
        return hotelSystemDao.getAllReservationsFromDate(dateFrom);
    }

    public List<Booking> getAllBookingsFromDate(Date dateFrom) {
        return hotelSystemDao.getAllBookingsFromDate(dateFrom);
    }

    @Override
    public List<Booking> getAllBookingsByStartDateAndEndDate(Date startDate, Date endDate) {
        return hotelSystemDao.getAllBookingsByStartDateAndEndDate(startDate,endDate);
    }

    @Override
    public Booking getBooking(int id) {
        return hotelSystemDao.getBooking(id);
    }

    @Override
    public void addItem(Item item) {
        hotelSystemDao.addItem(item);
    }

    @Override
    public List<Item> getAllItems() {
        return hotelSystemDao.getAllItems();
    }

    @Override
    public void addSellItem(Sell sell) {
    hotelSystemDao.addSellItem(sell);
    }

    public List<Reservation> getAllPendingReservations() {
        return hotelSystemDao.getAllPendingReservations();
    }

}
