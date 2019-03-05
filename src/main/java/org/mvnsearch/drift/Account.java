package org.mvnsearch.drift;

import io.airlift.drift.annotations.ThriftField;
import io.airlift.drift.annotations.ThriftStruct;

/**
 * account
 *
 * @author linux_china
 */
@ThriftStruct
public class Account {
    @ThriftField(1)
    public Integer id;

    @ThriftField(2)
    public String name;

    public Account() {
    }

    public Account(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
