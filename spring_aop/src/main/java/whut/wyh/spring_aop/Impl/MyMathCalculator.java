package whut.wyh.spring_aop.Impl;

import org.springframework.stereotype.Service;
import whut.wyh.spring_aop.Interface.Calculator;

@Service
public class MyMathCalculator implements Calculator {

    @Override
    public int add(int i, int j) {
        int res = i + j;
        return res;
    }

    @Override
    public int sub(int i, int j) {
        int res = i - j;
        return res;
    }

    @Override
    public int mul(int i, int j) {
        int res = i * j;
        return res;
    }

    @Override
    public int devi(int i, int j) {
        int res = i / j;
        return res;
    }
}
