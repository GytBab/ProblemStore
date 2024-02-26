package com.Babaitis.Project.ProblemStore;

public class HttpEndPoints {

    // Problem details
    public static final String PROBLEMS = "/problems";
    public static final String PROBLEMS_CREATE = PROBLEMS + "/create";
    public static final String PROBLEMS_UPDATE= PROBLEMS + "/{problemUuid}/update";
    public static final String PROBLEMS_DELETE= PROBLEMS + "/{problemUuid}/delete";

    // Employee details
    public static final String EMPLOYEE = "/employee";
    public static final String EMPLOYEE_CREATE = EMPLOYEE + "/create";
    public static final String EMPLOYEES_UPDATE= EMPLOYEE + "/{employeeUuid}/update";

    // Employee details
    public static final String LASERS = "/lasers";
    public static final String LASERS_CREATE = LASERS + "/create";
    public static final String LASERS_UPDATE = LASERS + "/{laserUuid}/update";
    public static final String LASERS_DELETE = LASERS + "/{laserUuid}/delete";

}
