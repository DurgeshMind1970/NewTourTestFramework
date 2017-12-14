package com.newtour.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.newtour.genericfunctions.GenericFunctions.EXPORTEDDATASHEET;
import com.newtour.genericfunctions.GenericFunctions.PROPERTY;
import com.newtour.genericfunctions.GenericFunctions.TESTDATASHEET;

public class ExcelUtility 
{
	private static XSSFWorkbook workbook=null;
	private static XSSFSheet sheet=null;
	private static XSSFRow _row=null;
	private static XSSFCell _cell=null;
	private static FileOutputStream fos=null;
	
	public static String f_readTestData(TESTDATASHEET sheetname, int row, int column) throws FileNotFoundException, IOException
	{
		workbook=new XSSFWorkbook(PropertyUtility.f_readProperty(PROPERTY.TESTDATA));
		sheet=workbook.getSheet(sheetname.toString());
		_row=sheet.getRow(row);
		_cell=_row.getCell(column);
		
		return _cell.getStringCellValue();
	}
	
	public static String f_readExportedData(EXPORTEDDATASHEET sheetname, int row, int column) throws FileNotFoundException, IOException
	{
		try
		{
		
			workbook=new XSSFWorkbook(PropertyUtility.f_readProperty(PROPERTY.EXPORTEDDATA));
			
			sheet=workbook.getSheet(sheetname.toString());
			_row=sheet.getRow(row);
			_cell=_row.getCell(column);
			
			return _cell.getStringCellValue();
			
		}
		catch(Exception e)
		{
			System.out.println(e.getStackTrace());
			throw e;
		}
	}
	
	public static void f_writeExportedData(TESTDATASHEET sheetname, int row, String[] data) throws FileNotFoundException, IOException
	{
		
		workbook=new XSSFWorkbook(new FileInputStream(PropertyUtility.f_readProperty(PROPERTY.EXPORTEDDATA)));
		sheet=workbook.getSheet(sheetname.toString());
		_row=sheet.createRow(row);
		
		for(int i=0;i<data.length;i++)
		{	
			XSSFCell _cell1 = null;
			_cell1=_row.createCell(i);
			_cell1.setCellValue(data[i]);
		}
		
		FileOutputStream outputStream = new FileOutputStream(PropertyUtility.f_readProperty(PROPERTY.EXPORTEDDATA));
		workbook.write(outputStream);
		outputStream.close();
		
	}
	
	
	public static String[] f_readMultipleTestData(TESTDATASHEET sheetname, int row, int columns) throws FileNotFoundException, IOException
	{
		String[] data=new String[columns];
		
		workbook=new XSSFWorkbook(PropertyUtility.f_readProperty(PROPERTY.TESTDATA));
		sheet=workbook.getSheet(sheetname.toString());
		_row=sheet.getRow(row);
		for(int i=0; i<columns;i++)
		{
			_cell=null;
			_cell=_row.getCell(i);
			data[i]=_cell.getStringCellValue();
			
		}
		
		return data;
	}
	
	
	public static String[] f_readMultipleExportedData(EXPORTEDDATASHEET sheetname, int row, int columns) throws FileNotFoundException, IOException
	{
		String[] data=new String[columns];
		
		workbook=new XSSFWorkbook(PropertyUtility.f_readProperty(PROPERTY.TESTDATA));
		sheet=workbook.getSheet(sheetname.toString());
		_row=sheet.getRow(row);
		for(int i=0; i<columns;i++)
		{
			_cell=null;
			_cell=_row.getCell(i);
			data[i]=_cell.getStringCellValue();
			
		}
		
		return data;
	}
	
	
	public static void main(String[] a) throws FileNotFoundException, IOException
	{
		System.out.println(ExcelUtility.f_readTestData(TESTDATASHEET.Login, 0, 0));
		String[] ts=ExcelUtility.f_readMultipleTestData(TESTDATASHEET.Login, 0, 2);
		for(String s : ts)
		{
			System.out.println(s);
		}
		String [] data={"qqqqq","k.qqqqq"};
		
		ExcelUtility.f_writeExportedData(TESTDATASHEET.Login, 2, data);
		
		System.out.println(ExcelUtility.f_readExportedData(EXPORTEDDATASHEET.Login, 2, 0));
		
		
	}
	
}
