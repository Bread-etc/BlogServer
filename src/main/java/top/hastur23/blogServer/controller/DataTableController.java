package top.hastur23.blogServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.hastur23.blogServer.entity.DataTableItem;
import top.hastur23.blogServer.entity.Response;
import top.hastur23.blogServer.service.DataTableService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DataTableController {

    @Autowired
    private DataTableService dataTableService;

    // 获取所有博客列表
    @GetMapping("/dataTable/get")
    public Response getAllDataTableItem() {
        try {
            List<DataTableItem> dataTableItems = dataTableService.getAllDataTableItem();
            return Response.success(dataTableItems);
        } catch (Exception e) {
            return Response.failure(500, "服务器异常");
        }
    }

    // 修改博客信息
    @PostMapping("/dataTable/revise")
    public Response updateDataTableItem(@RequestBody DataTableItem dataTableItem) {
        try {
            // 结果正确就返回 1
            int result = dataTableService.updateDataTableItem(dataTableItem);
            return Response.success(result);
        } catch (Exception e) {
            return Response.failure(500, "修改异常");
        }
    }
}