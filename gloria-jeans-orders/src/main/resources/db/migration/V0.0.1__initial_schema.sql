CREATE TABLE warehouse_documents_orders
(
    id uniqueidentifier NOT NULL,
    idd VARCHAR(50) NOT NULL,
    dk VARCHAR(50) NOT NULL,
    order_number VARCHAR(50) DEFAULT NULL,
    buyer_name VARCHAR(200) NOT NULL,
    warehouse VARCHAR(100),
    firm VARCHAR(100),
    collector_name VARCHAR(100),
    shipping_type VARCHAR(100),
    status_order VARCHAR(100),
    pay_type VARCHAR(100),
    warehouse_sender VARCHAR(100),
    warehouse_transit VARCHAR(100),
    buyer_address VARCHAR(200),
    shipping_method VARCHAR(100),
    order_id VARCHAR(100),
    dop VARCHAR(100),
    gift_certificate VARCHAR(100),
    tk VARCHAR(100),
    pvz VARCHAR(100),
    cash BIGINT,
    external_credit BIGINT,
    internal_credit BIGINT,
    quantity BIGINT,
    quantity_fact BIGINT,
    sum BIGINT,
    edit_time VARCHAR(50),
    date_created DATETIME,
    time_doc VARCHAR(100),
    comment VARCHAR(200),
    document_open_date DATETIME NOT NULL ,
    current_user_id VARCHAR(100) NOT NULL ,
    CONSTRAINT pk_warehouse_documents_orders PRIMARY KEY (id)
);

CREATE UNIQUE INDEX ui_warehouse_documents_orders_idd ON warehouse_documents_orders (idd);

CREATE TABLE warehouse_products_order
(
    id uniqueidentifier NOT NULL,
    idd VARCHAR(50) NOT NULL,
    id_doc VARCHAR(20),
    line_number_identity INTEGER NOT NULL,
    document_idd VARCHAR(50) NOT NULL,
    barcode VARCHAR(50) NOT NULL,
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
    quantity INTEGER NOT NULL,
    quantity_fact INTEGER,
    price DECIMAL(10,2),
    sum DECIMAL(10,2),
    vat DECIMAL(10,2),
    marks VARCHAR(131),
    is_mark bit,
    without_marks INTEGER,
    coefficient DECIMAL(10,2),
    unit VARCHAR(100),
    reason_return VARCHAR(500),
    products_comment TEXT,
    idd_analog VARCHAR(50),
    original_id VARCHAR(50),
    original_idoc VARCHAR(50),
    CONSTRAINT pk_warehouse_products_order PRIMARY KEY (id),
    CONSTRAINT fk_warehouse_products_order_warehouse_documents_orders FOREIGN KEY (document_idd) REFERENCES warehouse_documents_orders (idd)
);

CREATE UNIQUE INDEX ui_warehouse_products_order ON warehouse_products_order (idd, document_idd, line_number_identity);

CREATE TABLE warehouse_scanned_marks
(
    id uniqueidentifier NOT NULL ,
    order_item_id uniqueidentifier,
    number INTEGER NOT NULL,
    barcode_box VARCHAR(50),
    mark_type_code VARCHAR(100),
    scanned_mark VARCHAR(100),
    data_matrix VARCHAR(100),
    is_valid_mark bit,
    error_message VARCHAR(500),
    CONSTRAINT pk_warehouse_product_mark PRIMARY KEY (id)
);

CREATE TABLE warehouse_scanned_order_documents
(
    idd VARCHAR(20) NOT NULL ,
    order_number VARCHAR(50) NOT NULL,
    date_created DATETIME2,
    order_type VARCHAR(20),
    error_text VARCHAR(100),
    order_status VARCHAR(20),
    tk VARCHAR (20),
    shipping_method VARCHAR (50)
    CONSTRAINT pk_warehouse_scanned_order_documents PRIMARY KEY (order_number),

);

CREATE TABLE warehouse_returned_orders
(
    id uniqueidentifier NOT NULL,
    idd VARCHAR(50) NOT NULL,
    order_number VARCHAR(50) DEFAULT NULL,
    shipping_type VARCHAR(100),
    shipping_method VARCHAR(100),
    status_order VARCHAR(100),
    date_created DATETIME2,
    tk VARCHAR(100),
    buyer_name VARCHAR(100) NOT NULL,
    CONSTRAINT pk_warehouse_returned_orders PRIMARY KEY (id)
);

CREATE TABLE warehouse_package
(
    id uniqueidentifier NOT NULL,
    order_number VARCHAR(50) NOT NULL,
    package_idd VARCHAR(20) NOT NULL,
    package_quantity BIGINT NOT NULL,
    CONSTRAINT pk_warehouse_package PRIMARY KEY (id)
);
