create index IX_13DF9258 on ACE_Branch (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_58CEDA on ACE_Branch (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_3FA50E16 on ACE_Student (branchId);
create index IX_1C9574F9 on ACE_Student (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_A0B8E5BB on ACE_Student (uuid_[$COLUMN_LENGTH:75$], groupId);