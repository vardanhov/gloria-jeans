package ru.gloria_jeans.onecdbmapper.dao.enums;

public enum MovingDocumentBasis {
    /*
     1   	Пополнение
     2   	Возврат брака
     3   	Возврат сорта
     4   	Сезонный возврат
     5   	Возврат стока
     6   	Первоначальное распределение
     7   	Возврат на переделку
     8   	Перемещение-продажа
     9   	Пополнение опта из первоначального распределения розницы
     A   	Пополнение опта из розничного резерва
     B   	Пополнение розницы из оптового канала
     C   	Оптовое распределение
     D   	Перемещение стоковой продукции из розницы в опт
     E   	Подготовка Экспорта ОПТ
     F   	Подготовка Экспорта Розница
     G   	Списание на переделку
     H   	Досдача без направления
     I   	Свободное перемещение
     J   	Подготовка к инвентаризации
     Q   	Перемещение доли пополнения
     R   	Отгрузка по направлениям
     S   	Перемещение рекламных материалов
     V   	Интернет заказ
     U   	Перекодировка
     K   	Корректировка внутрикоробочных несоотвествий
     L   	Доукомплектация направлений
     M   	Перевод из брака
     N   	Перевод в брак
     O   	Снятие с витрины
     P   	Выкладка на витрину
     T   	Перемещение доли пополнения
    */

    //Пополнение
    REPLENISHMENT(
            "     1   ",
            "references.moving_document.basis.replenishment"
    ),
    //Возврат брака
    RETURN_OF_MARRIAGE(
            "     2   ",
            "references.moving_document.basis.return_of_marriage"
    );

    private String onecId;
    private String locale;

    MovingDocumentBasis(String onecId, String locale) {
        this.onecId = onecId;
        this.locale = locale;
    }

    public String getOnecId() {
        return onecId;
    }

    public void setOnecId(String onecId) {
        this.onecId = onecId;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }
}
