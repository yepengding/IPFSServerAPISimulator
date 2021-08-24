package jp.gmo.ipfssimulator.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class IPFSFile {

    private String cid;

    private Long size;

    private Long timestamp;

}
