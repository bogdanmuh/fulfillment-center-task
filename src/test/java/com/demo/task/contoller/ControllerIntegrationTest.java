package com.demo.task.contoller;



import com.demo.task.TestDataSourceConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@ActiveProfiles("test")
@Import(TestDataSourceConfiguration.class)
public class ControllerIntegrationTest
{
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void sellableSumTest() throws Exception
    {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/products/sellable/sum")
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().json("""
                                    {
                                        "sum":501770
                                    }
                        """)
                );

    }


    @Test
    public void groupbyTest() throws Exception
    {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/products/groupby")
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().json("""                              
                                   [
                                            {
                                              "fulfillmentCenter": "fc4",
                                              "totalValue": 339970
                                            },
                                            {
                                              "fulfillmentCenter": "fc3",
                                              "totalValue": 41120
                                            },
                                            {
                                              "fulfillmentCenter": "fc5",
                                              "totalValue": 208990
                                            },
                                            {
                                              "fulfillmentCenter": "fc1",
                                              "totalValue": 181150
                                            },
                                            {
                                              "fulfillmentCenter": "fc2",
                                              "totalValue": 118470
                                            }
                                          ]                                                                      
                        """)
                );
    }

    @Test
    public void statusUnfulfillableTest() throws Exception
    {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/products/status/unfulfillable")
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().json("""                              
                                   [
                                             {
                                               "id": "4e0f4a88-6eb3-4748-99b5-32ff54d73a31",
                                               "productId": "p2",
                                               "status": "UNFULFILLABLE",
                                               "fulfillmentCenter": "fc3",
                                               "value": 550,
                                               "qty": 5
                                             },
                                             {
                                               "id": "52f5a83d-ff18-4c7a-804e-3a4e5de24dfe",
                                               "productId": "p1",
                                               "status": "UNFULFILLABLE",
                                               "fulfillmentCenter": "fc2",
                                               "value": 1000,
                                               "qty": 10
                                             },
                                             {
                                               "id": "f8b1a477-e1ea-4cfb-9a1e-3745de7cae44",
                                               "productId": "p5",
                                               "status": "UNFULFILLABLE",
                                               "fulfillmentCenter": "fc2",
                                               "value": 980,
                                               "qty": 7
                                             },
                                             {
                                               "id": "7a3d2b99-4c56-4089-b8e9-5be84b07c23a",
                                               "productId": "p7",
                                               "status": "UNFULFILLABLE",
                                               "fulfillmentCenter": "fc3",
                                               "value": 640,
                                               "qty": 4
                                             },
                                             {
                                               "id": "255df3a7-0eac-4756-9f3f-4ca9072a29ed",
                                               "productId": "p6",
                                               "status": "UNFULFILLABLE",
                                               "fulfillmentCenter": "fc3",
                                               "value": 1350,
                                               "qty": 9
                                             },
                                             {
                                               "id": "95d96fe5-8c75-4c8d-a84d-3c6b1cd6ecb5",
                                               "productId": "p4",
                                               "status": "UNFULFILLABLE",
                                               "fulfillmentCenter": "fc2",
                                               "value": 2470,
                                               "qty": 19
                                             },
                                             {
                                               "id": "022b14d5-0849-4658-852f-62c0bb9449a7",
                                               "productId": "p5",
                                               "status": "UNFULFILLABLE",
                                               "fulfillmentCenter": "fc3",
                                               "value": 1820,
                                               "qty": 13
                                             },
                                             {
                                               "id": "bbec6d37-8b62-4b70-bf3a-8dfb7b659e10",
                                               "productId": "p6",
                                               "status": "UNFULFILLABLE",
                                               "fulfillmentCenter": "fc1",
                                               "value": 900,
                                               "qty": 6
                                             }
                                           ]                                                                     
                        """)
                );
    }

}
