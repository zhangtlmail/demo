/*
 * package com.example.demo.interceptor;
 * 
 * import org.slf4j.Logger; import org.slf4j.LoggerFactory; import
 * org.springframework.lang.Nullable;
 * 
 * import org.springframework.web.servlet.HandlerInterceptor; import
 * org.springframework.web.servlet.ModelAndView;
 * 
 * 
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse; import
 * javax.servlet.http.HttpSession;
 * 
 * public class LoginInterceptor implements HandlerInterceptor{ private final
 * Logger Log = LoggerFactory.getLogger(LoginInterceptor.class);
 * //键盘不敲烂，月薪不过万。机械键盘不敲烂，月薪不会过两万。
 * 
 * @Override public boolean preHandle(HttpServletRequest request,
 * HttpServletResponse response, Object handler) throws Exception {
 * Log.info("==========登录状态拦截");
 * 
 * HttpSession session = request.getSession(); Log.info("sessionId为：" +
 * session.getId());
 * 
 * // 获取用户信息，如果没有用户信息直接返回提示信息 Object userInfo =
 * session.getAttribute("userName"); if (userInfo == null) { Log.info("没有登录");
 * //response.getWriter().write("Please login In"); response.sendRedirect("/");
 * return false; } else { Log.info("已经登录过啦，用户信息为：" +
 * session.getAttribute("userName")); }
 * 
 * return true; }
 * 
 * @Override public void postHandle(HttpServletRequest request,
 * HttpServletResponse response, Object handler,
 * 
 * @Nullable ModelAndView modelAndView) throws Exception { }
 * 
 * @Override public void afterCompletion(HttpServletRequest request,
 * HttpServletResponse response, Object handler, @Nullable Exception ex) throws
 * Exception { } }
 */