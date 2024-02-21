package top.hastur23.blogServer.service;

import org.springframework.stereotype.Service;
import top.hastur23.blogServer.entity.MarkdownFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class MarkdownService {

    public MarkdownFile getMarkdownContent(String alias) {
        // String markdownFilePath = "/home/blog_articles" + alias + ".md"
        String markdownFilePath = "src/main/resources/static/" + alias + ".md";
        String markdownContent = readMarkdownFile(markdownFilePath);

        return new MarkdownFile(markdownContent);
    }

    private String readMarkdownFile(String filePath) {
        try {
            // 使用 FileReader 从文件系统中读取文件
            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            // 存储读取的文件内容
            StringBuilder contentBuilder = new StringBuilder();
            String line;
            // 逐行读取内容
            while ((line = reader.readLine()) != null) {
                contentBuilder.append(line).append("\n");
            }

            reader.close();
            return contentBuilder.toString();
        } catch (IOException e) {
            throw new RuntimeException("Error reading markdown file:" + filePath, e);
        }
    }
}
