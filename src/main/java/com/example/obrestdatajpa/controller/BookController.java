package com.example.obrestdatajpa.controller;

import com.example.obrestdatajpa.entities.Book;
import com.example.obrestdatajpa.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    private final Logger log= LoggerFactory.getLogger(BookController.class);
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
        public ResponseEntity<Book> create(@RequestBody Book book, @RequestHeader HttpHeaders headers){

            System.out.println(headers.get("User-Agent"));
            //Guardar el libro recibido por parámetro en la Base de Datos
            if(book.getId()!=null){
                log.warn("trying to create a book with id");
                return ResponseEntity.badRequest().build();
            }
            Book result= bookRepository.save(book); //El libro devuelto tiene una clave primaria
            return ResponseEntity.ok(result);
        }

    /**
     * actualizar libro existente en BD
     */
    @PutMapping("/api/books")
    public ResponseEntity<Book> update(@RequestBody Book book){
        if(book.getId()==null){
            log.warn("Tring to update a non existent book");
            return ResponseEntity.badRequest().build();
        }
        if(!bookRepository.existsById(book.getId())){
            log.warn(("Tring to update a non existent book"));
            return ResponseEntity.notFound().build();
        }
        Book result= bookRepository.save(book); //El libro devuelto tiene una clave primaria
        return ResponseEntity.ok(result);
    }
    @DeleteMapping("/api/books/{id}")
    public ResponseEntity<Book> delete(@PathVariable Long id){
        if(!bookRepository.existsById(id)){
            log.warn(("Tring to delete a non existent book"));
            return ResponseEntity.notFound().build();
        }
        bookRepository.deleteById(id);
        return ResponseEntity.noContent().build();


    }
    @DeleteMapping("/api/books")
    public ResponseEntity<Book> deleteAll(){
        log.info("Rest Request for delete all books");
        bookRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }



}
