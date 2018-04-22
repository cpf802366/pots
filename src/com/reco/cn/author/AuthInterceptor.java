package com.reco.cn.author;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by cpf on 2018/4/22.
 */
public class AuthInterceptor  extends HandlerInterceptorAdapter {
    private String authKey;  //session域中所放的验证字段
    private String toUrl;    //验证失败后返回的路径（登录界面）
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(handler.getClass().isAssignableFrom(HandlerMethod.class)){
            AuthPermission authPermission = ((HandlerMethod) handler).getMethodAnnotation(AuthPermission.class);

            //没有声明需要权限,或者声明不验证权限
            if(authPermission == null || authPermission.validate() == false)
                return true;
            else{
                //在这里实现自己的权限验证逻辑
                Object obj = request.getSession().getAttribute(this.authKey);

                if(obj != null)//如果验证成功返回true（这里直接写false来模拟验证失败的处理）
                    return true;
                else{
                    //返回到登录界面
                    response.sendRedirect(this.toUrl);
                    return false;
                }
            }
        }
        else
            return true;
    }
    public String getAuthKey() {
        return authKey;
    }
    public void setAuthKey(String authKey) {
        this.authKey = authKey;
    }
    public String getToUrl() {
        return toUrl;
    }
    public void setToUrl(String toUrl) {
        this.toUrl = toUrl;
    }


}
