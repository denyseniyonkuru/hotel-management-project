package org.kkempireofcode.controller;

import org.kkempireofcode.businesslogic.FileExport;
import org.kkempireofcode.model.Booking;
import org.kkempireofcode.model.Reservation;
import org.kkempireofcode.model.Room;
import org.kkempireofcode.service.HotelSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.Column;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Controller
public class ReceptionController {
    @Autowired
    private HotelSystemService service;
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");


    @RequestMapping(value = "/reception")
    public ModelAndView showReceptionPage(ModelAndView model){
    model.addObject("pendingReservations",service.getAllPendingReservations());
    model.addObject("availableRooms",service.getAllAvailableRooms());
        return model;
    }
    @RequestMapping(value = "/checkin")
    public ModelAndView showCheckInPage(ModelAndView model){

        return model;
    }

    @RequestMapping(value = "/checkinAction", method = RequestMethod.POST)
    public ModelAndView checkinAction(ModelAndView model, HttpServletRequest request) throws ParseException {
        String names=request.getParameter("names");
        String otherNames=request.getParameter("otherNames");
        if (!otherNames.equals("") && otherNames!=null){
            names=otherNames;
        }
        String tel=request.getParameter("tel");
        int roomId=Integer.parseInt(request.getParameter("roomId"));

        Date startDate=sdf.parse(request.getParameter("startDate"));
        Date endDate=sdf.parse(request.getParameter("endDate"));

        Booking book=new Booking();
        book.setNames(names);
        book.setTel(tel);
        book.setRoomId(roomId);
        book.setStartDate(startDate);
        book.setEndDate(endDate);
service.addBooking(book);
model.setViewName("redirect:/reception");

        return model;
    }
    @RequestMapping(value = "/checkout",method = RequestMethod.GET)
    public ModelAndView showCheckOutPage(ModelAndView model, HttpServletRequest request){
        int bookingId=Integer.parseInt(request.getParameter("bookingId"));

        Booking booking=service.getBooking(bookingId);
        Room room=service.getRoom(booking.getRoomId());


       java.sql.Date checkOutDate = new java.sql.Date(new java.util.Date().getTime());
       int nights = (int)TimeUnit.MILLISECONDS.toDays(checkOutDate.getTime() - booking.getStartDate().getTime());
       double amount= (nights-1)*room.getPrice();

        booking.setCheckOutDate(checkOutDate);
        booking.setNights(nights-1);
        booking.setAmount(amount);
        booking.setPayementDone(true);
        service.addBooking(booking);

        model.addObject("booking",booking);

        return model;
    }

    @RequestMapping(value = "/printbookingbill", method = RequestMethod.POST)
    public ModelAndView printBookingBill(ModelAndView model,HttpServletRequest request, HttpServletResponse response){
        int bookingId=Integer.parseInt(request.getParameter("bookingId"));

        Booking booking=service.getBooking(bookingId);
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String filename="bookingBill"+dateFormatter.format(new Date())+".pdf";
        FileExport.printBill(request,response,booking,filename.replaceAll("\\s+",""));

        return  model;
    }


    @RequestMapping(value = "/checkStatus",method = RequestMethod.POST)
    public ModelAndView roomStatus(ModelAndView model, HttpServletRequest request) throws ParseException {
       // String status=request.getParameter("status");

        java.sql.Date dateFrom=new java.sql.Date(sdf.parse(request.getParameter("dateFrom")).getTime());


        HashMap<Integer,List<Reservation>> roomReservations=new HashMap<Integer, List<Reservation>>();

        List<Reservation> reservationsMadeByDateFrom=service.getAllReservationsFromDate(dateFrom);

        for (Reservation res1:reservationsMadeByDateFrom) {

            List<Reservation> reservationsByRoom=new ArrayList<Reservation>();
            for (Reservation res2:reservationsMadeByDateFrom) {
                if(res1.getRoomId() == res2.getRoomId()){
                    reservationsByRoom.add(res2);
                    long millis=res2.getEndDate().getTime() - res2.getStartDate().getTime();
                    int days= (int) TimeUnit.MILLISECONDS.toDays(millis);
                            //(int) (millis/1000*60*60*24);
                    System.out.println("MilliSecond: "+ days);
                }
            }
                roomReservations.put(res1.getRoomId(), reservationsByRoom);

        }

        HashMap<Room,List<Reservation>> roomReservationstmp=new HashMap<Room, List<Reservation>>();

        for (Integer key:roomReservations.keySet()) {
             roomReservationstmp.put(service.getRoom(key),roomReservations.get(key));
        }

        // Booking

        HashMap<Integer,List<Booking>> roomBookings=new HashMap<Integer, List<Booking>>();

        List<Booking> bookingsMadeByDateFrom=service.getAllBookingsFromDate(dateFrom);

        for (Booking booking1:bookingsMadeByDateFrom) {

            List<Booking> bookingsByRoom=new ArrayList<Booking>();
            for (Booking booking2:bookingsMadeByDateFrom) {
                if(booking1.getRoomId() == booking2.getRoomId()){
                    bookingsByRoom.add(booking2);
                }
            }
            roomBookings.put(booking1.getRoomId(), bookingsByRoom);

        }

        HashMap<Room,List<Booking>> roomBookingstmp=new HashMap<Room, List<Booking>>();

        for (Integer key:roomBookings.keySet()) {
            roomBookingstmp.put(service.getRoom(key),roomBookings.get(key));
        }
        model.addObject("pendingReservations",service.getAllPendingReservations());
        model.addObject("availableRooms",service.getAllAvailableRooms());
        model.addObject("roomReservations",roomReservationstmp);
        model.addObject("roomBookings",roomBookingstmp);
        model.setViewName("reception");
        return model;
    }

    @RequestMapping(value = "/report")
    public ModelAndView showReportForm(ModelAndView model){

        return model;
    }

    @RequestMapping(value = "/reportAction",method = RequestMethod.POST)
    public ModelAndView runReport(ModelAndView model, HttpServletRequest request, HttpSession session) throws ParseException {

        java.sql.Date startDate=new java.sql.Date(sdf.parse(request.getParameter("startDate")).getTime());
        java.sql.Date endDate= new java.sql.Date(sdf.parse(request.getParameter("endDate")).getTime());
        String dataType=request.getParameter("dataType");

        System.out.println("StartDate In Controller:"+startDate.toString());
        System.out.println("EndDate  In Controller:"+endDate.toString());
        System.out.println("dataType In Controller:"+dataType);


        List<Booking> bookings=new ArrayList<Booking>();
        List<Reservation> reservations=new ArrayList<Reservation>();

        if(dataType.equals("booking")){
            bookings=service.getAllBookingsByStartDateAndEndDate(startDate,endDate);
        }

        if(dataType.equals("reservation")){

        }

        model.addObject("bookings",bookings);
        session.setAttribute("bookings",bookings);

        model.setViewName("report");
        return model;
    }

    @RequestMapping(value = "/printbookingReport",method = RequestMethod.POST)
    public ModelAndView printReportAction(ModelAndView model,HttpSession session,HttpServletResponse response){

        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String filename="bookingReport"+dateFormatter.format(new Date())+".pdf";
        FileExport.printBookingReport(response,(List<Booking>)session.getAttribute("bookings"),filename.replaceAll("\\s+",""));
        return model;
    }

}
