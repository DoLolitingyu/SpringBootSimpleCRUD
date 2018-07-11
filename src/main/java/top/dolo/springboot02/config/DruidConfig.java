package top.dolo.springboot02.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

@Configuration
public class DruidConfig {

    /*
     * Druid数据库连接池：
     * 第一步：配置DataSource
     * 第二步：创建Web监控Servlet（StatViewServlet）
     * 第三步：创建Web监控Filter(WebStatFilter)
     * */
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDatasource(){
        return new DruidDataSource();
    }

    @Bean
    public ServletRegistrationBean druidServlet(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        bean.addInitParameter("loginUsername", "dolo");
        bean.addInitParameter("loginPassword", "lty");
//        bean.addInitParameter("allow", "localhost");
//        bean.addInitParameter("deny", "");
        return bean;
    }

    @Bean
    public FilterRegistrationBean druidFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        bean.addInitParameter("exclusions", "*.js,*.css,/findAll,/insert,/druid/*,/*,/login,/index,/emp/*,/emps,/girl/*");
        return bean;
    }
}
