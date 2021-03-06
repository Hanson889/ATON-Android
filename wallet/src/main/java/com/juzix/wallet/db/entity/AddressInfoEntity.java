package com.juzix.wallet.db.entity;

import android.text.TextUtils;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class AddressInfoEntity extends RealmObject {

    /**
     * 钱包地址
     */
    @PrimaryKey
    private String uuid;

    private String address;
    /**
     * 钱包名称
     */
    private String name;
    /**
     * 钱包头像
     */
    private String avatar;

    public AddressInfoEntity() {

    }

    public AddressInfoEntity(String uuid, String address, String name, String avatar) {
        setUuid(uuid);
        setAddress(address);
        setName(name);
        setAvatar(avatar);
    }

    private AddressInfoEntity(Builder builder) {
        setUuid(builder.uuid);
        setAddress(builder.address);
        setName(builder.name);
        setAvatar(builder.avatar);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * 获取钱包地址
     *
     * @return
     */
    public String getPrefixAddress() {
        try {
            if (TextUtils.isEmpty(address)) {
                return null;
            }
            if (address.toLowerCase().startsWith("0x")) {
                return address;
            }
            return "0x" + address;
        } catch (Exception exp) {
            exp.printStackTrace();
            return null;
        }
    }

    public void setAddress(String address) {
        if (address.toLowerCase().startsWith("0x")) {
            this.address = address;
        } else {
            this.address = "0x" + address;
        }
    }

    public AddressInfoEntity buildAddressEntity() {
        AddressInfoEntity.Builder builder = new AddressInfoEntity.Builder();
        builder.uuid(uuid);
        builder.name(name);
        builder.address(address);
        return builder.build();
    }

    @Override
    public String toString() {
        return "WalletInfoEntity{" +
                " uuid='" + uuid + '\'' +
                " name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public static final class Builder {
        private String uuid;
        private String address;
        private String name;
        private String avatar;

        public Builder() {
        }

        public Builder uuid(String val) {
            uuid = val;
            return this;
        }

        public Builder address(String val) {
            address = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder avatar(String val) {
            avatar = val;
            return this;
        }

        public AddressInfoEntity build() {
            return new AddressInfoEntity(this);
        }
    }
}
