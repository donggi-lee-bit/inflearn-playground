package tobyspring.helloboot;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SimpleHelloServiceTest {

    @Test
    void simpleHelloService() {
        SimpleHelloService helloService = new SimpleHelloService();

        String res = helloService.sayHello("Test");

        assertThat(res).isEqualTo("Hello Test");
    }
}
