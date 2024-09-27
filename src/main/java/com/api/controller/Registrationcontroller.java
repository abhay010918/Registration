package com.api.controller;

import com.api.entity.Registration;
import com.api.payload.RegistrationDto;
import com.api.service.RegistrationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/registration")
public class Registrationcontroller {

    private RegistrationService registrationService;
    public Registrationcontroller(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping
    public ResponseEntity<List<RegistrationDto>> getAllRegistrations(){
        List<RegistrationDto> dtos = registrationService.getRegistrations();
        return  new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createRegistration(
           @Valid @RequestBody RegistrationDto registrationDto,
           BindingResult bindingResult
    ){

        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getFieldError().getDefaultMessage(), HttpStatus.CREATED);
        }

        RegistrationDto regDto = registrationService.createRegistration(registrationDto);
        return new ResponseEntity<>(regDto, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteRegistration(
            @RequestParam long id
    ){
        registrationService.deleteRegistration(id);
        return new ResponseEntity<>("Delete", HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Registration> updateRegistration(
            @PathVariable long id,
            @RequestBody Registration registration
    ){
        Registration updateReg =registrationService.updateRegistration(id, registration);
        return new ResponseEntity<>(updateReg, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistrationDto> getRegById(
            @PathVariable long id
    ){
        RegistrationDto dto = registrationService.getRegById(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);

    }
}