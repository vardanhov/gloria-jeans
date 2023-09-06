INSERT INTO gj_orders.dbo.warehouse_documents_orders (id, idd, id_doc, dk, order_number, buyer_name,
                                                                warehouse, firm, collector_name, shipping_type,
                                                                status_order, pay_type, warehouse_sender,
                                                                warehouse_transit, buyer_address, shipping_method,
                                                                order_id, dop, gift_certificate, tk, pvz, cash,
                                                                external_credit, internal_credit, quantity,
                                                                quantity_fact, sum, edit_time, date_created, time_doc,
                                                                comment, document_open_date, current_user_id)
VALUES (N'9C432FFC-899A-834B-8E10-C3AFA26C0461', N'H0013611025503207', N'  ZTIT   ', N'', N'1025503207', N'Buyer', null,
        N'Firm', null, null, N'4', null, null, null, null, N'   73P   ', null, null, null, N'cdek', null, null,
        null, null, null, 1, 1, null, N'2023-07-11 19:17:18.080', null, null, N'2023-07-11 19:17:18.083', N'testUser');

INSERT INTO gj_orders.dbo.warehouse_products_order
(id, idd, id_doc, line_number_identity, document_idd, barcode, vendor_code, base_unit, is_weight, kind_of, kind_of_product, model_code, pmm_code, min_balance, exclude_from_price, gtd_number, main_unit, main_property, nds_rate, np_rate, country_of_origin, product_group, full_name, mark_type_code, quantity, quantity_fact, price, sum, vat, marks, is_mark, without_marks, coefficient, unit, reason_return, products_comment, idd_analog, original_id, original_idoc)
VALUES(N'AA4DA1D0-BF9C-7843-8AD8-01F6CAC1D71B', N'00055550005187700', N'  DCX8   ', 1, N'H0013611025503207', N'4650215836909', N'BSU000192F0006           ', N'  WIZH   ', 0, N'   2Q2   ', N'Товар', N'BSU000192', N'BSU000192F0006', 0.00, 0, N'     0   ', N'  WIZH   ', N'     0   ', N'    I8   ', N'    I8   ', N'     0   ', N'   5SL   ', N'Брюки BSU000192 тканая темно-синий 10-11л/146', N'', 1, 1, 2199.00, 0.00, NULL, N'Брак', 0, NULL, NULL, NULL, NULL, NULL, N'00055550005187700', N'  SE5X   ', NULL);
