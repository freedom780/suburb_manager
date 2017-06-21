package au.com.aupost.suburbmanager.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "post_codes")
public class PostCode {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @NotNull
    @Column(name = "code")
    private Integer code;
    
    @OneToMany(mappedBy="postCode")
    private List<Suburb> suburbs;
    

    public PostCode() {
        super();
    }

    public PostCode(Integer code) {
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

    public void setCode(Integer code) {
        this.code = code;
    }

    public List<Suburb> getSuburbs() {
        return suburbs;
    }

    @Override
    public String toString() {
        return "PostCode [id=" + id + ", code=" + code + "]";
    }
 
    
}