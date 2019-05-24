package com.auch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.http.*;
import org.skyscreamer.jsonassert.JSONAssert;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CustomerDemoAppEndPointTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testListCustomer() {
        ResponseEntity<String> resp = restTemplate.getForEntity("/customerList", String.class);
        assertEquals(HttpStatus.OK, resp.getStatusCode());
    }

    @Test
    public void testCustomerNoteNotFound() throws Exception {
        String expected = "[]";
        ResponseEntity<String> resp = restTemplate.getForEntity("/customerNote/99999", String.class);
        assertEquals(HttpStatus.OK, resp.getStatusCode());
        JSONAssert.assertEquals(expected, resp.getBody(), false);
    }

    @Test
    public void testListCustomerStus() {
        ResponseEntity<String> resp = restTemplate.getForEntity("/custStusList", String.class);        
        assertEquals(HttpStatus.OK, resp.getStatusCode());
    }
}
