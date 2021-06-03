package com.rj.bd.classes.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author ShiJie
 * @desc
 * @time 2021-05-31-16:34
 */
@Data
@ApiModel
public class Classes {

    public String cid;
    public String cname;
}
