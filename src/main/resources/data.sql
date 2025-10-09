-- Initial Roles
INSERT INTO roles (name, description) VALUES 
('ADMIN', 'System Administrator'),
('MERCHANT', 'Merchant Role');

-- Users initialization with merchant IDs
INSERT INTO users (username, email, password, merchant_id) VALUES
('superadmin', 'admin@example.com', '1234', null),
('merchant1', 'merchant1@example.com', 'password123', 'MERCH002'),
('merchant2', 'merchant2@example.com', 'password123', 'MERCH003');

-- Transactions data
INSERT INTO transactions (reference_no, merchant_id, amount, currency, status, transaction_type, created_at) VALUES
('TRX001', 'MERCH001', 100.00, 'USD', 'COMPLETED', 'PAYMENT', CURRENT_TIMESTAMP()),
('TRX002', 'MERCH001', 150.00, 'USD', 'COMPLETED', 'PAYMENT', CURRENT_TIMESTAMP()),
('TRX003', 'MERCH002', 75.50, 'USD', 'PENDING', 'PAYMENT', CURRENT_TIMESTAMP()),
('TRX004', 'MERCH002', 200.00, 'USD', 'FAILED', 'PAYMENT', CURRENT_TIMESTAMP()),
('TRX005', 'MERCH003', 300.00, 'USD', 'COMPLETED', 'PAYMENT', CURRENT_TIMESTAMP());

INSERT INTO user_roles (user_id, role_id) VALUES
(1, 1), -- Assigns ADMIN (role_id=1) to superadmin (user_id=1)
(2, 2), -- Assigns MERCHANT (role_id=2) to merchant1 (user_id=2)
(3, 2); -- Assigns MERCHANT (role_id=2) to merchant2 (user_id=3)