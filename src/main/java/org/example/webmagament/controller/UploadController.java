package org.example.webmagament.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.webmagament.POJO.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Slf4j
@RestController
public class UploadController {

    @PostMapping("/upload")
    public Result upload(String username,Integer age,MultipartFile image) throws IOException {
        log.info("文件上传:{}.{}.{}",username,age,image);

        //获取原始文件名
        String originalFilename = image.getOriginalFilename();

        //将文件存储在服务器的磁盘目录中
        image.transferTo(new File("C:\\Users\\Lenovo\\Pictures\\Screenshots\\"+originalFilename));

        return Result.success();
    }
}
