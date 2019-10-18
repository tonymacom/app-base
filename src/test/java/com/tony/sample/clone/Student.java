package com.tony.sample.clone;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author www.yamibuy.com
 * @desc :
 * @date 2019/10/18
 * <b>版权所有：</b>版权所有(C) 2018，www.yamibuy.com<br>
 */
@Data
@Accessors(chain = true)
public class Student implements Cloneable{

    private String name;
    //教授
    private Professor professor;

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

}
