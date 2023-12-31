package com.example.obrestdatajpa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hola")
    public String holamundo(){
        return "Hola Mundo que tal vamos!!! hasta luego";
    }
    @GetMapping ("/bootstap")
    public String bootstrap(){
        return
                """
                          <!doctype html>
                                  <html lang="en">
                                    <head>
                                      <meta charset="utf-8">
                                      <meta name="viewport" content="width=device-width, initial-scale=1">
                                      <title>Bootstrap demo</title>
                                      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
                                    </head>
                                    <body>
                                      <h1>Hello, world! desde Spring Boot</h1>
                                      <a class="btn btn-primary" href="https://www.google.com">Google</a>
                                      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
                                    </body>
                                  </html>      
                        """;
    }
}
