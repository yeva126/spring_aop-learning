package whut.wyh.spring_aop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import whut.wyh.spring_aop.Impl.MyMathCalculator;

import javax.annotation.Resource;

@RestController
public class AOPController {
    @Resource
    private MyMathCalculator myMathCalculator;

    
    @GetMapping("/aopTest")
    public void getAOP(){
        myMathCalculator.add(1,10);
        myMathCalculator.devi(1,0);
    }
}
