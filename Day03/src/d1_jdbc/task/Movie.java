package d1_jdbc.task;

/**
 * @ Classname Movie
 * @ Description TODO
 * @ Date 2022/5/13 18:46
 * @ Created by 落尘
 */
public class Movie {
    private int id;
    private String name;
    private String link;
    private double score;
    private int rate;
    private String su;

    public Movie() {
    }

    public Movie(int id, String name, String link, double score, int rate, String su) {
        this.id = id;
        this.name = name;
        this.link = link;
        this.score = score;
        this.rate = rate;
        this.su = su;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getSu() {
        return su;
    }

    public void setSu(String su) {
        this.su = su;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", link='" + link + '\'' +
                ", score=" + score +
                ", rate=" + rate +
                ", su='" + su + '\'' +
                '}';
    }
}
