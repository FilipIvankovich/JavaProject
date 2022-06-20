package hr.tvz.ivankovic.hardwareapp.review;

public class ReviewDTO {
    private final String title;
    private final String text;
    private final Integer rating;

    public ReviewDTO(String title, String text, Integer rating) {
        this.title = title;
        this.text = text;
        this.rating = rating;
    }


    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public Integer getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "ReviewDTO{" +
                ", title='" + title + '\'' +
                ", content='" + text + '\'' +
                ", rating=" + rating +
                '}';
    }

}
