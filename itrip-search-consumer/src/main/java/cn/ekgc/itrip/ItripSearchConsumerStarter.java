package cn.ekgc.itrip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * <b>搜索项目Consumer启动项</b>
 * @author Qudoo
 * @version 3.0.0
 * @since 2019-12-12
 */
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class ItripSearchConsumerStarter {
	public static void main(String[] args) {
		SpringApplication.run(ItripSearchConsumerStarter.class, args);
	}
}
