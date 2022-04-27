package org.kkempireofcode.service;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.kkempireofcode.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Repository
public class HotelSystemDAOImpl implements HotelSystemDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public User getUSer(String username, String password) {
        User user=null;

        Query qr=sessionFactory.getCurrentSession().createQuery("FROM User");
        List<User> result=(List<User>) qr.list();

        for (User u:result) {
            if (u.getUserName().equals(username) && u.getPassword().equals(password)){
                user=u;
                break;
            }
        }
        return user ;
    }

    public List<User> getAllUSers() {
        Query qr=sessionFactory.getCurrentSession().createQuery("FROM User");
        List<User> result=(List<User>) qr.list();
        return result;
    }

    public List<Room> getAllRooms() {
        Query qr=sessionFactory.getCurrentSession().createQuery("FROM Room");
        List<Room> result=(List<Room>) qr.list();
        return result;
    }

    public List<Reservation> getAllReservation() {
        Query qr=sessionFactory.getCurrentSession().createQuery("FROM Reservation");
        List<Reservation> result=(List<Reservation>) qr.list();
        return result;
    }

    public void addUser(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    public void saveReservation(Reservation reservation) {
        sessionFactory.getCurrentSession().saveOrUpdate(reservation);
        Room room=getRoom(reservation.getRoomId());
        room.setStatus("Reserved");
        addRoom(room);

    }


    public void editUser(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    public void removeUser(User user) {
        sessionFactory.getCurrentSession().delete(user);
    }

    public void editRoom(Room room) {
        sessionFactory.getCurrentSession().update(room);
    }

    public void removeRoom(Room room) {
        sessionFactory.getCurrentSession().delete(room);
    }

    public Room getRoom(String description, double price, String status) {
        Room room=null;

        Query qr=sessionFactory.getCurrentSession().createQuery("FROM Room");
        List<Room> result=(List<Room>) qr.list();

        for (Room r:result) {
            if (r.getDescription().equals(description) && r.getStatus().equals(status)){
                room=r;
                break;
            }
        }
        return room ;
    }

    public void addRoom(Room room) {

        sessionFactory.getCurrentSession().saveOrUpdate(room);
    }

    public User getUSer(int id) {
        User user=null;

        Query qr=sessionFactory.getCurrentSession().createQuery("FROM User WHERE id="+id);
        List<User> result=(List<User>) qr.list();
        return result.get(0) ;
    }

    public Room getRoom(int id) {
        Room room=null;

        Query qr=sessionFactory.getCurrentSession().createQuery("FROM Room WHERE id="+id);
        List<Room> result=(List<Room>) qr.list();
        return result.get(0) ;
    }

    public List<Reservation> getAllPendingReservations() {
        Query qr=sessionFactory.getCurrentSession().createQuery("FROM Reservation order by roomId desc");
        List<Reservation> result=(List<Reservation>) qr.list();

        List<Reservation> pendingReservations=new ArrayList<Reservation>();

        for (Reservation reservation:result) {
            if(reservation.getResStatus().equals("Pending")){
                pendingReservations.add(reservation);
            }
        }
        return pendingReservations;
    }

    public List<Room> getAllAvailableRooms() {
        Query qr=sessionFactory.getCurrentSession().createQuery("FROM Room");
        List<Room> result=(List<Room>) qr.list();
        List<Room> availableRooms=new ArrayList<Room>();

        for (Room room:result) {
           if (room.getStatus().equals("Available")||room.getStatus().equals("Reserved")){
               availableRooms.add(room);
           }
        }
        return availableRooms;
    }

    public void addBooking(Booking booking) {
        sessionFactory.getCurrentSession().saveOrUpdate(booking);
    }

    public List<Reservation> getAllReservationsFromDate(Date dateFrom) {
        Query qr=sessionFactory.getCurrentSession().createQuery("FROM Reservation order by roomId");

        List<Reservation> result=(List<Reservation>) qr.list();

        List<Reservation> reservationsAfterDate=new ArrayList<Reservation>();

        for (Reservation res:result) {
            if (res.getStartDate().after(dateFrom) || res.getStartDate().equals(dateFrom)){
                reservationsAfterDate.add(res);
            }
        }

        return reservationsAfterDate;
    }

    public List<Booking> getAllBookingsFromDate(Date dateFrom) {
        Query qr=sessionFactory.getCurrentSession().createQuery("FROM Booking order by roomId");

        List<Booking> result=(List<Booking>) qr.list();

        List<Booking> bookingAfterDate=new ArrayList<Booking>();

        for (Booking booking:result) {
            if (booking.getStartDate().after(dateFrom) || booking.getStartDate().equals(dateFrom)){
                bookingAfterDate.add(booking);
            }
        }

        return bookingAfterDate;
    }

    @Override
    public Booking getBooking(int id) {
        Booking booking=null;
        Query qr=sessionFactory.getCurrentSession().createQuery("FROM Booking WHERE bookingId="+id);
        List<Booking> result=(List<Booking>) qr.list();
        return result.get(0) ;
    }

    @Override
    public List<Booking> getAllBookingsByStartDateAndEndDate(Date startDate, Date endDate) {
        Query qr=sessionFactory.getCurrentSession().createQuery("FROM Booking order by roomId");

        List<Booking> result=(List<Booking>) qr.list();

        List<Booking> bookingByStartDateAndEndDate=new ArrayList<Booking>();

        System.out.println("StartDate:"+startDate.toString());
        System.out.println("EndDate:"+endDate.toString());

        for (Booking booking:result) {
            if (
                    (booking.getStartDate().after(startDate) || booking.getStartDate().equals(startDate))
                            &&
                            (booking.getStartDate().before(endDate) || booking.getStartDate().equals(endDate))
            ){
                bookingByStartDateAndEndDate.add(booking);
            }
        }
        System.out.println("bookingByStartDateAndEndDate Size:"+bookingByStartDateAndEndDate.size());

        return bookingByStartDateAndEndDate;
    }

    @Override
    public void addItem(Item item) {
        sessionFactory.getCurrentSession().saveOrUpdate(item);
    }

    @Override
    public List<Item> getAllItems() {
        Query qr=sessionFactory.getCurrentSession().createQuery("FROM Item");
        List<Item> result=(List<Item>) qr.list();
        return result;
    }

    @Override
    public void addSellItem(Sell sell) {
        sessionFactory.getCurrentSession().saveOrUpdate(sell);
    }
}
