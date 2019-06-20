package com.ranx;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;

/** 过滤器Password
 * @author ranx
 * @create 2019-06-19 16:33
 **/
public class PasswordFilter extends ZuulFilter{

    @Override
    public String filterType() {
        return "post"; //可在请求被路由之前调用
    }

    @Override
    public int filterOrder() {
        return 1; //filter执行顺序，通过数字指定，优先级为0，数字越大，优先级越低
    }

    @Override
    public boolean shouldFilter() {
        //判断上一个过滤器结果为true,否则不走下面过滤器，直接跳过后面的所有过滤，并返回上一个过滤器不通过的结果
        RequestContext ctx = RequestContext.getCurrentContext();
        return  (boolean)ctx.get("isSuccess");
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        System.out.println("--->>> PasswordFilter " + request.getMethod() + "," + request.getRequestURL().toString());

        //获取请求的参数
        String pwd = request.getParameter("password");
        if (pwd != null && "123456".equals(pwd)) {
            //对请求进行路由
            ctx.setSendZuulResponse(true);
            ctx.setResponseStatusCode(200);
            ctx.set("isSuccess", true);
        } else {
            //不对其进行路由
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(400);
            ctx.setResponseBody("The password cannot be empty");
            ctx.set("isSuccess", false);
        }
        return null;
    }
}
