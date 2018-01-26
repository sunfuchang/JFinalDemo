package com.belonk.jfinal.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

/**
 * Created by sun on 2018/1/24.
 *
 * @author sunfuchang03@126.com
 * @version 1.0
 * @since 1.0
 */
public class GlobalServiceInterceptor implements Interceptor {
    //~ Static fields/initializers =====================================================================================


    //~ Instance fields ================================================================================================


    //~ Constructors ===================================================================================================


    //~ Methods ========================================================================================================

    @Override
    public void intercept(Invocation invocation) {
        System.out.println("Before GlobalServiceInterceptor...");
        invocation.invoke();
        System.out.println("After GlobalServiceInterceptor...");
    }
}
