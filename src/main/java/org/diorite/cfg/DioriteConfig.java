package org.diorite.cfg;

import java.io.File;

public interface DioriteConfig
{
    String getHostname();

    int getPort();

    int getQueryPort();

    int getRconPort();

    int getNetworkCompressionThreshold();

    int getNettyThreads();

    OnlineMode getOnlineMode();

    void setOnlineMode(OnlineMode onlineMode);

    int getMaxPlayers();

    void setMaxPlayers(int maxPlayers);

    int getPlayerIdleTimeout();

    void setPlayerIdleTimeout(int playerIdleTimeout);

    String getResourcePack();

    void setResourcePack(String resourcePack);

    String getResourcePackHash();

    void setResourcePackHash(String resourcePackHash);

    boolean isUseNativeTransport();

    int getViewDistance();

    void setViewDistance(int viewDistance);

    int getInputThreadPoolSize();

    File getAdministratorsFile();

    boolean isWhiteListEnabled();

    File getWhiteListFile();

    String getMotd();

    void setMotd(String motd);

    WorldsConfig getWorlds();

    enum OnlineMode
    {
        TRUE,
        FALSE,
        AUTO
    }
}
