package com.example.JDBCdemo;

import com.example.JDBCdemo.model.Alien;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Repository
public class AlienRepo {

    private final JdbcTemplate template;

    @Autowired
    public AlienRepo(JdbcTemplate template) {
        this.template = template;
    }

    public void save(Alien alien) {
        String sql = "INSERT INTO alien (id, name, tech) VALUES (?, ?, ?)";
        template.update(sql, alien.getId(), alien.getName(), alien.getTech());
        System.out.println("Added: " + alien);
    }

    public List<Alien> findAll() {
        String sql = "SELECT * FROM alien";
        return template.query(sql, (rs, rowNum) -> {
            Alien alien = new Alien();
            alien.setId(rs.getInt("id"));
            alien.setName(rs.getString("name"));
            alien.setTech(rs.getString("tech"));
            return alien;
        });
    }
}
