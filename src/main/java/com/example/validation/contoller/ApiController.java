package com.example.validation.contoller;

import com.example.validation.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class ApiController {

//    @PostMapping("/user")
//    public ResponseEntity user(@Valid @RequestBody User user) {
//        System.out.println("user = " + user);
//
//        if(user.getAge() >= 90) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(user);
//        }
//        return ResponseEntity.ok(user);
//    }
    @PostMapping("/user")
    public ResponseEntity user(@Valid @RequestBody User user, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            bindingResult.getAllErrors().forEach(objectError -> {
                FieldError field = (FieldError)  objectError;
                String message = objectError.getDefaultMessage();

                System.out.println("field : " + field.getField());
                System.out.println("message = " + message);

                sb.append("filed : " + field.getField());
                sb.append(" message : " + message);
            });
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sb.toString());
        }
        //logic 실행

        return ResponseEntity.ok(user);
    }

}
