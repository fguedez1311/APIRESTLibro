package com.example.obrestdatajpa.controller;

import com.example.obrestdatajpa.entities.Book;
import com.example.obrestdatajpa.repository.BookRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    //atributos
       private BookRepository bookRepository;
   //Constructores

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //Crud sobre la entidad Book


    //Buscar todos los libros
    /**
     * http://localhost:8081/api/books
     * @return
     */
    @GetMapping("/api/books")
    public List<Book> findAll(){
        //Recuperar y devolver los libros de BDs
        return bookRepository.findAll();
    }

    //Buscar un solo libro en la BD segun su id
//    public Book findOneById(Long id){
//
//    }
    //Crear un nuevo libro existente  en Base datos
    //actualizar libro existente en BD
    //Borrar libro en Base de datos

}
