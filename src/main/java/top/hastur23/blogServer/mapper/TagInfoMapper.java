package top.hastur23.blogServer.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import top.hastur23.blogServer.entity.Song;
import top.hastur23.blogServer.entity.TagAlias;
import top.hastur23.blogServer.entity.TagInfo;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Mapper
public interface TagInfoMapper {

    // 查询所有的 tag 及其数量
    @Select("select tag, count(tag) as count from blogItem group by tag")
    List<TagInfo> getTagInfo();

    // 查询文章数量 articleNum
    @Select("select count(alias) from blogItem")
    int getArticleNum();

    // 查询第一篇文章的 date 属性
    @Select("select min(time) from blogItem limit 1")
    LocalDate getFirstDate();

    // 获取 songLink 内的链接link
    @Select("select link from songLink")
    String getSong();

    // 修改 songLink 内的链接link
    @Update("update songLink set link = #{link}")
    boolean reviseSong(Song song);

    // 查询所有的 tag 及其tag下的alias
    @Select("select tag, alias from blogItem")
    List<TagAlias> getTagAndAlias();
}
