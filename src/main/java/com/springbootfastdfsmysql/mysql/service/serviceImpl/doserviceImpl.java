package com.springbootfastdfsmysql.mysql.service.serviceImpl;

import com.springbootfastdfsmysql.mysql.Dao.fileinfoMapper;
import com.springbootfastdfsmysql.mysql.myclass.fileinfo;
import com.springbootfastdfsmysql.mysql.service.doservice;
import com.springbootfastdfsmysql.util.fastdfsutil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class doserviceImpl implements doservice {
    fastdfsutil  til=new fastdfsutil();
    @Resource
    private fileinfoMapper fileok;

    public void setFileok(fileinfoMapper fileok) {
        this.fileok = fileok;
    }

    @Override
    public int insertfile(fileinfo file) {
      return  fileok.insert(file);
    }

    @Override
    public List<fileinfo> selectall() {
        return fileok.selectall();
    }

    @Override
    public int delete(Integer id) {
        fileinfo fileinfo = fileok.selectByPrimaryKey(id);
         til.delete("group1",fileinfo.getFilepath());
        int i = fileok.deleteByPrimaryKey(id);
        return  i;
    }
  @Override
    public   fileinfo selectfilepathbyid(Integer id){
      return  fileok.selectByPrimaryKey(id);
 }
}
