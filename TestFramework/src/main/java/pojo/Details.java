package pojo;

public class Details {
    String no;
    String name;
    String job;
    String id;
    public Details(){}

    public Details(String name, String job) {
        this.name = name;
        this.job = job;
    }
    public Details(String name, String job,String id) {
        this.name = name;
        this.job = job;
        this.id=id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Details{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
