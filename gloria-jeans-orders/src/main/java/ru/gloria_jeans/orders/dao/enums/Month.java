package ru.gloria_jeans.orders.dao.enums;

import java.time.LocalDateTime;

public enum Month {
    UNKNOWN(0, "unknown"),
    JANUARY(1, "Январь"),
    FEBRUARY(2, "Февраль"),
    MARCH(3, "Март"),
    APRIL(4, "Апрель"),
    MAY(5, "Май"),
    JUNE(6, "Июнь"),
    JULY(7, "Июль"),
    AUGUST(8, "Август"),
    SEPTEMBER(9, "Сентябрь"),
    OCTOBER(10, "Октябрь"),
    NOVEMBER(11, "Ноябрь"),
    DECEMBER(12, "Декабрь");

    public final Integer value;

    public final String name;

    Month(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    public static Month getCurrentMonth() {
        for (Month month : Month.values()) {
            if (month.getValue() == LocalDateTime.now().getMonthValue()) {
                return month;
            }
        }

        return Month.UNKNOWN;
    }

    public Integer getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
