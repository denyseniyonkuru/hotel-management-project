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
public class ManageUsersController {
    @Autowired
    private HotelSystemService service;


    @RequestMapping(value = "/user")
    public ModelAndView showManageUsePage(ModelAndView model) {
        model.setViewName("addUser");
        return model;
    }
    @RequestMapping(value = "addUser",method = RequestMethod.POST)
    public ModelAndView addUser(ModelAndView model, HttpServletRequest request, HttpSession session) throws Exception {

        if (!isAuthenticated(session)){
            return new ModelAndView("redirect:/");
        }
        String names= request.getParameter("names");
        String userName= request.getParameter("userName");
        String password = EncriptPassword.byteArrayToHexString(EncriptPassword.computeHash(request.getParameter("password")));
        String role=request.getParameter("role");

        User user=new User();
        user.setUserName(userName);
        user.setPassword(password);
        user.setNames(names);
        user.setRole(role);

        service.addUser(user);
        model.addObject("allusers",service.getAllUSers());
        model.addObject("allrooms",service.getAllRooms());
        model.setViewName("homeUser");
        return model;
    }
    public boolean isAuthenticated(HttpSession session){
        if(session.getAttribute("userId")!=null)
            return true;
        return false;
    }
    @RequestMapping(value = "/showedituser",method = RequestMethod.GET)
    public ModelAndView showEditUser(ModelAndView model,HttpServletRequest request) {
        String userId = request.getParameter("id");
        String userName = request.getParameter("userName");
        String names = request.getParameter("names");
        String password = request.getParameter("password");
        String role=request.getParameter("role");

        model.addObject("id",userId);
        model.addObject("userName",userName);
        model.addObject("names",names);
        model.addObject("password",password);
        model.addObject("role",role);
        model.setViewName("editUser");
        return model;
    }
    @RequestMapping(value = "/editUser",method = RequestMethod.POST)
    public ModelAndView editUser(ModelAndView model,HttpServletRequest request) {
        int userId = Integer.parseInt(request.getParameter("id"));
        String userName = request.getParameter("userName");
        String names = request.getParameter("names");
        String password = request.getParameter("password");
        String role=request.getParameter("role");

        User user=service.getUSer(userId);
        user.setUserName(userName);
        user.setNames(names);
        user.setRole(role);
        service.editUser(user);
         model.setViewName("homeUser");
        model.addObject("allusers",service.getAllUSers());
        model.addObject("allrooms",service.getAllRooms());
        return model;
    }
    @RequestMapping(value = "/removeUser",method = RequestMethod.GET)
    public  ModelAndView removeUser(ModelAndView model,HttpServletRequest request){
        int id= Integer.parseInt(request.getParameter("id"));
        User user=service.getUSer(id);
        service.removeUser(user);
        model.addObject("allusers",service.getAllUSers());
        model.addObject("allrooms",service.getAllRooms());
        model.setViewName("homeUser");
        return model;
    }

}
