package au.com.aupost.suburbmanager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "suburbs")
public class Suburb {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;
    
    @ManyToOne
    @JoinColumn(name="post_code_id", nullable = false)
    private PostCode postCode;

    public Suburb() {
        super();
    }
     
    public Suburb(String name, PostCode postCode) {
        super();
        this.name = name;
        this.postCode = postCode;
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

}