package model;

import java.sql.SQLException;


public class main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        
        UserData data = new UserData("'11111111K'", "123", "'Pepe'", "'Martínez Castillo'", "'pepemc@hotmail.com'", "'Mi casa'", "1245");
        UserData data2 = new UserData("'11111111Q'", "1234", "'Pepeee'", "'Martínez Castillo'", "'pepemcccccc@hotmail.com'", "'Mi casa'", "12345");
        UserData data3 = new UserData("'11111111N'", "1234", "'Nahima'", "'Ortega Rodríguez'", "'nahimao@gmail.com'", "'Casa de Nahima'", "6789");
        UserData data4 = new UserData("'1111111S'", "123455", "'Nahima'", "'Ortegaaa Rodríguez'", "'nahimaort@gmail.com'", "'Casa de Nahimaaa'", "678910");
        
        Bank.register(data);
        Bank.register(data2);
        Bank.register(data3);
        Bank.register(data4);
    }
}