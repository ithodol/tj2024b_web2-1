package example.day02._2의존성;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/*
    [스프링 방법 IOC와 DI] 권장
*/
@Service // @Service 에는 @Component 포함
class SampleServie4 {
    void method() {
        System.out.println("SampleServie4.method");
    }
}
class SampleController4 {
    // static : 전역 final : 수정불가
    private final SampleServie4 sampleServie4;
    @Autowired
    public SampleController4(SampleServie4 sampleServie4) {
        this.sampleServie4 = sampleServie4;
    }

    void method() {
        sampleServie4.method();
    }
}

public class Example4 {
}
