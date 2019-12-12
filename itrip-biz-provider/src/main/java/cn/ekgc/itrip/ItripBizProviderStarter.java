package cn.ekgc.itrip;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <b>项目认证子项目provider启动项</b>
 * @author Qudoo
 * @version 3.0.0
 * @since 2019-12-12
 */
@EnableEurekaClient
@MapperScan("cn.ekgc.itrip.dao")
@SpringBootApplication
public class ItripBizProviderStarter {
	public static void main(String[] args) {
		SpringApplication.run(ItripBizProviderStarter.class, args);
	}
}
