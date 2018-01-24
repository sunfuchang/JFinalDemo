package com.belonk.jfinal;

import com.belonk.jfinal.controller.HelloController;
import com.belonk.jfinal.controller.IndexController;
import com.belonk.jfinal.interceptor.FrontInterceptor;
import com.belonk.jfinal.model.Test;
import com.jfinal.config.*;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.template.Engine;

/**
 * Created by sun on 2018/1/24.
 *
 * @author sunfuchang03@126.com
 * @version 1.0
 * @since 1.0
 */
public class Config extends JFinalConfig {
    //~ Static fields/initializers =====================================================================================


    //~ Instance fields ================================================================================================


    //~ Constructors ===================================================================================================


    //~ Methods ========================================================================================================

    @Override
    public void afterJFinalStart() {

    }

    @Override
    public void configConstant(Constants me) {
        PropKit.use("config.properties");
        me.setDevMode(PropKit.getBoolean("devMode", false));
    }

    @Override
    public void configRoute(Routes me) {
        me.setBaseViewPath("/pages");
        me.addInterceptor(new FrontInterceptor());
        me.add("/", IndexController.class);
        me.add("/hello", HelloController.class);
    }

    @Override
    public void configPlugin(Plugins me) {
        // Druid插件
        DruidPlugin dp = new DruidPlugin("jdbc:mysql://localhost/test", "root", "admin");
        me.add(dp);
        // active record插件
        ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
        arp.addMapping("test", Test.class);
        me.add(arp);
    }

    @Override
    public void configInterceptor(Interceptors me) {

    }

    @Override
    public void configHandler(Handlers me) {

    }

    @Override
    public void configEngine(Engine engine) {

    }
}
