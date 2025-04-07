package com.aytsnw.routes;


import java.util.HashMap;

public class Alternator {
    static String currentRoute = null;
    static String prevRoute = null;

    public static void alternateRoute(String routeName, HashMap<String, Object> params){
        if (currentRoute == null){
            prevRoute = routeName;
        } else if (!(currentRoute.equals("decision"))){
            prevRoute = currentRoute;
        }
        currentRoute = routeName;
        Route.routes.get(routeName).process(params);
    }
}
