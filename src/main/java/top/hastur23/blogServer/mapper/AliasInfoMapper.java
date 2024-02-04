package top.hastur23.blogServer.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import top.hastur23.blogServer.entity.AliasInfo;

@Mapper
public interface AliasInfoMapper {

    // 获取某一篇文章的具体路径
    @Select("select alias from maintext where id = #{id}")
    String getAlias(int id);

    // 插入新的文章的路径
    @Insert("insert into ")
    String insertAlias(AliasInfo aliasInfo);
}
