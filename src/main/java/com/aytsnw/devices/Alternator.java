package com.aytsnw.devices;


import com.aytsnw.core.Route;

import java.util.HashMap;

public class Alternator {
    static String currentRoute = null;
    static String prevRoute = null;

    public static void alternateRoute(String routeName, HashMap<String, String> params){
        System.out.println("Calling route: '" + routeName + "'...");
        if (currentRoute == null){
            prevRoute = routeName;
        } else {
            prevRoute = currentRoute;
        }
        currentRoute = routeName;
        try{
            Route.routes.get(routeName).process(params);
        } catch (NullPointerException ex) {
            System.out.println("Route not initialized");
            System.out.println(ex.getMessage());
        }
    }

    public static void alternateRoute(String routeName){
        System.out.println("Calling route: '" + routeName + "'...");
        if (currentRoute == null){
            prevRoute = routeName;
        } else{
            prevRoute = currentRoute;
        }
        currentRoute = routeName;
        try{
            Route.routes.get(routeName).process();
        } catch (NullPointerException ex) {
            System.out.println("Route '" + routeName + "' not initialized");
            System.out.println(ex.getMessage());
        }
    }

    public static void alternatePrev(){
        Alternator.alternateRoute(prevRoute);
    }
}
