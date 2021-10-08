package com.yjl.mvc.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.UUID;

/**
 * @author yujiale
 */
@Controller
public class UploadHandler {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ServletContext servletContext;

    /**
     * 文件上传
     * @param nickName
     * @param picture
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping("/simple/upload")
    public String doUpload(
            // 表单提交的数据仍然是请求参数，所以使用 @RequestParam 注解接收
            @RequestParam("nickName") String nickName,
            // 对于上传的文件使用 MultipartFile 类型接收其相关数据
            @RequestParam("picture") MultipartFile picture,
            Model model
            ) throws IOException {

        // 测试文件上传代码：第一部分——获取相关数据
        String inputName = picture.getName();
        logger.debug("文件上传表单项的 name 属性值：" + inputName);

        // 获取这个数据通常都是为了获取文件本身的扩展名
        String originalFilename = picture.getOriginalFilename();
        logger.debug("文件在用户本地原始的文件名：" + originalFilename);

        String contentType = picture.getContentType();
        logger.debug("文件的内容类型：" + contentType);

        boolean empty = picture.isEmpty();
        logger.debug("文件是否为空：" + empty);

        long size = picture.getSize();
        logger.debug("文件大小：" + size);

        byte[] bytes = picture.getBytes();
        logger.debug("文件二进制数据的字节数组：" + Arrays.asList(bytes));

        InputStream inputStream = picture.getInputStream();
        logger.debug("读取文件数据的输入流对象：" + inputStream);

        Resource resource = picture.getResource();
        logger.debug("代表当前 MultiPartFile 对象的资源对象" + resource);

        // 测试文件上传代码：第二部分——转存文件（转存到本地）
        // 1、准备好保存文件的目标目录
        // ①File 对象要求目标路径是一个物理路径（在硬盘空间里能够直接找到文件的路径）
        // ②项目在不同系统平台上运行，要求能够自动兼容、适配不同系统平台的路径格式
        //      例如：Window系统平台的路径是 D:/aaa/bbb 格式
        //      例如：Linux系统平台的路径是 /ttt/uuu/vvv 格式
        //      所以我们需要根据『不会变的虚拟路径』作为基准动态获取『跨平台的物理路径』
        // ③虚拟路径：浏览器通过 Tomcat 服务器访问 Web 应用中的资源时使用的路径
        String destFileFolderVirtualPath = "/head-picture";

        // ④调用 ServletContext 对象的方法将虚拟路径转换为真实物理路径
        String destFileFolderRealPath = servletContext.getRealPath(destFileFolderVirtualPath);

        // 2、生成保存文件的文件名
        // ①为了避免同名的文件覆盖已有文件，不使用 originalFilename，所以需要我们生成文件名
        // ②我们生成文件名包含两部分：文件名本身和扩展名
        // ③声明变量生成文件名本身
        String generatedFileName = UUID.randomUUID().toString().replace("-","");

        // ④根据 originalFilename 获取文件的扩展名
        String fileExtname = originalFilename.substring(originalFilename.lastIndexOf("."));

        // ⑤拼装起来就是我们生成的整体文件名
        String destFileName = generatedFileName + "" + fileExtname;

        // 3、拼接保存文件的路径，由两部分组成
        //      第一部分：文件所在目录
        //      第二部分：文件名
        String destFilePath = destFileFolderRealPath + "/" + destFileName;

        // 4、创建 File 对象，对应文件具体保存的位置
        File destFile = new File(destFilePath);

        // 5、执行转存
        picture.transferTo(destFile);

        // 测试文件上传代码：第三部分——到目标页面显示图片
        // 1、拼接能够访问到上传文件的虚拟路径
        String fileAccessVirtualPath = destFileFolderVirtualPath + "/" + destFileName;

        // 2、将文件路径存入请求域
        model.addAttribute("fileAccessVirtualPath", fileAccessVirtualPath);

        return "target";
    }

//    public static void main(String[] args) {
//        String a = "aaa.jpg";
//        String extName = a.substring(a.lastIndexOf("."));
//        System.out.println("extName = " + extName);
//    }
}
