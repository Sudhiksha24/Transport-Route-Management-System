package com.wipro.route.bean;

public class RouteBean {

    private String routeId;
    private String routeCode;
    private String routeName;
    private String startLoc;
    private String endLoc;
    private double distanceKm;
    private String remarks;

    public String getRouteId() { return routeId; }
    public void setRouteId(String routeId) { this.routeId = routeId; }

    public String getRouteCode() { return routeCode; }
    public void setRouteCode(String routeCode) { this.routeCode = routeCode; }

    public String getRouteName() { return routeName; }
    public void setRouteName(String routeName) { this.routeName = routeName; }

    public String getStartLoc() { return startLoc; }
    public void setStartLoc(String startLoc) { this.startLoc = startLoc; }

    public String getEndLoc() { return endLoc; }
    public void setEndLoc(String endLoc) { this.endLoc = endLoc; }

    public double getDistanceKm() { return distanceKm; }
    public void setDistanceKm(double distanceKm) { this.distanceKm = distanceKm; }

    public String getRemarks() { return remarks; }
    public void setRemarks(String remarks) { this.remarks = remarks; }
}
