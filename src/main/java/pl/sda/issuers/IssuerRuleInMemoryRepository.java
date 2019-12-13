package pl.sda.issuers;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class IssuerRuleInMemoryRepository implements IssuerRuleRepository {

    @Override
    public List<IssuerRule> getRules() {
        List<IssuerRule> rules = new ArrayList<>();
        rules.add(new IssuerRule("Visa", "4", 16));
        rules.add(new IssuerRule("MasterCard", "51", 16));
        rules.add(new IssuerRule("MasterCard", "52", 16));
        rules.add(new IssuerRule("MasterCard", "53", 16));
        rules.add(new IssuerRule("MasterCard", "54", 16));
        rules.add(new IssuerRule("MasterCard", "55", 16));
        rules.add(new IssuerRule("AmericanExpress", "34", 15));
        rules.add(new IssuerRule("AmericanExpress", "37", 15));
        return rules;
    }

    @Override
    public List<IssuerRule> getRulesFromFile(String path) {

        List<IssuerRule> rules = new ArrayList<>();
        List<String> headers = new LinkedList<>();

        try {
            FileInputStream file = new FileInputStream(new File(path));

            XSSFWorkbook workbook = new XSSFWorkbook(file);

            XSSFSheet sheet = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheet.iterator();
            Row firstRow = rowIterator.next();
            Iterator<Cell> cellIterator = firstRow.cellIterator();

            while (cellIterator.hasNext()) {
                headers.add(cellIterator.next().getStringCellValue());
            }

            while (rowIterator.hasNext()) {
                int i = 0;
                Iterator<Cell> cellInRow = rowIterator.next().cellIterator();
                String name=null;
                String prefix=null;
                int lenght=0;
                while (cellInRow.hasNext()) {
                    if (headers.get(i).equals("name")) {
                        name = cellInRow.next().getStringCellValue();
                    }
                    if (headers.get(i).equals("prefix")) {
                        prefix= String.valueOf((int) cellInRow.next().getNumericCellValue());
                    }
                    if (headers.get(i).equals("lenght")) {
                        lenght= (int) cellInRow.next().getNumericCellValue();
                    }
                    i++;
                }
                rules.add(new IssuerRule(name, prefix,lenght));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(IssuerRule rule: rules){
            System.out.println(rule.getPrefix() + " " + rule.getName() + " " +rule.getLength());
        }
        return rules;
    }
}