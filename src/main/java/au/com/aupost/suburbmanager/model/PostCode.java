package au.com.aupost.suburbmanager.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "post_codes")
public class PostCode {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "code")
    private int code;
    
    @OneToMany(mappedBy="postCode")
    private List<Suburb> suburbs;
    

    public PostCode() {
        super();
    }

    public PostCode(int code) {
        super();
        this.code = code;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Suburb> getSuburbs() {
        return suburbs;
    }
    
}