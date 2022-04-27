package org.kkempireofcode.controller;

import org.kkempireofcode.businesslogic.EncriptPassword;
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
public class LoginController {
    @Autowired
    private HotelSystemService hotelSystemService;

    @RequestMapping(value= "/")
    public ModelAndView viewhomePage (ModelAndView model){
        model.addObject("allrooms",hotelSystemService.getAllRooms());
        model.setViewName("home");
        return model;
    }
    @RequestMapping(value= "/homeUser")
    public ModelAndView viewhomeUserPage (ModelAndView model){
        model.addObject("allrooms",hotelSystemService.getAllRooms());
        model.setViewName("homeUser");
        return model;
    }
    @RequestMapping(value= "/date")
    public ModelAndView viewdate (ModelAndView model){
        return model;
    }
   @RequestMapping(value= "/login",method = RequestMethod.POST)
        public ModelAndView loginPage (ModelAndView model, HttpServletRequest request, HttpSession session) throws Exception {
        String username = request.getParameter("username");
        String password = EncriptPassword.byteArrayToHexString(EncriptPassword.computeHash(request.getParameter("password")));
        User user = hotelSystemService.getUSer(username, password);
        if (user != null) {
               model.addObject("allusers", hotelSystemService.getAllUSers());
            model.addObject("allrooms",hotelSystemService.getAllRooms());
               model.setViewName("homeUser");
               session.setAttribute("Izina",user.getNames());
               session.setAttribute("userId",user.getId());
               session.setAttribute("role",user.getRole());


        } else {
                model.setViewName("home");
            }
            return model;
    }

    @RequestMapping(value= "/logout")
    public ModelAndView logout (ModelAndView model, HttpSession session){
        session.removeAttribute("userId");
        session.removeAttribute("Izina");
        model.addObject("allusers", hotelSystemService.getAllUSers());
        model.addObject("allrooms",hotelSystemService.getAllRooms());
        model.setViewName("home");
        return model;
    }
    @RequestMapping(value= "/home")
    public ModelAndView showhome (ModelAndView model){
        model.addObject("allrooms",hotelSystemService.getAllRooms());
        model.setViewName("home");
        return model;
    }


}
