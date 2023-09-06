CREATE DATABASE gj_warehouse
COLLATE Cyrillic_General_CI_AS;

USE gj_warehouse;

CREATE TABLE warehouse_documents
(
    id uniqueidentifier NOT NULL,
    idd VARCHAR(50) NOT NULL,
    document_grounds_id uniqueidentifier DEFAULT NULL,
    document_type INTEGER NOT NULL,
    warehouse VARCHAR(100),
    currency VARCHAR(100),
    return_type VARCHAR(100),
    warehouse_receiver VARCHAR(100),
    final_warehouse VARCHAR(100),
    currency_rate DECIMAL(10, 4),
    quantity_places INTEGER,
    ground VARCHAR(100),
    status INTEGER DEFAULT 0,
    expected_arrival datetime2,
    transfer_number BIGINT,
    correction VARCHAR(100),
    transit_warehouse VARCHAR(100),
    trade_number VARCHAR(100),
    prepayment DECIMAL(10,2),
    order_status VARCHAR(50),
    guid VARCHAR(100),
    quantity BIGINT,
    sum DECIMAL(10,2),
    fact_quantity BIGINT,
    document_comment TEXT,
    collected_by VARCHAR(100),
    accepted_by VARCHAR(100),
    created_at datetime2 NOT NULL,
    created_by VARCHAR(100),
    updated_at VARCHAR(10),
    updated_by VARCHAR(100),
    iddoc VARCHAR(100),
    docno VARCHAR(100),
    idocdef INTEGER,
    cashbox INTEGER,
    sales bit,
    realized bit,
    purchases_book INTEGER,
    availability INTEGER,
    jur_person VARCHAR(100),
    firm_recipient VARCHAR(100),
    is_mark INTEGER,
    project VARCHAR(100),
    suppliers bit,
    sales_book INTEGER,
    tmc bit,
    reserves bit,
    orders_requests bit,
    app_code VARCHAR(100),
    requests bit,
    cash bit,
    delivered bit,
    sub_contacts bit,
    closed bit,
    orders bit,
    CONSTRAINT pk_warehouse_documents PRIMARY KEY (id)
);

CREATE UNIQUE INDEX ui_warehouse_documents_idd ON warehouse_documents (idd);

CREATE TABLE warehouse_products
(
    id uniqueidentifier NOT NULL ,
    idd VARCHAR(50) NOT NULL,
    document_idd VARCHAR(50) NOT NULL,
    barcode VARCHAR(50) NOT NULL,
    barcode_box VARCHAR(50) NOT NULL,
    vendor_code VARCHAR(50),
    base_unit VARCHAR(50),
    is_weight bit,
    kind_of VARCHAR(50),
    kind_of_product VARCHAR(50),
    model_code VARCHAR(50),
    pmm_code VARCHAR(50),
    min_balance DECIMAL(10,2),
    exclude_from_price bit,
    gtd_number VARCHAR(50),
    main_unit VARCHAR(50),
    main_property VARCHAR(50),
    nds_rate VARCHAR(10),
    np_rate VARCHAR(10),
    country_of_origin VARCHAR(50),
    product_group VARCHAR(50),
    full_name VARCHAR(255),
    mark_type_code VARCHAR(100),
    line_number INTEGER NOT NULL,
    quantity INTEGER NOT NULL,
    quantity_fact INTEGER,
    price DECIMAL(10,2),
    sum DECIMAL(10,2),
    vat DECIMAL(10,2),
    marks VARCHAR(131),
    without_marks INTEGER,
    coefficient DECIMAL(10,2),
    unit VARCHAR(100),
    reason_return VARCHAR(500),
    products_comment TEXT,
    idd_analog VARCHAR(50),
    original_id VARCHAR(50),
    original_idoc VARCHAR(50),
    CONSTRAINT pk_warehouse_products PRIMARY KEY (id),
    CONSTRAINT fk_warehouse_products_warehouse_documents FOREIGN KEY (document_idd) REFERENCES warehouse_documents (idd)
);

CREATE UNIQUE INDEX ui_warehouse_products ON warehouse_products (idd, document_idd, barcode_box, line_number);

