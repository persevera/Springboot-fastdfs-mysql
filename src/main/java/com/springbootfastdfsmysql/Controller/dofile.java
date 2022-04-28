package com.springbootfastdfsmysql.Controller;

import com.springbootfastdfsmysql.mysql.myclass.fileinfo;
import com.springbootfastdfsmysql.mysql.service.serviceImpl.doserviceImpl;
import com.springbootfastdfsmysql.util.fastdfsutil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.IOException;

@Controller
public class dofile {
    @Resource
      private doserviceImpl  doservice;

    //引入操作file类的工具类
    fastdfsutil util=new fastdfsutil();


    //上传文件
    @RequestMapping("doupload")
    @ResponseBody
    public  String  doupload(MultipartFile myfile,String newname) throws IOException {
        fileinfo file=new fileinfo();
        //获取获取上传文件的字节数组
        byte[] buffFile = myfile.getBytes();
        //获取上传文件的文件名
        String filename = myfile.getOriginalFilename();
    /*
    获取上传文件的文件后缀名(截取.后面的字符串)
    可能存在问题,因为有些文件是没有后缀名的，必要时需要进行逻辑判断
     */
        String fileExtName=filename.substring(filename.lastIndexOf(".")+1);
        //调用web操作FastDFS工具类中的上传的方法,返回文件上传后的组名和远程文件路径
        String[] result = util.upload(buffFile, fileExtName);
        //上传成功后，可以一些文件的信息展示出来
       file.setFilesize((int)myfile.getSize());//文件大小
        file.setOldname(filename);//文件的原名称
        file.setNewname(newname);
        file.setFilepath(result[1]);//文件的远程访问路径,可以在前端界面中，通过这个值是否为空判断是否允许上传
        doservice.insertfile(file);
       return  "上传成功";
    }


    //删除文件
    @RequestMapping(value = "dodelete",method = RequestMethod.POST)
    @ResponseBody
    public  String dodelete(Integer id){
        int selectbynewname = doservice.delete(id);
        if(selectbynewname==1){
           return  "删除成功";
        }else{
           return  "删除失败";
        }
    }

    //下载文件
    @RequestMapping(value = "download",method = RequestMethod.POST)
    public ModelAndView download(Integer id){
        ModelAndView mo=new ModelAndView();
        String group="group1/";
        String myfilepath="http://43.138.55.22/"+group+doservice.selectfilepathbyid(id).getFilepath();
        mo.setViewName("redirect:"+myfilepath);
        return  mo;
    }
}
