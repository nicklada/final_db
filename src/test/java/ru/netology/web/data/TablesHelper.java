package ru.netology.web.data;

import lombok.val;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.DriverManager;
import java.sql.SQLException;

public class TablesHelper {

    public static void cleanData() throws SQLException {
        val runner = new QueryRunner();
        val creditRequest = "DELETE FROM credit_request_entity";
        val order = "DELETE FROM order_entity";
        val payment = "DELETE FROM payment_entity";

        try (
                val conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/app", "app", "pass"
                )
        ) {
            runner.update(conn, creditRequest);
            runner.update(conn, order);
            runner.update(conn, payment);
        }
    }

    public static String getPaymentStatus() throws SQLException {
        val getStatus = "SELECT status FROM payment_entity WHERE created = (SELECT MAX(created) FROM payment_entity)";

        try (
                val conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/app", "app", "pass"
                );
                val countStmt = conn.createStatement();
        ) {
            try (val rs = countStmt.executeQuery(getStatus)) {
                if (rs.next()) {
                    // выборка значения по индексу столбца (нумерация с 1)
                    val status = rs.getString("status");
                    // TODO: использовать
                    return status;
                }
            }
        }
        return null;
    }

    public static String getCreditStatus() throws SQLException {
        val getStatus = "SELECT status FROM credit_request_entity WHERE created = (SELECT MAX(created) FROM credit_request_entity)";

        try (
                val conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/app", "app", "pass"
                );
                val countStmt = conn.createStatement();
        ) {
            try (val rs = countStmt.executeQuery(getStatus)) {
                if (rs.next()) {
                    // выборка значения по индексу столбца (нумерация с 1)
                    val status = rs.getString("status");
                    // TODO: использовать
                    return status;
                }
            }
        }
        return null;
    }
}
