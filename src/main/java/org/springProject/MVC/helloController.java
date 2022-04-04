package org.springProject.MVC;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class helloController {

    @GetMapping("/hello-world")
    public String sayHello(){
        return "hello_world!";
    }
}
