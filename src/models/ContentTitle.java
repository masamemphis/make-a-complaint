package models;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "contenttitle")
@Entity
public class ContentTitle {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)//id リソース内での連番   数値型
    private Integer id;
    @Column(name = "password", length = 64, nullable = false)//password システムへのログインパスワード 文字列型
    private String password;
    @Column(name = "created_at", nullable = false)//created_at  登録日時    日時型
    private Timestamp created_at;
    @Column(name = "updated_at", nullable = false)//
    private Timestamp updated_at;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

}
