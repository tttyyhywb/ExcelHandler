package com.example.y_z;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.util.List;

public class SpecificationSpliter {

    private int specificationIndex;
    private int specificationTargetIndex;

    private Dictionary dictionary;

    public SpecificationSpliter(int specificationIndex, int specificationTargetIndex) {
        this.specificationIndex = specificationIndex;
        this.specificationTargetIndex = specificationTargetIndex;
        this.dictionary = new Dictionary();
    }

    public void split(Row row) {
        Cell cell = row.getCell(specificationIndex - 1);
        String value = cell.getStringCellValue();

        List<String> materials = dictionary.getMaterials();
        materials.forEach(material -> {
            boolean match = value.endsWith(material);
            if (match) {
                String spec = value.replace(material, "");
                Cell specCell = row.createCell(specificationTargetIndex);
                specCell.setCellValue(spec);
                Cell materialCell = row.createCell(specificationTargetIndex + 1);
                materialCell.setCellValue(material);
            }
        });

    }
}
