package cogent.infotech;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan("cogent.infotech")
public class Main {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext applicationContext=new AnnotationConfigApplicationContext(Main.class);
		Employee employee=applicationContext.getBean(Employee.class);
		System.out.println(employee);
		applicationContext.close();
	}

}
