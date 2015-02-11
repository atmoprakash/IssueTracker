package com.issuetracker.mvc.dao.issueDao;

import com.issuetracker.mvc.model.AssignEvent;
import com.issuetracker.mvc.model.EventStatus;
import com.issuetracker.mvc.model.IssueModel;
import com.issuetracker.mvc.rowmapper.IssueRowMapper;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by acer on 1/25/2015.
 */
@Repository
public class IssueDaoImpl implements IssueDao {

//    @Autowired
//    DataSource dataSource;

    private DataSource dataSource;
    public void setDataSource(DataSource dataSource){
        this.dataSource=dataSource;
    }
    @Override
    public int insertData(final IssueModel user) {
        KeyHolder keyHolder=new GeneratedKeyHolder();
        final String sql="Insert into issue_tracker (issuename,servicename,issuedate,customername,createdby,status)"+ "values(?,?,?,?,?,?)";
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf =new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        final String currentTime = sdf.format(dt);
        final String created_by="rewat";
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, user.getIssuename());
                ps.setString(2, user.getServicename());
                ps.setString(3, currentTime);
                ps.setString(4, user.getCustomername());
                ps.setString(5, created_by);
                ps.setString(6, EventStatus.NEWISSUE.toString());
                return ps;
            }
        },keyHolder);
        return keyHolder.getKey().intValue();
        // jdbcTemplate.update(sql,new Object[]{user.getIssuename(),user.getServicename(),currentTime,user.getCustomername(),created_by, EventStatus.NEWISSUE.toString()});
    }

    @Override
    public void updateData(IssueModel user) {
        String sql="update issue_tracker set issuename=?,servicename=?,issuedate=?,customername=?,createdby=? where issue_tracker_id=?";
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf =new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String updateTime = sdf.format(dt);
        jdbcTemplate.update(sql,new Object[]{user.getIssuename(),user.getServicename(),updateTime,user.getCustomername(),user.getCreatedby(),user.issue_tracker_id});
    }

    @Override
    public void deleteData(Integer id) {
        String sql = "delete from issue_tracker where issue_tracker_id=" + id;
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql);
    }

    @Override
    public IssueModel getUser(Integer id) {
        List<IssueModel> userList=new ArrayList<IssueModel>();
        String sql="select * from issue_tracker where issue_tracker_id=" +id;
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
        userList=jdbcTemplate.query(sql,new IssueRowMapper());
        return userList.get(0);
    }

    @Override
    public List<IssueModel> getUserList() {
        List userList=new ArrayList();
        String sql="select * from issue_tracker ORDER BY issue_tracker_id DESC ";
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
        userList=jdbcTemplate.query(sql,new IssueRowMapper());
        return userList;
    }

    @Override
    public void updateStatus(Integer id) {
        String sql="update issue_tracker set status='"+EventStatus.PENDING.toString()+"' where issue_tracker_id="+id;
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql);
    }

    @Override
    public void updateEventStatusSolved(Integer id) {
        String sql="update issue_tracker set status='"+EventStatus.SOLVED.toString()+"' where issue_tracker_id="+id;
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql);
    }

    @Override
    public int insertRecord(final int tracker_id) {
        KeyHolder keyHolder=new GeneratedKeyHolder();
        final java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf =new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        final String currentTime = sdf.format(dt);
        final Integer solve=0;
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
        final String sql="insert into issue_event(issue_tracker_id,assigned_date,solve)values(?,?,?)";
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1,tracker_id);
                ps.setString(2, currentTime);
                ps.setInt(3,solve);

                return ps;
            }
        },keyHolder);
        return keyHolder.getKey().intValue();
        // jdbcTemplate.update(sql,new Object[]{tracker_id,currentTime,solve});

    }


}