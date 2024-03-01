package top.hastur23.blogServer.mapper;

import org.apache.ibatis.annotations.*;
import top.hastur23.blogServer.entity.AliasInfo;

@Mapper
public interface AliasInfoMapper {

    // 添加数据 (maintext)
    @Insert("insert into mainText (id, alias) values (#{id}, #{alias})")
    void createNewText(AliasInfo aliasInfo);

    // 查询最大 id
    @Select("select max(id) from mainText")
    Integer getMaxId();

    // 删除指定数据
    @Delete("delete from mainText where alias = #{alias}")
    boolean deleteMainText(String alias);
}