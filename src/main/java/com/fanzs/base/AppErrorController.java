package com.fanzs.base;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class AppErrorController implements ErrorController {
    private static final String ERROR_PATH="/error";
    private ErrorAttributes errorAttributes;

    @Override
    public String getErrorPath() {
        return null;
    }

    @Autowired
    public AppErrorController(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    /**
     * WEB页面错误
     */
    @RequestMapping(value = ERROR_PATH,produces = "text/html")
    public String errorPageHandler(HttpServletRequest request, HttpServletResponse response){
        int status=response.getStatus();
//        System.out.println("status = "+status);
        switch (status){
            case 403: return "403";
            case 404: return "404";
            case 500: return "500";
        }
        return "index";
    }

    /***
     * 除WEB页面的错误
     */
    @RequestMapping(value = ERROR_PATH)
    @ResponseBody
    public APIResponse requestAttributes(HttpServletRequest request){
        RequestAttributes requestAttributes=new ServletRequestAttributes(request);
        Map<String,Object> attr=this.errorAttributes.getErrorAttributes(requestAttributes,false);
        int status = getStatus(request);
        return APIResponse.ofMessage(status,String.valueOf(attr.getOrDefault("message","error")));
    }

    private int getStatus(HttpServletRequest request){
        Integer status=(Integer)request.getAttribute("javax.servlet.error.status_code");
        if(status!=null)return status;
        return 500;
    }
}
