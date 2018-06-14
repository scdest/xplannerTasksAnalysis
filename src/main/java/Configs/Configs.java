package Configs;

import java.io.*;

public class Configs {
    private static Configs ourInstance = new Configs();
    private String login = "";
    private String password = "";
    private String urlToXplanner = "https://app.ardas.ua/xplanner/";
    private String pathToDriver = "C:\\chromedriver.exe";
    private String projectId = "8780344";
    private String projectName = "TEG Owls' Microservices";
    private String iterationId = "10061529";
    private String iterationName = "TEG Owls' Microservices: 2018-05";

    public static Configs getInstance() {
        return ourInstance;
    }

    public String getProjectId() {
        return projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getPathToDriver() {
        return pathToDriver;
    }
    public String getLogin() {
        if(login.equals("")){
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader("C:\\xplanner.txt"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                this.login = reader.readLine().split(";")[0];
            } catch (IOException e) {
                System.out.println("Something went wrong");;
            }
        }
        return login;
    }

    public String getPassword() {
        if(password.equals("")){
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader("C:\\xplanner.txt"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                this.password = reader.readLine().split(";")[1];
            } catch (IOException e) {
                System.out.println("Something went wrong");;
            }
        }
        return password;
    }

    public String getUrlToXplanner() {
        return urlToXplanner;
    }

    public String getIterationId() {
        return iterationId;
    }

    public String getIterationName() {
        return iterationName;
    }

    private Configs() {
    }
}
