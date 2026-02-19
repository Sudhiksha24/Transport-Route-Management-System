package com.wipro.route.service;

import java.util.List;

import com.wipro.route.bean.RouteBean;
import com.wipro.route.dao.RouteDAO;
import com.wipro.route.util.InvalidInputException;

public class Administrator {

    RouteDAO dao = new RouteDAO();

    public String addRecord(RouteBean bean) {

        try {
            if (bean == null || bean.getRouteCode() == null ||
                bean.getRouteName() == null ||
                bean.getStartLoc() == null ||
                bean.getEndLoc() == null)
                throw new InvalidInputException();

            if (bean.getRouteCode().length() < 2)
                return "INVALID ROUTE CODE";

            if (bean.getRouteName().length() < 2)
                return "INVALID ROUTE NAME";

            if (bean.getStartLoc().length() < 2 ||
                bean.getEndLoc().length() < 2)
                return "INVALID LOCATION";

            if (dao.recordExists(bean.getRouteCode(), bean.getRouteName()))
                return "ALREADY EXISTS";

            String id = dao.generateRouteID(
                    bean.getRouteCode(),
                    bean.getRouteName());

            bean.setRouteId(id);

            return dao.createRecord(bean);

        } catch (InvalidInputException e) {
            return "INVALID INPUT";
        }
    }

    public RouteBean viewRecord(String routeCode, String routeName) {
        return dao.fetchRecord(routeCode, routeName);
    }

    public List<RouteBean> viewAllRecords() {
        return dao.fetchAllRecords();
    }
}
