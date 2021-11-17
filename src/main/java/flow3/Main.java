package flow3;

import flow3.runtime.FlowSession;
import flow3.util.DSLMode;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@MapperScan({"flow3.model"})

//@Configuration
//@EnableAutoConfiguration
//@ComponentScan(basePackages = {"flow3.model"})
public class Main {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Main.class, args);

		FlowSession flowSession = new FlowSession();
		//flowSession.run(DSLMode.VisitorNode);
		flowSession.run(DSLMode.ListenerNode);
	}
}
