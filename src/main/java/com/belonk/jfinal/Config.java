package com.belonk.jfinal;

import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.util.StringUtils;
import com.belonk.jfinal.controller.HelloController;
import com.belonk.jfinal.controller.IndexController;
import com.belonk.jfinal.interceptor.ControlInjectlerInterceptor;
import com.belonk.jfinal.interceptor.GlobalActionInterceptor;
import com.belonk.jfinal.interceptor.GlobalServiceInterceptor;
import com.belonk.jfinal.model.Hello;
import com.jfinal.config.*;
import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.dialect.MysqlDialect;
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
        System.out.println("After jfinal start ...");
        super.afterJFinalStart();
    }

    @Override
    public void beforeJFinalStop() {
        System.out.println("Before jfinal stop ...");
        super.beforeJFinalStop();
    }

    @Override
    public void configConstant(Constants me) {
        PropKit.use("config.properties");
        me.setDevMode(PropKit.getBoolean("devMode", false));
    }

    @Override
    public void configRoute(Routes me) {
        me.setBaseViewPath("/pages");
        // Inject拦截器
        me.addInterceptor(new ControlInjectlerInterceptor());
        me.add("/", IndexController.class);
        me.add("/hello", HelloController.class);
    }

    @Override
    public void configPlugin(Plugins me) {
        Prop dbProp = PropKit.use("db.properties");
        String db_host = dbProp.get("db_host").trim();

        String db_host_port = dbProp.get("db_host_port");
        db_host_port = !StringUtils.isEmpty(db_host_port) ? db_host_port.trim() : "3306";

        String db_name = dbProp.get("db_name").trim();
        String db_user = dbProp.get("db_user").trim();
        String db_password = dbProp.get("db_password").trim();

        String jdbc_url = "jdbc:mysql://" + db_host + ":" + db_host_port + "/" + db_name + "?" + "useUnicode=true&"
                + "characterEncoding=utf8&" + "zeroDateTimeBehavior=convertToNull";

        // Druid插件
        DruidPlugin druidPlugin = new DruidPlugin(jdbc_url, db_user, db_password);
        druidPlugin.addFilter(new StatFilter());
        me.add(druidPlugin);
        // active record插件
        ActiveRecordPlugin arp = new ActiveRecordPlugin(druidPlugin);
        arp.addMapping("hello", Hello.class);
        me.add(arp);
        arp.setDialect(new MysqlDialect());
    }

    @Override
    public void configInterceptor(Interceptors me) {
        // 全局Action拦截器
        me.addGlobalActionInterceptor(new GlobalActionInterceptor());
        // 全局Service拦截器
        me.addGlobalServiceInterceptor(new GlobalServiceInterceptor());
    }

    @Override
    public void configHandler(Handlers me) {

    }

    @Override
    public void configEngine(Engine engine) {

    }
}
