package com.library.shop.service;

import com.library.shop.model.Library;
import com.library.shop.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {

    @Autowired
    private LibraryRepository libraryRepository;

    public Library addShop(Library library) {
        return libraryRepository.save(library);
    }

    public List<Library> listShops() {
        return libraryRepository.findAll();
    }

    public Library fetchShopById(int id) {
        return libraryRepository.findById(id).orElse(null);
    }

}
