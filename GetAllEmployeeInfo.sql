DELIMITER //
CREATE PROCEDURE GetAllEmployeeInfo()
BEGIN
    SELECT ename, esal FROM Emp;
END //
DELIMITER ;
