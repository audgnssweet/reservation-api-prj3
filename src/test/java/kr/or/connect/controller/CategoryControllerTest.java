package kr.or.connect.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import kr.or.connect.service.CategoryService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/*
controller의 단위 테스트를 위함.
 */
@ExtendWith({MockitoExtension.class})
@TestInstance(Lifecycle.PER_CLASS)
//@ContextConfiguration(classes = {ApplicationConfig.class, WebMvcConfig.class})
@WebAppConfiguration
public class CategoryControllerTest {

    @InjectMocks
    private CategoryController categoryController;

    @Mock
    private CategoryService categoryService;

    private MockMvc mockMvc;

    @BeforeAll
    public void setUpTest() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(categoryController).build();
    }

    @Test
    void getCategoriesTest() throws Exception {
        RequestBuilder builder = MockMvcRequestBuilders.get("/api/categories")
            .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(builder).andExpect(status().isOk())
            .andDo(print());
    }

}
