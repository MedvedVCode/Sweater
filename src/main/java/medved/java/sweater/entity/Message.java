package medved.java.sweater.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String tag;
    private String text;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;
    public Message(String tag, String text, User user) {
        this.author = user;
        this.tag = tag;
        this.text = text;
    }

    public String getAuthorName(){
        return author != null ? author.getUsername() : "<none>";
    }
}
