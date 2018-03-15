package org.fsj.demo.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Http请求返回的最外层对象
 * Created by wxy on 2018-2-1.
 */

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultVO {
    /**错误码**/
    private Integer code;

    /**提示信息**/
    private String msg ;

    /**返回的具体内容**/
    private Object data;
}
