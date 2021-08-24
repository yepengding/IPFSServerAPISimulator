package jp.gmo.ipfssimulator.controller;

import jp.gmo.ipfssimulator.common.CommonResult;
import jp.gmo.ipfssimulator.model.IPFSFile;
import jp.gmo.ipfssimulator.service.StorageService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/ipfs")
public class IPFSController {

    @Autowired
    private StorageService storageService;


    @PostMapping("/upload")
    @ResponseBody
    public CommonResult<IPFSFile> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        String cid;

        try (InputStream is = file.getInputStream()) {
            cid = DigestUtils.md5Hex(is);
            cid = "Qm" + DigestUtils.md5Hex(System.currentTimeMillis() + cid);
        }

        Assert.notNull(cid, "Failed to generate CID.");
        storageService.store(cid, file);

        return CommonResult.success(new IPFSFile(cid, file.getSize(), System.currentTimeMillis()));
    }

    @GetMapping("/list")
    @ResponseBody
    public CommonResult<List<String>> listFiles() {
        List<String> files = storageService.loadAll().map(
                path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,
                        "serveFile", path.getFileName().toString()).build().toUri().toString())
                .collect(Collectors.toList());
        return CommonResult.success(files);
    }

    @GetMapping("/{cid}")
    @ResponseBody
    public ResponseEntity<Resource> getFileByCID(@PathVariable String cid) {

        Resource file = storageService.loadAsResource(cid);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
}
