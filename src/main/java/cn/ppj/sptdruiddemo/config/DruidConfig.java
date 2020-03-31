package cn.ppj.sptdruiddemo.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource dataSource() {
        return new DruidDataSource();
    }

    //配置对web整个应用的监控
    @Bean
    public ServletRegistrationBean getViewServlet() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet());

        //设置对本servlet的url映射地址
        String[] urlArr = new String[]{"/druid/*"};
        bean.setUrlMappings(Arrays.asList(urlArr));
        //还需要设置druid后台页面的一些基本东西，后台的登录用户名和密码，后台有哪些ip地址都可以访问，那些不可以
        Map<String, String> initParams = new HashMap<>();
        initParams.put("loginUsername", "admin");
        initParams.put("loginPassword", "123456");
        initParams.put("allow", "");//设置为空字符串表示任何ip都可以访问
        // initParams.put("deny","10.21.33.6");
        bean.setInitParameters(initParams);
        return bean;
    }

    //配置过滤器来实现对web应用的所有访问请求进行过滤，从而实现对web应用对数据库的访问监控
    @Bean
    public FilterRegistrationBean getFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean(new WebStatFilter());
        //设置对本servlet的url映射地址
        String[] urlArr = new String[]{"/*"};
        bean.setUrlPatterns(Arrays.asList(urlArr));
        //不能对所有请求都拦截。比如静态、druid后台这些请求要排除
        Map<String, String> initParams = new HashMap<>();
        initParams.put("exclusions", "*.js,*.css,*.jpg,*.png,/druid/*");
        bean.setInitParameters(initParams);
        return bean;
    }
}
