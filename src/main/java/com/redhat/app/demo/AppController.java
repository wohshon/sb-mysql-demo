package com.redhat.app.demo;

import com.redhat.app.demo.entity.Product;
import com.redhat.app.demo.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/rest")
public class AppController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping(path="/users/all")
    public @ResponseBody Iterable<User> getAllUsers() {
      // This returns a JSON or XML with the users
      return userRepository.findAll();
    }    
    @GetMapping(path="/products/all")
    public @ResponseBody Iterable<Product> getAllProducts() {
      // This returns a JSON or XML with the users
      return productRepository.findAll();
    }    

    @PostMapping(path="/products/add") // Map ONLY POST Requests
    public @ResponseBody String addNewProduct (@RequestBody Product product) {
      log.info("product {}",product);
      productRepository.save(product);
      return "Saved";
    }    

    @PostMapping(path="/users/add") // Map ONLY POST Requests
    public @ResponseBody String addNewUser (@RequestParam String name
        , @RequestParam String email) {
      // @ResponseBody means the returned String is the response, not a view name
      // @RequestParam means it is a parameter from the GET or POST request
  
      User n = new User();
      n.setName(name);
      n.setEmail(email);
      userRepository.save(n);
      return "Saved";
    }    
}
