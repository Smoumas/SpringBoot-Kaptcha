package kaptcha.demo.util;

import com.google.code.kaptcha.Constants;

import javax.servlet.http.HttpServletRequest;

public class CodeUtil {

    public static String getString(HttpServletRequest request, String key){
        try{
            String result = request.getParameter(key);
            if(result != null){
                result = result.trim();
            }
            if (result.equals("")){
                result = null;
            }
            return result;
        }catch (Exception e){
            return null;
        }
    }

    public static boolean checkVerifyCode(HttpServletRequest request){
        String verifyCodeExpected = (String)request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        String verifyCodeActual = CodeUtil.getString(request,"verifyCodeActual");
        if(verifyCodeActual == null || (!verifyCodeActual.equals(verifyCodeExpected))){
            return false;
        }
        return true;
    }
}
