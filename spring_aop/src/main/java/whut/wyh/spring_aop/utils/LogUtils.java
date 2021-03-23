package whut.wyh.spring_aop.utils;


import java.lang.reflect.Method;
import java.util.Arrays;

public class LogUtils {
    public static void logStart(Method method, Object... args){
        System.out.println("["+method.getName()+"]开始执行，用的参数列表["+ Arrays.asList(args)+"]");
    }
    public static void logReturn(Method method, Object res){
        System.out.println("["+method.getName()+"]正常执行完成，结果是："+res);
    }
    public static void logException(Method method, Exception e){
        System.out.println("["+method.getName()+"]执行结果出现异常，异常是："+e.getCause());
    }
    public static void logFinally(Method method){
        System.out.println("["+method.getName()+"]结束执行");
    }
}
