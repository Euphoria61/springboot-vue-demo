package com.feng.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.feng.common.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

/**
 * @author: ❤ Euphoria ❤
 * @title: FileController
 * @projectName vue
 * @description: 文件上传 及下载
 * @date 2021/11/28  14:06
 */
@RestController
@RequestMapping("/files")
public class FileController {
    @Value("${server.port}")
    private String port;
    private static  final String ip = "http://localhost";
//    上传接口
    @PostMapping("/upload")
    public Result<?> upload(MultipartFile file) throws IOException {
        //获取原文件名称
        String originalFilename = file.getOriginalFilename();
//        防止相同文件名覆盖问题
        //定义文件唯一标识（前缀）
        String flag = IdUtil.fastSimpleUUID();
        //获取上传路径
        String rootFilePath = System.getProperty("user.dir") + "/springboot-vue3-demo/src/main/resources/files/" + flag + "_" + originalFilename;
        //把文件写入上传的路径
        FileUtil.writeBytes(file.getBytes(), rootFilePath);
        return Result.success(ip + ":" + port +"/files/" + flag);
    }
    /**
     * 下载接口
     */
    @GetMapping("/{flag}")
    public void getFiles(@PathVariable String flag, HttpServletResponse response) {
        OutputStream os;  // 新建一个输出流对象
        String basePath = System.getProperty("user.dir") + "/springboot-vue3-demo/src/main/resources/files/";  // 定于文件上传的根路径
        List<String> fileNames = FileUtil.listFileNames(basePath);  // 获取所有的文件名称
        String fileName = fileNames.stream().filter(name -> name.contains(flag)).findAny().orElse("");  // 找到跟参数一致的文件
        try {
            if (StrUtil.isNotEmpty(fileName)) {
                response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
                response.setContentType("application/octet-stream");
                byte[] bytes = FileUtil.readBytes(basePath + fileName);  // 通过文件的路径读取文件字节流
                os = response.getOutputStream();   // 通过输出流返回文件
                os.write(bytes);
                os.flush();
                os.close();
            }
        } catch (Exception e) {
            System.out.println("文件下载失败");
        }
    }

}
