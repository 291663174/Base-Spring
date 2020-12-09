package wuhen.spring.aop2;

import org.springframework.stereotype.Component;

// TODO: 2020/7/18 需要把该类放入到IOC容器中(@Component)，并起别名arithmeticCalculatorImpl   Spring返回通知
@Component("arithmeticCalculatorImpl")
public class ArithmeticCalculatorImpl implements ArithmeticCalculator {
    @Override
    public int add(int i, int j) {
        //System.out.println("The method add begins with[" + i + "," + j + "]");
        int result = i + j;
        //System.out.println("The method add ends with " + result);
        return result;
    }

    @Override
    public int sub(int i, int j) {
        //System.out.println("The method sub begins with[" + i + "," + j + "]");
        int result = i - j;
        //System.out.println("The method sub ends with " + result);
        return result;
    }

    @Override
    public int mul(int i, int j) {
        //System.out.println("The method mul begins with[" + i + "," + j + "]");
        int result = i * j;
        //System.out.println("The method mul ends with " + result);
        return result;
    }

    @Override
    public int div(int i, int j) {
        //System.out.println("The method div begins with[" + i + "," + j + "]");
        int result = i / j;
        //System.out.println("The method div ends with " + result);
        return result;
    }
}
