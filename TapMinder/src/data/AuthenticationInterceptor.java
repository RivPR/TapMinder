package data;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import entities.User;

@Component
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {
//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//			throws Exception {
//		String uri = request.getRequestURI();
//		if (!uri.endsWith("login.do") && !uri.endsWith("logout.do")) {
//			User userData = (User) request.getSession().getAttribute("LOGGEDIN_USER");
//			if (userData == null) {
//				response.sendRedirect("login.do");
//				return false;
//			}
//		}
//		return true;
//	}

//	@Override
//    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {
//        HandlerMethod handlerMethod = (HandlerMethod) handler;
//        LoginRequired loginRequired = handlerMethod.getMethod().getAnnotation(LoginRequired.class);
//        if (loginRequired == null) {
//            return true;
//        }
// 
//        String token = httpServletRequest.getParameter("token");
// 
//        if (StringUtils.isBlank(token)) {
//            throw new MissingParameterException();
//        }
// 
//        authenticationService.checkToken(token);
// 
//        return super.preHandle(httpServletRequest, httpServletResponse, handler);
//    }
	
//	 @Override
//	    public boolean preHandle(HttpServletRequest request,
//	        HttpServletResponse response, Object handler) throws Exception {
//	        System.out.println("Pre-handle");
//	         
//	        return true;
//	    }
	     
//	    @Override
//	    public void postHandle(HttpServletRequest request,
//	            HttpServletResponse response, Object handler,
//	            ModelAndView modelAndView) throws Exception {
//	        System.out.println("Post-handle");
//	    }
//	     
//	    @Override
//	    public void afterCompletion(HttpServletRequest request,
//	            HttpServletResponse response, Object handler, Exception ex)
//	            throws Exception {
//	        System.out.println("After completion handle");
//	    }
}