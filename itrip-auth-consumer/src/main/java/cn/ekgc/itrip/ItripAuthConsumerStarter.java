package cn.ekgc.itrip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * <b>项目认证子项目consumer启动项</b>
 * @author Qudoo
 * @version 3.0.0
 * @since 2019-12-12
 */
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class ItripAuthConsumerStarter {
	public static void main(String[] args) {
		SpringApplication.run(ItripAuthConsumerStarter.class, args);
	}
}
