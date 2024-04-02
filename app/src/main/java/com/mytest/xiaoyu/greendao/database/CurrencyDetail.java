package com.mytest.xiaoyu.greendao.database;



import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;


@Entity
public class CurrencyDetail{
    @Id(autoincrement = true)
    private Long id;
    private String symbol;
    private String change;
    private String sell;
    private String buy;
    @Generated(hash = 1786374202)
    public CurrencyDetail(Long id, String symbol, String change, String sell,
            String buy) {
        this.id = id;
        this.symbol = symbol;
        this.change = change;
        this.sell = sell;
        this.buy = buy;
    }
    @Generated(hash = 568072945)
    public CurrencyDetail() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getSymbol() {
        return this.symbol;
    }
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    public String getChange() {
        return this.change;
    }
    public void setChange(String change) {
        this.change = change;
    }
    public String getSell() {
        return this.sell;
    }
    public void setSell(String sell) {
        this.sell = sell;
    }
    public String getBuy() {
        return this.buy;
    }
    public void setBuy(String buy) {
        this.buy = buy;
    }

    

}
