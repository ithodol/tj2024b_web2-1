package example.day01._1어노테이션;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.Scanner;

class SuperClass {
    public void method1() {}
        }

class SubClass extends SuperClass {
    @Override   // 부모클래스로 부터 물려받은 메소드를 재정의(내부코드 수정)한다.
    public void method1() {
        super.method1();
    }
    @Deprecated // 더이상 사용하지 않는 코드 임을 알림
    public void method2() {}
}
// [1] 어노테이션 만들기
@Retention(RetentionPolicy.RUNTIME) // JVM runtime시까지 유지
@Target(ElementType.METHOD) // method만 targetting
@interface Annotation1 {
    // 추상메소드
    String value1();
    
}
// [2] 어노테이션 사용하기
class TestClass {
    @Annotation1( value1 = "어노테이션에 값 저장")
    public void method3() {}
}

public class Example1 {
    public static void main(String[] args) {
    SubClass subclass = new SubClass();
    subclass.method1(); // SuperClass의 method1() 호출 // 오버라이딩된 메소드subclass.method2(); // method2() - Deprecated warning // 바권장(더이상 사용하지 않는) 매소드
        try {
            Method method = TestClass.class.getMethod("method3");
            Annotation1 annotation1 = method.getAnnotation(Annotation1.class);
            System.out.println(annotation1.value1());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
