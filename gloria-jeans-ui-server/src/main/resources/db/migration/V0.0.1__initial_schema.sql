CREATE EXTENSION IF NOT EXISTS "uuid-ossp" WITH SCHEMA public;

CREATE TABLE warehouse_documents
(
    id UUID NOT NULL DEFAULT uuid_generate_v4(),
    idd VARCHAR(100) NOT NULL,
    document_grounds_id UUID DEFAULT NULL,
    document_type INTEGER NOT NULL,
    warehouse VARCHAR(100),
    currency VARCHAR(100),
    return_type VARCHAR(100),
    warehouse_receiver VARCHAR(100),
    final_warehouse VARCHAR(100),
    currency_rate DECIMAL(10, 4),
    quantity_places INTEGER,
    ground VARCHAR,
    status INTEGER DEFAULT 0,
    expected_arrival TIMESTAMP,
    transfer_number BIGINT,
    correction VARCHAR,
    transit_warehouse VARCHAR,
    trade_number VARCHAR,
    prepayment DECIMAL(10,2),
    order_status VARCHAR(50),
    guid VARCHAR,
    quantity BIGINT,
    sum DECIMAL(10,2),
    fact_quantity BIGINT,
    document_comment TEXT,
    collected_by VARCHAR(100),
    accepted_by VARCHAR(100),
    created_at TIMESTAMP NOT NULL,
    created_by VARCHAR(100),
    updated_at VARCHAR(10),
    updated_by VARCHAR(100),
    iddoc VARCHAR(100),
    docno VARCHAR(100),
    idocdef INTEGER,
    cashbox INTEGER,
    sales BOOLEAN,
    realized BOOLEAN,
    purchases_book INTEGER,
    availability INTEGER,
    jur_person VARCHAR(100),
    firm_recipient VARCHAR(100),
    is_mark INTEGER,
    project VARCHAR(100),
    suppliers BOOLEAN,
    sales_book INTEGER,
    tmc BOOLEAN,
    reserves BOOLEAN,
    orders_requests BOOLEAN,
    app_code VARCHAR(100),
    requests BOOLEAN,
    cash BOOLEAN,
    delivered BOOLEAN,
    sub_contacts BOOLEAN,
    closed BOOLEAN,
    orders BOOLEAN,
    CONSTRAINT pk_warehouse_documents PRIMARY KEY (id)
);

CREATE UNIQUE INDEX ui_warehouse_documents_idd ON warehouse_documents (idd);

CREATE TABLE warehouse_products
(
    id UUID NOT NULL DEFAULT uuid_generate_v4(),
    idd VARCHAR(50) NOT NULL,
    document_idd VARCHAR(50) NOT NULL,
    barcode VARCHAR(50) NOT NULL,
    barcode_box VARCHAR(50) NOT NULL,
    vendor_code VARCHAR(50),
    base_unit VARCHAR(50),
    is_weight BOOLEAN,
    kind_of VARCHAR(50),
    kind_of_product VARCHAR(50),
    model_code VARCHAR(50),
    pmm_code VARCHAR(50),
    min_balance DECIMAL(10,2),
    exclude_from_price BOOLEAN,
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
    marks VARCHAR(100),
    without_marks INTEGER,
    coefficient DECIMAL(10,2),
    unit VARCHAR(100),
    reason_return VARCHAR,
    products_comment TEXT,
    idd_analog VARCHAR(50),
    original_id VARCHAR(50) NOT NULL,
    original_idoc VARCHAR(50) NOT NULL,
    CONSTRAINT pk_warehouse_products PRIMARY KEY (id),
    CONSTRAINT fk_warehouse_products_warehouse_documents FOREIGN KEY (document_idd) REFERENCES warehouse_documents (idd)
);

CREATE UNIQUE INDEX ui_warehouse_products ON warehouse_products (idd, document_idd, barcode_box, line_number);

CREATE TABLE warehouse_open_lot
(
    id UUID NOT NULL DEFAULT uuid_generate_v4(),
    document_idd VARCHAR(50) NOT NULL,
    lot_idd VARCHAR(50) NOT NULL,
    product_idd VARCHAR(50) NOT NULL,
    original_id_lot VARCHAR(50) NOT NULL,
    original_id VARCHAR(50) NOT NULL,
    barcode VARCHAR(50) NOT NULL,
    barcode_box VARCHAR(50) NOT NULL,
    full_name VARCHAR NOT NULL,
    vendor_code VARCHAR(100) NOT NULL,
    fact_quantity INTEGER NOT NULL,
    quantity INTEGER NOT NULL,
    price DECIMAL(10,2),
    vat DECIMAL(10,2),
    mark_type_code VARCHAR(100),
    CONSTRAINT pk_warehouse_open_lot PRIMARY KEY (id)
);

CREATE UNIQUE INDEX ui_warehouse_open_lot_lot_idd_product_idd ON warehouse_open_lot (lot_idd, product_idd);

CREATE TABLE warehouse_scanned_marks
(
    id UUID NOT NULL DEFAULT uuid_generate_v4(),
    product_id UUID,
    open_lot_id UUID,
    number INTEGER NOT NULL,
    mark_type_code VARCHAR(100),
    scanned_mark VARCHAR,
    is_valid_mark BOOLEAN,
    error_message VARCHAR,
    CONSTRAINT pk_warehouse_product_mark PRIMARY KEY (id)
);

CREATE UNIQUE INDEX ui_warehouse_product_mark_product_id_open_lot_id_number ON warehouse_scanned_marks (product_id, open_lot_id, number);