package com.wipro.route.dao;

import java.sql.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.wipro.route.bean.RouteBean;
import com.wipro.route.util.DBUtil;

public class RouteDAO {

    public String createRecord(RouteBean bean) {
        String status = "FAIL";
        try {
            Connection con = DBUtil.getDBConnection();
            System.out.println("Connection: " + con);
            String query = "INSERT INTO ROUTE_TB VALUES(?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            System.out.println("RouteID: " + bean.getRouteId());
            ps.setString(1, bean.getRouteId());
            ps.setString(2, bean.getRouteCode());
            ps.setString(3, bean.getRouteName());
            ps.setString(4, bean.getStartLoc());
            ps.setString(5, bean.getEndLoc());
            ps.setDouble(6, bean.getDistanceKm());
            ps.setString(7, bean.getRemarks());

            int result = ps.executeUpdate();
            System.out.println("Insert Result: " + result);
            if (result > 0)
                status = bean.getRouteId();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public RouteBean fetchRecord(String routeCode, String routeName) {
        RouteBean bean = null;
        try {
            Connection con = DBUtil.getDBConnection();
            String query = "SELECT * FROM ROUTE_TB WHERE ROUTECODE=? AND ROUTENAME=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, routeCode);
            ps.setString(2, routeName);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                bean = new RouteBean();
                bean.setRouteId(rs.getString(1));
                bean.setRouteCode(rs.getString(2));
                bean.setRouteName(rs.getString(3));
                bean.setStartLoc(rs.getString(4));
                bean.setEndLoc(rs.getString(5));
                bean.setDistanceKm(rs.getDouble(6));
                bean.setRemarks(rs.getString(7));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    public boolean recordExists(String routeCode, String routeName) {
        return fetchRecord(routeCode, routeName) != null;
    }

    public String generateRouteID(String routeCode, String routeName) {
        String routeId = "";
        try {
            Connection con = DBUtil.getDBConnection();
            String seqQuery = "SELECT ROUTE_SEQ.NEXTVAL FROM DUAL";
            PreparedStatement ps = con.prepareStatement(seqQuery);
            ResultSet rs = ps.executeQuery();
            int seq = 0;
            if (rs.next())
                seq = rs.getInt(1);

            String date = new SimpleDateFormat("yyyyMMdd").format(new Date());

            routeId = date +
                    routeCode.substring(0, 2).toUpperCase() +
                    seq;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return routeId;
    }

    public List<RouteBean> fetchAllRecords() {
        List<RouteBean> list = new ArrayList<>();
        try {
            Connection con = DBUtil.getDBConnection();
            String query = "SELECT * FROM ROUTE_TB";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                RouteBean bean = new RouteBean();
                bean.setRouteId(rs.getString(1));
                bean.setRouteCode(rs.getString(2));
                bean.setRouteName(rs.getString(3));
                bean.setStartLoc(rs.getString(4));
                bean.setEndLoc(rs.getString(5));
                bean.setDistanceKm(rs.getDouble(6));
                bean.setRemarks(rs.getString(7));
                list.add(bean);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
