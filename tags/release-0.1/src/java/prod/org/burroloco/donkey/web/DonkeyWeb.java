package org.burroloco.donkey.web;

import au.net.netstorm.boost.spider.api.builder.Spinneret;
import au.net.netstorm.boost.spider.api.config.factory.Factorer;
import au.net.netstorm.boost.spider.api.config.mapping.Mapper;
import au.net.netstorm.boost.spider.api.config.web.Web;
import au.net.netstorm.boost.spider.plugs.factory.supplied.ThreadedFactory;
import org.burroloco.donkey.cache.ConnectionCacheWeb;
import org.burroloco.donkey.log.LoggingWeb;
import org.burroloco.util.wire.UtilitiesWeb;

public class DonkeyWeb implements Web {
    String scope = "";
    Spinneret spinneret;
    Factorer factorer;
    Mapper mapper;

    public void web() {
        mapper.prefix("Default", scope);
        factorer.add(ThreadedFactory.class);
        spinneret.spin(LoggingWeb.class, ConnectionCacheWeb.class, UtilitiesWeb.class);
    }
}