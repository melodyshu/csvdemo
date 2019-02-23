package com.demo.csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

    public class CsvMain {
        public static void writeHeaserCsv(String[] headers,String filePath) throws IOException{
            CSVFormat formator = CSVFormat.DEFAULT.withRecordSeparator("\n");
            FileOutputStream fos = new FileOutputStream(filePath);
            fos.write(new byte[] { (byte) 0xEF, (byte) 0xBB,(byte) 0xBF});
            OutputStreamWriter outputStreamWriter=new OutputStreamWriter(fos,Charset.forName("utf-8"));
            CSVPrinter printer=new CSVPrinter(outputStreamWriter,formator);
            //写入列头数据
            printer.printRecord(headers);
            System.out.println("CSV文件创建成功,并写入列头成功,文件路径:"+filePath);
            printer.flush();
            printer.close();
            outputStreamWriter.close();
        }

        public static void writeCsv(List<OrderStock> data, String filePath) throws IOException{
            CSVFormat formator = CSVFormat.DEFAULT.withRecordSeparator("\n");
            OutputStreamWriter outputStreamWriter=new OutputStreamWriter(new FileOutputStream(filePath,true), Charset.forName("utf-8"));
            CSVPrinter printer=new CSVPrinter(outputStreamWriter,formator);
            if(null!=data){
                //循环写入数据
                for(OrderStock orderStock:data){
                    List<Object> records = new ArrayList<>();
                    records.add(orderStock.getOrderNo());
                    records.add(orderStock.getOrderStatus());
                    records.add(orderStock.getStartTime());
                    printer.printRecord(records);
                }
            }
            System.out.println("CSV文件创建成功,文件路径:"+filePath);
            printer.flush();
            printer.close();
            outputStreamWriter.close();
        }
        public static void main(String[] args) throws IOException {
            String[] header=new String[]{"订单号","订单状态","下单时间"};
            List<OrderStock> data = new ArrayList<>();
            data.add(new OrderStock("111",5,222222L));
            data.add(new OrderStock("112",5,222223L));
            data.add(new OrderStock("113",5,222224L));
            String csvPath="c:/hello.csv";
            writeHeaserCsv(header,csvPath);
            writeCsv(data,csvPath);
        }
    }
