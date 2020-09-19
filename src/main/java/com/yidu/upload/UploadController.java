package com.yidu.upload;

import com.yidu.businessData.service.TransactionDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author Tmac
 * @version 1.0
 * @time 2020/9/17  21:49
 **/

@RestController
@RequestMapping("/api")
public class UploadController {


    @Value("${location}")
    private String location;

    private final TransactionDataService transactionDataService;

    public UploadController(TransactionDataService transactionDataService) {
        this.transactionDataService = transactionDataService;
    }

    @RequestMapping("/upload")
    public Map<String, Object> upload (@RequestParam("file") MultipartFile file) {
        System.out.println("进来了");
        Map<String,Object> ret  = new HashMap<>() {{
           put("code", 0);
        }};

        if (file.isEmpty()) {
            ret.put("msg", "上传失败，请选择文件");
            return ret;
        }

        String fileName = file.getOriginalFilename();
        String fileNameUUId = UUID.randomUUID().toString();
        fileName = fileNameUUId + fileName;
        String filePath = location + fileName;
        File dest = new File(filePath);
        try {
            try {
                file.transferTo(dest);
            } catch (IOException e) {
                e.printStackTrace();
            }
            ret.put("msg", "上传成功");
            ret.put("fileName", fileName);
            transactionDataService.importTransactionData(fileName);
            return ret;
        } catch (Exception e) {
            e.printStackTrace();
        }

        ret.put("msg", "上传失败，请选择文件");
        return ret;
    }



}
