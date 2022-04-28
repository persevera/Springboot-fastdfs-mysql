package com.springbootfastdfsmysql.mysql.Dao;

import com.springbootfastdfsmysql.mysql.myclass.fileinfo;

import java.util.List;


public interface fileinfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(fileinfo record);

    int insertSelective(fileinfo record);

    fileinfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(fileinfo record);

    int updateByPrimaryKey(fileinfo record);
    List<fileinfo> selectall();
    String selectbynewname(String newname);
    int deletefile(Integer id);
}