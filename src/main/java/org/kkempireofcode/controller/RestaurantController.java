package org.kkempireofcode.controller;

import org.kkempireofcode.model.Item;
import org.kkempireofcode.model.Sell;
import org.kkempireofcode.service.HotelSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class RestaurantController {

    @Autowired
    private HotelSystemService service;

    @RequestMapping(value = "restaurant")
    public ModelAndView viewRestaurantPage(ModelAndView model){
        model.addObject("allItems",service.getAllItems());
        model.setViewName("restaurant");
        return model;
    }
    @RequestMapping(value = "addItem")
    public ModelAndView viewAddItemPage(ModelAndView model){
        model.addObject("allItems",service.getAllItems());
        model.setViewName("addItem");
        return model;
    }
    @RequestMapping(value = "addItemAction",method = RequestMethod.POST)
    public ModelAndView addItemAction(ModelAndView model, HttpServletRequest request){
        String name=request.getParameter("name");
        Double buyPrice=Double.parseDouble(request.getParameter("buyprice"));
        Double sellPrice=Double.parseDouble(request.getParameter("sellprice"));
        int availableQuantity=Integer.parseInt(request.getParameter("availableQuantity"));
        Item item=new Item();
        item.setName(name);
        item.setBuyPrice(buyPrice);
        item.setSellPrice(sellPrice);
        item.setAvailableQuantity(availableQuantity);
        service.addItem(item);

        model.addObject("allItems",service.getAllItems());

        model.setViewName("addItem");
        return model;

    }

    @RequestMapping(value = "sellItem")
    public ModelAndView viewItemsToSell(ModelAndView model){
        model.addObject("allItems",service.getAllItems());
        model.setViewName("sellItem");
        return model;
    }

    @RequestMapping(value = "sellItemAction",method = RequestMethod.POST)
    public ModelAndView sellItemAction(ModelAndView model, HttpServletRequest request){
    String customer=request.getParameter("customer");
        List<Item> allItems=service.getAllItems();
        Map<Item,Integer> selectItems=new HashMap<Item, Integer>();

        for (Item item:allItems) {
            if(request.getParameter(""+item.getItemId())!=null){
                selectItems.put(item,Integer.parseInt(request.getParameter("qnt_"+item.getItemId())));
            }
        }

        for (Item selectedItem:selectItems.keySet()) {
            Sell sell = new Sell();
            sell.setItemId(selectedItem.getItemId());
            sell.setName(selectedItem.getName());
            sell.setBuyPrice(selectedItem.getBuyPrice());
            sell.setSellPrice(selectedItem.getSellPrice());
            sell.setInterest(selectedItem.getSellPrice()- selectedItem.getBuyPrice());
            sell.setDateCreated(new java.sql.Date(new Date().getTime()));
            sell.setCustomerIdentifier(customer);
            sell.setSellQuantity(selectItems.get(selectedItem));
            service.addSellItem(sell);
            selectedItem.setAvailableQuantity(selectedItem.getAvailableQuantity()- selectItems.get(selectedItem));
            service.addItem(selectedItem);
        }
        model.addObject("allItems",service.getAllItems());
        model.setViewName("sellItem");
        return model;
    }
}
