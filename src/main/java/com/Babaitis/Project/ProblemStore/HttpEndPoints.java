package com.Babaitis.Project.ProblemStore;

public class HttpEndPoints {
    public static final String PROBLEMS = "/problems";
    public static final String PROBLEMS_CREATE = PROBLEMS + "/create";
    public static final String PROBLEMS_UPDATE= PROBLEMS + "/{problemUuid}/update";
    public static final String PROBLEMS_DELETE= PROBLEMS + "/{problemUuid}/delete";

}
