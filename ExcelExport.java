import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class ExcelExport{

	private FileOutputStream fileOut;
	private HSSFWorkbook workbook;
	private HSSFSheet worksheet;

	private HashMap<Integer, HSSFRow> rows;

	public ExcelExport(String name) {
		rows = new HashMap<>();
		try {
			fileOut = new FileOutputStream(name + ".xls");
		}  catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		workbook = new HSSFWorkbook();
		worksheet = workbook.createSheet(name);
	} 	

	public HSSFRow getRow(int r) {
		if(rows.containsKey(r)) {
			return rows.get(r);
		}
		HSSFRow row = worksheet.createRow(r);
		rows.put(r, row);
		return row;
	}

	public void wirteStringToFile(int _row, int _colum, String _s) {
		HSSFRow row = getRow(_row);
		// index from 0,0... cell A1 is cell(0,0)
		HSSFCell cell = row.createCell((short)_colum);
		cell.setCellValue(_s);
	}

	public void wirteArrayToFile(int _row, int _columStart, int[] _content) {
		HSSFRow row = getRow(_row);
		// index from 0,0... cell A1 is cell(0,0)
		for(int c = 0; c < _content.length; c++) {
			HSSFCell cell = row.createCell((short)c + _columStart);
			cell.setCellValue(_content[c]);
		}
	}

	public void saveFile() {
		try {
			workbook.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}