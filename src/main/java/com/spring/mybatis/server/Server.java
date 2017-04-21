package com.spring.mybatis.server;

import lombok.extern.log4j.Log4j;
import org.apache.tuscany.sca.node.SCANode;
import org.apache.tuscany.sca.node.SCANodeFactory;

/**
 * 服务启动类
 * 
 * @author
 */
@Log4j
public class Server {

	private static SCANode node;

	/**
	 * start account server.
	 * 
	 * @throws java.io.IOException
	 *             IOException
	 */
	public void start() throws Exception {

		if (log.isInfoEnabled()) {
			log.info("===> spring-mybatis-demo Start Begin");
		}

		node = SCANodeFactory.newInstance().createSCANode("META-INF/spring-mybatis-demo/server.composite");
		node.start();

		if (log.isInfoEnabled()) {
			log.info("===>spring-mybatis-demo Start Successful");
		}
	}

	public void run() throws InterruptedException {
		while (true) {
			Thread.sleep(Long.MAX_VALUE);
		}
	}

	/**
	 * 服务启动程序.
	 * 
	 * @param args
	 * @throws Exception
	 *             Exception
	 */
	public static void main(String[] args) throws Exception {
		Server server = new Server();
		server.start();
		try {
			server.run();

		} catch (InterruptedException e) {
			log.error("spring-mybatis-demo server run error ", e);
		}
	}
}
