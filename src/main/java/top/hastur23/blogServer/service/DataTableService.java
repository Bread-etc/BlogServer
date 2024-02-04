package top.hastur23.blogServer.service;

import org.apache.ibatis.type.Alias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.hastur23.blogServer.entity.DataTableItem;
import top.hastur23.blogServer.mapper.DataTableMapper;

import java.util.List;

@Service
public class DataTableService {

    @Autowired
    DataTableMapper dataTableMapper;

    // 查询所有数据
    public List<DataTableItem> getAllDataTableItem() {
        return dataTableMapper.getAllDataTableItem();
    }

    // 修改数据
    public int updateDataTableItem(DataTableItem dataTableItem) {
        // 查询数据库中原有的数据
        DataTableItem originalItem = dataTableMapper.getDataTableItemById(dataTableItem.getId());

        // 传入字段为空的时候默认不更新数据库中对应的字段
        if (dataTableItem.getContent() == null) {
            dataTableItem.setContent(originalItem.getContent());
        }
        if (dataTableItem.getTitle() == null) {
            dataTableItem.setTitle(originalItem.getTitle());
        }
        if (dataTableItem.getImage() == null) {
            dataTableItem.setImage(originalItem.getImage());
        }

        // 执行更新操作
        return dataTableMapper.updateDataTableItem(dataTableItem);
    }


    // 删除指定 id 的数据
    public int deleteDataTableItem(int id) {
        return dataTableMapper.deleteDataTableItem(id);
    }

    // 新增 newBlog 的数据
    public void insertDataTableItem(Alias newBlog) {
        return dataTableMapper.insertDataTableItem(newBlog);
    }
}
