package com.yidu.util;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * poi导入文件工具类;
 *  导入数据excel文件的要求：
 *      从A1单元格开始
 *      A1,A2,...,An为实体类相对应的属性名，大小写不限
 *      B1---Bn,C1---Cn,.....N1-----Nn为要导入数据的内容
 *      其中每列之间不能够出现空缺的列：
 *          例如：A1与A2与A3为合格的方式，A1与A3中间A2没内容为不合格
 *      不遵守上述规定可能会导致数据插入异常
 *
 *
 * 1）只获取excel对象( getXSSFWrokBook(InputStream inputStream)  )：后面的获取工作表操作自己完成，遍历也自己完成
 *      传入InputStream对象，文件输入流对象，获取XSSFWorkBook对象
 *
 * 2）获取工作表对象(  getXSSFSheet(InputStream inputStream, Integer index)  ):
 *      传入InputStream输入流对象和指定要选择哪个工作表
 *
 * 3）直接获取相对应的实体类集合(  getList(Class<T> objects, InputStream in, Integer index)   )：简化转化和遍历的操作
 *      传入对象的泛型，输入流对象，和哪个工作表，直接获取指定的实体类集合对象，获取集合对象之后就进行相对应的数据库操作
 *      遍历集合
 * @author
 * @since 2020/09/20
 */
