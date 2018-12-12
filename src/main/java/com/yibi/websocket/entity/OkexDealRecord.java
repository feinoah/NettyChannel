package com.yibi.websocket.entity;

import java.io.Serializable;

public class OkexDealRecord implements Serializable {
    private static final long serialVersionUID = -999077130710398783L;

    private Integer id;

    private Integer coinid;

    private String price;

    private String volume;

    private Integer type;

    private String time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCoinid() {
        return coinid;
    }

    public void setCoinid(Integer coinid) {
        this.coinid = coinid;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume == null ? null : volume.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", id=").append(id);
        sb.append(", coinid=").append(coinid);
        sb.append(", price=").append(price);
        sb.append(", volume=").append(volume);
        sb.append(", type=").append(type);
        sb.append(", time=").append(time);
        sb.append("]");
        return sb.toString();
    }
}