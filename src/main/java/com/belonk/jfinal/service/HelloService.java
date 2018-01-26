package com.belonk.jfinal.service;

import com.jfinal.plugin.activerecord.Model;

/**
 * Created by sun on 2018/1/26.
 *
 * @author sunfuchang03@126.com
 * @version 1.0
 * @since 1.0
 */
public class HelloService {
    //~ Static fields/initializers =====================================================================================


    //~ Instance fields ================================================================================================


    //~ Constructors ===================================================================================================


    //~ Methods ========================================================================================================
    public <T extends Model> void save(T model) {
        model.save();
    }
}