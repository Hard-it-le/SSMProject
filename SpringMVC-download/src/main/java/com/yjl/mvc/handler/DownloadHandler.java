package com.yjl.mvc.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author yujiale
 */
@Controller
public class DownloadHandler {

    @Autowired
    private ServletContext servletContext;

    @RequestMapping("/download/handler")
    public ResponseEntity<byte[]> downloadHandler() {

        ResponseEntity<byte[]> responseEntity = null;

        // 1、将要下载的文件读取到输入流中
        InputStream inputStream = servletContext.getResourceAsStream("/download/tank.jpg");

        try {
            // 2、使用输入流将文件读取到一个字节数组中
            byte[] buffer = new byte[inputStream.available()];

            inputStream.read(buffer);

            // 3、将响应消息头数据封装到Map中
            MultiValueMap responseHeaderMap = new HttpHeaders();

            // attachment 表示这个响应数据不是用来直接显示的，而是要提示下载
            // filename 用于指定文件名
            responseHeaderMap.add("Content-Disposition", "attachment; filename=tank.jpg");

            // 4、创建 ResponseEntity 对象作为 handler 方法返回值
            responseEntity = new ResponseEntity<>(buffer, responseHeaderMap, HttpStatus.OK);

            return responseEntity;

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if(inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

        return responseEntity;
    }

}
