package com.ymjia.demo.application.server;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.concurrent.CountDownLatch;

/**
 * 服务启动类
 *
 * @author jiayongming
 */
@Slf4j
@SpringBootApplication
@ComponentScan(basePackages = {
        "com.ymjia.demo"
})
@EnableAspectJAutoProxy
@MapperScan("com.ymjia.demo.application.mapper")
public class Server {

    @Bean
    public CountDownLatch closeLatch() {
        return new CountDownLatch(1);
    }

    /**
     * 服务启动程序.
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            log.info("===> springboot-dubbo-mybatis Start {} Begin" ,System.getProperty("spring.profiles.active"));
            ApplicationContext ctx = new SpringApplicationBuilder()
                    .sources(Server.class)
                    .web(false)
                    .registerShutdownHook(false)
                    .run(args);
            CountDownLatch closeLatch = ctx.getBean(CountDownLatch.class);
            // register Message as shutdown hook
            Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
                @Override
                public void run() {
                    log.error("springboot-dubbo-mybatis stop");
                }
            }));
            log.info("===> springboot-dubbo-mybatis Start {} successful" ,System.getProperty("spring.profiles.active"));
            closeLatch.await();
        } catch (Exception e) {
            log.error("springboot-dubbo-mybatis 程序中断异常退出",e);
        }
    }
}
