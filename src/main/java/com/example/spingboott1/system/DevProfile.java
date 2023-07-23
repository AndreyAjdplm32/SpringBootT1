package com.example.spingboott1.system;


public class DevProfile implements SystemProfile {

     @Override
     public String getProfile() {
         return "Current profile is dev";
     }
}