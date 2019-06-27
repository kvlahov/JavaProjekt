use JavaProjekt

create procedure getDoctor
	@IDDoctor int
as
	select *
	from Doctor as d
	where d.IDDoctor = @IDDoctor

create procedure getPatient
	@IDPatient int
as 
	select * 
	from Patient as p
	where p.IDPatient = @IDPatient
go

create procedure getPatientsForDoctor
	@IDDoctor int
as
	select p.IDPatient, p.Name, p.Surname, p.SexID, p.DateOfBirth
	from DoctorPatient as dp
	inner join Patient as p
	on p.IDPatient = dp.PatientID
	where dp.DoctorID = @IDDoctor
	go

create procedure getReceiptsForPatient
	@IDPatient int
as
	select *
	from Receipt as r
	where r.PatientID = @IDPatient

create procedure insertPatient
	@Name nvarchar(50),
	@Surname nvarchar(50),
	@DateOfBirth datetime,
	@SexID int
as
begin
	declare @id int
	insert into Patient
	values
	(@Name, @Surname, @DateOfBirth, @SexID)
	set @id = SCOPE_IDENTITY()
	return @id
end
go

create procedure insertDoctor
	@Name nvarchar(50),
	@Surname nvarchar(50),
	@DepartmentID int
as
begin	
	declare @id int
	insert into Doctor
	values (@Name, @Surname, @DepartmentID)
	set @id = SCOPE_IDENTITY()
	return @id
end

create procedure assignPatientToDoctor
	@IDPatient int,
	@IDDoctor int,
	@StartOfTreatment datetime
as
	insert into DoctorPatient
	values
	(@IDPatient, @IDDoctor, @StartOfTreatment, null)

create procedure setEndOfTreatmentForPatient
	@PatientID int,
	@DoctorID int,
	@EndOfTreatment datetime
as
	update DoctorPatient
	set DateEndOfTreatment = @EndOfTreatment
	where PatientID = @PatientID and DoctorID = @DoctorID

create procedure updatePatient
	@Id int,
	@Name nvarchar(50),
	@Surname nvarchar(50),
	@DateOfBirth datetime,
	@SexID int
as
	update Patient
	set 
		Patient.Name = @Name,
		Surname = @Surname,
		DateOfBirth = @DateOfBirth,
		SexID = @SexID
	where IDPatient = @Id

create procedure updateDoctor
	@Id int,
	@Name nvarchar(50),
	@Surname nvarchar(50),
	@DepartmentID int
as
	update Doctor
	set
		Doctor.Name = @Name,
		Surname = @Surname,
		DepartmentID = @DepartmentID
	where IDDoctor = @Id

create procedure getTotalForReceipt
	@IDReceipt int
as
	select SUM(ri.TotalPrice)
	from Receipt as r
	inner join ReceiptItem as ri
	on ri.ReceiptID = r.IDReceipt
	where ri.ReceiptID = @IDReceipt

create procedure insertAppointment
	@Date datetime,
	@PatientID int,
	@DoctorID int,
	@Anamnesis nvarchar(1000),
	@Diagnosis nvarchar(1000)
as
begin
	declare @id int
	insert into Appointment(Date, PatientID, DoctorID, Anamnesis, Diagnosis)
	values
	(@Date, @PatientID, @DoctorID, @Anamnesis, @Diagnosis)
	set @id = SCOPE_IDENTITY()
	return @id
end

create procedure updateAnamnesis
	@IDAppointment int,
	@Anamnesis nvarchar(1000)
as
	update Appointment
	set Anamnesis = @Anamnesis
	where IDAppointment = @IDAppointment


create procedure updateDiagnosis
	@IDAppointment int,
	@Diagnosis nvarchar(1000)
as
	update Appointment
	set Diagnosis = @Diagnosis
	where IDAppointment = @IDAppointment

create procedure deletePatient
	@IDPatient int
as
	delete 
	from Patient
	where IDPatient = @IDPatient

go

create procedure getDoctors
as
begin
	select * 
	from Doctor
end

create procedure isValidUser
	@Username nvarchar(50),
	@Pass nvarchar(50)
as
begin
	declare @res bit
	if exists (
		select * 
		from OMSUser
		where OMSUser.Username = @Username COLLATE Latin1_General_CS_AS and OMSUser.Pass = @Pass COLLATE Latin1_General_CS_AS 
	)
		begin
			set @res = 1
		end
	else
		begin
			set @res = 0
		end
	
	return @res

end

create procedure getUserRole(@id int)
as
begin
	select *
	from UserRole as ur
	where ur.IDUserRole = @id
end

create procedure getRoleForUser(@user nvarchar(50), @pass nvarchar(50))
as
begin
	select ur.IDUserRole, ur.Type
	from OMSUser as u
	inner join UserRole as ur
	on ur.IDUserRole = u.UserRoleID
	where u.Username = @user and u.Pass = @pass
end