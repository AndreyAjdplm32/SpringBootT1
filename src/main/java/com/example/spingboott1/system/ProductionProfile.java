package com.example.spingboott1.system;




public class ProductionProfile implements SystemProfile {

     @Override
     public String getProfile() {
         return "Current profile is production";
     }
}