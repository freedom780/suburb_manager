package au.com.aupost.suburbmanager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "suburbs")
public class Suburb {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @NotNull
    @Column(name = "name")
    private String name;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name="post_code_id", nullable = false)
    private PostCode postCode;

    @Enumerated(EnumType.STRING)
    @Column(name = "state_territory")
    private State state;
    
    public Suburb() {
        super();
    }
     
    public Suburb(String name, PostCode postCode, State state) {
        super();
        this.name = name;
        this.postCode = postCode;
        this.state = state;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PostCode getPostCode() {
        return postCode;
    }

    public void setPostCode(PostCode postCode) {
        this.postCode = postCode;
    }
    
    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Suburb [id=" + id + ", name=" + name + ", postCode=" + postCode + "]";
    }
    
}