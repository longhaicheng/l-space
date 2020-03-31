package website.lhc.lspace;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"website.lhc.lspace.system.*.mapper"})
public class LSpaceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LSpaceApplication.class, args);
    }

}
