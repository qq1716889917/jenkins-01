package com.wzt.Zuulfilter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import javax.servlet.http.HttpServletRequest;

public class Filter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        /*获取request*/
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();

        /*获取用户的请求传参*/
        String token = request.getParameter("token");
        if(token==null){
            /*拒绝*/
            currentContext.setSendZuulResponse(false);
            /*状态码*/
            currentContext.setResponseStatusCode(403);
        }

        return null;
    }
}
