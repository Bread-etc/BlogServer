# 个人博客后端开发
本服务器是基于`springboot3`进行开发

## 更新日志
### 2023/09/18 (1)
- 初步认识框架

### 2023/09/19 (2)
- 初步使用`yml`连接本地`MySQL`数据库

### 2023/09/20 (3)
- 熟悉软件包命名规范

### 2023/09/21 (4)
- 移除`jdbc`,加入`Mybatis`,初步了解Mybatis的使用

### 2023/09/22 (5)
- 完善数据库的连接,修复bug

### 2023/09/25 (6)
- 写入`MainText`接口
- 更改数据库表结构

### 2023/09/28 (7)
- mysql实现分页

### 2023/10/11 (8)
- 新增`webInfo`接口
- 理清接口思路

### 2023/10/24 (9)
- 新增`/admin/userAuth`接口

### 2023/10/25 (10)
- 新增类`rsaUtils`

### 2023/10/27 (11)
- 加入`HuTool`

### 2023/10/28 (12)
- 完善`rsaUtils`工具类
- 完成获取公钥接口`/getPublicKey`
- 加入`LoginController`
- 加入`Redis`数据库

### 2023/10/29 (13)
- 添加跨域配置`CorsConfig`
- 完善`LoginController`

### 2023/10/30 (14)
- 修复跨域请求问题`BlogServerApplication.addAllowedOrigin()`

### 2023/11/1 (15)
- 了解`JWT`
- 添加`JWTUtils`工具类
- 添加`User`模型

### 2023/11/2 (16)
- 继续`JWTUtils`类

### 2023/11/3 (17)
- 完善jwt

### 2023/11/4 (18)
- 添加`config`目录,加入`WebMvcConfig`用于拦截器
- 添加`interceptor`,加入拦截器验证token - `TokenInterceptor`
- 加入实体`LoginResult`
- 修改`JWTUtils`工具类

### 2024/2/4 (19)
- 添加`DataTableItem`类以及一系列增删改的方法
- 加入entity `AliasInfo` 和 `DataTableItem`

### 2024/2/11 (20)
- 修改`DataTable`和`AliasInfo`一系列的接口
- 增加上传文件功能
- 增加删除功能
- 修改数据库部分属性

### 2024/2/12 (21)
- 在`DataTableService`内添加记录时间`java.sql.Date`

### 2024/2/21 (22)
- 完成大部分内容
- 开始优化细节

### 2024/3/1 (23)
- 完善服务器部署

### 2024/4/1 (24)
- 修改部分隐私
- 代办事项：api图片上传