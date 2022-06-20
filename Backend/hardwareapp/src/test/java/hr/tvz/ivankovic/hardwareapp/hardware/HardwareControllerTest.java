package hr.tvz.ivankovic.hardwareapp.hardware;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.annotation.After;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.reactive.server.SecurityMockServerConfigurers.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class HardwareControllerTest {

    @Autowired
    private MockMvc mockMvc;

    final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void getAllHardware() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hardware")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    void getByCode() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hardware/{code}", 1434)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(1434))
                .andExpect(jsonPath("$.name").value("Geforce GTX 1060"));
    }

    @Test
    void saveAsAdmin() throws Exception {
        mockMvc.perform(
                        MockMvcRequestBuilders.post("/hardware")
                                .with(user("admin")
                                        .password("admin")
                                        .roles("ADMIN"))
                                .content(objectMapper.writeValueAsString(new Hardware(12L, "3344" , "new hardware test", 1221.75 , "MBO", 12342)))
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    void updateAsAdmin() throws Exception {
        mockMvc.perform(
                        MockMvcRequestBuilders.put("/hardware/{code}", 2525)
                                .with(user("admin")
                                        .password("admin")
                                        .roles("ADMIN"))
                                .content(objectMapper.writeValueAsString(new Hardware(2L, "new name test" , "2525", 123.21 , "GPU", 12)))
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("2525"))
                .andExpect(jsonPath("$.name").value("new name test"))
                .andExpect(jsonPath("$.price").value(123.21));
    }

    @Test
    void deleteAsAdmin() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/hardware/{code}", 1111)
                        .with(user("admin")
                                .password("admin")
                                .roles("ADMIN"))
        ).andExpect(status().isNoContent());
    }

    @Test
    void saveAsUser() throws Exception {
        mockMvc.perform(
                        MockMvcRequestBuilders.post("/hardware")
                                .with(user("user")
                                        .password("user")
                                        .roles("USER"))
                                .content(objectMapper.writeValueAsString(new Hardware(12L, "3344" , "new hardware test", 1221.75 , "MBO", 12342)))
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isForbidden());
    }

    @Test
    void updateAsUser() throws Exception {
        mockMvc.perform(
                        MockMvcRequestBuilders.put("/hardware/{code}", 2525)
                                .with(user("user")
                                        .password("user")
                                        .roles("USER"))
                                .content(objectMapper.writeValueAsString(new Hardware(2L, "new name test" , "2525", 123.21 , "GPU", 12)))
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isForbidden());
    }

    @Test
    void deleteAsUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/hardware/{code}", 1111)
                .with(user("user")
                        .password("user")
                        .roles("USER"))
        ).andExpect(status().isForbidden());
    }
}