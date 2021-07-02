package kr.or.connect.reservation.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

@Configuration
/*
 	@EnableTransactionManagement
	 transaction과 관련된 설정을 자동으로 해준다. 
	 단, 사용자간의 트랜잭션 처리를 위한 PlatformTransactionManager를 설정하기 위해서는 
	 TransactionManagementConfigurer를 구현하고 annotationDrivenTransactionManager 메서드를 오버라이딩 해야 한다. 
	 PlatformTransactionManager를 return 한다. 
 */
@EnableTransactionManagement
public class DBConfig implements TransactionManagementConfigurer {
	
	private String driverClassName = "com.mysql.jdbc.Driver";

	private String url = "jdbc:mysql://localhost:3306/connectdb?useUnicode=true&characterEncoding=utf8";

	private String username = "connectuser";

	private String password = "connect123!@#";

	@Bean
	public DataSource dataSource() {
		System.out.println("DBConfig.java => DataSource");
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}

	@Override
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		System.out.println("DBConfig.java => annotationDrivenTransactionManager");
		return transactionManager();
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		System.out.println("DBConfig.java => transactionManager");
		return new DataSourceTransactionManager(dataSource());
	}
}