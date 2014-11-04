package controllers;

import play.mvc.*;
import views.html.*;

public class Application extends Controller {

    public static Result index() {
    	System.out.println("index username: " + ctx().request().username());
        return ok(index.render("Your new application is ready."));
    }

}
