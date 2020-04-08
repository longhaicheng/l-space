# l-space

### 概述
一个网站的后台与前台，功能简单

### 提交日志
#### 202004070040
1. 将原计划的Shiro框架改为Spring Security并整合JSON Web Token，实现无状态的认证
2. 可以校验JWT的[网站](https://jwt.io/)，用来测试还挺不错的！
3. 完成登录接口：通过账号和密码登录，返回token
* 接口说明：
    * 请求方式： POST
    * 请求地址： http://localhost:8080/sys/user/authenticate
    * 请求示例：
    ```json
    {
    	"userAccount":"12345",
    	"userPasswd": "123"
    }
    ```
     * 返回示例：
    ```json
    {
        "code": 200,
        "expiration": 1586190218308,
        "message": "success",
        "token": "eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJsLXNwYWNlIiwicm9sZSI6WyJ1c2VyMSIsImFkbWluIl0sImV4cCI6MTU4NjE5MDIxOCwiaWF0IjoxNTg2MTkwMDM4LCJhY2NvdW50IjoiMTIzNDUiLCJqdGkiOiI4ZmE5NTM3Yi00ZDdlLWE5ZTktY2Q3Zi1hNmJhNzllZGRlODQifQ.iB2E5XGLOHWs7cCP03-BBdPryDa6LjDOlMe-yShXAzxvgqpmz7s3Dx9aIj5pH_IQY9AlL5kGawHhodg4sPe7rw"
    }
    ```
    * token信息
    ![token info](http://image.haicheng.website/20200407005413.bmp)


*开发进度比较慢*
