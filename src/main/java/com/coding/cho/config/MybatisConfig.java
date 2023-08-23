package com.coding.cho.config;

import javax.sql.DataSource;

import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.apache.ibatis.session.SqlSessionFactory;
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
public class MybatisConfig {//mybatisConfig
	
	//JPA 사용하기때문에 자동구성됩니다.
	private final DataSource dataSource;
	
	private final ApplicationContext ac;
	
	@Bean
	@ConfigurationProperties(prefix = "mybatis.configuration")
	org.apache.ibatis.session.Configuration mybatisConfiguration() {
		org.apache.ibatis.session.Configuration config= 
				new org.apache.ibatis.session.Configuration();
		config.setLogImpl(StdOutImpl.class);//쿼리확인하기위한 설정
		return config;
	}
	
	//1.SqlSessionFactiory
	@Bean
	SqlSessionFactory sqlSessionFactiory() throws Exception {
		SqlSessionFactoryBean sfb=new SqlSessionFactoryBean();
		sfb.setDataSource(dataSource);
		
		String locationPattern="classpath:mapper/**/*-mapper.xml";
		Resource[] mapperLocations=ac.getResources(locationPattern);
		//Resource[] mapperLocations=new PathMatchingResourcePatternResolver().getResources(locationPattern);
		sfb.setMapperLocations(mapperLocations);
		
		sfb.setConfiguration(mybatisConfiguration());
		
		return sfb.getObject();
	}
	
	@Bean
	SqlSessionTemplate sqlSessionTemplate() throws Exception{
		return new SqlSessionTemplate(sqlSessionFactiory());
	}

	//DB 암호화
	@Configuration
	public class JasyptConfig {

	    @Bean(name = "jasyptStringEncryptor")
	    public StringEncryptor stringEncryptor() {

	        String key = "my_jasypt_key";
	        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
	        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
	        config.setPassword(key); // 암호화할 때 사용하는 키
	        config.setAlgorithm("PBEWithMD5AndDES"); // 암호화 알고리즘
	        config.setKeyObtentionIterations("1000"); // 반복할 해싱 회수
	        config.setPoolSize("1"); // 인스턴스 pool
	        config.setProviderName("SunJCE");
	        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator"); // salt 생성 클래스
	        config.setStringOutputType("base64"); //인코딩 방식
	        encryptor.setConfig(config);
	        return encryptor;
	    }
	}

}
