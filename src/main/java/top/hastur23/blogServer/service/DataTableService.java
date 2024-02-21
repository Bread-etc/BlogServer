package top.hastur23.blogServer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.hastur23.blogServer.entity.DataTableItem;
import top.hastur23.blogServer.mapper.DataTableMapper;

import java.time.LocalDate;
import java.sql.Date;
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


    // 删除指定 id 的数据 (重新排序)
    public boolean deleteDataTableItem(String alias) {
        return dataTableMapper.deleteDataTableItem(alias);
    }

    // 创建新的记录并保存到数据库 (blogitem)
    public void createNewItem(int newId, String fileName) {
        DataTableItem dataTableItem = new DataTableItem();
        dataTableItem.setId(newId);
        // title = alias (初始化)
        dataTableItem.setTitle(fileName);
        dataTableItem.setAlias(fileName);

        // 获取当前系统时间
        LocalDate uploadTime = LocalDate.now();
        Date date = Date.valueOf(uploadTime);
        // 添加上传时间
        dataTableItem.setTime(date);
        dataTableMapper.createNewItem(dataTableItem);
    }

}
