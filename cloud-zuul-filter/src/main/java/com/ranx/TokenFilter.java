package com.ranx;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;

/** 过滤器Token
 * @author ranx
 * @create 2019-06-19 16:33
 **/
public class TokenFilter extends ZuulFilter{

    @Override
    public String filterType() {
        return "pre"; //可在请求被路由之前调用
    }

    @Override
    public int filterOrder() {
        return 0; //filter执行顺序，通过数字指定，优先级为0，数字越大，优先级越低
    }

    @Override
    public boolean shouldFilter() {
        return true; //是否执行该过滤，true表示需要过滤
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        System.out.println("--->>> TokenFilter " + request.getMethod() + "," + request.getRequestURL().toString());

        //获取请求的参数
        String token = request.getParameter("token");
        if (StringUtils.isNotBlank(token)) {
            //对请求进行路由
            ctx.setSendZuulResponse(true);
            ctx.setResponseStatusCode(200);
            ctx.set("isSuccess", true);
        } else {
            //不对其进行路由
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(400);
            ctx.setResponseBody("token is empty");
            ctx.set("isSuccess", false);
        }
        return null;
    }
}
