package com.issuetracker.mvc.dao.issueDao;

import com.issuetracker.mvc.model.IssueModel;
import com.issuetracker.mvc.rowmapper.IssueRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
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
    public void insertData(IssueModel user) {
    String sql="Insert into issue_tracker (issuename,servicename,issuedate,customername,createdby)"+ "values(?,?,?,?,?)";
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf =new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(dt);
        String created_by="asif";
        jdbcTemplate.update(sql,new Object[]{user.getIssuename(),user.getServicename(),currentTime,user.getCustomername(),created_by});
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
}
