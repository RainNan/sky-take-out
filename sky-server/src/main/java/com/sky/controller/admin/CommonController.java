package com.sky.controller.admin;

import com.sky.result.Result;
import com.sky.utils.AliOssUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/admin/common")
@Api(tags = "通用接口")
public class CommonController {
    @Autowired
    AliOssUtil aliOssUtil;

    // file 的名字与前端提交的文件保持一致

    /**
     * 文件上传
     *
     * @param file
     * @return
     */
    @ApiOperation("文件上传")
    @PostMapping("/upload")
    public Result<String> upload(MultipartFile file) throws IOException {
        log.info("文件上传");

        String originalFileName = file.getOriginalFilename();
        // 截取文件后缀名
        String extension = originalFileName.substring(originalFileName.lastIndexOf('.'));
        // 构造新文件名称
        String objectName = UUID.randomUUID().toString() + extension;
        // 文件请求路径
        String filePath = aliOssUtil.upload(file.getBytes(), objectName);

        return Result.success(filePath);
    }
}
