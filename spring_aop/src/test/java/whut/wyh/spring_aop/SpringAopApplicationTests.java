package whut.wyh.spring_aop;

import org.junit.jupiter.api.Test;
import org.springframework.boot.ApplicationContextFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import whut.wyh.spring_aop.Impl.MyMathCalculator;
import whut.wyh.spring_aop.Interface.Calculator;
import whut.wyh.spring_aop.proxy.CalculatorProxy;

@SpringBootTest
class SpringAopApplicationTests {



    @Test
    void contextLoads() {
        Calculator calculator = new MyMathCalculator();
        calculator.add(1,3);
        //动态代理
        //拿到了这个对象的代理对象，代理对象进行加减乘除
        System.out.println("=================动态代理==================");
        /**
         * @description：动态代理致命缺陷：jdk默认的动态代理，如果代理对象没有实现任何借口，无法创建动态代理对象
         */
        Calculator proxy = CalculatorProxy.getProxy(calculator);
        proxy.add(11,2);
        System.out.println("==================AOP=====================");

    }

}
