package ru.gloria_jeans.orders.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class IddGeneratingService {
    public Logger logger = LoggerFactory.getLogger("IDD Generating Service");
    private final String iddGeneratingUrl;

    @Autowired
    public IddGeneratingService(@Value("${idd-generator.url}") String iddGeneratingUrl) {
        this.iddGeneratingUrl = iddGeneratingUrl;
    }

    public String getNewIdd() {
        logger.info("Starting getting IDD.");
        String idd = null;

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(iddGeneratingUrl))
                    .GET()
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(
                            request,
                            HttpResponse.BodyHandlers.ofString()
            );
            idd = response.body();
        } catch (Exception exception) {
            logger.error(exception.getMessage());
        }

        logger.info("Service generated new IDD: {}", idd);
        return idd;
    }
}
