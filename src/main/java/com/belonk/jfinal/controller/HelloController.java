package com.belonk.jfinal.controller;

import com.belonk.jfinal.model.Test;
import com.jfinal.core.Controller;

/**
 * Created by sun on 2018/1/24.
 *
 * @author sunfuchang03@126.com
 * @version 1.0
 * @since 1.0
 */
public class HelloController extends Controller {
    //~ Static fields/initializers =====================================================================================


    //~ Instance fields ================================================================================================


    //~ Constructors ===================================================================================================


    //~ Methods ========================================================================================================

    public void hello() {
        render("hello");
    }

    public void save() {
        Test test = getModel(Test.class);
        test.save();
    }
}
