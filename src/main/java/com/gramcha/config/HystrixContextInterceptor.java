package com.gramcha.config;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by gramachandran on 30/10/18.
 */
public class HystrixContextInterceptor extends HandlerInterceptorAdapter {

    static HystrixRequestContext globalSharedContext;
    static {
        HystrixRequestContext.initializeContext();
        globalSharedContext = HystrixRequestContext.getContextForCurrentThread();

    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HystrixRequestContext.setContextOnCurrentThread(globalSharedContext);
        return super.preHandle(request, response, handler);
    }
}
