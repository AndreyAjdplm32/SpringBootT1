package com.example.spingboott1.controller;


import com.example.spingboott1.system.DevProfile;
import com.example.spingboott1.system.ProductionProfile;
import com.example.spingboott1.system.SystemProfile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ProfileController {
    private final SystemProfile systemProfile;
    public ProfileController(SystemProfile systemProfile){
        this.systemProfile = systemProfile;
    }
    @GetMapping("profile")
    public String getProfile(){
        return systemProfile.getProfile();
    }
    @GetMapping("dev")
    public String devProfile(DevProfile devProfile){
        return devProfile.getProfile();
    }
    @GetMapping("production")
    public String productionProfile(ProductionProfile productionProfile ){
        return productionProfile.getProfile();
    }
}