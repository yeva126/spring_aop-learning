package whut.wyh.spring_aop.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.concurrent.ForkJoinTask;

/**
 * @author： wenyihan
 * @description：如何将这个类（切面类）的这些方法（通知方法）切入
 * @date： 19:16 2021/3/23
 */

@Component
@Aspect
public class AOPLogUtils {
    /**
     * 告诉spring每个方法什么时候运行
    */
    //拿到目标方法的详细信息：
    //只需要为通知方法的参数列表上写一个参数JoinPoint
    @Before("execution(public int whut.wyh.spring_aop.Interface.Calculator.*(int, int))")
    public static void logStart(JoinPoint joinPoint){
        //获取运行使用参数
        Object[] args = joinPoint.getArgs();
        //获取方法签名
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println("["+name+"]开始执行，用的参数列表["+ Arrays.asList(args)+"]");
    }
    /**
     * 告诉spring res是返回结果
    */
    @AfterReturning(value = "execution(public int whut.wyh.spring_aop.Interface.Calculator.*(int, int))", returning = "res")
    public static void logReturn(JoinPoint joinPoint, Object res){
        //获取方法签名
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println("["+name+"]正常执行完成，结果是："+res);
    }
    /**
     * 告诉spring e
    */
    @AfterThrowing(value = "execution(public int whut.wyh.spring_aop.Interface.Calculator.*(int, int))", throwing = "e")
    public static void logException(JoinPoint joinPoint, Exception e){
        //获取方法签名
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();

        System.out.println("["+name+"]执行结果出现异常，异常是："+e);
    }
    @After("execution(public int whut.wyh.spring_aop.Interface.Calculator.*(int, int))")
    public static void logFinally(JoinPoint joinPoint){
        //获取方法签名
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println("["+name+"]结束执行");
    }
}
