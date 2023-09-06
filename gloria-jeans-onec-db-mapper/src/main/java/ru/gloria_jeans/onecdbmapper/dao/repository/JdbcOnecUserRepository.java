package ru.gloria_jeans.onecdbmapper.dao.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;
import ru.gloria_jeans.onecdbmapper.dao.model.OnecUser;

@Repository
public class JdbcOnecUserRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcOnecUserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public OnecUser getOnecUser() throws Exception {
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet("SELECT TOP (1) USRSCNT,NETCHGCN FROM _1SUSERS");
        sqlRowSet.next();
        OnecUser onecUser  = new OnecUser();
        onecUser.setUsrscnt(sqlRowSet.getInt("USRSCNT"));
        onecUser.setNetchgcn(sqlRowSet.getInt("NETCHGCN"));
        return onecUser;
    }

    public void updateOnecUser(OnecUser onecUser) {
        jdbcTemplate.update(
                "UPDATE _1SUSERS SET USRSCNT=?,NETCHGCN=?",
                onecUser.getUsrscnt(),
                onecUser.getNetchgcn()
        );
    }
}
