package data;

import utilities.Xls_Reader;

public class DataFile {

Xls_Reader d = new Xls_Reader ("c:\\Testing\\Email.xlsx");
	
	public String correctEmail = d.getCellData("Data1", 0,2);
	public String wrongEmail=d.getCellData("Data1", 1,2);
	public String wrongPassword=d.getCellData("Data1", 2,2);
	public String emailErr=d.getCellData("Data1", 3,2);
	public String passwordErr=d.getCellData("Data1", 4,2);
	
}
