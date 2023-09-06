package ru.gloria_jeans.core.v1.marks.services;


import com.google.common.base.Strings;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import ru.gloria_jeans.core.v1.marks.configuration.MarkConstants;
import ru.gloria_jeans.core.v1.marks.model.*;


import java.util.Objects;

@Service
public class MarksService {
    public Logger logger = LoggerFactory.getLogger("MarksService");
    private final MarkConstants markConstants;

    @Autowired
    public MarksService(MarkConstants markConstants) {
        this.markConstants = markConstants;
    }

    public String auth(
            String serverMarksAuthorizationUrl,
            String username,
            String password
    ) {
        String token = null;
        AuthMark authMark = new AuthMark();
        authMark.setUsername(username);
        authMark.setPassword(password);
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<AuthMark> request = new HttpEntity<>(authMark);

        try {
            ResponseEntity<String> response = restTemplate.postForEntity(
                    serverMarksAuthorizationUrl,
                    request,
                    String.class
            );

            if (response.getStatusCode() == HttpStatus.OK) {
                token = response.getBody();
                logger.info("Auth get correct token.");
            } else {
                logger.info("Auth get not OK status. Status:'{}', body:'{}'", response.getStatusCode(), response.getBody());
            }
        } catch (Exception ex) {
            logger.error("Auth got exception.", ex);
        }

        return token;
    }

    public String validate(
            String mark,
            String currentStoreIdd,
            String firmIdd,
            String serverMarksUrl,
            String serverMarksAuthorizationUrl,
            String username,
            String password
    ) {
        String message = null;
        String token = auth(serverMarksAuthorizationUrl, username, password);
        if (!Strings.isNullOrEmpty(token)) {
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", String.format("Bearer %s", token));
            RestTemplate restTemplate = new RestTemplate();
            HttpEntity<?> request = new HttpEntity<>(headers);

            try {
                ResponseEntity<String> response = restTemplate.exchange(
                        String.format("%s/api/KM/GetKMFull?km=%s", serverMarksUrl, mark),
                        HttpMethod.GET,
                        request,
                        String.class
                );

                if (response.getStatusCode() == HttpStatus.OK) {
                    String responseBody = response.getBody();
                    logger.info("Mark validation get OK status. Body: {}", responseBody);
                    Gson gson = new Gson();
                    message = checkForReceiving(
                            gson.fromJson(responseBody, ValidationMark.class),
                            currentStoreIdd,
                            firmIdd
                    );
                } else {
                    logger.info(
                            "Mark validation get not OK status. Status: {}, body: {}",
                            response.getStatusCode(),
                            response.getBody()
                    );
                }

                return message;
            } catch (Exception ex) {
                logger.error("Mark validation got exception.", ex);
                return ex.getMessage();
            }
        } else {
            logger.error("Authorization token return empty.");
            return null;
        }
    }

    public String checkForReceiving(ValidationMark validationMark, String currentStoreIdd, String firmIdd) {
        String message = null;

        if (Objects.isNull(validationMark)) {
            message = "marks.service.message.empty_response";
        } else if (Objects.isNull(validationMark.getItems()) || validationMark.getItems().size() <= 0) {
            message = "marks.service.message.empty_items";
        } else if (!Strings.isNullOrEmpty(validationMark.getError())) {
            message = "marks.service.message.error";
        } else {
            if (
                    validationMark.getItems().get(0).getIn_circulation() &&
                            !validationMark.getItems().get(0).getIs_out() &&
                            !validationMark.getItems().get(0).getIs_lock() &&
                            !currentStoreIdd.equals(validationMark.getItems().get(0).getStore_idd())
            ) {
                message = "OK";
            } else {
                if (!validationMark.getItems().get(0).getIn_circulation()) {
                    //Не в обороте
                    message = "marks.service.message.in_circulation";
                } else if (validationMark.getItems().get(0).getIs_lock()) {
                    //Заблокирована
                    message = "marks.service.message.blocked";
                } else if (validationMark.getItems().get(0).getIs_out()) {
                    //Выведена из оборота
                    message = "marks.service.message.out";
                } else if (currentStoreIdd.equals(validationMark.getItems().get(0).getStore_idd())) {
                    //Марка уже закреплена за текущим магазином
                    message = "marks.service.message.store_idd";
                }
            }

            if (!message.equals("OK")) {
                return message;
            }

            String firmTin = null;

            if (firmIdd.equals(markConstants.getRetailIdd())) {
                firmTin = markConstants.getRetailTin();
            } else if (firmIdd.equals(markConstants.getEcommerceIdd())) {
                firmTin = markConstants.getEcommerceTin();
            } else if (firmIdd.equals(markConstants.getContinentIdd())) {
                firmTin = markConstants.getContinentTin();
            } else {
                firmTin = markConstants.getWarehousesTin();
            }

            if (!firmTin.equals(validationMark.getItems().get(0).getInn())) {
                message = "marks.service.message.tin";
            }
        }

        return message;
    }

    public ValidationMark getStatusOfMark(
            String mark,
            String serverMarksUrl,
            String serverMarksAuthorizationUrl,
            String username,
            String password
    ) {
        String token = auth(serverMarksAuthorizationUrl, username, password);
        if (!Strings.isNullOrEmpty(token)) {
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", String.format("Bearer %s", token));
            RestTemplate restTemplate = new RestTemplate();
            HttpEntity<?> request = new HttpEntity<>(headers);

            try {
                ResponseEntity<String> response = restTemplate.exchange(
                        String.format("%s/api/KM/GetKMFull?km=%s", serverMarksUrl, mark),
                        HttpMethod.GET,
                        request,
                        String.class
                );

                if (response.getStatusCode() == HttpStatus.OK) {
                    String responseBody = response.getBody();
                    logger.info("Getting status of mark get OK status. Body: {}", responseBody);
                    Gson gson = new Gson();
                    return gson.fromJson(responseBody, ValidationMark.class);
                } else {
                    logger.info(
                            "Getting status of mark get not OK status. Status: {}, body: {}",
                            response.getStatusCode(),
                            response.getBody()
                    );
                }

                return null;
            } catch (Exception ex) {
                logger.error("Getting status of mark got exception.", ex);
                return null;
            }
        } else {
            logger.error("Authorization token return empty.");
            return null;
        }
    }
}
