package com.pch.system.api.param;

import com.pch.common.api.param.Relevance;
import com.pch.system.api.entity.Menu;
import com.pch.system.api.entity.Role;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * @author pch 651158394@qq.com
 * @version 2021/7/1 下午5:35
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RelateRole extends Relevance<Role, Menu> {
}
