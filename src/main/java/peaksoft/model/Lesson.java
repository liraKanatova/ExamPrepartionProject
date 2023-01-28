package peaksoft.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import peaksoft.config.HibernateConfig;

import java.util.List;

@Entity
@Table(name="lessons")
@Getter
@Setter

@NoArgsConstructor

public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String videoLink;
    @ManyToOne(cascade = {CascadeType.MERGE,
    CascadeType.PERSIST,
    CascadeType.REFRESH,
    CascadeType.DETACH})

    private  Course course;
    @OneToMany(cascade = {CascadeType.MERGE,
    CascadeType.PERSIST,
    CascadeType.REFRESH,
    CascadeType.DETACH})
    private List<Task> tasks;

    public Lesson(String name, String videoLink, Course course, List<Task> tasks) {
        this.name = name;
        this.videoLink = videoLink;
        this.course = course;
        this.tasks = tasks;
    }

    public Lesson(String name, String videoLink) {
        this.name = name;
        this.videoLink = videoLink;

    }


    private Course convertCourse(Long id){
        EntityManager entityManager = HibernateConfig.getEntityManager();
        try{
            entityManager.getTransaction().begin();
            Course course = entityManager.find(Course.class, id);
           entityManager.getTransaction().commit();
            return course;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }




    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", videoLink='" + videoLink + '\'' +
                '}';
    }
}
