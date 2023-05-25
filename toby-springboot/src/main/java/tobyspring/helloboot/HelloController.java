package tobyspring.helloboot;

import java.util.Objects;

public class HelloController {

    private final HelloService helloService;

    public HelloController(SimpleHelloService helloService) {
        this.helloService = helloService;
    }

    public String hello(String name) {
        return helloService.sayHello(Objects.requireNonNull(name));
    }
}
