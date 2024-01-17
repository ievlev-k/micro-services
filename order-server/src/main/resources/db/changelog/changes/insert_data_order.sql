INSERT INTO payments (create_date, description, status, amount) VALUES
                                                                    ('2022-01-02', 'Payment 2', 2, 200),
                                                                    ('2022-01-03', 'Payment 3', 1, 300),
                                                                    ('2022-01-04', 'Payment 4', 2, 400),
                                                                    ('2022-01-05', 'Payment 5', 1, 500),
                                                                    ('2022-01-06', 'Payment 6', 2, 600),
                                                                    ('2022-01-07', 'Payment 7', 1, 700),
                                                                    ('2022-01-08', 'Payment 8', 2, 800),
                                                                    ('2022-01-09', 'Payment 9', 1, 900),
                                                                    ('2022-01-10', 'Payment 10', 2, 1000),
                                                                    ('2022-01-11', 'Payment 11', 1, 1100),
                                                                    ('2022-01-12', 'Payment 12', 2, 1200);


INSERT INTO orders (delivery_info, payment_id, user_id)
VALUES
    ('test2', 3, '745b8307-00b5-47c7-b8c3-80a0ba0267b5'),
    ('test3', 3, '745b8307-00b5-47c7-b8c3-80a0ba0267b5'),
    ('test4', 4, '745b8307-00b5-47c7-b8c3-80a0ba0267b5'),
    ('test5', 5, '745b8307-00b5-47c7-b8c3-80a0ba0267b5'),
    ('test6', 3, '745b8307-00b5-47c7-b8c3-80a0ba0267b5'),
    ('test7', 3, '745b8307-00b5-47c7-b8c3-80a0ba0267b5'),
    ('test8', 4, '745b8307-00b5-47c7-b8c3-80a0ba0267b5'),
    ('test9', 5, '745b8307-00b5-47c7-b8c3-80a0ba0267b5');
