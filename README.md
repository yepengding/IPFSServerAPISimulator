# IPFS Server API Simulator

A simple IPFS server API simulator for a quick start to interact with an IPFS server.

## Commands

### Compile

```
mvn package
```

### Run

```
java -jar *.jar
```

## API

> http://localhost:8080/swagger-ui/


**Contact information:**  
Yepeng Ding  
https://yepengding.github.io/

**License:** [MIT License](https://github.com/yepengding/IPFSServerAPISimulator/blob/main/LICENSE)

### /ipfs/list

#### GET

##### Summary:

listFiles

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [CommonResult«List«string»»](#CommonResult«List«string»») |
| 403 | Forbidden |  |
| 500 | Internal Error |  |

### /ipfs/upload

#### POST

##### Summary:

uploadFile

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| file | body | file | Yes | binary |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [CommonResult«IPFSFile»](#CommonResult«IPFSFile») |

### /ipfs/{cid}

#### GET

##### Summary:

getFileByCID

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| cid | path | cid | Yes | string |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [Resource](#Resource) |
| 403 | Forbidden |  |
| 500 | Internal Error |  |

### Models

#### CommonResult«IPFSFile»

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| code | long |  | No |
| data | [IPFSFile](#IPFSFile) |  | No |
| message | string |  | No |

#### CommonResult«List«string»»

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| code | long |  | No |
| data | [ string ] |  | No |
| message | string |  | No |

#### IPFSFile

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| cid | string |  | No |
| integrity | string |  | No |
| size | long |  | No |
| timestamp | long |  | No |

#### InputStream

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| InputStream | object |  |  |

#### Resource

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| description | string |  | No |
| file | file |  | No |
| filename | string |  | No |
| inputStream | [InputStream](#InputStream) |  | No |
| open | boolean |  | No |
| readable | boolean |  | No |
| uri | string (uri) |  | No |
| url | string (url) |  | No |

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.5.4/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.5.4/maven-plugin/reference/html/#build-image)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.5.4/reference/htmlsingle/#boot-features-jpa-and-spring-data)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.5.4/reference/htmlsingle/#boot-features-developing-web-applications)
* [Thymeleaf](https://docs.spring.io/spring-boot/docs/2.5.4/reference/htmlsingle/#boot-features-spring-mvc-template-engines)