CREATE TABLE warehouse_open_lot
(
    id uniqueidentifier NOT NULL ,
    document_idd VARCHAR(50) NOT NULL,
    lot_idd VARCHAR(50) NOT NULL,
    product_idd VARCHAR(50) NOT NULL,
    line_number_lot INTEGER NOT NULL,
    original_id_lot VARCHAR(50),
    original_id VARCHAR(50) NOT NULL,
    barcode VARCHAR(50) NOT NULL,
    barcode_box VARCHAR(50) NOT NULL,
    full_name VARCHAR(100) NOT NULL,
    vendor_code VARCHAR(100) NOT NULL,
    fact_quantity INTEGER NOT NULL,
    quantity INTEGER NOT NULL,
    price DECIMAL(10,2),
    vat DECIMAL(10,2),
    mark_type_code VARCHAR(100),
    unit VARCHAR(100),
    nds_rate VARCHAR(100),
    CONSTRAINT pk_warehouse_open_lot PRIMARY KEY (id)
);

CREATE UNIQUE INDEX ui_warehouse_open_lot_lot_idd_product_idd_line_number_lot ON warehouse_open_lot (lot_idd, product_idd, line_number_lot);

CREATE TABLE warehouse_scanned_marks
(
    id uniqueidentifier NOT NULL ,
    product_id uniqueidentifier,
    open_lot_id uniqueidentifier,
    number INTEGER NOT NULL,
    barcode_box VARCHAR(50),
    mark_type_code VARCHAR(100),
    scanned_mark VARCHAR(100),
    data_matrix VARCHAR(100),
    is_valid_mark bit,
    error_message VARCHAR(500),
    CONSTRAINT pk_warehouse_product_mark PRIMARY KEY (id)
);

-- CREATE UNIQUE INDEX ui_warehouse_product_mark_product_id_open_lot_id_number ON warehouse_scanned_marks (product_id, open_lot_id, number);

-- INSERT INTO warehouse_documents (id, idd, document_grounds_id, document_type, warehouse, currency, return_type, warehouse_receiver, final_warehouse, currency_rate, quantity_places, ground, status, expected_arrival, transfer_number, correction, transit_warehouse, trade_number, prepayment, order_status, guid, quantity, "sum", fact_quantity, document_comment, collected_by, accepted_by, created_at, created_by, updated_at, updated_by, iddoc, docno, idocdef, cashbox, sales, realized, purchases_book, availability, jur_person, firm_recipient, is_mark, project, suppliers, sales_book, tmc, reserves, orders_requests, app_code, requests, cash, delivered, sub_contacts, closed, orders)
-- VALUES (NEWID(),N'00006040002042293',null,N'1',   N'16L'   ,     1   ,N'                                                  ',    N'VQ'   ,     N'0'   ,1.0000,4,     N'6'   ,1, N'2012-12-31 23:30:17.000',0,N''                 ,     N'0'   ,N''                    ,0.00,     N'0'   ,N'',68,26725.00,6,N'',     N'0'   ,null, N'2022-01-05 08:06:21.000',     N'0'   ,N'08:07:19',null, N'  YBLX   '   ,null,8244,null,null,null,null,null,null,     N'T'   ,null,null,null,null,null,null,null,null,null,null,null,null,null,null);
--
-- INSERT INTO warehouse_products (id, idd, document_idd, barcode, barcode_box, vendor_code, base_unit, is_weight, kind_of, kind_of_product, model_code, pmm_code, min_balance, exclude_from_price, gtd_number, main_unit, main_property, nds_rate, np_rate, country_of_origin, product_group, full_name, mark_type_code, line_number, quantity, quantity_fact, price, "sum", vat, marks, without_marks, coefficient, unit, reason_return, products_comment, idd_analog, original_id, original_idoc)
-- VALUES (NEWID(),N'00055550000380171',N'00006040002042293',N'4690387570881',N'3060400003099',N'GAS01014501L01',N'  W5GE   ',0,N'   2Q2   ',N'Лот','GAS010145',N'AAL0000170829 ',0.00,0,     0   ,N'  W5GE   ',     0   ,N'    I8   ',     0   ,     0   ,N'   5WJ   ',N'Магнит 03929 пластик черный "Противокражный" 42х48мм','',25,1,0,348.00,348.00,0.00,'',0,null,null,null,N'пластик, черный',N'00044040000170829',N'  S20C   ',N' 1097S  '),
--        (NEWID(),N'00055550004171539',N'00006040002042293',N'4680063559972',N'3060400003099',N'GAS010146F0001',N'  W4IT   ',0,N'   2Q2   ',N'Товар',N'GAS010146',N'GAS010146F0001',0.00,0,     0   ,N'  W4IT   ',     0   ,N'    I8   ',     0   ,     0   ,N'   5WJ   ',N'Фуфайка GKT009094 трикотаж белый/разноцветный S/164','',26,1,0,115.00,230.00,20.00,'',0,null,null,null,N'трикотаж, белый/разноцветный',N'00055550005116982',N'  S12R   ',N' 1097S  ')
