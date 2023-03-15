package com.example.demo.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.example.demo.entity.Files;
import com.example.demo.mapper.FileMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

/**
 * 文件上传相关接口
 */
@RestController
@CrossOrigin
@RequestMapping("/file")
public class FileController {
    //上传
    @Value("${files.upload.path}")
    private String fileUploadPath;

    @Resource
    private FileMapper fileMapper;
    /**
     * 文件上传接口
     * @param file 前端传递过来的文件
     * @return
     * @throws IOException
     */
    @PostMapping("/upload")
    public String upload(@RequestParam MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        String type = FileUtil.extName(originalFilename);
        //获取类型
        //String type=file.getContentType();
        long size = file.getSize();
        //先存储到磁盘
        File uploadParentFile = new File(fileUploadPath);
        //判断配置文件的目录是否存在，若不存在则创建一个新的文件目录
        if(!uploadParentFile.exists()){
            uploadParentFile.mkdirs();
        }
        //定义文件唯一标示码
        String uuid = IdUtil.fastSimpleUUID();
        String fileUUID=uuid+ StrUtil.DOT + type;
        File uploadFile = new File(fileUploadPath+fileUUID);


        file.transferTo(uploadFile);
       // System.out.println("ip地址： " +getIp().toArray()[2]);
        String url="http://"+getIp().toArray()[2]+":8001/file/" + fileUUID;
        //存储数据库
        Files saveFile = new Files();
        saveFile.setName(originalFilename);
        saveFile.setType(type);
        saveFile.setSize(size);
        saveFile.setUrl(url);
        fileMapper.insert(saveFile);
        return url;
    }

    /**
     * 文件下载接口 "http://localhost:8001/file/{fileUUID};
     * @param fileUUID
     * @param response
     * @throws IOException
     */
    //下载接口
    @GetMapping("/{fileUUID}")
    public void download(@PathVariable String fileUUID, HttpServletResponse response) throws IOException {
        //根据文件的唯一标识码获取文件
        File uploadFile = new File(fileUploadPath + fileUUID);
        //设置输出流的格式
        ServletOutputStream os = response.getOutputStream();
        response.addHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(fileUUID,"UTF-8"));
        response.setContentType("application/octet-stream");
        //读取文件字节流
        os.write(FileUtil.readBytes(uploadFile));
        os.flush();
        os.close();




    }
    public  Set<String> getIp(){ //获取ip地址
        Set<String> set = new HashSet<String>();
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress() && !inetAddress.isLinkLocalAddress() && inetAddress.isSiteLocalAddress()) {
                        set.add(inetAddress.getHostAddress().toString());
                    }
                }
            }
        } catch (SocketException ex) {
        }
        return set;
    }

}
