package ru.netology.web.data;

import lombok.Value;
import lombok.val;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DataHelper {
    private static String url = "jdbc:mysql://192.168.99.100:3306/database";
    private static String user = "user1";
    private static String password = "qwerty";

    private DataHelper() {
    }

    @Value
    public static class AuthInfo {
        private String login;
        private String password;
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    public static AuthInfo getOtherAuthInfo() {
        return new AuthInfo("petya", "123qwerty");
    }

    public static AuthInfo getInvalidLogin() {
        return new AuthInfo("natasha", "123qwerty");
    }

    public static AuthInfo getInvalidPassword() {
        return new AuthInfo("natasha", "123qwerty");
    }

    @Value
    public static class VerificationCode {
        private String code;
    }

    public static String getVerificationCodeFor() {

        val authCodes = "SELECT  code FROM auth_codes WHERE created >= DATE_SUB(NOW() , INTERVAL 1 MINUTE);";
        try (
                val conn = DriverManager.getConnection(url, user, password);
                val countStmt = conn.createStatement();
        ) {
            try (val rs = countStmt.executeQuery(authCodes)) {
                if (rs.next()) {
                    // выборка значения по индексу столбца (нумерация с 1)
                    val code = rs.getString("code");
                    return code;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
