package cn.edu.jsu.hujie.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 * Excel�����
 * @author ����
 *
 */
public class Exceldao {

	/**
	 * ���ļ���Ϣд�뵽Excel���
	 * @throws IOException
	 */
	public static void excelAdd() throws IOException {
		String str;
		File file1=new File("D:/���ۼ�¼.txt");
		File file = new File("D:/���ۼ�¼.xls");
		Workbook workbook = new HSSFWorkbook();// ��������������
		Sheet sheet = workbook.createSheet("���ۼ�¼");// �������������.
		int i,j;
		j=0;
		try {
			FileReader fr=new FileReader(file1);
			BufferedReader br=new BufferedReader(fr);
			try {
				String s[]=new String[10];
				while((str=br.readLine())!=null) {
					s=str.split("\t");
					Row row = sheet.createRow(j++);
					for(i=0;i<5;i++)
					{
						Cell cell = row.createCell(i);
						cell.setCellValue(s[i]);
					}
				}
				br.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		FileOutputStream fos;
		try {
			fos = new FileOutputStream(file);
			try {
				workbook.write(fos);
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			} // ������д�뵽ָ����excel�ĵ�

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} // �������������
	}
}
