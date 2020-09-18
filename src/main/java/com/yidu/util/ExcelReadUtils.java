package com.yidu.util;



import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.yidu.businessData.pojo.Import.TransactionImport;
import com.yidu.businessData.pojo.TransactionData;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ExcelReadUtils {
	
	
	
	private static Logger logger = LoggerFactory.getLogger(ExcelReadUtils.class);
	public static void main(String[] args) throws Exception {
		//导入理赔数据
		InputStream inp = new FileInputStream("C:\\Users\\chen\\Desktop\\test.xlsx");
		List<String[]> excels = readLoanInfoArray(inp,15);
		List<TransactionImport> dataList = new ArrayList();

		// 行数据
		for (int i = 0; i < excels.size(); i++) {
				TransactionImport data = setTransactionImport(excels.get(i));
				dataList.add(data);
			//insertTransactionData(data.getTransactionData());
		}
		List<TransactionData> saveDateList = new ArrayList();
		for(TransactionImport item : dataList){
			saveDateList.add(item.getTransactionData());
			//insertTransactionData(item.getTransactionData());
		}
		System.out.println(dataList.size());
		System.out.println(saveDateList.size());

	}

	/**
	 * 设置导入实体数据
	 * @param dataList
	 * @return
	 */
	public static TransactionImport setTransactionImport(String[] dataList){
		TransactionImport data = new TransactionImport();
		if(dataList.length > 0){
			data.setGddm(dataList[0]);
			data.setGdxm(dataList[1]);
		}
		return data;
	}

	// 转换Cell类型的值
	public static String getValue(Cell cell) {
		if (null == cell)
			return null;
		if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN)
			return String.valueOf(cell.getBooleanCellValue());
		else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
			DecimalFormat format = new DecimalFormat("#.##");
			format.format(cell.getNumericCellValue());
			return format.format(cell.getNumericCellValue());
		} else if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
			return null;
		} else {
			return cell.getStringCellValue();
		}
	}


	/**
	 * 解析excel
	 * @param inp
	 * @param fixedColumn
	 * @return
	 */
	public static List<String[]> readLoanInfoArray(InputStream inp,int fixedColumn) {
		Workbook wb = null;
		List<String[]> excels = new ArrayList();
		try {
			wb = WorkbookFactory.create(inp);
			for (int i = 0; i < wb.getNumberOfSheets(); i++) {
				Sheet sheet = wb.getSheetAt(i); // 读取工作表
				if (sheet == null) // 为空判断
					continue;

				for (int rowNum = 2; rowNum <= sheet.getLastRowNum(); rowNum++) {
					//List<Object> excelRows = new ArrayList<>();
					String[] excelRow = new String[fixedColumn];
					Row row = sheet.getRow(rowNum);
					if(row != null){
						for(int c = 0; c < fixedColumn; c++ ){
							Cell cell = row.getCell(c);
							if(cell != null){
								cell.setCellType(Cell.CELL_TYPE_STRING);
								excelRow[c] = cell.getStringCellValue();
							}
						}
					}
					excels.add(excelRow);
				}
			}
			return excels;
		} catch (Exception e) {
			logger.error("导入excel错误 : " + e.getMessage());
			return null;
		} finally {
			try {
				if (wb != null) {
					wb.close();
				}
				if (inp != null) {
					inp.close();
				}
			} catch (Exception e) {
				logger.error("导入excel关流错误 : " + e.getMessage());
			}
		}
	}
}