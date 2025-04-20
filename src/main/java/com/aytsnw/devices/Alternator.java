package com.aytsnw.devices;


import com.aytsnw.core.Route;

import java.util.HashMap;

public class Alternator {
    static String currentRoute = null;
    static String prevRoute = null;

    public static void alternateRoute(String routeName, HashMap<String, Object> params){
        System.out.println("Calling route: '" + routeName + "'...");
        if (Route.routes.get(routeName) == null) {
            System.out.println("Route '" + routeName + "' not initialized");
            return;
        }

        if (currentRoute == null) prevRoute = routeName;
        else prevRoute = currentRoute;

        currentRoute = routeName;
        Route.routes.get(routeName).process(params);
    }

    public static void alternateRoute(String routeName){
        System.out.println("Calling route: '" + routeName + "'...");

        if (Route.routes.get(routeName) == null) {
            System.out.println("Route '" + routeName + "' not initialized");
            return;
        }

        if (currentRoute == null) prevRoute = routeName;
        else prevRoute = currentRoute;

        currentRoute = routeName;
        Route.routes.get(routeName).process();
    }

    public static void alternatePrev(){
        Alternator.alternateRoute(prevRoute);
    }
}
