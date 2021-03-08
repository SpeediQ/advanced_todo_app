package pl.kowalczyk.advanced_todo_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import pl.kowalczyk.advanced_todo_app.model.Task;
import pl.kowalczyk.advanced_todo_app.model.TaskRepository;

import javax.validation.Validator;

@SpringBootApplication
public class AdvancedTodoAppApplication {


    public static void main(String[] args) {
        SpringApplication.run(AdvancedTodoAppApplication.class, args);
    }

    @Bean
    Validator validator() {
        return new LocalValidatorFactoryBean();
    }

}
