/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Foo
 * Author:   YuSong
 * Date:     2019/4/6 17:31
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package geektime.spring.data.simplejdbcdemo;

import lombok.Builder;
import lombok.Data;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Raven
 * @create 2019/4/6
 * @since 1.0.0
 */
@Data
@Builder
public class Foo {

    private Long id;
    private  String bar;
}