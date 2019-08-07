package com.sevincfurkan.airlineticketingsystem.config;

import com.sevincfurkan.airlineticketingsystem.entity.Rota;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DistanceCalculation {


    Rota rota =new Rota();

    /*private double getDistanceFromLatLongInKm(double originLat, double originLong, double destinationLat, double destinationLong) {
       double radius=6371;
       double dLat=deg2rad(destinationLat-originLat);
       double dLong=deg2rad(destinationLong-originLong);
       double a=Math.sin(dLat/2) * Math.sin(dLat/2) +
               Math.cos(deg2rad(originLat)) * Math.cos(deg2rad(destinationLat)) * Math.sin(dLong/2) * Math.sin(dLong/2);

       double c=2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
       double result =radius*c;
       return result;
    }*/

    //toRadyan
    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    //toAçı
    private double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }

    private double distance(double originLat, double originLong, double destinationLat, double destinationLong){
        double radius=6371;
        double dLat=Double.parseDouble(rota.getPosition());
        dLat=deg2rad(destinationLat-originLat);
        double dLong=Double.parseDouble(rota.getDestination());
        dLong=deg2rad(destinationLong-originLong);
        double a=Math.sin(dLat/2) * Math.sin(dLat/2) +
                Math.cos(deg2rad(originLat)) * Math.cos(deg2rad(destinationLat)) * Math.sin(dLong/2) * Math.sin(dLong/2);
        double c=2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        double result =radius*c;
        return result;
    }

}
