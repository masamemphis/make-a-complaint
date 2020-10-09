package models;


import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "reports")
@NamedQueries({
    @NamedQuery(
            name = "getAllReports",
            query = "SELECT r FROM Report AS r ORDER BY r.id DESC"
            ),
    @NamedQuery(
            name = "getReportsCount",
            query = "SELECT COUNT(r) FROM Report AS r"
            ),
})
@Entity
public class Report {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)//id リソース内での連番   数値型
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)//user_id    日報を登録した使用者の番号  文字列型
    private ContentTitle user;

    @Column(name = "report_date", nullable = false)//report_date    いつの日報かを示す日付 日付型
    private Date report_date;

    @Column(name = "title", length = 255, nullable = false)//title  日報のタイトル 文字列型
    private String title;

    @Lob
    @Column(name = "content", nullable = false)//content    日報の内容   テキスト型
    private String content;

    @Column(name = "created_at", nullable = false)//created_at  登録日時    日時型
    private Timestamp created_at;

    @Column(name = "updated_at", nullable = false)//updated_at  更新日時    日時型
    private Timestamp updated_at;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ContentTitle getContentTitle() {
        return user;
    }

    public void setContentTitle(ContentTitle user) {
        this.user = user;
    }

    public Date getReport_date() {
        return report_date;
    }

    public void setReport_date(Date report_date) {
        this.report_date = report_date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
