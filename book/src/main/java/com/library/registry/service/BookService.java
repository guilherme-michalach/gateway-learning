package com.library.registry.service;

import com.library.registry.dto.BookResponse;
import com.library.registry.dto.Library;
import com.library.registry.model.Book;
import com.library.registry.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<?> addBook(Book book){
        try {
            return new ResponseEntity<Book>(bookRepository.save(book), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> fetchBookById(Integer id){
        Optional<Book> book =  bookRepository.findById(id);
        if (book.isPresent()) {
            Library library = restTemplate.getForObject("http://shop-service/shop/" + book.get().getLibraryId(), Library.class);
            BookResponse bookResponse = new BookResponse(
                    book.get().getId(),
                    book.get().getBookName(),
                    book.get().getBookAuthor(),
                    book.get().getReleaseDate(),
                    book.get().getGenre(),
                    library
            );

            return new ResponseEntity<>(bookResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No Book Found",HttpStatus.NOT_FOUND);
        }
    }
// TODO Don't remember if it's necessary, see later
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public ResponseEntity<?> listBooks(){
        List<Book> books = bookRepository.findAll();
        if (!books.isEmpty()) {
            return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("There aren't books in the database", HttpStatus.NOT_FOUND);
        }
    }

}
