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

create procedure insertComplaint
	@IDPatient int,
	@TreatmentHistory nvarchar(500),
	@StatementOfComplaint nvarchar(500),
	@HospitalTreated nvarchar(500),
	@IsDiabetic bit,
	@IsHypertensive bit,
	@CardiacCondition nvarchar(500),
	@RespitoryCondition nvarchar(500),
	@DigestiveCondition nvarchar(500),
	@OrthopedicCondition nvarchar(500),
	@MuscularCondition nvarchar(500),
	@NeurologicalCondition nvarchar(500),
	@Allergies nvarchar(500),
	@ReactionToDrugs nvarchar(500),
	@SurgeryHistory nvarchar(500)
as
begin
	insert into Complaints
	values
	(
	@TreatmentHistory,
	@StatementOfComplaint,
	@HospitalTreated,
	@IsDiabetic ,
	@IsHypertensive ,
	@CardiacCondition ,
	@RespitoryCondition ,
	@DigestiveCondition ,
	@OrthopedicCondition ,
	@MuscularCondition ,
	@NeurologicalCondition,
	@Allergies ,
	@ReactionToDrugs,
	@SurgeryHistory,
	@IDPatient
	)
end
go

create procedure insertLifestyle
	@IDPatient int,
	@IsSmoker bit,
	@CigarretesPerDay int,
	@ConsumesAlcohol bit,
	@AlcoholPerDay int,
	@UsesStimulants nvarchar(50),
	@CaffeineDrinkPerDay nvarchar(50),
	@SoftDrinkPerDay nvarchar(50),
	@EatingHabits nvarchar(50),
	@IsVegetarian bit
as
begin
	insert into Lifestyle
	values
	(
	@IsSmoker ,
	@CigarretesPerDay ,
	@ConsumesAlcohol ,
	@AlcoholPerDay ,
	@UsesStimulants ,
	@CaffeineDrinkPerDay,
	@SoftDrinkPerDay,
	@EatingHabits,
	@IDPatient,
	@IsVegetarian
	)
end
go

create procedure insertPersonalInfo
	@IDPatient int,
	@NoOfDependents int,
	@Height float,
	@PWeight float,
	@BloodType nvarchar(50),
	@Occupation nvarchar(50),
	@AnnualIncome nvarchar(50)
as
begin
	insert into PersonalInfo
	values
	(
	@NoOfDependents,
	@Height ,
	@PWeight ,
	@BloodType,
	@Occupation,
	@AnnualIncome,
	@IDPatient
	)
end
go

create procedure insertNokAddress
	@NextOfKinID int,
	@Street nvarchar(50),
	@Area nvarchar(50),
	@City nvarchar(50),
	@State nvarchar(50),
	@ZipCode nvarchar(50),
	@AddressTypeID int
as
begin
	declare @IDAddress int
	insert into OMAddress
	values
	(
		@Street ,
	@Area ,
	@City ,
	@State ,
	@ZipCode ,
	@AddressTypeID
	)

	set @IDAddress = SCOPE_IDENTITY()

	insert into NextOfKinAddress
	values
	(
		@IDAddress,
		@NextOfKinID
	)
end
go

create procedure insertPatientAddress
	@PatientID int,
	@Street nvarchar(50),
	@Area nvarchar(50),
	@City nvarchar(50),
	@State nvarchar(50),
	@ZipCode nvarchar(50),
	@AddressTypeID int
as
begin
	declare @IDAddress int
	insert into OMAddress
	values
	(
		@Street ,
	@Area ,
	@City ,
	@State ,
	@ZipCode ,
	@AddressTypeID
	)

	set @IDAddress = SCOPE_IDENTITY()

	insert into PatientAddress
	values
	(
		@IDAddress,
		@PatientID
	)
end
go

create procedure insertPatientContact
	@IDPatient int,
	@ContactTypeID int,
	@ContactNumber nvarchar(50)
as
begin
	declare @IDContact int
	insert into Contact
	values
	(
		@ContactTypeID ,
		@ContactNumber
	)
	set @IDContact = SCOPE_IDENTITY()
	
	insert into ContactPatient
	values
	(
		@IDContact,
		@IDPatient
	)
end
GO

create procedure insertNokContact
	@IDNextOfKin int,
	@ContactTypeID int,
	@ContactNumber nvarchar(50)
as
begin
	declare @IDContact int
	insert into Contact
	values
	(
		@ContactTypeID ,
		@ContactNumber
	)
	set @IDContact = SCOPE_IDENTITY()
	
	insert into ContactNextOfKin
	values
	(
		@IDContact,
		@IDNextOfKin

	)
end
go

create procedure insertNextOfKin
	@FirstName nvarchar(50),
	@LastName nvarchar(50),
	@RelationshipToPatient nvarchar(50),
	@PatientID int
as
begin
	declare @IDNok int
	insert into NextofKin
	values
	(
		@FirstName ,
		@LastName ,
		@RelationshipToPatient,
		@PatientID 
	)
	set @IDNok = SCOPE_IDENTITY()
	return @IDNok
end

go

create procedure getAddressTypes
as
begin
	select * from AddressType
end
go

create procedure getContactTypes
as
begin
	select * from ContactType
end

create procedure getComplaints
	@IDPatient int
as
begin
	select *
	from Complaints as c
	where c.PatientID = @IDPatient
end
go

create procedure getLifestyle
	@IDPatient int
as
begin
	select *
	from Lifestyle as l
	where l.PatientID = @IDPatient
end
go

create procedure getNextOfKin
	@IDPatient int
as
begin
	select *
	from NextofKin as nok
	where nok.PatientID = @IDPatient
end
go

create procedure getAddressesForNok
	@IDNextOfKin int
as
begin
	select a.*, atype.Type
	from NextOfKinAddress as na
	inner join OMAddress as a
	on a.IDOmAddress = na.AddressID
	inner join AddressType as atype
	on atype.IDAddressType = a.AddressTypeID
	where na.NextOfKinID = @IDNextOfKin
end
go

create procedure getContactsForNok
	@IDNextOfKin int
as
begin
	select c.*, ctype.Type
	from ContactNextOfKin as cn
	inner join Contact as c
	on c.IDContact= cn.ContactID
	inner join ContactType as ctype
	on ctype.IDContactType = c.ContactTypeID
	where cn.NextOfKinID= @IDNextOfKin
end
go

create procedure getAddressesForPatient
	@IDPatient int
as
begin
	select a.*, atype.Type
	from PatientAddress as pa
	inner join OMAddress as a
	on a.IDOmAddress = pa.AddressID
	inner join AddressType as atype
	on atype.IDAddressType = a.AddressTypeID
	where pa.PatientID = @IDPatient
end
go

create procedure getContactsForPatient
	@IDPatient int
as
begin
	select c.*, ctype.Type
	from ContactPatient as cp
	inner join Contact as c
	on c.IDContact= cp.ContactID
	inner join ContactType as ctype
	on ctype.IDContactType = c.ContactTypeID
	where cp.PatientID= @IDPatient
end
go

create procedure getPersonalInfo
	@IDPatient int
as
begin
	select *
	from PersonalInfo as pin
	where pin.PatientID = @IDPatient
end
go

create procedure getContactTypeId
	@Type nvarchar(50)
as
begin
	select ct.IDContactType
	from ContactType as ct
	where ct.Type = @Type
end
go

