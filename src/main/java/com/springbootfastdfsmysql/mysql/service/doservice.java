package com.springbootfastdfsmysql.mysql.service;

import com.springbootfastdfsmysql.mysql.myclass.fileinfo;

import java.util.List;

public interface doservice {
    int insertfile(fileinfo file);
     List<fileinfo> selectall();
    int  delete(Integer id);
    public  fileinfo  selectfilepathbyid(Integer id);
}
