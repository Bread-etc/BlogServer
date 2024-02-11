package top.hastur23.blogServer.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import top.hastur23.blogServer.entity.AliasInfo;
import top.hastur23.blogServer.mapper.AliasInfoMapper;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class AliasInfoService {
    @Autowired
    AliasInfoMapper aliasInfoMapper;

    // 检查文件是否存在
    public boolean checkFileExists(String fileName) {
        // path 路径
        Path path = Paths.get("src/main/resources/static", fileName);
        return Files.exists(path);
    }

    // 查询数据库获取当前最大的 ID
    public int getMaxId() {
        return aliasInfoMapper.getMaxId();
    }

    // 添加数据 (maintext)
    public void createNewText(int newId, String fileName) {
        AliasInfo aliasInfo = new AliasInfo();
        aliasInfo.setId(newId);
        aliasInfo.setAlias(fileName);
        aliasInfoMapper.createNewText(aliasInfo);
    }

    // 删除数据 (maintext)
    public boolean deleteMainText(String alias) {
        return aliasInfoMapper.deleteMainText(alias);
    }
}