/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: FooDao
 * Author:   YuSong
 * Date:     2019/4/6 16:44
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package geektime.spring.data.simplejdbcdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Raven
 * @create 2019/4/6
 * @since 1.0.0
 */
@Slf4j
@Repository
public class FooDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private SimpleJdbcInsert simpleJdbcInsert;

    public void insertData(){
        Arrays.asList("b","c").forEach(bar ->{
            jdbcTemplate.update("insert into FOO (BAR) VALUES  (?)",bar);
        });

        HashMap<String,String> row = new HashMap<>(16);
        row.put("BAR","d");
        Number id = simpleJdbcInsert.executeAndReturnKey(row);
        log.info("ID of d: {}",id.longValue());
    }

    public void listData(){
         log.info("Count: {}",
                 jdbcTemplate.queryForObject("SELECT COUNT(*) FROM FOO",Long.class));

        List<String> list = jdbcTemplate.queryForList("SELECT BAR FROM FOO",String.class);
        list.forEach(s ->log.info("Bar: {}",s));

        List<Foo> fooList = jdbcTemplate.query("SELECT * FROM FOO",new RowMapper<Foo>(){
            @Override
            public Foo mapRow(ResultSet resultSet, int i) throws SQLException {
                return Foo.builder()
                        .id(resultSet.getLong(1))
                        .bar(resultSet.getString(2))
                        .build();
            }
        });

         fooList.forEach(f -> log.info("Foo: {}",f));

    }
}