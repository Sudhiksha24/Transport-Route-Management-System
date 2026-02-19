package com.wipro.route.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.wipro.route.bean.RouteBean;
import com.wipro.route.service.Administrator;

public class MainServlet extends HttpServlet {

    Administrator admin = new Administrator();

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
                          throws ServletException, IOException {

        String operation = request.getParameter("operation");

        if (operation.equals("newRecord")) {

            String status = addRecord(request);

            if (status.equals("FAIL") ||
                status.equals("INVALID INPUT")) {

                response.sendRedirect("error.html");
            } else {
                response.sendRedirect("success.html");
            }

        } else if (operation.equals("viewRecord")) {

            RouteBean bean = viewRecord(request);

            if (bean == null) {
                request.setAttribute("message",
                    "No matching records exists! Please try again!");
            } else {
                request.setAttribute("bean", bean);
            }

            RequestDispatcher rd =
                request.getRequestDispatcher("displayRoute.jsp");
            rd.forward(request, response);

        } else if (operation.equals("viewAllRecords")) {

            List<RouteBean> list = admin.viewAllRecords();

            if (list.isEmpty()) {
                request.setAttribute("message",
                    "No records available!");
            } else {
                request.setAttribute("list", list);
            }

            RequestDispatcher rd =
                request.getRequestDispatcher("displayAllRoutes.jsp");
            rd.forward(request, response);
        }
    }

    public String addRecord(HttpServletRequest request) {

        RouteBean bean = new RouteBean();
        bean.setRouteCode(request.getParameter("routeCode"));
        bean.setRouteName(request.getParameter("routeName"));
        bean.setStartLoc(request.getParameter("startLoc"));
        bean.setEndLoc(request.getParameter("endLoc"));
        bean.setDistanceKm(
            Double.parseDouble(request.getParameter("distanceKm")));
        bean.setRemarks(request.getParameter("remarks"));

        return admin.addRecord(bean);
    }

    public RouteBean viewRecord(HttpServletRequest request) {

        String routeCode = request.getParameter("routeCode");
        String routeName = request.getParameter("routeName");

        return admin.viewRecord(routeCode, routeName);
    }
}
