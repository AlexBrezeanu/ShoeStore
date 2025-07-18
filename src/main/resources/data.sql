INSERT INTO category (name) VALUES
('Sport Shoes'),
('Casual Shoes'),
('Flip-Flops'),
('Regular Shoes');

INSERT INTO product (category_id, name, colour, _size, price) VALUES
(1, 'Nike Air Zoom', 'Black', 42, 499.99),
(1, 'Adidas Ultraboost', 'White', 43, 579.99),
(2, 'Clarks Loafers', 'Brown', 42, 349.50),
(3, 'Havaianas Slim', 'Blue', 41, 89.99),
(4, 'Leather Office Shoes', 'Black', 44, 299.00),
(1, 'Turbo Runner 5000', 'Black/Red', 42, 299.99),
(1, 'StormSprint X', 'Blue', 43, 279.50),
(2, 'Daily Glide', 'Gray', 41, 149.90),
(2, 'Urban Flexi', 'Beige', 44, 169.95),
(3, 'Beach Breeze', 'Yellow', 40, 39.99),
(3, 'Foam Floaters', 'Turquoise', 41, 29.95),
(4, 'Classic Street', 'Brown', 42, 189.00),
(4, 'Office Prime', 'Black', 43, 210.50),
(1, 'Aero Pulse', 'White/Green', 44, 310.00),
(2, 'Metro Walker', 'Navy Blue', 42, 159.75) ON CONFLICT DO NOTHING;