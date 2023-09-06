package ru.gloria_jeans.ui.server.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Component
public class LocaleComponent {
    private final Locale locale;
    private final MessageSource messageSource;

    @Autowired
    public LocaleComponent(Locale locale, MessageSource messageSource) {
        this.locale = locale;
        this.messageSource = messageSource;
    }

    public String locale(String key) {
        try {
            return messageSource.getMessage(key, null, locale);
        } catch (Exception exception) {
            return key;
        }
    }

    public List<String> locale(List<String> keys) {
        List<String> values = new ArrayList<>();

        for (String key : keys) {
            values.add(locale(key));
        }

        return values;
    }

    public String locale(String key, List<String> args) {
        try {
            return messageSource.getMessage(key, args.toArray(), locale);
        } catch (Exception exception) {
            return key;
        }
    }
}
