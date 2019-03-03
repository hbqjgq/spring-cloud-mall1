package com.kwok.gateway.util;

import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

@Component
public class FilterUtils {
    private static final String CORRELATION_ID = "txm-correlation-id";
    public static final String PRE_FILTER_TYPE = "pre";

    public String getCorrelationId(){
        RequestContext ctx = RequestContext.getCurrentContext();

        if(ctx.getRequest().getHeader(CORRELATION_ID) != null) {
            return ctx.getRequest().getHeader(CORRELATION_ID);
        }else{
            return ctx.getZuulRequestHeaders().get(CORRELATION_ID);
        }
    }

    public void setCorrelationId(String correlationId){
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.addZuulRequestHeader(CORRELATION_ID,correlationId);
    }
}
