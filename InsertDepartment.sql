DELIMITER //

CREATE PROCEDURE InsertDepartment(IN dname VARCHAR(255), IN dloc VARCHAR(255))
BEGIN
    INSERT INTO Department (dname, dloc) VALUES (dname, dloc);
END //

DELIMITER ;
