CREATE TABLE expense (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(255),
    total_amount DOUBLE,
    split_type VARCHAR(20),
    created_by_id BIGINT,
    group_id BIGINT,
    FOREIGN KEY (created_by_id) REFERENCES user(id),
    FOREIGN KEY (group_id) REFERENCES expense_group(id)

);


CREATE TABLE split (
   id BIGINT AUTO_INCREMENT PRIMARY KEY,
   expense_id BIGINT,
   user_id BIGINT,
   paid DOUBLE,
   owed DOUBLE,
   FOREIGN KEY (expense_id) REFERENCES expense(id),
   FOREIGN KEY (user_id) REFERENCES user(id)
);