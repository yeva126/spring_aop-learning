package whut.wyh.spring_aop.proxy;



import whut.wyh.spring_aop.Interface.Calculator;
import whut.wyh.spring_aop.utils.LogUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CalculatorProxy {
    /**
     * @author： wenyihan
     * @description：创建动态代理对象进行日志管理
     * @date： 17:02 2021/3/23
     * @param：calculator-被代理对象
     * @return：代理对象
    */
    public static Calculator getProxy(Calculator calculator) {
        ClassLoader loader = calculator.getClass().getClassLoader();
        Class<?>[] interfaces = calculator.getClass().getInterfaces();
        InvocationHandler h = new InvocationHandler() {
            /**
             * @author： wenyihan
             * @description：//TODO
             * @date： 17:07 2021/3/23
             * @param： proxy:代理对象，给jdk使用，任何时候不要动
             *          method：当前将要执行的目标方法
             *          args：这个方法调用时外界传入的参数值
             * @return： java.lang.Object
            */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //利用反射执行目标方法
                //目标方法执行后的返回值
                System.out.println("动态代理执行");
                //日志记录
                Object res = null;
                try{
                    LogUtils.logStart(method, args);
                    res = method.invoke(calculator, args);
                    LogUtils.logReturn(method, res);
                }catch (Exception e){
                    LogUtils.logException(method, e);
                }finally {
                    LogUtils.logFinally(method);
                }

                //返回值返回后外界才能拿到返回值
                return res;
            }
        };

        //Proxy为目标对象创建代理对象
        Object proxy = Proxy.newProxyInstance(loader, interfaces, h);
        return (Calculator) proxy;
    }
}
