package top.hastur23.blogServer.entity;

import lombok.Data;

@Data
public class MarkdownFile {
    private String content;

    // 构造函数
    public MarkdownFile(String content) {
        this.content = content;
    }
}
