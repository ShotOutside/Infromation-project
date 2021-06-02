package com.rj.bd.classes.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author ShiJie
 * @desc
 * @time 2021-05-31-16:34
 */
@Data
public class Classes {

    @TableId
    public String cid;
    public String cname;
}
