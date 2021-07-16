package com.pch.system.impl;

import com.pch.system.api.entity.User;
import lombok.AllArgsConstructor;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author pch 651158394@qq.com
 * @version 2021/6/17 上午9:46
 */
@AllArgsConstructor
public class SystemDatabaseImpl {

    private DataSource dataSource;

    public User queryUser(String username) {
        try (final Connection connection = dataSource.getConnection()) {
            final List<User> airlineList = new ArrayList<>();
            final PreparedStatement preparedStatement = connection.prepareStatement(
                    "" +
                            "select t.airline_no           as \"airlineNo\",\n" +
                            "       t.company_no           as \"companyNo\",\n" +
                            "       t1.company_name        as \"companyName\",\n" +
                            "       t.start_city           as \"startCity\",\n" +
                            "       t.end_city             as \"airlinendCityeNo\",\n" +
                            "       t.leave_time           as \"leaveTime\",\n" +
                            "       t2.seat_num            as \"seatNum\",\n" +
                            "       t2.price / t2.seat_num as \"price\",\n" +
                            "       t2.price               as \"totalPrice\"\n" +
                            "from airline t,\n" +
                            "     company t1,\n" +
                            "     airline_price t2\n" +
                            "where t.airline_no = t2.airline_no\n" +
                            "  and t.company_no = t1.company_no\n" +
                            "  and t.start_city like ?");
            preparedStatement.setString(1, "%" + username + "%");
            final ResultSet resultSet = preparedStatement.executeQuery();
            final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            while (resultSet.next()) {
                final User airline = new User();
                airlineList.add(airline);
            }
            return airlineList.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
