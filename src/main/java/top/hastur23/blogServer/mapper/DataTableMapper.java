package top.hastur23.blogServer.mapper;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Delete;
import top.hastur23.blogServer.entity.DataTableItem;

import java.util.List;

@Mapper
public interface DataTableMapper {

    // 查询所有数据
    @Select("select * from blogItem")
    List<DataTableItem> getAllDataTableItem();

    // 修改数据 (title,tag,content,image)
    @Update("update blogItem SET title = #{title}, tag =  #{tag}, image = #{image}, content = #{content} where id = #{id}")
    int updateDataTableItem(DataTableItem dataTableItem);

    // 根据 Id 查找到对应DataTableItem
    @Select("select * from blogItem where id = #{id}")
    DataTableItem getDataTableItemById(int id);

    // 删除数据 (blogitem)
    @Delete("delete from blogItem where alias = #{alias}")
    boolean deleteDataTableItem(String alias);

    // 添加数据 (blogitem) [仅仅是上传文件,读取文件名作为title和alias, title后续再通过其他api修改]
    @Insert("insert into blogItem (id, title, alias, time) values (#{id}, #{title}, #{alias}, #{time})")
    int createNewItem(DataTableItem dataTableItem);

}
