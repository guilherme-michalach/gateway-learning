package com.library.shop.controller;

import com.library.shop.model.Library;
import com.library.shop.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RequestMapping(value = "/shop")
@RestController
public class LibraryController {

    @Autowired
    LibraryService libraryService;

    @PostMapping
    public Library addBook(@RequestBody Library library) {
        return libraryService.addShop(library);
    }

    @GetMapping("/list")
    public List<Library> listShops() {
        return libraryService.listShops();
    }

    @GetMapping("/{id}")
    public Library fetchShopById(@PathVariable int id) {
        return libraryService.fetchShopById(id);
    }
}
