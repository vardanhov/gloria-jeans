package ru.gloria_jeans.ui.server;

import io.micrometer.core.instrument.util.IOUtils;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.*;
import org.skyscreamer.jsonassert.comparator.CustomComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.nio.charset.StandardCharsets;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class UiServerApplicationTests {

    @Value("${base-server-url}")
    String baseServerUrl;

    @Autowired
    private MockMvc mvc;

    @Test
    public void supplySearchBoxTest() throws Exception {
        ClassPathResource requestBodyResource = new ClassPathResource("data/request/search_box_request_body.json");
        String requestBody = IOUtils.toString(requestBodyResource.getInputStream(), StandardCharsets.UTF_8);

        MvcResult result = mvc.perform(post(baseServerUrl + "/screen/warehouse/supply/search/box")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody)
                        .characterEncoding("UTF-8")
                        .header("Device-Serial", "a")
                        .header("Device-Model", "a")
                        .header("Device-Manufacturer", "a"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.items[0].id").exists())
                .andExpect(jsonPath("$.items[0].id").isNotEmpty())
                .andExpect(jsonPath("$.items", hasSize(1)))
                .andExpect(content().string(containsString("id"))).andReturn();

        result.getResponse().setCharacterEncoding("UTF-8");
        String responseBody = result.getResponse().getContentAsString();

        ClassPathResource classPathResource = new ClassPathResource("data/templates/search_box_response_body.json");
        String jsonTemplate = IOUtils.toString(classPathResource.getInputStream(), StandardCharsets.UTF_8);

        ValueMatcher<Object> valueMatcher = (o1, o2) -> o1.toString()
                .equals(o2.toString().replace("##BASE_URL##", baseServerUrl));

        ArrayValueMatcher<Object> arrayValueMatcher = new ArrayValueMatcher<>(new CustomComparator(
                JSONCompareMode.NON_EXTENSIBLE,
                new Customization("**.id", (o1, o2) -> true))
        );
        arrayValueMatcher = new ArrayValueMatcher<>(new CustomComparator(
                JSONCompareMode.NON_EXTENSIBLE,
                new Customization("**.id", (o1, o2) -> true),
                new Customization("**.items", arrayValueMatcher))
        );
        arrayValueMatcher = new ArrayValueMatcher<>(new CustomComparator(
                JSONCompareMode.NON_EXTENSIBLE,
                new Customization("**.id", (o1, o2) -> true),
                new Customization("**.items", arrayValueMatcher),
                new Customization("**.clickAction.actionUri", valueMatcher))
        );
        CustomComparator comparator = new CustomComparator(
                JSONCompareMode.NON_EXTENSIBLE,
                new Customization("**.id", (o1, o2) -> true),
                new Customization("items[*].items", arrayValueMatcher),
                new Customization("header.contents", arrayValueMatcher),
                new Customization("dataContext.headerRefreshAction", valueMatcher),
                new Customization("scanAction.actionUri", valueMatcher)
        );
        JSONAssert.assertEquals(jsonTemplate, responseBody, comparator);
    }

    @Test
    public void supplySearchDocumentTest() throws Exception {
        ClassPathResource requestBodyResource = new ClassPathResource("data/request/search_document_request_body.json");
        String requestBody = IOUtils.toString(requestBodyResource.getInputStream(), StandardCharsets.UTF_8);

        MvcResult result = mvc.perform(post(baseServerUrl + "/screen/warehouse/supply/search/document")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody)
                        .characterEncoding("UTF-8")
                        .header("Device-Serial", "a")
                        .header("Device-Model", "a")
                        .header("Device-Manufacturer", "a"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.items[0].id").exists())
                .andExpect(jsonPath("$.items[0].id").isNotEmpty())
                .andExpect(jsonPath("$.items", hasSize(1)))
                .andExpect(content().string(containsString("id"))).andReturn();

        result.getResponse().setCharacterEncoding("UTF-8");
        String responseBody = result.getResponse().getContentAsString();

        ClassPathResource classPathResource = new ClassPathResource("data/templates/search_document_response_body.json");
        String jsonTemplate = IOUtils.toString(classPathResource.getInputStream(), StandardCharsets.UTF_8);

        ValueMatcher<Object> valueMatcher = (o1, o2) -> o1.toString()
                .equals(o2.toString().replace("##BASE_URL##", baseServerUrl));

        ArrayValueMatcher<Object> arrayValueMatcher = new ArrayValueMatcher<>(new CustomComparator(
                JSONCompareMode.NON_EXTENSIBLE,
                new Customization("**.id", (o1, o2) -> true)));
        arrayValueMatcher = new ArrayValueMatcher<>(new CustomComparator(
                JSONCompareMode.NON_EXTENSIBLE,
                new Customization("**.id", (o1, o2) -> true),
                new Customization("**.items", arrayValueMatcher)));
        arrayValueMatcher = new ArrayValueMatcher<>(new CustomComparator(
                JSONCompareMode.NON_EXTENSIBLE,
                new Customization("**.id", (o1, o2) -> true),
                new Customization("**.items", arrayValueMatcher),
                new Customization("**.clickAction.actionUri", valueMatcher))
        );
        CustomComparator comparator = new CustomComparator(
                JSONCompareMode.NON_EXTENSIBLE,
                new Customization("**.id", (o1, o2) -> true),
                new Customization("items[*].items", arrayValueMatcher),
                new Customization("header.contents", arrayValueMatcher),
                new Customization("dataContext.headerRefreshAction", valueMatcher),
                new Customization("scanAction.actionUri", valueMatcher)
        );
        JSONAssert.assertEquals(jsonTemplate, responseBody, comparator);
    }

    @Test
    public void supplyConfirmDiscrepancyTest() throws Exception {
        ClassPathResource requestBodyResource = new ClassPathResource("data/request/supply_confirm_discrepancy_request_body.json");
        String requestBody = IOUtils.toString(requestBodyResource.getInputStream(), StandardCharsets.UTF_8);

        MvcResult result = mvc.perform(post(baseServerUrl + "/screen/warehouse/supply/confirm/discrepancy")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody)
                        .param("id", "")
                        .param("idd", "")
                        .param("fullName", "")
                        .param("position", "")
                        .characterEncoding("UTF-8")
                        .header("Device-Serial", "a")
                        .header("Device-Model", "a")
                        .header("Device-Manufacturer", "a"))
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.items[0].id").exists())
                .andExpect(jsonPath("$.items[0].id").isNotEmpty())
                .andExpect(jsonPath("$.items", hasSize(1)))
                .andExpect(status().isOk())
                .andReturn();

        result.getResponse().setCharacterEncoding("UTF-8");
        String responseBody = result.getResponse().getContentAsString();

        ClassPathResource classPathResource = new ClassPathResource("data/templates/supply_confirm_discrepancy_response_body.json");
        String jsonTemplate = IOUtils.toString(classPathResource.getInputStream(), StandardCharsets.UTF_8);

        ValueMatcher<Object> valueMatcher = (o1, o2) -> o1.toString()
                .equals(o2.toString().replace("##BASE_URL##", baseServerUrl));

        ArrayValueMatcher<Object> arrayValueMatcher = new ArrayValueMatcher<>(new CustomComparator(
                JSONCompareMode.NON_EXTENSIBLE,
                new Customization("**.id", (o1, o2) -> true)));
        arrayValueMatcher = new ArrayValueMatcher<>(new CustomComparator(
                JSONCompareMode.NON_EXTENSIBLE,
                new Customization("**.id", (o1, o2) -> true),
                new Customization("**.items", arrayValueMatcher)));
        arrayValueMatcher = new ArrayValueMatcher<>(new CustomComparator(
                JSONCompareMode.NON_EXTENSIBLE,
                new Customization("**.id", (o1, o2) -> true),
                new Customization("**.items", arrayValueMatcher),
                new Customization("**.clickAction.actionUri", valueMatcher))
        );
        CustomComparator comparator = new CustomComparator(
                JSONCompareMode.NON_EXTENSIBLE,
                new Customization("**.id", (o1, o2) -> true),
                new Customization("items[*].items", arrayValueMatcher),
                new Customization("header.contents", arrayValueMatcher),
                new Customization("dataContext.headerRefreshAction", valueMatcher),
                new Customization("scanAction.actionUri", valueMatcher)
        );
        JSONAssert.assertEquals(jsonTemplate, responseBody, comparator);
    }

    @Test
    public void supplyChangeQuantityTest() throws Exception {
        ClassPathResource requestBodyResource = new ClassPathResource("data/request/supply_change_quantity_request_body.json");
        String requestBody = IOUtils.toString(requestBodyResource.getInputStream(), StandardCharsets.UTF_8);

        MvcResult result = mvc.perform(post(baseServerUrl + "/screen/warehouse/supply/change/quantity")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody)
                        .characterEncoding("UTF-8")
                        .header("Device-Serial", "a")
                        .header("Device-Model", "a")
                        .header("Device-Manufacturer", "a"))
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.items[0].id").exists())
                .andExpect(jsonPath("$.items[0].id").isNotEmpty())
                .andExpect(jsonPath("$.items", hasSize(1)))
                .andExpect(status().isOk())
                .andReturn();

        result.getResponse().setCharacterEncoding("UTF-8");
        String responseBody = result.getResponse().getContentAsString();


        ClassPathResource classPathResource = new ClassPathResource("data/templates/supply_change_quantity_response_body.json");
        String jsonTemplate = IOUtils.toString(classPathResource.getInputStream(), StandardCharsets.UTF_8);

        ValueMatcher<Object> valueMatcher = (o1, o2) -> o1.toString()
                .equals(o2.toString().replace("##BASE_URL##", baseServerUrl));

        ArrayValueMatcher<Object> arrayValueMatcher = new ArrayValueMatcher<>(new CustomComparator(
                JSONCompareMode.NON_EXTENSIBLE,
                new Customization("**.id", (o1, o2) -> true),
                new Customization("**.clickAction.actionUri", valueMatcher)));
        arrayValueMatcher = new ArrayValueMatcher<>(new CustomComparator(
                JSONCompareMode.NON_EXTENSIBLE,
                new Customization("**.id", (o1, o2) -> true),
                new Customization("**.items", arrayValueMatcher)));
        arrayValueMatcher = new ArrayValueMatcher<>(new CustomComparator(
                JSONCompareMode.NON_EXTENSIBLE,
                new Customization("**.id", (o1, o2) -> true),
                new Customization("**.items", arrayValueMatcher),
                new Customization("**.clickAction.actionUri", valueMatcher))
        );
        CustomComparator comparator = new CustomComparator(
                JSONCompareMode.NON_EXTENSIBLE,
                new Customization("**.id", (o1, o2) -> true),
                new Customization("items[*].items", arrayValueMatcher),
                new Customization("header.contents", arrayValueMatcher),
                new Customization("dataContext.headerRefreshAction", valueMatcher)
        );
        JSONAssert.assertEquals(jsonTemplate, responseBody, comparator);
    }
}
