package top.hastur23.blogServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import top.hastur23.blogServer.entity.Response;
import top.hastur23.blogServer.service.AliasInfoService;
import top.hastur23.blogServer.service.DataTableService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@RestController
public class AliasInfoController {
    @Autowired
    private AliasInfoService aliasInfoService;
    @Autowired
    private DataTableService dataTableService; // 添加 DataTableService 字段

    // 上传文件到指定目录
    @PostMapping("/upload")
    public ResponseEntity<String> fileUpload(@RequestParam("file") MultipartFile file) {

        String fileName = file.getOriginalFilename();

        if (fileName == null) {
            return ResponseEntity.badRequest().body("上传文件不能为空");
        }
        String fileNameWithoutExtentsion = new File(fileName).getName().replaceFirst("[.][^.]+$", "");

        try {
            // 检查文件是否存在
            boolean fileExists = aliasInfoService.checkFileExists(fileName);

            // 如果文件不存在, 则创建一个新的记录, 并将文件保存到目标目录
            //Path paths = Paths.get("~/home/blog_articles", fileName);
            Path filePath = Paths.get("src/main/resources/static", fileName);
            if (!fileExists) {
                int newId = aliasInfoService.getMaxId() + 1;

                // 将文件保存到指定目录
                Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

                // 创建新的记录并保存到数据库 (保存不包含后缀的文件名)
                aliasInfoService.createNewText(newId, fileNameWithoutExtentsion);
                dataTableService.createNewItem(newId, fileNameWithoutExtentsion);
            } else {
                // 文件已经存在, 则覆盖现有的文件
                Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            }

            return ResponseEntity.ok("文件上传成功");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("文件上传失败");
        }
    }

    // 删除指定文件
    @DeleteMapping("/delete")
    public Response deleteMainText(@RequestParam String alias) {
        try {
            // 删除成功
            String filePath = "src/main/resources/static/" + alias + ".md";

            // 创建 File 对象
            File file = new File(filePath);

            // 检查文件是否存在并且是一个文件
            if (file.exists() && file.isFile()) {
                // 删除文件
                boolean deleteInAlias = aliasInfoService.deleteMainText(alias);
                boolean deleteInBlogItem = dataTableService.deleteDataTableItem(alias);
                boolean deleteResult = file.delete() && deleteInAlias && deleteInBlogItem;

                if (deleteResult) {
                    return Response.success("文件删除成功");
                } else {
                    return Response.failure(500, "文件删除失败");
                }
            } else {
                return Response.failure(404, "文件不存在或者不是一个文件");
            }
        } catch (Exception e) {
            return Response.failure(500, "删除异常");
        }
    }

}