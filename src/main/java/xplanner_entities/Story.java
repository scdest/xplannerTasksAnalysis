package xplanner_entities;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class Story {
    private String storyId;
    private String name;
    private String responsible;
    private String customer;
    private String status;
    private double estTime;
    private double actTime;
    private boolean isFromPreviousIteration;

    public Story(String storyId, String name, String responsible, String customer, String status, double estTime, double actTime, boolean isFromPreviousIteration) {
        this.storyId = storyId;
        this.name = name;
        this.responsible = responsible;
        this.customer = customer;
        this.status = status;
        this.estTime = estTime;
        this.actTime = actTime;
        this.isFromPreviousIteration = isFromPreviousIteration;
    }

    public String getStoryId() {
        return storyId;
    }

    public void setStoryId(String storyId) {
        this.storyId = storyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public double getEstTime() {
        return estTime;
    }

    public void setEstTime(double estTime) {
        this.estTime = estTime;
    }

    public double getActTime() {
        return actTime;
    }

    public void setActTime(double actTime) {
        this.actTime = actTime;
    }

    public boolean isFromPreviousIteration() {
        return isFromPreviousIteration;
    }

    public void setFromPreviousIteration(boolean fromPreviousIteration) {
        isFromPreviousIteration = fromPreviousIteration;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Story{" +
                "storyId='" + storyId + '\'' +
                ", name='" + name + '\'' +
                ", responsible='" + responsible + '\'' +
                ", customer='" + customer + '\'' +
                ", status='" + status + '\'' +
                ", estTime=" + estTime +
                ", actTime=" + actTime +
                ", isFromPreviousIteration=" + isFromPreviousIteration +
                '}';
    }

    public static void storiesToCsv(List<Story> stories){
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new File("C:\\stories.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("storyId");
        sb.append(';');
        sb.append("name");
        sb.append(';');
        sb.append("responsible");
        sb.append(';');
        sb.append("customer");
        sb.append(';');
        sb.append("status");
        sb.append(';');
        sb.append("estTime");
        sb.append(';');
        sb.append("actTime");
        sb.append(';');
        sb.append("isFromPreviousIteration");
        sb.append('\n');
        for(Story story : stories){
            sb.append(story.getStoryId());
            sb.append(';');
            sb.append(story.getName());
            sb.append(';');
            sb.append(story.getResponsible());
            sb.append(';');
            sb.append(story.getCustomer());
            sb.append(';');
            sb.append(story.getStatus());
            sb.append(';');
            sb.append(String.valueOf(story.getEstTime()));
            sb.append(';');
            sb.append(String.valueOf(story.getActTime()));
            sb.append(';');
            sb.append(String.valueOf(story.isFromPreviousIteration()));
            sb.append('\n');
        }

        pw.write(sb.toString());
        pw.close();
        System.out.println("done!");
    }
}
