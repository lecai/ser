package org.eacan.server.model;

/**
 * 项目名称:
 * 创建人: lecai
 * 创建时间: 13-9-13
 * 类描述:
 * 版本:
 */
public abstract class Channel {
    protected ChannelType channelType;
    protected int channelId;

    protected Channel(ChannelType channelType, int channelId) {
        this.channelType = channelType;
        this.channelId = channelId;
    }

    public ChannelType getChannelType() {
        return channelType;
    }

    public int getChannelId() {
        return channelId;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + channelId;
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Channel other = (Channel) obj;
        if (channelId != other.channelId)
            return false;
        return true;
    }

}
