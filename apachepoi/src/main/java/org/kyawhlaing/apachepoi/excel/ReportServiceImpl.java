package org.kyawhlaing.apachepoi.excel;

import lombok.AllArgsConstructor;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ReportServiceImpl implements IReportService {
    private final ExcelRepository excelRepository;
    private static final Logger LOG = LoggerFactory.getLogger(ReportServiceImpl.class);
    @Override
    public void insertToDB() {
        try (InputStream is = new FileInputStream("C:\\Users\\ACEBNK\\Downloads\\AYFD072023_COM.xlsx"))
        {
            try (XSSFWorkbook workbook = new XSSFWorkbook(is)){
                XSSFSheet worksheet = workbook.getSheetAt(1);
                int rows = worksheet.getLastRowNum();
                List<Report> reports = new ArrayList<>();
                for (int r = 1; r <= rows; r++) {
                    XSSFRow row = worksheet.getRow(r);
                    System.out.println(
                            "First Column: " + row.getCell(0).toString()
                                    + "; Second Column: " + row.getCell(1).toString()
                                    + "; Third Column: " + row.getCell(2).getNumericCellValue()
                    );
                    Report report = new Report();
                    report.setIdType1(row.getCell(1).toString());
                    report.setIdNumber1(row.getCell(2).toString());
                    reports.add(report);
                }

                excelRepository.saveAll(reports);
            }
        } catch (FileNotFoundException e) {
            new Exception(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
