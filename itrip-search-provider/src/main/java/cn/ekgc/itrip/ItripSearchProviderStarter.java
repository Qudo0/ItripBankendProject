package cn.ekgc.itrip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <b>搜索项目provider启动项</b>
 * @author Qudoo
 * @version 3.0.0
 * @since 2019-12-12
 */
@EnableEurekaClient
@SpringBootApplication
public class ItripSearchProviderStarter {
	public static void main(String[] args) {
		SpringApplication.run(ItripSearchProviderStarter.class, args);
	}
}
