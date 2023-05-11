CREATE TABLE patients(
    id BIGSERIAL NOT NULL,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    description VARCHAR(100) NOT NULL UNIQUE,
    street VARCHAR(100) NOT NULL,
    city VARCHAR(100) NOT NULL,
    state VARCHAR(100) NOT NULL,
    house_number VARCHAR(20),
    extra_info VARCHAR(100),

    PRIMARY KEY(id)
)