package cn.agree.controller;

import cn.agree.domain.Address;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(path = "/address")
public class AddressController {

    /*
    *  把ajax传过来的 data json类型的数据
    *  直接打印出来
    *
    *  add 和 add1 return 不会跳转到success页面
    *  因为使用的是ajax发送的
    *
    *
    * */
    @RequestMapping(value = "/add")
    public String add(@RequestBody String body) {
        System.out.println(body);
        return "success";
    }

    /*
    *  使用@RequestBody接收整个提交内容体
    *  并转换成Address对象
    *
    *
    * */
    @RequestMapping(value = "/add1")
    public String add1(@RequestBody Address address) {
        System.out.println(address);
        return "success";
    }

    /*
    *  使用@RequestBody接收整个提交的内容
    *  并转换成Address对象
    *  在方法上加上@Response注解 每次响应数据为JSON数据
    *
    * */
    @ResponseBody
    @RequestMapping(value = "/add2")
    public Address add2(@RequestBody Address address) {
        System.out.println(address);
        return address;
    }


    /*
    *  原始的方式实现文件上传
    *
    * */
    @RequestMapping(value = "/fileUpload")
    public String fileUpload(HttpServletRequest request) throws Exception {
        // 先获取到要上传的文件目录
        String path = request.getSession().getServletContext().getRealPath("/uploads");
        System.out.println(path);
        // 创建File对象, 一会向该路径下传文件
        File file = new File(path);
        // 判断路径是否存在, 如果不存在 创建该路径
        if (!file.exists()) {
            file.mkdir();
        }

        // 创建磁盘文件项工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload fileUpload = new ServletFileUpload(factory);
        // 解析request对象
        List<FileItem> list = fileUpload.parseRequest(request);
        // 遍历
        for (FileItem fileItem : list) {
            // 判断文件项是普通字段 还是上传的文件
            if (fileItem.isFormField()) {
                System.out.println(fileItem);
            } else {
                // 上传文件项
                // 获取到上传文件的名称
                String filename = fileItem.getName();
                System.out.println(filename);
                // 上传文件
                fileItem.write(new File(file, filename));
                // 删除临时文件
                fileItem.delete();
            }
        }


        return "success";

    }


    /*
    *  SpringMVC的方式进行
    *  文件上传
    *
    * */
    @RequestMapping(value = "/fileUpload1")
    public String fileUpload1(HttpServletRequest request, MultipartFile upload) throws IOException {
        System.out.println("SpringMVC方式的文件上传");
        // 先获取到要上传的文件目录
        String path = request.getSession().getServletContext().getRealPath("/uploads1");
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        // 获取到上传文件的名称
        String filename = upload.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-", "").toUpperCase();
        //把文件的名称唯一化
        filename = uuid+"_"+filename;
        // 上传
        upload.transferTo(new File(file, filename));

        return "success";


    }







}
