package kr.or.connect.config;

import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import javax.sql.DataSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(ApplicationConfig.class)
public class DBConfigTest {

    private final DataSource dataSource;

    @Autowired
    public DBConfigTest (DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Test
    void DB연결테스트() {
        try (final Connection connection = dataSource.getConnection()) {
            Assertions.assertNotNull(connection);
        }catch (Exception e) {
            fail();
        }
    }

}
