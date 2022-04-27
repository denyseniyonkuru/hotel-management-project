package org.kkempireofcode.controller;

import org.kkempireofcode.model.Reservation;
import org.kkempireofcode.service.HotelSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


@Controller
public class ManageReservation {
    @Autowired
    private HotelSystemService service;
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");


    @RequestMapping(value= "/reservation",method = RequestMethod.GET)
    public ModelAndView showReserve(ModelAndView model,HttpServletRequest request){
        model.addObject("roomId",request.getParameter("roomId"));
        model.setViewName("reservation");
        return model;
    }

    @RequestMapping(value = "reservation",method = RequestMethod.POST)
    public ModelAndView addRoom(ModelAndView model, HttpServletRequest request, HttpSession session) throws ParseException {
//        if (!isAuthenticated(session)){
//            return new ModelAndView("redirect:/");
//        }
     int roomId=Integer.parseInt(request.getParameter("roomId"));
     String names=request.getParameter("names");
     String email=request.getParameter("email");
     String tel=request.getParameter("tel");
     String startDate=request.getParameter("startDate");
     String endDate=request.getParameter("endDate");

    Reservation reservation=new Reservation();
        reservation.setRoomId(roomId);
        reservation.setNames(names);
        reservation.setEmail(email);
        reservation.setTel(tel);
        reservation.setStartDate(new java.sql.Date(sdf.parse(String.valueOf(startDate)).getTime()));
        reservation.setEndDate(new java.sql.Date(sdf.parse(String.valueOf(endDate)).getTime()));
        reservation.setResStatus("Pending");
        service.saveReservation(reservation);

        model.setViewName("home");
        model.addObject("allrooms",service.getAllRooms());
        return model;
    }
//    public boolean isAuthenticated(HttpSession session){
////        if(session.getAttribute("userId")!=null)
////            return true;
////        return false;
////    }
    }

