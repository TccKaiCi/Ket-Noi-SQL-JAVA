package jdbc;

import java.sql.*;
import java.util.HashMap;

public class JDBC {
    public static void main(String[] args) throws Exception {
//         MySQLConnection connect = new MySQLConnection("localhost", "root", "", "svdb");
//        
//         if (connect.getConnect() != null) System.out.println("thanh cong");
//         else System.out.println("that bai");
         
        MyConnectUnit connect = new MyConnectUnit("localhost", "root", "", "svdb");
        
        //select
        ResultSet result = connect.Select("sinhvien");
        System.out.println(CountRows(result));
        
        //insert
        HashMap<String, Object> insertValues = new HashMap<>();
        insertValues.put("Masv", "1");
        insertValues.put("Hovaten", "123");
        insertValues.put("NgaySinh","11112222");
        insertValues.put("gioitinh", "nam");
        insertValues.put("Diachi", "aokfjdoasfj");
//        System.out.println(connect.Insert("sinhvien", insertValues));

        //update
        HashMap<String, Object> updateValues = new HashMap<>();
        updateValues.put("Masv", "3");
//        System.out.println(connect.Update("sinhvien", updateValues, "Masv = 1"));
        
        //delete
//        System.out.println(connect.Delete("sinhvien", "Masv = 2"));
        
        connect.Close();
    }
    
    //đếm số dòng
    protected static int CountRows(ResultSet resultSet) throws Exception {
        int count = 0;
        while (resultSet.next()) {
            count++;
            System.out.println(resultSet.getObject("Hovaten"));
        }
        return count;
    }
}
