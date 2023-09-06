package ru.gloria_jeans.ui.server.jetpackcompose.enums;

public enum WarehouseScreen {
    MAIN("main"),
    SUPPLY_SEARCH_BOX("supply_search_box"),
    SUPPLY_SEARCH_DOCUMENT("supply_search_document"),
    SUPPLY_RESULT_SEARCH("supply_result_search"),
    SUPPLY_VIEW_DOCUMENT("supply_view_document"),
    SUPPLY_RECALCULATION_BOX("supply_recalculation_box"),
    SUPPLY_RECALCULATION_BOX_UPDATE("supply_recalculation_box_update"),
    SUPPLY_SCAN_BLOCK_MARK_LOT("supply_scan_block_mark_lot"),
    SUPPLY_RECALCULATION_LOT("supply_recalculation_lot"),
    SUPPLY_GOOD_IMAGE("supply_good_image"),
    SUPPLY_LIST_PROBLEM_MARKS("supply_list_problem_marks"),
    SUPPLY_MENU_LIST_PROBLEM_MARKS("supply_menu_list_problem_marks"),
    SUPPLY_CONFIRM_DISCREPANCY("supply_confirm_discrepancy"),
    SUPPLY_CONFIRM_DISCREPANCY_POPUP("supply_confirm_discrepancy_popup"),
    SUPPLY_EMPLOYEES_LIST("supply_employees_list"),
    SUPPLY_CONFIRM_ACCEPTANCE_DELIVERY_YES("supply_confirm_acceptance_delivery_yes"),
    SUPPLY_CHANGE_QUANTITY("supply_change_quantity"),
    SUPPLY_CHANGE_QUANTITY_UPDATE("supply_change_quantity_update"),
    SUPPLY_CLEAR_FACT_POSITION("supply_clear_fact_position"),
    SUPPLY_CLEAR_FACT_ALL_POSITIONS("supply_clear_fact_all_positions"),
    SUPPLY_DELETE_POSITION("supply_delete_position"),
    EXPORT("export"),
    SEARCH("search"),
    INVENTORY("inventory"),
    INTERNET_ORDERS("internet_orders"),
    INTERNET_ORDERS_ACCEPT_CLICK_COLLECT("internet_orders_accept_click_collect"),
    INTERNET_ORDERS_ACCEPT_CLICK_COLLECT_CONFIRM("internet_orders_accept_click_collect_confirm"),
    INTERNET_ORDERS_COLLECT_ORDERS("internet_orders_collect_orders"),
    INTERNET_ORDERS_COLLECT_ORDERS_CONTENT_ORDER("internet_orders_collect_orders_content_order"),
    INTERNET_ORDERS_COLLECT_ORDERS_CONTENT_ORDER_AFTER_PACKAGES("internet_orders_collect_orders_content_order_after_packages"),
    INTERNET_ORDERS_COLLECT_ORDERS_MENU_ORDER("internet_orders_collect_orders_menu_order"),
    INTERNET_ORDERS_COLLECT_ORDERS_CONFIRM_ASSEMBLY_ORDER("internet_orders_collect_orders_confirm_assembly_order"),
    INTERNET_ORDERS_COLLECT_ORDERS_PACKAGES("internet_orders_collect_orders_packages"),
    INTERNET_ORDERS_COLLECT_ORDERS_PACKAGES_CHANGE_QUANTITY("internet_orders_collect_orders_packages_change_quantity"),
    INTERNET_ORDERS_COURIER_DELIVERY("internet_orders_courier_delivery"),
    INTERNET_ORDERS_COURIER_DELIVERY_ORDERS_LIST("internet_orders_courier_delivery_orders_list"),
    INTERNET_ORDERS_RETURN_COMPLETE("internet_orders_return_complete"),
    INTERNET_ORDERS_COURIER_RETURN("internet_orders_courier_return"),
    INTERNET_ORDERS_ORDER_DISBANDMENT("internet_orders_order_disbandment"),
    INTERNET_ORDERS_ORDER_DISBANDMENT_RESULT("internet_orders_order_disbandment_result"),
    INTERNET_ORDERS_ORDER_INFORMATION("internet_orders_order_information"),
    INTERNET_ORDERS_ORDER_INFORMATION_ORDERS_LIST("internet_orders_order_information_orders_list"),
    INTERNET_ORDERS_INFORMATION_ABOUT_ORDER("internet_orders_information_about_order"),
    INTERNET_ORDERS_INFORMATION_ABOUT_ORDER_MENU_ORDER("internet_orders_information_about_order_menu_order"),
    INTERNET_ORDERS_EMPLOYEES_LIST("internet_orders_employees_list"),
    INTERNET_ORDERS_COLLECT_ORDERS_VIEW_POSITION("internet_orders_collect_orders_view_position"),
    INTERNET_ORDERS_CHECK_ACCEPTANCE_DOCUMENT("internet_orders_check_acceptance_document"),
    INTERNET_ORDERS_CHECK_CURRENT_USER_ID("internet_orders_check_current_user_id"),
    INTERNET_ORDERS_CLEAR_FACT_POSITION("internet_orders_clear_fact_position"),
    INTERNET_ORDERS_CHANGE_QUANTITY("internet_orders_change_quantity"),
    INTERNET_ORDERS_CHANGE_QUANTITY_UPDATE("internet_orders_change_quantity_update"),
    INTERNET_ORDERS_DELETE_POSITION("internet_orders_delete_position"),
    INTERNET_ORDERS_ACCEPTANCE_DOCUMENT("internet_orders_acceptance_document"),
    INTERNET_ORDERS_CONFIRMATION_DOCUMENT("internet_orders_confirmation_document"),
    INTERNET_ORDERS_FINISH_ISSUING_ORDERS("internet_orders_finish_issuing_orders"),
    INTERNET_ORDERS_CAUSES_OF_NOT_ASSEMBLY("internet_orders_causes_of_not_assembly"),
    INTERNET_ORDERS_CAUSES_OF_NOT_ASSEMBLY_AFTER_CHOICE("internet_orders_causes_of_not_assembly_after_choice"),
    INTERNET_ORDERS_ERROR_PACKAGE("internet_orders_error_package"),
    CATALOG_SEARCH_PRODUCT("catalog_search_product"),
    CATALOG_PRODUCT_LIST("catalog_product_list"),
    CATALOG_PRODUCT_INFORMATION_RESULT("catalog_product_information_result"),
    CATALOG_ENLARGE_PRODUCT_IMAGE("catalog_enlarge_product_image"),
    CATALOG_PRODUCT_FROM_LIST("catalog_product_from_list"),
    CATALOG_PRODUCT_GET_MODELS_BALANCE("catalog_product_get_models_balance"),
    CATALOG_PRODUCT_CITY_BALANCE("catalog_product_city_balance"),
    EXPORT_MOVING_LIST("export_moving_list"),
    EXPORT_COLLECT_BOX("export_collect_box");
    private String warehouseScreen;

    WarehouseScreen(String warehouseScreen) {
        this.warehouseScreen = warehouseScreen;
    }

    public String getWarehouseScreen() {
        return warehouseScreen.replace('_', '/');
    }

    public String getWarehouseScreenWithoutSlashes(){
        return warehouseScreen;
    }
}
