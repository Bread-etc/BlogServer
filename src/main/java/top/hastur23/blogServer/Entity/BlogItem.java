package top.hastur23.blogServer.Entity;

// 对应数据库blogitem表
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.*;

@Entity
@Table(name = "blogitem")
public class BlogItem {
    @Id
    @GeneratedValue(stratey = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

}
