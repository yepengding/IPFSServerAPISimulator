# IPFSServerAPISimulator

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

### Endpoint

http://localhost:8080

### Requests

#### Upload

Upload a file

```
/ipfs/upload
```

| Parameter | Type | Description |
|:----------|:-----|:------------|
|file|MultipartFile||

> Response: `IPFSFile`

#### List

List all files

```
/ipfs/list
```

> Response: `List<FileURI: String>`

#### Download

Get a file by CID

```
/ipfs/{cid}
```

| Parameter | Type | Description |
|:----------|:-----|:------------|
|cid|String||

> Response: `File`