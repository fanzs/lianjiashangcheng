package com.fanzs.entity;

import javax.persistence.*;

/**
 * Created by fzs on 2018/4/20.
 */
@Entity
@Table(name="support_address")
public class SupportAddress {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "belong_to")
    private String belongTo;

    @Column(name = "en_name")
    private String enName;

    @Column(name = "cn_name")
    private String level;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBelongTo() {
        return belongTo;
    }

    public void setBelongTo(String belongTo) {
        this.belongTo = belongTo;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    /**
     * 行政級別的定義
     */
    public enum Level{
        CITY("city"),
        REGIN("regin");

        private String value;
        Level(String value){
            this.value=value;
        }

        public String getValue() {
            return value;
        }

        public static Level of(String value){
            for (Level level :Level.values()) {
                if(level.getValue().equals(value)){
                    return level;
                }
            }
            throw new IllegalArgumentException();
        }
    }
}
