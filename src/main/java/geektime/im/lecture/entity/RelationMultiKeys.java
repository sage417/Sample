package geektime.im.lecture.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class RelationMultiKeys implements Serializable {

    protected Long mid;
    protected Long ownerUid;
}