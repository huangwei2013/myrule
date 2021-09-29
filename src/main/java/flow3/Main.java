package flow3;

import flow3.runtime.FlowSession;
import flow3.uitl.DSLMode;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@MapperScan({"flow3.model.dao","flow3.model.entity","flow3.model.mapper"})
public class Main {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Main.class, args);

		FlowSession flowSession = new FlowSession();
		//flowSession.run(DSLMode.VisitorNode);
		flowSession.run(DSLMode.ListenerNode);
	}
}
