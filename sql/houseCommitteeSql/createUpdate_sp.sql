use house;
#select * from Payments;
DROP PROCEDURE IF EXISTS sp_insert_update;
delimiter $$
create procedure sp_insert_update(
in in_apartmentNum int,
in in_monthNum int,
in in_monthAmount int
)
begin 
	declare payments_count int;
	select count(monthNum) into payments_count
    from `house`.`Payments`
    where MonthNum = in_monthNum and ApartmentNumber = in_apartmentNum;
    case payments_count
    when 0 then 
    INSERT INTO  `house`.`Payments` (ApartmentNumber,AmountPayed,MonthNum) 
	values (in_apartmentNum,in_monthAmount,in_monthNum);
    else 
		UPDATE Payments
		SET
		AmountPayed =in_monthAmount
		WHERE ApartmentNumber = in_apartmentNum and MonthNum = in_monthNum;
    end case;
end$$