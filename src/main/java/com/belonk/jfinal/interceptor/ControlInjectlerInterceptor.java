package com.belonk.jfinal.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

/**
 * 用于拦截Controller的拦截器。
 * <p>
 * 在config的configRoute方法中配置，则可以拦截全部controller。
 * <p>
 * Created by sun on 2018/1/24.
 *
 * @author sunfuchang03@126.com
 * @version 1.0
 * @since 1.0
 */
public class ControlInjectlerInterceptor implements Interceptor {
    //~ Static fields/initializers =====================================================================================


    //~ Instance fields ================================================================================================


    //~ Constructors ===================================================================================================


    //~ Methods ========================================================================================================

    @Override
    public void intercept(Invocation invocation) {
        System.out.println("Before ControlInjectlerInterceptor...");
        invocation.invoke();
        System.out.println("After ControlInjectlerInterceptor...");
    }
}
