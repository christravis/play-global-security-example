import play.*;
import play.libs.F.Promise;
import play.mvc.Action;
import play.mvc.Result;
import play.mvc.Http.Context;
import play.mvc.Http.Request;

import java.lang.reflect.Method;

public class Global extends GlobalSettings {

	public Action onRequest(Request request, Method actionMethod) {
		System.out.println("\n\nbefore each request..." + request.toString());

		System.out.println(request.host());
		System.out.println(request.method());
		System.out.println(request.path());

		if (request.path().equals("/test")) {
			return new Action.Simple() {
				@Override
				public Promise<Result> call(Context context) throws Throwable {
					return Promise.pure(play.mvc.Results.unauthorized(views.html.unauthorized.render("sorry, but go away!")));
				}
			};
		}

		request.setUsername("chris@travis");
		return super.onRequest(request, actionMethod);
	}

}
