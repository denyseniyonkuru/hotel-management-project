package org.kkempireofcode.controller;


import org.kkempireofcode.model.Room;
import org.kkempireofcode.model.User;
import org.kkempireofcode.service.HotelSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class RoomController {
    @Autowired
    private HotelSystemService service;

    @RequestMapping(value = "/addRoom")
    public ModelAndView showRoomPage(ModelAndView model) {
        model.addObject("allrooms",service.getAllRooms());
        model.setViewName("addRoom");
        return model;
    }

    @RequestMapping(value = "/addRoomAction",method = RequestMethod.POST)
    public ModelAndView addRoom(ModelAndView model, HttpServletRequest request, HttpSession session){

        if (!isAuthenticated(session)){
            return new ModelAndView("redirect:/");
        }
        String description= request.getParameter("description");
        Double price= Double.parseDouble(request.getParameter("price"));
        String status= request.getParameter("status");

        Room room=new Room();
        room.setDescription(description);
        room.setPrice(price);
        room.setStatus(status);

        service.addRoom(room);
        //model.addObject("allusers",service.getAllUSers());
        model.addObject("allrooms",service.getAllRooms());
        model.setViewName("addRoom");
        return model;
    }
    public boolean isAuthenticated(HttpSession session){
        if(session.getAttribute("userId")!=null)
            return true;
        return false;
    }
    @RequestMapping(value = "/showeditroom",method = RequestMethod.GET)
    public ModelAndView showEditUser(ModelAndView model,HttpServletRequest request) {
        String roomId = request.getParameter("roomId");
        String description = request.getParameter("description");
        Double price = Double.parseDouble(request.getParameter("price"));
        String status = request.getParameter("status");

        model.addObject("roomId",roomId);
        model.addObject("description",description);
        model.addObject("price",price);
        model.addObject("status",status);
        model.setViewName("editRoom");
        return model;
    }
    @RequestMapping(value = "/editRoom",method = RequestMethod.POST)
    public ModelAndView editRoom(ModelAndView model,HttpServletRequest request) {
        int roomId = Integer.parseInt(request.getParameter("roomId"));
        String description = request.getParameter("description");
        Double price = Double.parseDouble(request.getParameter("price"));
        String status = request.getParameter("status");


        Room room=service.getRoom(roomId);
        room.setDescription(description);
        room.setPrice(price);
        room.setStatus(status);
        service.editRoom(room);
        model.setViewName("homeUser");
        model.addObject("allusers",service.getAllUSers());
        model.addObject("allrooms",service.getAllRooms());
        return model;
    }
    @RequestMapping(value = "/removeRoom",method = RequestMethod.GET)
    public  ModelAndView removeRoom(ModelAndView model,HttpServletRequest request){
        int id= Integer.parseInt(request.getParameter("id"));
        Room room=service.getRoom(id);
        service.removeRoom(room);
        model.addObject("allusers",service.getAllUSers());
        model.addObject("allrooms",service.getAllRooms());
        model.setViewName("homeUser");
        return model;
    }

}
