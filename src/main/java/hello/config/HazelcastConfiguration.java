package hello.config;

import com.hazelcast.config.Config;
import com.hazelcast.config.JoinConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.web.spring.SpringAwareWebFilter;
import hello.Application;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.web.WebFilter;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by adel on 10/08/17.
 */
@Configuration
@ConditionalOnExpression(Application.USE_HAZELCAST)
public class HazelcastConfiguration {

    @Bean
    public Config config() {

        Config config = new Config();

//        JoinConfig joinConfig = config.getNetworkConfig().getJoin();
//
//        List<String> nodes = new ArrayList();
//        nodes.add("172.21.0.4");
//        nodes.add("172.21.0.2");
//
//        joinConfig.getMulticastConfig().setEnabled(false);
//        joinConfig.getTcpIpConfig().setEnabled(true).setMembers(nodes);

        return config;
    }

    @Bean
    public SpringAwareWebFilter webFilter(HazelcastInstance hazelcastInstance) {

        Properties properties = new Properties();
        properties.put("instance-name", hazelcastInstance.getName());
        properties.put("sticky-session", "false");

        SpringAwareWebFilter webFilter = new SpringAwareWebFilter(properties);

        return webFilter;
    }
}