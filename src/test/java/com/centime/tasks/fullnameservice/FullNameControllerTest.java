package com.centime.tasks.fullnameservice;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(FullNameController.class)
public class FullNameControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void testShouldReturnConcatenatedNameWhenPostEndpointIsInvoked() throws Exception {
        //Given
        String request = new JSONObject().put("name", "John").put("surName", "Doe").toString();

        //When
        mvc.perform(post("/full-name").contentType(MediaType.APPLICATION_JSON).content(request))
                //Then
                .andExpect(status().isOk()).andExpect(content().string("John Doe"));
        ;
    }

    @Test
    public void testShouldReturnBadRequestWhenPostEndpointRequestIsInvalid() throws Exception {
        //Given
        String request = new JSONObject().put("name", "John").put("surName", "Doe").toString();

        //When
        mvc.perform(post("/full-name").contentType(MediaType.APPLICATION_JSON)
                .content("{\"Name\": \"John\",\"middlename\":\"Doe\"}"))
                //Then
                .andExpect(status().isBadRequest());
    }
}
