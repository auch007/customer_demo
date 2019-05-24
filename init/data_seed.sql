DELETE FROM ta_cust_stus;
INSERT INTO ta_cust_stus (stus_cod, stus) VALUES ('P','Prospective');
INSERT INTO ta_cust_stus (stus_cod, stus) VALUES ('C','Current');
INSERT INTO ta_cust_stus (stus_cod, stus) VALUES ('N','Non-active');

DELETE FROM ta_cust;
INSERT INTO ta_cust (stus_cod, name, email, phone, dob) VALUES ('C', 'Current Customer 01','currCust01@email.com','12345678',STR_TO_DATE('1988-02-11', '%Y-%m-%d'));
INSERT INTO ta_cust (stus_cod, name, email, phone, dob) VALUES ('C', 'Current Customer 02','currCust02@email.com','23456789',STR_TO_DATE('1989-03-12', '%Y-%m-%d'));
INSERT INTO ta_cust (stus_cod, name, email, phone, dob) VALUES ('C', 'Current Customer 03','currCust03@email.com','34567890',STR_TO_DATE('1990-04-13', '%Y-%m-%d'));
INSERT INTO ta_cust (stus_cod, name, email, phone, dob) VALUES ('C', 'Current Customer 04','currCust04@email.com','45678901',STR_TO_DATE('1991-05-14', '%Y-%m-%d'));
INSERT INTO ta_cust (stus_cod, name, email, phone, dob) VALUES ('C', 'Current Customer 05','currCust05@email.com','56789012',STR_TO_DATE('1992-06-15', '%Y-%m-%d'));

INSERT INTO ta_cust (stus_cod, name, email, phone, dob) VALUES ('P', 'Prospective Customer 01','proCust01@email.com','12345678',STR_TO_DATE('1988-02-11', '%Y-%m-%d'));
INSERT INTO ta_cust (stus_cod, name, email, phone, dob) VALUES ('P', 'Prospective Customer 02','proCust02@email.com','23456789',STR_TO_DATE('1989-03-12', '%Y-%m-%d'));
INSERT INTO ta_cust (stus_cod, name, email, phone, dob) VALUES ('P', 'Prospective Customer 03','proCust03@email.com','34567890',STR_TO_DATE('1990-04-13', '%Y-%m-%d'));
INSERT INTO ta_cust (stus_cod, name, email, phone, dob) VALUES ('P', 'Prospective Customer 04','proCust04@email.com','45678901',STR_TO_DATE('1991-05-14', '%Y-%m-%d'));
INSERT INTO ta_cust (stus_cod, name, email, phone, dob) VALUES ('P', 'Prospective Customer 05','proCust05@email.com','56789012',STR_TO_DATE('1992-06-15', '%Y-%m-%d'));

INSERT INTO ta_cust (stus_cod, name, email, phone, dob) VALUES ('N', 'Non-active Customer 01','nonCust01@email.com','12345678',STR_TO_DATE('1988-02-11', '%Y-%m-%d'));
INSERT INTO ta_cust (stus_cod, name, email, phone, dob) VALUES ('N', 'Non-active Customer 02','nonCust02@email.com','23456789',STR_TO_DATE('1989-03-12', '%Y-%m-%d'));
INSERT INTO ta_cust (stus_cod, name, email, phone, dob) VALUES ('N', 'Non-active Customer 03','nonCust03@email.com','34567890',STR_TO_DATE('1990-04-13', '%Y-%m-%d'));
INSERT INTO ta_cust (stus_cod, name, email, phone, dob) VALUES ('N', 'Non-active Customer 04','nonCust04@email.com','45678901',STR_TO_DATE('1991-05-14', '%Y-%m-%d'));
INSERT INTO ta_cust (stus_cod, name, email, phone, dob) VALUES ('N', 'Non-active Customer 05','nonCust05@email.com','56789012',STR_TO_DATE('1992-06-15', '%Y-%m-%d'));