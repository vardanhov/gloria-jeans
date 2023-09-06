package ru.gloria_jeans.onecdbmapper.dao.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;
import ru.gloria_jeans.onecdbmapper.dao.model.OnecSystem;

import java.text.SimpleDateFormat;

@Repository
public class JdbcOnecSystemRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcOnecSystemRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public OnecSystem getFirstOnecSystem() throws Exception {
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet("SELECT TOP (1) CURDATE,CURTIME,EVENTIDTA,DBSIGN,DBSETUUID,SNAPSHPER,ACCDATE,FLAGS FROM _1SSYSTEM");
        sqlRowSet.next();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        OnecSystem onecSystem = new OnecSystem();
        onecSystem.setCurdate(simpleDateFormat.parse(sqlRowSet.getString("CURDATE")));
        onecSystem.setCurtime(sqlRowSet.getInt("CURTIME"));
        onecSystem.setEventidta(sqlRowSet.getString("EVENTIDTA"));
        onecSystem.setDbsign(sqlRowSet.getString("DBSIGN"));
        onecSystem.setDbsetuuid(sqlRowSet.getString("DBSETUUID"));
        onecSystem.setSnapshper(sqlRowSet.getString("SNAPSHPER"));
        onecSystem.setAccdate(simpleDateFormat.parse(sqlRowSet.getString("ACCDATE")));
        onecSystem.setFlags(sqlRowSet.getInt("FLAGS"));
        return onecSystem;
    }

    public void updateOnecSystem(OnecSystem onecSystem) {
        jdbcTemplate.update(
                "UPDATE _1SSYSTEM SET CURDATE=?,CURTIME=?,EVENTIDTA=?,DBSIGN=?,DBSETUUID=?,SNAPSHPER=?,ACCDATE=?,FLAGS=?",
                onecSystem.getCurdate(),
                onecSystem.getCurtime(),
                onecSystem.getEventidta(),
                onecSystem.getDbsign(),
                onecSystem.getDbsetuuid(),
                onecSystem.getSnapshper(),
                onecSystem.getAccdate(),
                onecSystem.getFlags()
        );
    }
}
