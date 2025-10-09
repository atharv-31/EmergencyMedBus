package com.atharv.medbus.controller;

import com.atharv.medbus.model.User;
import com.atharv.medbus.model.Request;
import com.atharv.medbus.repository.UserRepository;
import com.atharv.medbus.repository.RequestRepository;
import com.atharv.medbus.dto.UserRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*") // Allow all frontend requests
@RestController
@RequestMapping("/api")
public class MedBusController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RequestRepository requestRepo;

    @PostMapping("/request")
    public String raiseRequest(@RequestBody UserRequestDto dto){
        User user = new User(dto.getName(), dto.getAge(), dto.getLocation(), dto.getContact());
        userRepo.save(user);

        Request request = new Request(user, dto.getEmergencyType());
        requestRepo.save(request);

        return "✅ Request saved successfully!";
    }

    @GetMapping("/requests")
    public List<Request> viewRequests(){
        return requestRepo.findAll();
    }
}
