package com.example.obrestdatajpa.controller;

import com.example.obrestdatajpa.entities.Book;
import com.example.obrestdatajpa.repository.BookRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

//    Buscar un solo libro en la BD segun su id

    @GetMapping("/api/books/{id}")
    public ResponseEntity<Book> findOneById(@PathVariable Long id){
        Optional<Book> bookOpt=bookRepository.findById(id);
        if(bookOpt.isPresent()){
            return ResponseEntity.ok(bookOpt.get());
        }
        else
            return ResponseEntity.notFound().build();
    }
    //Crear un nuevo libro existente  en Base datos
    @PostMapping("/api/books")
        public Book create(@RequestBody Book book, @RequestHeader HttpHeaders headers){

        System.out.println(headers.get("User-Agent"));
        //Guardar el libro recibido por parámetro en la Base de Datos
            return bookRepository.save(book);
        }
    //actualizar libro existente en BD
    //Borrar libro en Base de datos

}
