# l-space

### 概述
基于SpringSecurity使用token完成接口请求
## 使用
1. Spring Security整合JSON Web Token，实现无状态的认证
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
      "expiration": 1586596704891,
      "message": "success",
      "token": "eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NSIsImV4cCI6MTU4NjU5NjcwNCwianRpIjoiNGU5YTYwMDgtNmIzNy1lZTE1LTEzOTctZjBlZjk0ZmFmNjNjIiwiaWF0IjoxNTg2NTkzMTk2LCJpc3MiOiJsLXNwYWNlIn0.kL3lQsPcdojN7ttfXxhAVDCZs4_OOmIAbl6SE00q4a5nwvz7nsedPEkyV5Is2lj1GoW5RbIfq1gThckWrNVvog"
  }
    ```
* 获取token之后，将token存放在header中请求受保护的接口
    * 请求方式：POST
    * 请求地址：http://localhost:8080/sys/setting/list
    * 请求示例：
    ```bash
        curl --location --request POST 'http://118.126.117.177:8080/sys/setting/list' \
        --header 'Authorization: Bearer eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJsLXNwYWNlIiwicm9sZSI6W10sImV4cCI6MTU4NjQwMjYwMiwiaWF0IjoxNTg2Mzk5MDA5LCJhY2NvdW50IjoiZGVtb0RhdGEiLCJqdGkiOiIyMWRhNzQ4Zi1lOWUzLTM2MzItNzYxNS0yOWRiN2YzNDUyNTgifQ.TQOfd7BqBUZxGvx9ccs6wS8BM5szQwgSOT1PkLPGZQpPur6k8mqzF_9BwArR8YDh3gv8GALQVM91Dmctsf61kQ'
    ```
    * 返回示例：
    ```json
      {
          "code": 200,
          "data": [
              {
                  "id": 1,
                  "configName": "友站",
                  "configKey": "百度",
                  "configValue": "https://www.baidu.com/",
                  "createTime": "2020-04-06T16:43:57",
                  "createBy": "admin",
                  "updateTime": "2020-04-06T16:47:44",
                  "updateBy": null,
                  "remark": "添加",
                  "status": 0
              }
          ],
          "message": "success"
      }
    ```
## 七牛云OSS交互流程
![七牛云OSS交互流程](http://image.haicheng.website/20200412200512.bmp)


*开发进度比较慢*
