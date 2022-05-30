package com.techelevator.auctions.controller;

import com.techelevator.auctions.dao.AuctionDao;
import com.techelevator.auctions.dao.MemoryAuctionDao;
import com.techelevator.auctions.model.Auction;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class AuctionController {
    private AuctionDao dao;

    public AuctionController() {
        this.dao = new MemoryAuctionDao();
    }

    //Step Two: Implement the list() method
    @RequestMapping(path = "/auctions", method = RequestMethod.GET)
    public List<Auction> list() {
        return dao.list();
    }


    //Step Three: Implement the get() action
    @RequestMapping(path = "/auctions/{id}", method = RequestMethod.GET)
    public Auction get(@PathVariable int id) {
        return dao.get(id);
    }

    //Step Four: Implement the create() action
    @RequestMapping(value = "/auctions", method = RequestMethod.POST)
    public Auction create(@RequestBody Auction auction) {
        if (auction != null) {
            dao.create(auction);
            return auction;
        }
        return null;
    }

    //Step Five: Step Five: Add searching by title
    @RequestMapping(path = "/auctions/title", method = RequestMethod.GET)
    public List<Auction> list2(@RequestParam(defaultValue = "/auctions/title") String title_like) {
        if (!title_like.equals("/auctions/title")) {
            return dao.searchByTitle(title_like);
        } else {
            return null;
        }


    }
}