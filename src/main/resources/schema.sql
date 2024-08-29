CREATE TABLE customer (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255)
);

CREATE TABLE service_request (
    id SERIAL PRIMARY KEY,
    description TEXT NOT NULL,
    customer_id BIGINT,
    FOREIGN KEY (customer_id) REFERENCES customer(id)
);

CREATE TABLE complaint (
    id SERIAL PRIMARY KEY,
    description TEXT NOT NULL,
    customer_id BIGINT,
    FOREIGN KEY (customer_id) REFERENCES customer(id)
);