public class marketDateUtil {
    private static DateFormat dateFormat =  new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 获取excel对象，传入一个文件输入流对象，获取相对应的excel对象
     * @param inputStream 输入流对象
     */
    public static XSSFWorkbook getXSSFWrokBook(InputStream inputStream) {
        try {
            //获取excel文件对象
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(inputStream);
            //返回excel文件对象
            return xssfWorkbook;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (null != inputStream) {
                try {
                    //关闭输入流对象
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 获取工作表对象，传入一个文件输入流对象，获取相对应的excel对象
     * @param inputStream 输入流对象
     * @param index 指定的工作表
     */
    public static XSSFSheet getXSSFSheet(InputStream inputStream, Integer index) {
        try {
            //获取excel对象
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(inputStream);
            //获取指定的工作表
            XSSFSheet sheetAt = xssfWorkbook.getSheetAt(index);
            //返回工作表对象
            return sheetAt;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (null != inputStream) {
                try {
                    //关闭输入流对象
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 获取excel表中的数据，并且转换为指定的实体类集合对象
     * @param objects 要转换的泛型
     * @param in 文件输入流
     * @param index 指定哪个工作表
     * @return 封装好的指定对象的集合
     */
    public static <T> List<T> getList(Class<T> objects, InputStream in, Integer index) {
        //创建用来存放实体类的集合
        List<T> pojoList = new ArrayList<>();;

        try {

            //获取对象中的属性名称
            List<String> propertyList = getProperty(objects.newInstance());
            //获取总共有几个属性
            Integer propertySize = propertyList.size();
            //创建Map集合，存放excel表格中的头信息，键是名称，值是当前所在单元格中第几列
            Map<String, Integer> excelMap = null;
            //获取工作表对象,指定的工作表
            XSSFSheet xssfSheet = getXSSFSheet(in, index);
            //将工作表的每行数据进行遍历
            for (int rowIndex = 0; rowIndex <= xssfSheet.getLastRowNum(); rowIndex ++) {
                //获取行数据对象
                XSSFRow row = xssfSheet.getRow(rowIndex);
                //如果是标题部分，获取标题部分的值
                if (rowIndex == 0) {
                    //获取excel表格中的表头信息所对应的数据
                    excelMap = getExcelProperty(row, propertySize);
                    //执行完毕后跳过当前循环进入下次循环
                    continue;
                }

                //如果其中行没有数据是null,结束本次循环进行下次循环
                if (null == row) {
                    //执行完毕后跳过当前循环进入下次循环
                    continue;
                }

                T object = objects.newInstance();


                //获取当前的数据的集合
                Map<String, Integer> propertyMap = getExcelProperty(row, propertySize);
                //将propertyMap集合中的键存放到set集合中
                Set<String> propertyKeys = propertyMap.keySet();


                //进行map集合的遍历,将map的键存储到set集合中
                Set<String> keys = excelMap.keySet();
                //遍历set集合
                for (String key:
                        keys) {
                    //获取相对应的值
                    Integer value = excelMap.get(key);
                    //遍历里面的结果
                    for (String propertyKey:
                            propertyKeys ) {
                        //获取相对应的值
                        Integer propertyValue = propertyMap.get(propertyKey);
                        //将表头内容进行一一对应
                        if (value == propertyValue) {
                            //遍历对象中的属性
                            for (String propertyName :
                                    propertyList) {
                                //如果遍历的对象中的属性名和获取的表头名称相同
                                if (propertyName.equalsIgnoreCase(key)) {
                                    //获取相对应的setter()方法
                                    String setMethodName = "set" + propertyName;
                                    //获取对象中的所有的方法
                                    Method[] methods = object.getClass().getMethods();
                                    //遍历对象中的所有的方法
                                    for (int i = 0; i < methods.length; i ++) {
                                        //获取对象中的方法名
                                        String name = methods[i].getName();
                                        //如果方法名称和需要进行设置值的方法名称相同，就执行下面操作
                                        if (name.equals(setMethodName)) {
                                            //获取方法的参数的类型
                                            Class<?>[] parameterTypes = methods[i].getParameterTypes();
                                            //如果方法参数的类型是日期类型
                                            if (parameterTypes[0] == java.sql.Date.class) {
                                                methods[i].invoke(object, new java.sql.Date(dateFormat.parse(propertyKey).getTime()));
                                            } else if (parameterTypes[0] == Integer.class) {
                                                methods[i].invoke(object, Integer.parseInt(propertyKey));
                                            } else if (parameterTypes[0] == Double.class) {
                                                methods[i].invoke(object, Double.parseDouble(propertyKey));
                                            } else if (parameterTypes[0] == String.class) {
                                                methods[i].invoke(object, propertyKey);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                }
                pojoList.add(object);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return pojoList;
    }


    /**
     * 获取Object对象中的属性名称
     * @param  object
     * @return
     */
    private static List<String> getProperty(Object object) {
        Method[] methods = object.getClass().getMethods();
        //创建用来存放方法名的集合
        List<String> methodNameList = new ArrayList<>();
        //将传入的方法对象数组进行遍历，并且一一进行名称的获取
        for (Method method :
                methods) {
            //获取当前方法的方法名
            String methodName = method.getName();
            //判断方法名是否以set开头
            if (methodName.startsWith("set")) {
                //如果是以set开始的，就将set去掉，再将首字母小写: setFundName--->FundName
                String methodStartsWith  = methodName.substring(3);
                //将获取到的属性名存入到集合中
                methodNameList.add(methodStartsWith);
            }
        }
        return methodNameList;
    }

    /**
     * 通过行数据对象和所要传入的对象属性的个数来获取excel表中的的头字段名称
     * @param row 行数据对象
     * @param propertySize 总共有多少个属性
     * @return 头字段名称集合
     */
    private static Map<String, Integer> getExcelProperty(XSSFRow row, Integer propertySize) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //创建map集合用来存放头信息
        Map<String, Integer> map = new HashMap<>();
        for (int cellIndex = 0; cellIndex < propertySize; cellIndex ++) {
            //获取指定的单元格对象
            XSSFCell cell = row.getCell(cellIndex);
            //将获取到的单元格中的数据作为键存入到map集合中，将第几列作为值存入到map集合中
            if (null != cell) {
                //判断cell是不是数字类型
                if (cell.getCellType() == 0) {
                    if (HSSFDateUtil.isCellDateFormatted(cell)) {
                        map.put(dateFormat.format(cell.getDateCellValue()), cellIndex);
                        continue;
                    } else {
                        cell.setCellType(XSSFCell.CELL_TYPE_STRING);
                        map.put(cell.toString(), cellIndex);
                    }
                } else {
                    map.put(cell.toString(), cellIndex);
                }

            } else {
                map.put(null, cellIndex);

            }

        }
        return map;
    }

}
