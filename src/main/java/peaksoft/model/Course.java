package peaksoft.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="courses")
@Getter
@Setter
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseName;
    private int duration;
    private LocalDate craeteAt;
    private String imageLink;
    private String description;
    @OneToMany(mappedBy = "course",cascade = {
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH,
            CascadeType.DETACH
    })
    private List<Lesson> lessons;
    @ManyToMany(cascade = {CascadeType.MERGE,
        CascadeType.PERSIST,
        CascadeType.REFRESH,
        CascadeType.DETACH}
    )
    private List<Instructor>instructors;

    public Course(String courseName, int duration, LocalDate craeteAt, String imageLink, String description, List<Lesson> lessons, List<Instructor> instructors) {
        this.courseName = courseName;
        this.duration = duration;
        this.craeteAt = craeteAt;
        this.imageLink = imageLink;
        this.description = description;
        this.lessons = lessons;
        this.instructors = instructors;
    }

    public Course(String courseName, int duration, LocalDate craeteAt, String imageLink, String description) {
        this.courseName = courseName;
        this.duration = duration;
        this.craeteAt = craeteAt;
        this.imageLink = imageLink;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", duration=" + duration +
                ", craeteAt=" + craeteAt +
                ", imageLink='" + imageLink + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
