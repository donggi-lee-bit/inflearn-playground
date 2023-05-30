package tobyspring.helloboot;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE) // class, interface, annotation 에 적용 가능
@Configuration
@ComponentScan
public @interface MySpringBootAnnotation {

}
