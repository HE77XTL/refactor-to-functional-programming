package com.github.hcsp.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class RefactorToSupplier {
    private static int randomInt() {
        return new Random().nextInt();
    }

    static int a = 0;

    public static void main(String[] args) {
        System.out.println(createObjects());
        System.out.println(createStrings());
        System.out.println(createRandomIntegers());
    }

    private static Object getObject() {
        return new Object();
    }

    private static String getString() {
        return "" + a++;
    }

    private static int getRandom() {
        return randomInt();
    }

    // 请尝试使用函数式接口Supplier对三个方法进行重构，消除冗余代码
    // 并尽量尝试使用lambda表达式和方法引用来传递参数
    public static List<Object> create(Supplier<Object> supplier) {
        List<Object> result = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            result.add(supplier.get());
        }
        return result;
    }


    public static List<Object> createObjects() {
        return create(RefactorToSupplier::getObject);
    }

    public static List<Object> createStrings() {
        return create(RefactorToSupplier::getString);
    }

    public static List<Object> createRandomIntegers() {
        return create(RefactorToSupplier::getRandom);
    }
}
