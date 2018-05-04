package com.reco.cn.Exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * Created by cpf on 2018/4/27.
 */
@ControllerAdvice
public class GlobalExceptionHandler {



    private final static String EXPTION_MSG_KEY = "message";

  /*  @ExceptionHandler(Exception.class)
    @ResponseBody
    public void handleBizExp(HttpServletRequest request, Exception ex){

        request.getSession(true).setAttribute(EXPTION_MSG_KEY, ex.getMessage());
    }*/

    @ExceptionHandler(SQLException.class)
    public ModelAndView handSql(Exception ex){

        ModelAndView mv = new ModelAndView();
        mv.addObject("message", ex.getMessage());
        mv.setViewName("sql_error");
        return mv;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleExp(Exception ex){

        ModelAndView mv = new ModelAndView();
      /*  mv.addObject("error", ex.toString().replaceAll("\n", "<br/>"));*/

        mv.addObject("error", getExceptionDetail(ex));
        mv.setViewName("exception/error");
        return mv;
    }
    public String getExceptionDetail(Exception e) {
        System.out.println("异常开始-------------------------------------");
        e.printStackTrace();
        System.out.println("异常结束-------------------------------------");
        StringBuffer stringBuffer = new StringBuffer(e.toString() + "\n");
        StackTraceElement[] messages = e.getStackTrace();
        int length = messages.length;
        for (int i = 0; i < length; i++) {
            stringBuffer.append("\t\t\t\t"+messages[i].toString()+"\n");
        }
        return stringBuffer.toString().replaceAll("\n", "<br/>");
    }
}
