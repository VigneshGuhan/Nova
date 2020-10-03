package com.nova;

import api.resreq.ResReqDemo;

import pojo.Details;
import utility.ExcelUtility;

import java.io.File;
import java.util.ArrayList;

import org.testng.annotations.Test;

public class AppsTest {

    @Test
    public void addResourceUsingApi(){
        String fileName="TestData.xls";
        File testDir = new File("src", "test");
        File resourcesDir = new File(testDir, "resources");
        File filePath = new File(resourcesDir, fileName);

        String[][] data = ExcelUtility.readExcelToArray(filePath.getAbsolutePath(),"Details");
        ArrayList<Details> details=new ArrayList<>();
        System.out.println("data.length = " + data.length);
        for (int i = 1; i < data.length; i++) {
            String name=data[i][1];
            String job=data[i][2];
            String id = ResReqDemo.createDetailsViaApiUsingPost(name, job);
            if(!id.isEmpty()) {
                details.add(new Details(name, job, id));
            }
        }

        System.out.println("Details = " + details.toString());
    }

}
