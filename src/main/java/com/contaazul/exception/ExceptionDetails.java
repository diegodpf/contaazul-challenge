package com.contaazul.exception;

import java.util.HashMap;
import java.util.Map;

public class ExceptionDetails {
    private final Map<String, Object> detailsMap;

    private ExceptionDetails(Map<String, Object> detailsMap) {
        this.detailsMap = detailsMap;
    }

    public static ExceptionDetails of(String key, Object value, Object... others) {
        Map<String, Object> details = new HashMap<>();
        details.put(key, value);

        if (others != null) {
            assert others.length % 2 == 0;

            for (int i = 0; i < others.length; i += 2) {
                details.put(String.valueOf(others[i]), others[i + 1]);
            }
        }

        return new ExceptionDetails(details);
    }

    public Map<String, Object> getDetailsMap() {
        return detailsMap;
    }
}
