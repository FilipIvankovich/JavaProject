package hr.tvz.ivankovic.hardwareapp.review;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ReviewControllerTest {

    @Autowired
    private MockMvc mockMvc;

    final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void getAllReview() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/review")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    void getByCode() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/review/{code}", 1434)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].rating").value(5))
                .andExpect(jsonPath("$[0].title").value("Amazing piece of hardware"))
                .andExpect(jsonPath("$[1].rating").value(4))
                .andExpect(jsonPath("$[1].title").value("Very solid..."));
    }
}