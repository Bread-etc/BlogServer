package top.hastur23.blogServer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.hastur23.blogServer.entity.Song;
import top.hastur23.blogServer.entity.TagAlias;
import top.hastur23.blogServer.entity.TagInfo;
import top.hastur23.blogServer.mapper.TagInfoMapper;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Service
public class TagInfoService {

    @Autowired
    TagInfoMapper tagInfoMapper;

    // 查询所有 tag 及其数量
    public List<TagInfo> getTagInfo() {
        return tagInfoMapper.getTagInfo();
    }

    // 查询文章数量
    public int getArticleNum() {
        return tagInfoMapper.getArticleNum();
    }

    // 查询第一篇文章的天数
    public long getDays() {
        LocalDate firstDate = tagInfoMapper.getFirstDate();
        LocalDate nowDate = LocalDate.now();
        return ChronoUnit.DAYS.between(firstDate, nowDate);
    }

    // 获取歌曲链接
    public String getSong() {
        return tagInfoMapper.getSong();
    }

    // 修改歌曲链接 (id)
    public boolean reviseSong(Song song) {
        return tagInfoMapper.reviseSong(song);
    }

    // 查询所有的 tag 及其tag下的alias, 以及tag的数量
    public List<Map<String, Object>> getTagAndAliases() {
        List<Map<String, Object>> result = new ArrayList<>();
        Map<String, List<String>> tagMap = new HashMap<>();

        // 查询所有tag以及对应的alias
        List<TagAlias> tagLists = tagInfoMapper.getTagAndAlias();

        // 根据tag分类alias
        for (TagAlias tagList : tagLists) {
            String tag = tagList.getTag();
            String alias = tagList.getAlias();

            List<String> aliases = tagMap.getOrDefault(tag, new ArrayList<>());
            aliases.add(alias);
            tagMap.put(tag, aliases);
        }

        // 构建结果列表
        for (Map.Entry<String, List<String>> entry : tagMap.entrySet()) {
            Map<String, Object> tagWithAliases = new HashMap<>();
            tagWithAliases.put("tag", entry.getKey());
            tagWithAliases.put("aliases", entry.getValue());
            result.add(tagWithAliases);
        }

        return result;
    }
}