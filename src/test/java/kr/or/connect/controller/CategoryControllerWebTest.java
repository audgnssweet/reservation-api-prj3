package kr.or.connect.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import kr.or.connect.config.ApplicationConfig;
import kr.or.connect.config.WebMvcConfig;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;


/*
이것은 Controller의 통합 테스트를 위함.
 */
@SpringJUnitConfig
@WebAppConfiguration    //WebApplicationContext를 자동으로 설정해줌.
@ContextConfiguration(classes = {ApplicationConfig.class, WebMvcConfig.class})
@TestInstance(Lifecycle.PER_CLASS)
public class CategoryControllerWebTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockmvc;

    @BeforeAll
    public void setMockmvc() {
        mockmvc = MockMvcBuilders.webAppContextSetup(wac)
            .addFilters(new CharacterEncodingFilter("UTF-8",true))
            .build();
    }

    @Test
    void test() throws Exception {
        RequestBuilder builder = MockMvcRequestBuilders.get("/api/categories")
            .contentType(MediaType.APPLICATION_JSON).characterEncoding("UTF-8");

        mockmvc.perform(builder).andExpect(status().isOk()).andDo(print());
    }

}
